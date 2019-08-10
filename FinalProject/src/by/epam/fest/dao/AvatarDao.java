package by.epam.fest.dao;

import by.epam.fest.exception.DaoException;

public interface AvatarDao {
   String read(Integer id) throws DaoException;
   Integer read(String path) throws DaoException;
}
