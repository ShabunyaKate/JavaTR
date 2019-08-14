package by.epam.fest.service.impl;

import by.epam.fest.dao.DAOFactory;

import by.epam.fest.dao.UserDao;
import by.epam.fest.dao.UserInfoDao;

import by.epam.fest.domain.Role;
import by.epam.fest.domain.User;
import by.epam.fest.domain.UserInfo;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.ClientService;
import by.epam.fest.validation.Validation;
import by.epam.fest.validation.ValidationImpl;

import java.sql.Date;

public class ClientServiceImpl implements ClientService {
    private DAOFactory factory = DAOFactory.getInstance();

    @Override
    public User authorizeUser(String login, String password) throws ServiceException {
        UserDao userDao = factory.getUserDao();
        User user = null;
        try {
            user = userDao.getUserByLoginAndPassword(login, password);
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean cheakUniqueLogin(String login) throws ServiceException {
        UserDao userDao = factory.getUserDao();
        try {
            return userDao.isUniqueLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User registerNewUser(String name, String surname, String birthday, String phone, String email, String login, String password, String avatar) throws ServiceException {
        Validation validation = ValidationImpl.getInstance();
        if (validation.isTextForm(name) && validation.isTextForm(surname) && validation.isValidDate(birthday) && validation.isPhone(phone) && validation.isEmail(email) && validation.isLogin(login) && validation.isPassword(password)) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName(name);
            userInfo.setSurname(surname);
            userInfo.setBirthdate(Date.valueOf(birthday));
            userInfo.setPhone(phone);
            userInfo.setEmail(email);
            User user = new User();
            user.setRole(Role.USER);
            user.setLogin(login);
            user.setPassword(password);
            user.setAvatar(avatar);
            UserInfoDao userInfoDao = factory.getUserInfoDao();
            UserDao userDao = factory.getUserDao();
            try {
                Integer info_id = userInfoDao.create(userInfo);
                userInfo.setId(info_id);
                user.setUserInfo(userInfo);
                userDao.create(user);
                return user;
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }else
            throw new ServiceException();
    }
    }

