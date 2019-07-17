package by.epam.musician.dao;

import by.epam.musician.domain.Entity;
import by.epam.musician.exception.TaskException;

public interface Dao<Type extends Entity> {
	public Integer create(Type entity) throws TaskException;

	public Type read(Integer id) throws TaskException;

	public void update(Type entity) throws TaskException;

	public void delete(Integer id) throws TaskException;
}
