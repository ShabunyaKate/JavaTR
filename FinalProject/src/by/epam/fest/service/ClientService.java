package by.epam.fest.service;

import by.epam.fest.domain.User;
import by.epam.fest.domain.UserInfo;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;

public interface ClientService {
    User authorizeUser(String login, String password) throws ServiceException;
    boolean cheakUniqueLogin(String login) throws ServiceException;
    User registerNewUser(User user, UserInfo info) throws ServiceException;
}
