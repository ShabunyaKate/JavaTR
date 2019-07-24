package by.epam.musician.dao;

import by.epam.musician.domain.Day;
import by.epam.musician.exception.TaskException;

import java.util.List;

public interface DayDao extends Dao<Day> {
    List<Day> readAllDays() throws TaskException;
}
