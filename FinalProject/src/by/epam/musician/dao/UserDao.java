package by.epam.musician.dao;

import by.epam.musician.domain.User;

public interface UserDao extends Dao<User>{
   User getUserByLoginAndPassword(String login, String password);
}
