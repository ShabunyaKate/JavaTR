//package by.epam.musician.dao.impl;
//
//import by.epam.musician.domain.Song;
//import by.epam.musician.dao.SongDao;
//import by.epam.musician.exception.TaskException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class SongDaoImpl extends BaseDaoImpl implements SongDao {
//        private static Logger logger = LogManager.getLogger(SongDaoImpl.class);
//        @Override
//        public Integer create(Song song) throws TaskException {
//            String sql = "INSERT INTO `song` (`name`) VALUES (?)";
//            PreparedStatement statement = null;
//            ResultSet resultSet = null;
//            try {
//                statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//                statement.setString(1, song.getSong());
//                statement.executeUpdate();
//                resultSet = statement.getGeneratedKeys();
//                if(resultSet.next()) {
//                    return resultSet.getInt(1);
//                } else {
//                    logger.error("There is no autoincremented index after trying to add record into table `song`");
//                    throw new TaskException();
//                }
//            } catch(SQLException e) {
//                throw new TaskException(e);
//            } finally {
//                try {
//                    resultSet.close();
//                } catch(SQLException | NullPointerException e) {}
//                try {
//                    statement.close();
//                } catch(SQLException | NullPointerException e) {}
//            }
//        }
//        @Override
//        public Song read(Integer id) throws TaskException {
//            String sql = "SELECT `name` FROM `song` WHERE `id` = ?";
//            PreparedStatement statement = null;
//            ResultSet resultSet = null;
//            try {
//                statement = connection.prepareStatement(sql);
//                statement.setInt(1, id);
//                resultSet = statement.executeQuery();
//                Song song= null;
//                if(resultSet.next()) {
//                    song = new Song();
//                    song.setId(id);
//                    song.setSong(resultSet.getString("name"));
//                }
//                return song;
//            } catch(SQLException e) {
//                throw new TaskException(e);
//            } finally {
//                try {
//                    resultSet.close();
//                } catch(SQLException | NullPointerException e) {}
//                try {
//                    statement.close();
//                } catch(SQLException | NullPointerException e) {}
//            }
//        }
//
//        @Override
//        public void update(Song song) throws TaskException {
//            String sql = "UPDATE `song` SET `name` = ? WHERE `id` = ?";
//            PreparedStatement statement = null;
//            try {
//                statement = connection.prepareStatement(sql);
//                statement.setString(1, song.getSong());
//                statement.setInt(2, song.getId());
//                statement.executeUpdate();
//            } catch(SQLException e) {
//                throw new TaskException(e);
//            } finally {
//                try {
//                    statement.close();
//                } catch(SQLException | NullPointerException e) {}
//            }
//        }
//
//        @Override
//        public void delete(Integer id) throws TaskException {
//            String sql = "DELETE FROM `song` WHERE `id` = ?";
//            PreparedStatement statement = null;
//            try {
//                statement = connection.prepareStatement(sql);
//                statement.setInt(1, id);
//                statement.executeUpdate();
//            } catch(SQLException e) {
//                throw new TaskException(e);
//            } finally {
//                try {
//                    statement.close();
//                } catch(SQLException | NullPointerException e) {}
//            }
//        }
//    }
//
