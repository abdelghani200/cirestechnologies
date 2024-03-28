package com.cirestechnologies.cirestechnologies.web;

import com.cirestechnologies.cirestechnologies.entities.User;
import com.cirestechnologies.cirestechnologies.exceptions.CountValueInvalidException;
import com.cirestechnologies.cirestechnologies.services.Interfaces.GenerateUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserGenerateController {
    private final GenerateUserService usersGeneratorService;

    @GetMapping("/generate")
    public ResponseEntity<Object> generate(@RequestParam int count) throws IOException, CountValueInvalidException {
        List<User> users = usersGeneratorService.generateUsers(count);

        // Serialize users to JSON
        String jsonContent = new ObjectMapper().writeValueAsString(users);

        // Create response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentDispositionFormData("attachment", "users.json");

        // Return ResponseEntity with JSON content and headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(jsonContent);
    }
}
