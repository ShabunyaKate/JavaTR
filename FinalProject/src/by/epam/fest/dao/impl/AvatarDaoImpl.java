package by.epam.fest.dao.impl;

import by.epam.fest.dao.AvatarDao;
import by.epam.fest.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AvatarDaoImpl  extends DaoImpl implements AvatarDao{
    private static Logger logger = LogManager.getLogger(SongDaoImpl.class);

    public String read(Integer id) throws DaoException {
        Connection con = null;
        String sql = "SELECT `path` FROM `avatar` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            String avatar_path= null;
            if(resultSet.next()) {
                avatar_path=resultSet.getString("path");
            }
            return avatar_path;
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
    public Integer read(String path) throws DaoException {
        Connection con = null;
        String sql = "SELECT `id` FROM `avatar` WHERE `path` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, path);
            resultSet = statement.executeQuery();
            Integer id=null;
            if(resultSet.next()) {
                id=resultSet.getInt("id");
            }
            return id;
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
}
