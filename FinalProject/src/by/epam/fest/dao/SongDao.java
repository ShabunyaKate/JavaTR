package by.epam.fest.dao;

import by.epam.fest.domain.Song;
import by.epam.fest.exception.TaskException;

import java.util.List;

public interface SongDao extends Dao<Song> {
    List<Song> readAllSongsByMusician(Integer id) throws TaskException;
}
