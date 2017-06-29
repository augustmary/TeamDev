package ua.dev.team.service;

import ua.dev.team.entity.User;

public interface UserService extends MainService<User> {
    void save(User user);
    User findByUsername(String username);
    static String ADMIN = "ADMIN";
    static String USER = "USER";
}
