package by.epam.fest.dao.impl;


import by.epam.fest.dao.UserInfoDao;
import by.epam.fest.domain.UserInfo;
import by.epam.fest.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
public class UserInfoDaoImpl extends DaoImpl implements UserInfoDao {
    private static Logger logger = LogManager.getLogger(UserInfoDaoImpl.class);

    @Override
    public Integer create(UserInfo userInfo) throws DaoException {
        Connection con = null;
        String sql = "INSERT INTO `user_info` (`name`,`surname`,`birth_date`,`email`,`phone`) VALUES (?, ?, ?,?,?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userInfo.getName());
            statement.setString(2,userInfo.getSurname());
            statement.setDate(3,userInfo.getBirthdate());
            statement.setString(4,userInfo.getEmail());
            statement.setString(5,userInfo.getPhone());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `user_info`");
                throw  new DaoException();
            }
        } catch(SQLException e) {
            throw new DaoException(e);
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
    public UserInfo read(Integer id) throws DaoException {
        Connection con = null;
        String sql = "SELECT `name`,`surname`,`birth_date`,`email`,`phone` FROM `user_info` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            UserInfo userInfo = null;
            if(resultSet.next()) {
                userInfo = new UserInfo();
                userInfo.setId(id);
                userInfo.setName(resultSet.getString("name"));
                userInfo.setSurname(resultSet.getString("surname"));
                userInfo.setBirthdate((resultSet.getDate("birth_date")));
                userInfo.setEmail(resultSet.getString("email"));
                userInfo.setPhone(resultSet.getString("phone"));
            }
            return userInfo;
        } catch(SQLException e) {
            throw new DaoException(e);
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
    public void update(UserInfo userInfo) throws DaoException {
        Connection con = null;
        String sql = "UPDATE `user_info` SET `name` = ?, `surname` = ?, `birth_day` = ?, `email` = ?, `phone` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, userInfo.getName());
            statement.setString(2, userInfo.getSurname());
            statement.setDate(3, userInfo.getBirthdate());
            statement.setString(4,userInfo.getEmail());
            statement.setString(5,userInfo.getPhone());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }
    @Override
    public void delete(Integer id) throws DaoException {
        Connection con = null;
        String sql = "DELETE FROM `user_info` WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }
}
