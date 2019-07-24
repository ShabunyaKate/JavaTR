package by.epam.musician.dao.impl;

import by.epam.musician.domain.Musician;
import by.epam.musician.dao.MusicianDao;
import by.epam.musician.domain.Day;
import by.epam.musician.domain.User;
import by.epam.musician.exception.TaskException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicianDaoImpl extends DaoImpl implements MusicianDao {
    private static Logger logger = LogManager.getLogger(MusicianDaoImpl.class);

    @Override
    public Integer create(Musician musician) throws TaskException {
        Connection con = null;
        String sql = "INSERT INTO `musician` (`user_id`, `day_id`) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, musician.getUser().getId());
            statement.setInt(2, musician.getDay().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `musician`");
                throw new TaskException();
            }
        } catch (SQLException e) {
            throw new TaskException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public Musician read(Integer id) throws TaskException {
        Connection con = null;
        String sql = "SELECT `user_id`, `day_id` FROM `musician` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Musician musician = null;
            if (resultSet.next()) {
                musician = new Musician();
                musician.setId(id);
                User user=new User();
                user.setId(resultSet.getInt("user_id"));
                musician.setUser(user);
                Day day=new Day();
                day.setId(resultSet.getInt("day_id"));
                musician.setDay(day);

            }
            return musician;
        } catch (SQLException e) {
            throw new TaskException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public void update(Musician musician) throws TaskException {
        Connection con = null;
        String sql = "UPDATE `musician` SET `user_id` = ?, `day_id` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, musician.getUser().getId());
            statement.setInt(2, musician.getDay().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new TaskException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public void delete(Integer id) throws TaskException {
        Connection con = null;
        String sql = "DELETE FROM `musician` WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new TaskException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public List<Musician> readAllMusicianByDay(Day day) throws TaskException {
        Connection con = null;
        String sql = "SELECT `id`, `user_id`  FROM `musician` WHERE `day_id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, day.getId());
            resultSet = statement.executeQuery();
            List<Musician> musicians=new ArrayList<>();
            Musician musician = null;
            UserDaoImpl userDao=new UserDaoImpl();
            while(resultSet.next()) {
                musician = new Musician();
                musician.setId(resultSet.getInt("id"));
                User user=userDao.read(resultSet.getInt("user_id"));
                musician.setUser(user);
                musician.setDay(day);
                musicians.add(musician);
            }
            return musicians;
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
