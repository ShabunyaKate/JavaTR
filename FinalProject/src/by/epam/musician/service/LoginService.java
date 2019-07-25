package by.epam.musician.service;

import by.epam.musician.domain.User;
import by.epam.musician.exception.TaskException;

public interface LoginService {

    User authorizeUser(String login, String password) throws TaskException;
}
