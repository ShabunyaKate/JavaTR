package by.epam.musician.dao;

import by.epam.musician.domain.Role;
import by.epam.musician.domain.User;
import by.epam.musician.exception.TaskException;

import java.util.List;

public interface UserDao extends Dao<User>{
   User getUserByLoginAndPassword(String login, String password) throws TaskException ;
   List<User> readAllUsers(Role role) throws TaskException;
}
