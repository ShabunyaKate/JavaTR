package by.epam.fest.service.impl;

import by.epam.fest.dao.DAOFactory;
import by.epam.fest.dao.MusicianDao;
import by.epam.fest.dao.SongDao;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.dao.impl.SongDaoImpl;
import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Song;
import by.epam.fest.domain.User;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.MusicianService;
import org.apache.logging.log4j.core.util.IOUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void downloadImageIntoDB(InputStream inputStream, Integer musician_id) throws ServiceException {
            try {
             //   BufferedImage image = ImageIO.read(inputStream);
              //  Byte.inputStream
                byte[] bytes = MusicianServiceImpl.getBytesFromInputStream(inputStream);
                MusicianDao dao=daoObjectFactory.getMusicianDao();
                dao.addBlobToMusician(bytes,musician_id);
            } catch (DaoException | IOException e) {
                throw new ServiceException();
            }
    }

    @Override
    public Map<Day, List<Musician>> getDaysMusiciansWithImg(List<Day> days) throws ServiceException {
       try {
           List<Musician> musicians;
           MusicianDao musicianDao = daoObjectFactory.getMusicianDao();
           Map<Day, List<Musician>> linkedHashMap = new LinkedHashMap<>();
           for (Day day : days) {
               musicians = musicianDao.readAllMusicianByDayWithImg(day);
               linkedHashMap.put(day, musicians);
           }
           return linkedHashMap;
       } catch (DaoException e) {
           throw new ServiceException(e);
       }
    }
    public static byte[] getBytesFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[0xFFFF];
        for (int len = is.read(buffer); len != -1; len = is.read(buffer)) {
            os.write(buffer, 0, len);
        }
        return os.toByteArray();
    }
}
