package by.epam.musician.dao;

import by.epam.musician.domain.Musician;
import by.epam.musician.domain.Song;
import by.epam.musician.exception.TaskException;

import java.util.List;

public interface SongDao extends Dao<Song> {
    List<Song> readAllSongsByMusician(Integer id) throws TaskException;
}
