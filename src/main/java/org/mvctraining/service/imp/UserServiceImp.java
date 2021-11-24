package org.mvctraining.service.imp;

import org.mvctraining.model.User;
import org.mvctraining.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {


    private List<User> users = new ArrayList<>();

    {
        users.add(new User(1, "Saiful Islam", "saiful.sust.cse@gmail.com"));
        users.add(new User(2, "Ashikur  Islam", "Ashikur.sust.cse@gmail.com"));
        users.add(new User(3, "Nahid Islam", "Nahid.sust.cse@gmail.com"));
        users.add(new User(4, "Rabiul Islam", "Rabiul.sust.cse@gmail.com"));
    }

    @Override
    public List<User> findUserByUserId(final int userId) {
        return users.stream().filter(user -> {
            return user.getUser_id()== userId;
        }).collect(Collectors.toList());
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public List<User> deleteByUserId(int userId) {
        return users.stream().filter(user -> {
            return user.getUser_id() != userId;
        }).collect(Collectors.toList());
    }



}
