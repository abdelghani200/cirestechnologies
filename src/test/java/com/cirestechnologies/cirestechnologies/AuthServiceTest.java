package com.cirestechnologies.cirestechnologies;

import com.cirestechnologies.cirestechnologies.dtos.req.AuthReq;
import com.cirestechnologies.cirestechnologies.dtos.resp.AuthRes;
import com.cirestechnologies.cirestechnologies.entities.User;
import com.cirestechnologies.cirestechnologies.persistences.UserRepository;
import com.cirestechnologies.cirestechnologies.security.AuthService;
import com.cirestechnologies.cirestechnologies.security.JwtService;
import com.cirestechnologies.cirestechnologies.security.UserAuthenticate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void login_ValidCredentials_ReturnsAccessToken() {
        // Given
        AuthReq authRequest = new AuthReq("test_username", "test_password");
        User user = new User();
        user.setUsername("test_username");
        user.setPassword("hashed_password");

        when(userRepository.findUserByUsername("test_username")).thenReturn(java.util.Optional.of(user));

        when(jwtService.generateToken(any(UserAuthenticate.class))).thenReturn("mocked_jwt_token");

        // When
        AuthRes authResponse = authService.login(authRequest);

        // Then
        assertEquals("mocked_jwt_token", authResponse.getToken());
    }

    @Test
    void login_InvalidCredentials_ThrowsException() {
        // Given
        AuthReq authRequest = new AuthReq("invalid_username", "invalid_password");

        when(userRepository.findUserByUsername("invalid_username")).thenReturn(java.util.Optional.empty());

        // Then (verify if UsernameNotFoundException is thrown)
        assertThrows(UsernameNotFoundException.class, () -> {
            authService.login(authRequest);
        });
    }

}
