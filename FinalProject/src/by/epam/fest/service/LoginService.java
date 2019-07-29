package by.epam.fest.service;

import by.epam.fest.domain.User;
import by.epam.fest.exception.TaskException;

public interface LoginService {

    User authorizeUser(String login, String password) throws TaskException;
}
