package by.epam.musician.dao;

import by.epam.musician.domain.Day;
import by.epam.musician.domain.Musician;
import by.epam.musician.exception.TaskException;

import java.util.List;

public interface MusicianDao extends Dao<Musician>{
    List<Musician> readAllMusicianByDay(Day day) throws TaskException;
}
