package com.cirestechnologies.cirestechnologies.services.Interfaces;

import com.cirestechnologies.cirestechnologies.entities.User;

import java.util.List;

public interface GenerateUserService {
    List<User> generateUsers(int count);
}
