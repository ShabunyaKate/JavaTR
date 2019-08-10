package by.epam.fest.dao;

import by.epam.fest.domain.Role;
import by.epam.fest.domain.User;
import by.epam.fest.exception.DaoException;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface UserDao extends Dao<User>{
   User getUserByLoginAndPassword(String login, String password) throws DaoException;
   boolean isUniqueLogin(String login) throws DaoException;
   List<User> readAllUsers(Role role) throws DaoException;
   Integer getInfoIdByUserId(Integer id) throws DaoException;
}
