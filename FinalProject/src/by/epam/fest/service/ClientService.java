package by.epam.fest.service;

import by.epam.fest.domain.User;
import by.epam.fest.domain.UserInfo;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;

import java.sql.Date;

public interface ClientService {
    User authorizeUser(String login, String password) throws ServiceException;
    boolean cheakUniqueLogin(String login) throws ServiceException;
    User registerNewUser(String name, String surname, String  birthday, String phone, String email, String login, String password, String avatar) throws ServiceException;
}
