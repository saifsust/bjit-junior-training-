package org.mvctraining.service;

import org.mvctraining.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> findUserByUserId(int userId);
    public List<User> findAll();
    public  List<User> deleteByUserId(int userId);
}
