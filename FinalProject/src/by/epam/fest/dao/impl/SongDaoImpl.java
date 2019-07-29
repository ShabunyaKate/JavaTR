package by.epam.fest.dao.impl;

import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Song;
import by.epam.fest.dao.SongDao;
import by.epam.fest.exception.TaskException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDaoImpl extends DaoImpl implements SongDao {
        private static Logger logger = LogManager.getLogger(SongDaoImpl.class);
        @Override
        public Integer create(Song song) throws TaskException {
            Connection con = null;
            String sql = "INSERT INTO `song` (`name`,`musician_id`) VALUES (?,?)";
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                con = getDBConnection();
                statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, song.getSong());
                statement.setInt(2, song.getMusician_id());
                statement.executeUpdate();
                resultSet = statement.getGeneratedKeys();
                if(resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    logger.error("There is no autoincremented index after trying to add record into table `song`");
                    throw new TaskException();
                }
            } catch(SQLException e) {
                throw new TaskException(e);
            } finally {
                try {
                    resultSet.close();
                } catch(SQLException | NullPointerException e) {}
                try {
                    statement.close();
                } catch(SQLException | NullPointerException e) {}
            }
        }
        @Override
        public Song read(Integer id) throws TaskException {
            Connection con = null;
            String sql = "SELECT `name` FROM `song` WHERE `id` = ?";
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                con = getDBConnection();
                statement = con.prepareStatement(sql);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                Song song= null;
                if(resultSet.next()) {
                    song = new Song();
                    song.setId(id);
                    song.setSong(resultSet.getString("name"));
                }
                return song;
            } catch(SQLException e) {
                throw new TaskException(e);
            } finally {
                try {
                    resultSet.close();
                } catch(SQLException | NullPointerException e) {}
                try {
                    statement.close();
                } catch(SQLException | NullPointerException e) {}
            }
        }

        @Override
        public void update(Song song) throws TaskException {
            Connection con = null;
            String sql = "UPDATE `song` SET `name` = ? WHERE `id` = ?";
            PreparedStatement statement = null;
            try {
                con = getDBConnection();
                statement = con.prepareStatement(sql);
                statement.setString(1, song.getSong());
                statement.setInt(2, song.getId());
                statement.executeUpdate();
            } catch(SQLException e) {
                throw new TaskException(e);
            } finally {
                try {
                    statement.close();
                } catch(SQLException | NullPointerException e) {}
            }
        }

        @Override
        public void delete(Integer id) throws TaskException {
            Connection con = null;
            String sql = "DELETE FROM `song` WHERE `id` = ?";
            PreparedStatement statement = null;
            try {
                con = getDBConnection();
                statement = con.prepareStatement(sql);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch(SQLException e) {
                throw new TaskException(e);
            } finally {
                try {
                    statement.close();
                } catch(SQLException | NullPointerException e) {}
            }
        }

    @Override
    public List<Song> readAllSongsByMusician(Integer musician_id) throws TaskException {
        Connection con = null;
        String sql = "SELECT `id`, `name`  FROM `song` WHERE `musician_id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Song> songs=null;
        Song song=null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, musician_id);
            resultSet = statement.executeQuery();
            songs=new ArrayList<>();
            while(resultSet.next()) {
                song=new Song();
                song.setId(resultSet.getInt("id"));
                song.setSong(resultSet.getString("name"));
                songs.add(song);
            }
            return songs;
        } catch(SQLException e) {
            throw new TaskException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }

    }
    }


