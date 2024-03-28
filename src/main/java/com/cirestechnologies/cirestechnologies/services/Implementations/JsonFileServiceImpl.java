package com.cirestechnologies.cirestechnologies.services.Implementations;

import com.cirestechnologies.cirestechnologies.dtos.resp.UploadRes;
import com.cirestechnologies.cirestechnologies.entities.User;
import com.cirestechnologies.cirestechnologies.exceptions.EmailUsedException;
import com.cirestechnologies.cirestechnologies.exceptions.UsernameUsedException;
import com.cirestechnologies.cirestechnologies.persistences.UserRepository;
import com.cirestechnologies.cirestechnologies.services.Interfaces.JsonFileService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JsonFileServiceImpl implements JsonFileService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UploadRes saveJsonFile(MultipartFile jsonFile) throws IOException {
        if (!Objects.equals(jsonFile.getContentType(), "application/json")){
            throw new BadRequestException("Must be a JSON format");
        }

        List<User> users = new ObjectMapper().readValue(jsonFile.getInputStream(), new TypeReference<List<User>>() {
        });

        List<User> saveUsers = new ArrayList<>();
        List<User> failedUsers = new ArrayList<>();

        for (User user : users) {
            try {
                if(userRepository.findUserByUsername(user.getUsername()).isPresent()) {
                    throw new UsernameUsedException("This username is already in use");
                } else if(userRepository.findUserByEmail(user.getEmail()).isPresent()) {
                    throw new EmailUsedException("This email is already in use");
                } else {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    saveUsers.add(userRepository.save(user));
                }
            } catch (Exception e) {
                failedUsers.add(user);
            }
        }

        UploadRes response = new UploadRes();
        response.setTotalRecords(users.size());
        response.setImportedRecords(saveUsers.size());
        response.setFailedRecords(failedUsers.size());
        return response;

    }
}
