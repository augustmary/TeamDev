package ua.dev.team.dao;

import ua.dev.team.entity.User;

public interface UserDAO extends MainDAO<User, Long> {
    User findByUsername(String username);
}
