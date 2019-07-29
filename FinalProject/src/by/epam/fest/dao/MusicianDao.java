package by.epam.fest.dao;

import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.User;
import by.epam.fest.exception.TaskException;

import java.util.List;

public interface MusicianDao extends Dao<Musician>{
    List<Musician> readAllMusicianByDay(Day day) throws TaskException;
    Musician read(User user) throws TaskException;
}
