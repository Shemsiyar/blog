package com.shearing.blog.services;

import com.shearing.blog.model.User;

public interface UserServices {
    void saveUser(User user);
    User loginUser(String email, String password);
    User findUserById(Long id);
}
