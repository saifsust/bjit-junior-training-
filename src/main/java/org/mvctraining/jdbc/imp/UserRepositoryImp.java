package org.mvctraining.jdbc.imp;

import org.mvctraining.jdbc.UserRepository;
import org.mvctraining.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {
    public static final String ALL_USERS_FROM_USERS = "SELECT * FROM users";
    public static final String SELECT_USER_WHERE = "SELECT * FROM users WHERE userid = ";
    public static final String DELETE_FROM_USERS_WHERE_USERID = "DELETE FROM users WHERE userid = ";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        return jdbcTemplate.query(ALL_USERS_FROM_USERS, (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("name"), rs.getString("email")));
    }

    public User save(User user) {
        jdbcTemplate.execute(user.toInsert());
        return findLastUser();
    }

    public User findLastUser() {
        return findUser("(SELECT max(userid) FROM users)");
    }

    public User findUserByUserId(int userId) {
        return findUser(userId);
    }

    private User findUser(String sql) {
        return jdbcTemplate.queryForObject(SELECT_USER_WHERE + sql, (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("name"), rs.getString("email")));
    }

    private User findUser(int userId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_USER_WHERE + userId, (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("name"), rs.getString("email")));
        } catch (Exception ex) {
            return null;
        }
    }

    public User delete(int userid) {
        User user = findUserByUserId(userid);
        jdbcTemplate.execute(DELETE_FROM_USERS_WHERE_USERID + userid);
        return user;
    }

    public User update(User user) {
        jdbcTemplate.execute("UPDATE users SET name ='" + user.getName() + "', email = '" + user.getEmail() + "' WHERE userid =" + user.getUser_id());
        return findUserByUserId(user.getUser_id());
    }
}
