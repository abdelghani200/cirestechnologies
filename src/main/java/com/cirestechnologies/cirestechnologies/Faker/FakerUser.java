package com.cirestechnologies.cirestechnologies.Faker;

import com.cirestechnologies.cirestechnologies.entities.User;
import com.cirestechnologies.cirestechnologies.enums.Role;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FakerUser {

    private final Faker faker;

    public User generate(User user){
        user.setId(faker.number().randomNumber());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setBirthDate(faker.date().birthday());
        user.setCity(faker.address().city());
        user.setCountry(faker.address().country());
        user.setAvatar(faker.avatar().image());
        user.setCompany(faker.company().name());
        user.setJobPosition(faker.job().position());
        user.setMobile(faker.phoneNumber().phoneNumber());
        user.setEmail(faker.internet().emailAddress());
        user.setUsername(faker.internet().emailAddress());
        user.setPassword(faker.internet().password(6, 10));
        user.setRole(faker.random().nextBoolean() ? Role.ADMIN : Role.USER);
        return user;
    }

}
