package com.corporate_etiquette_mvp.service;

import com.corporate_etiquette_mvp.model.User;
import java.util.List;

public interface UserService {

    // Existing methods
    User createUser(User user);
    User getUserById(Integer id);
    List<User> getAllUsers();
    void deleteUser(Integer id);

    // New methods for login/signup
    User registerUser(User user);
    User loginUser(String email, String password);
    User updateUserStatus(Integer id, String status);

}