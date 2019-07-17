package by.epam.musician.service.impl;

import by.epam.musician.dao.UserDao;
import by.epam.musician.dao.impl.UserDaoImpl;
import by.epam.musician.domain.User;
import by.epam.musician.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public User authorizeUser(String login, String password) {
        return dao.getUserByLoginAndPassword(login, password);
    }
}
