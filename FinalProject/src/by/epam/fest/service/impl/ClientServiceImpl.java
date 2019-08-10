package by.epam.fest.service.impl;

import by.epam.fest.dao.DAOFactory;
import by.epam.fest.dao.Dao;
import by.epam.fest.dao.UserDao;
import by.epam.fest.dao.UserInfoDao;
import by.epam.fest.dao.impl.UserDaoImpl;
import by.epam.fest.domain.User;
import by.epam.fest.domain.UserInfo;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.ClientService;

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
    public User registerNewUser(User user, UserInfo userInfo) throws ServiceException {
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
    }
}
