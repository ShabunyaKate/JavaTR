package by.epam.fest.service.impl;

import by.epam.fest.dao.DAOFactory;
import by.epam.fest.dao.MusicianDao;
import by.epam.fest.dao.SongDao;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.dao.impl.SongDaoImpl;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Song;
import by.epam.fest.domain.User;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.MusicianService;

import java.util.List;

public class MusicianServiceImpl implements MusicianService {
    DAOFactory daoObjectFactory = DAOFactory.getInstance();
    @Override
    public int addSong(Song song) throws ServiceException {
        try {
            SongDao songDao = daoObjectFactory.getSongDao();
            return songDao.create(song);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void deleteSong(Integer id) throws ServiceException {
        try {
            SongDao songDao = daoObjectFactory.getSongDao();
            songDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Musician getMusician(User user) throws ServiceException {
        try {
            SongDao songDao = daoObjectFactory.getSongDao();
            MusicianDao musicianDao=daoObjectFactory.getMusicianDao();
            Musician musician = musicianDao.read(user);
            musician.setSongs(songDao.readAllSongsByMusician(musician.getId()));
            return musician;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Musician updateMusicianSongs(Musician musician) throws ServiceException {
        try {
            SongDao songDao = daoObjectFactory.getSongDao();
            List<Song> songs = songDao.readAllSongsByMusician(musician.getId());
            musician.setSongs(songs);
            return musician;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }
}
