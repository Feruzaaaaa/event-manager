package com.example.eventmanager.service;

import com.example.eventmanager.model.User;
import java.util.List;

public interface UserService {
    User create(User user);
    List<User> getAll();
}
