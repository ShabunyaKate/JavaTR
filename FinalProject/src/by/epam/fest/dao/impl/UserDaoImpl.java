package by.epam.fest.dao.impl;

import by.epam.fest.dao.AvatarDao;
import by.epam.fest.dao.DAOFactory;
import by.epam.fest.dao.UserInfoDao;
import by.epam.fest.domain.*;
import by.epam.fest.dao.UserDao;
import by.epam.fest.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DaoImpl implements UserDao {

    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);
    @Override
    public Integer create(User user) throws DaoException {
        Connection con = null;
        String sql = "INSERT INTO `user` (`info_id`,`login`, `password`, `role`,`avatar_id`) VALUES (?, ?, ?,?,?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DAOFactory daoObjectFactory=DAOFactory.getInstance();
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            if(user.getUserInfo()==null){
                statement.setNull(1, java.sql.Types.INTEGER);
            }
            else statement.setInt(1, user.getUserInfo().getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().getId());
            String path=user.getAvatar();
            if(user.getAvatar()==null){
                statement.setNull(5, Types.INTEGER);
            }
            else {
                AvatarDao avatarDao= daoObjectFactory.getAvatarDaoImpl();
                statement.setInt(5,avatarDao.read(path));
            }
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `user`");
                throw new DaoException();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
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
    public User read(Integer id) throws DaoException {
        Connection con = null;
        String sql = "SELECT `info_id`,`login`, `password`, `role`,`avatar_id` FROM `user` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DAOFactory daoObjectFactory=DAOFactory.getInstance();
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
                AvatarDao avatarDao= daoObjectFactory.getAvatarDaoImpl();
                user.setAvatar(avatarDao.read(avatar_id));
            }
            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
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
    public void update(User user) throws DaoException {
        Connection con = null;
        String sql = "UPDATE `user` SET `info_id` = ?, `login` = ?, `password` = ?, `role` = ?,`avatar_id`=? WHERE `id` = ?";
        PreparedStatement statement = null;
        DAOFactory daoObjectFactory=DAOFactory.getInstance();
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, user.getUserInfo().getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().getId());
            String path=user.getAvatar();
            AvatarDao avatarDao= daoObjectFactory.getAvatarDaoImpl();
            statement.setInt(5,avatarDao.read(path));
            statement.setInt(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        Connection con = null;
        String sql = "DELETE FROM `user` WHERE `id` = ?";
        PreparedStatement statement = null;

        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }
    @Override
    public User getUserByLoginAndPassword(String login, String password)  throws DaoException {
        Connection con = null;
        String sql = "SELECT `id`,`info_id`,`role`,`avatar_id` FROM `user` WHERE `login` = ? AND `password` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DAOFactory daoObjectFactory=DAOFactory.getInstance();
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
                UserInfo userInfo = new UserInfo();
                userInfo.setId(resultSet.getInt("info_id"));
                user.setUserInfo(userInfo);
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.getById(resultSet.getInt("role")));
                Integer avatar_id = resultSet.getInt("avatar_id");
                AvatarDao avatarDao= daoObjectFactory.getAvatarDaoImpl();
                user.setAvatar(avatarDao.read(avatar_id));
            }
            return user;
        } catch (SQLException e) {
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
    public boolean isUniqueLogin(String login) throws DaoException {
        Connection con = null;
        String sql="SELECT `id` FROM `user` WHERE `login` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                 return false;
            }else return true;

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
    public List<User> readAllUsers(Role role) throws DaoException {
        Connection con = null;
        String sql="SELECT `id`,`info_id`,`login`, `password` FROM `user` WHERE `role` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DAOFactory daoObjectFactory=DAOFactory.getInstance();
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, role.ordinal());
            resultSet = statement.executeQuery();
            List<User> users=new ArrayList<>();
            User user = null;
            UserInfoDao userInfoDao= daoObjectFactory.getUserInfoDao();
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
    public Integer getInfoIdByUserId(Integer id) throws DaoException {
        Connection con = null;
        String sql = "SELECT `info_id` FROM `user` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer info_id=null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
               info_id=resultSet.getInt("info_id");

            }
            return info_id;
        } catch (SQLException e) {
            throw new DaoException(e);
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
    }

