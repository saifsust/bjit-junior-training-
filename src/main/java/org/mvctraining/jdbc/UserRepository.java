package org.mvctraining.jdbc;

import org.mvctraining.model.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
    public User save(User user);
    public User findLastUser();
    public User findUserByUserId(int userId);
    public User delete(int userid);
    public User update(User user);
}
