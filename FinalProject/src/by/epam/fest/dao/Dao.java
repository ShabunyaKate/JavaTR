package by.epam.fest.dao;

import by.epam.fest.domain.Entity;
import by.epam.fest.exception.DaoException;

public interface Dao<Type extends Entity> {
	public Integer create(Type entity) throws DaoException;

	public Type read(Integer id) throws DaoException;

	public void update(Type entity) throws DaoException;

	public void delete(Integer id) throws DaoException;
}
