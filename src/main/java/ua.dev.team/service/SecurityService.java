package ua.dev.team.service;

public interface SecurityService {
    String findLogggedInUsername();
    void autoLogin(String username, String password);
}
