package com.corporate_etiquette_mvp.service.impl;

import com.corporate_etiquette_mvp.Dao.UserDao;
import com.corporate_etiquette_mvp.model.User;
import com.corporate_etiquette_mvp.model.User.Status;
import com.corporate_etiquette_mvp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public User registerUser(User user) {
        // As requested, no password hashing is performed.
        return userDao.save(user);
    }
    @Override
	public User updateUserStatus(Integer id, String status) {
		return userDao.findById(id).map(user -> {
			user.setStatus(Status.valueOf(status));
			return userDao.save(user);
		}).orElseThrow(() -> new RuntimeException("User not found with id " + id));
	}

    @Override
    public User loginUser(String email, String password) {
        User user = userDao.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        // As requested, a simple plain-text password comparison is used.
        if (password.equals(user.getPasswordHash())) {
            return user;
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}