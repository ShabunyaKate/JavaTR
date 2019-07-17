package by.epam.musician.service;

import by.epam.musician.domain.User;

public interface LoginService {

    User authorizeUser(String login, String password);
}
