package com.cirestechnologies.cirestechnologies.services;

import com.cirestechnologies.cirestechnologies.entities.User;
import com.cirestechnologies.cirestechnologies.persistences.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User profile(String username){
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}
