package by.epam.fest.service;

import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Song;
import by.epam.fest.domain.User;
import by.epam.fest.exception.ServiceException;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface MusicianService {
    int addSong(Song song) throws ServiceException;
    void deleteSong(Integer id) throws ServiceException;
    Musician getMusician(User user)throws ServiceException;
    Musician updateMusicianSongs(Musician musician) throws ServiceException;
    void downloadImageIntoDB(InputStream inputStream, Integer musician_id) throws ServiceException;
    Map<Day, List<Musician>> getDaysMusiciansWithImg(List<Day> days) throws  ServiceException;
}
