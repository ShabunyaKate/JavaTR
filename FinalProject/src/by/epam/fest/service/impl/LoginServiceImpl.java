package by.epam.fest.service.impl;

import by.epam.fest.dao.UserDao;
import by.epam.fest.dao.impl.UserDaoImpl;
import by.epam.fest.domain.User;
import by.epam.fest.exception.TaskException;
import by.epam.fest.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public User authorizeUser(String login, String password) throws TaskException {
        return dao.getUserByLoginAndPassword(login, password) ;
    }
}
