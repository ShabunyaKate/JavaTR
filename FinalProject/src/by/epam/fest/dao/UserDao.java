package by.epam.fest.dao;

import by.epam.fest.domain.Role;
import by.epam.fest.domain.User;
import by.epam.fest.exception.TaskException;

import java.util.List;

public interface UserDao extends Dao<User>{
   User getUserByLoginAndPassword(String login, String password) throws TaskException ;
   List<User> readAllUsers(Role role) throws TaskException;
}
