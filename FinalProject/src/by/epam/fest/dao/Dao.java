package by.epam.fest.dao;

import by.epam.fest.domain.Entity;
import by.epam.fest.exception.TaskException;

public interface Dao<Type extends Entity> {
	public Integer create(Type entity) throws TaskException;

	public Type read(Integer id) throws TaskException;

	public void update(Type entity) throws TaskException;

	public void delete(Integer id) throws TaskException;
}
