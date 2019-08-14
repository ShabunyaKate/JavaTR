package by.epam.fest.dao;

import by.epam.fest.domain.Song;
import by.epam.fest.exception.DaoException;

import java.util.List;

public interface SongDao extends Dao<Song> {
    List<Song> readAllSongsByMusician(Integer id) throws DaoException;
    boolean isUniqueName(String name) throws DaoException;
}
