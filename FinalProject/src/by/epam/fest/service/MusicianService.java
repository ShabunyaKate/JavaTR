package by.epam.fest.service;

import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Song;
import by.epam.fest.domain.User;
import by.epam.fest.exception.ServiceException;

public interface MusicianService {
    int addSong(Song song) throws ServiceException;
    void deleteSong(Integer id) throws ServiceException;
    Musician getMusician(User user)throws ServiceException;
    Musician updateMusicianSongs(Musician musician) throws ServiceException;
}
