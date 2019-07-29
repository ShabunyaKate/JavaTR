package by.epam.fest.dao;

import by.epam.fest.domain.Day;
import by.epam.fest.exception.TaskException;

import java.util.List;

public interface DayDao extends Dao<Day> {
    List<Day> readAllDays() throws TaskException;
}
