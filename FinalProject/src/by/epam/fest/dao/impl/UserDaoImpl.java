package by.epam.fest.dao.impl;

import by.epam.fest.domain.*;
import by.epam.fest.dao.UserDao;
import by.epam.fest.exception.TaskException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DaoImpl implements UserDao {

    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private static  AvatarDaoImpl avatarDao=new AvatarDaoImpl();
    @Override
    public Integer create(User user) throws TaskException {
        Connection con = null;
        String sql = "INSERT INTO `user` (`info_id`,`login`, `password`, `role`,`avatar_id`) VALUES (?, ?, ?,?,?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, user.getUserInfo().getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().getId());
            String path=user.getAvatar();
            statement.setInt(5,avatarDao.read(path));
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `user`");
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
    public User read(Integer id) throws TaskException {
        Connection con = null;
        String sql = "SELECT `info_id`,`login`, `password`, `role`,`avatar_id` FROM `user` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(id);
                UserInfo userInfo = new UserInfo();
                userInfo.setId(resultSet.getInt("info_id"));
                user.setUserInfo(userInfo);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                Integer avatar_id=resultSet.getInt("avatar_id");
                user.setAvatar(avatarDao.read(avatar_id));
            }
            return user;
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
    public void update(User user) throws TaskException {
        Connection con = null;
        String sql = "UPDATE `user` SET `info_id` = ?, `login` = ?, `password` = ?, `role` = ?,`avatar_id`=? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, user.getUserInfo().getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().getId());
            String path=user.getAvatar();
            statement.setInt(5,avatarDao.read(path));
            statement.setInt(6, user.getId());
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
        String sql = "DELETE FROM `user` WHERE `id` = ?";
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
    public User getUserByLoginAndPassword(String login, String password)  throws TaskException {
        Connection con = null;
        String sql = "Select * From `user` where `login` = ? and `password` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                Integer id = resultSet.getInt("id");
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                Integer avatar_id = resultSet.getInt("avatar_id");
                user.setAvatar(avatarDao.read(avatar_id));
            }
            return user;
        } catch (SQLException e) {
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
    public List<User> readAllUsers(Role role) throws TaskException {
        Connection con = null;
        String sql="SELECT `id`,`info_id`,`login`, `password` FROM `user` WHERE `role` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, role.ordinal());
            resultSet = statement.executeQuery();
            List<User> users=new ArrayList<>();
            User user = null;
            UserInfoDaoImpl userInfoDao=new UserInfoDaoImpl();
            while(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                UserInfo userInfo=userInfoDao.read(resultSet.getInt("info_id"));
                user.setUserInfo(userInfo);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(role);
                users.add(user);
            }
            return users;
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

