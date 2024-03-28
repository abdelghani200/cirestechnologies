package com.cirestechnologies.cirestechnologies.security;

import com.cirestechnologies.cirestechnologies.dtos.req.AuthReq;
import com.cirestechnologies.cirestechnologies.dtos.resp.AuthRes;
import com.cirestechnologies.cirestechnologies.entities.User;
import com.cirestechnologies.cirestechnologies.persistences.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthRes login(AuthReq authRequest) {

        User user = userRepository.findUserByUsername(authRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Email or password not valid"));

        UserAuthenticate userAuthenticator = new UserAuthenticate(user);
        String jwtToken = jwtService.generateToken(userAuthenticator);
        AuthRes authResponse = new AuthRes();
        authResponse.setToken(jwtToken);
        return authResponse;
    }

}
