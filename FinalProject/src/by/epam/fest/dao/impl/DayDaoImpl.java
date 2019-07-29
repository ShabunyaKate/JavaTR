package by.epam.fest.dao.impl;

import by.epam.fest.dao.DayDao;
import by.epam.fest.domain.Day;
import by.epam.fest.exception.TaskException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DayDaoImpl extends DaoImpl implements DayDao {
    private static Logger logger = LogManager.getLogger(DayDaoImpl.class);
    @Override
    public Integer create(Day day) throws TaskException {
        Connection con = null;
            String sql = "INSERT INTO `day` (`date`) VALUES (?)";
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                con = getDBConnection();
                statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setDate(1, day.getDate());
                statement.executeUpdate();
                resultSet = statement.getGeneratedKeys();
                if(resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    logger.error("There is no autoincremented index after trying to add record into table `day`");
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
    public Day read(Integer id) throws TaskException {
        Connection con = null;
            String sql = "SELECT `date` FROM `day` WHERE `id` = ?";
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                con = getDBConnection();
                statement = con.prepareStatement(sql);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                Day day= null;
                if(resultSet.next()) {
                    day = new Day();
                    day.setId(id);
                    day.setDate(resultSet.getDate("date"));
                }
                return day;
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
    public void update(Day day) throws TaskException {
        Connection con = null;
        String sql = "UPDATE `day` SET `date` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            con = getDBConnection();
        statement = con.prepareStatement(sql);
        statement.setDate(1, day.getDate());
        statement.setInt(2, day.getId());
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
        String sql = "DELETE FROM `day` WHERE `id` = ?";
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
    public List<Day> readAllDays() throws TaskException {
        Connection con = null;
        String sql = "SELECT `id`,`date` FROM `day`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Day> days=new ArrayList<>();
            Day day=null;
            while(resultSet.next()) {
                day=new Day();
                day.setId(resultSet.getInt("id"));
                day.setDate(resultSet.getDate("date"));
                days.add(day);
            }
            return days;
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
