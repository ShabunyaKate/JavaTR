package by.epam.fest.dao;

import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.User;
import by.epam.fest.exception.DaoException;

import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.util.List;

public interface MusicianDao extends Dao<Musician>{
    List<Musician> readAllMusicianByDay(Day day) throws DaoException;
    Musician read(User user) throws DaoException;
    List<Musician> readAllMusician() throws DaoException;
    Integer getUserIdByMusicianId(Integer id) throws DaoException;
     void addBlobToMusician(BufferedImage image,Integer musician_id) throws DaoException;
     List<Musician> readAllMusicianByDayWithImg(Day day) throws DaoException;
}
