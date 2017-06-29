package ua.dev.team.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.dev.team.dao.RoleDAO;
import ua.dev.team.dao.UserDAO;
import ua.dev.team.entity.Role;
import ua.dev.team.entity.User;
import ua.dev.team.service.UserService;

import java.util.*;

@Service
public class UserServImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(1L));
        user.setRoles(roles);
        userDAO.save(user);
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public List<User> getAll () {
        return userDAO.findAll();
    }
}