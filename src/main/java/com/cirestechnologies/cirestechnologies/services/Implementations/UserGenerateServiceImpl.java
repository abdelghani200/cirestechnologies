package com.cirestechnologies.cirestechnologies.services.Implementations;

import com.cirestechnologies.cirestechnologies.Faker.FakerUser;
import com.cirestechnologies.cirestechnologies.entities.User;
import com.cirestechnologies.cirestechnologies.exceptions.CountValueInvalidException;
import com.cirestechnologies.cirestechnologies.services.Interfaces.GenerateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGenerateServiceImpl implements GenerateUserService {

    private final FakerUser fakerUser;

    @Override
    public List<User> generateUsers(int count) {
        if (count <= 0){
            throw new CountValueInvalidException("Le nombre d'utilisateurs doit être supérieur à zéro.");
        }
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < count; i++){
            User user = fakerUser.generate(new User());
            userList.add(user);
        }
        return userList;
    }
}
