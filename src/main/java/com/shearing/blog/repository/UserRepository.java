package com.shearing.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shearing.blog.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
