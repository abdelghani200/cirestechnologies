package com.cirestechnologies.cirestechnologies;

import com.cirestechnologies.cirestechnologies.Faker.FakerUser;
import com.cirestechnologies.cirestechnologies.entities.User;
import com.cirestechnologies.cirestechnologies.exceptions.CountValueInvalidException;
import com.cirestechnologies.cirestechnologies.services.Implementations.UserGenerateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.mockito.Mockito.when;

public class UsersGeneratorServiceImplTest {

    @Mock
    private FakerUser fakeUserGenerator;

    @InjectMocks
    private UserGenerateServiceImpl usersGeneratorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateUsers_ReturnsCorrectNumberOfUsers() throws CountValueInvalidException {
        // Given
        int count = 5;
        User fakeUser = new User(); // Create a fake user
        when(fakeUserGenerator.generate(fakeUser)).thenReturn(fakeUser);

        List<User> users = usersGeneratorService.generateUsers(count);

        // Then
        assertEquals(count, users.size());
    }

}
