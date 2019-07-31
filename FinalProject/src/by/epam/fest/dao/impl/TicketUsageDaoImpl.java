package by.epam.fest.dao.impl;

import by.epam.fest.dao.TicketDao;
import by.epam.fest.dao.TicketUsageDao;
import by.epam.fest.domain.Ticket;
import by.epam.fest.domain.TicketUsage;
import by.epam.fest.domain.User;
import by.epam.fest.exception.TaskException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketUsageDaoImpl extends DaoImpl implements TicketUsageDao {
    private static Logger logger = LogManager.getLogger(TicketUsageDaoImpl.class);

    @Override
    public Integer create(TicketUsage ticketUsage) throws TaskException {
        Connection con = null;
        String sql = "INSERT INTO `ticket_user` (`ticket_id`, `count`, `user_id`) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, ticketUsage.getTicket().getId());
            statement.setInt(2, ticketUsage.getCount());
            statement.setInt(3, ticketUsage.getUser().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `ticket_user`");
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
    public TicketUsage read(Integer id) throws TaskException {
        Connection con = null;
        String sql = "SELECT `ticket_id`, `count`, `user_id` FROM `ticket_user` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            TicketUsage ticketUsage = null;
            if (resultSet.next()) {
                ticketUsage = new TicketUsage();
                ticketUsage.setId(id);
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getInt("ticket_id"));
                ticketUsage.setTicket(ticket);
                ticketUsage.setCount(resultSet.getInt("count"));
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                ticketUsage.setUser(user);
            }
            return ticketUsage;
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
    public void update(TicketUsage ticketUsage) throws TaskException {
        Connection con = null;
        String sql = "UPDATE `ticket_user` SET `ticket_id` = ?, `count` = ?, `user_id` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, ticketUsage.getTicket().getId());
            statement.setInt(2, ticketUsage.getCount());
            statement.setInt(3, ticketUsage.getUser().getId());
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
        String sql = "DELETE FROM `ticket_user` WHERE `id` = ?";
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
    public List<TicketUsage> readAllTicketsByUserId(Integer id) throws TaskException {
        Connection con = null;
        String sql = "SELECT `id`,`ticket_id`, `count`,`user_id` FROM `ticket_user` WHERE `user_id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            TicketUsage ticketUsage = null;
            List<TicketUsage> ticketUsages = new ArrayList<>();
            TicketDao ticketDao = new TicketDaoImpl();
            while (resultSet.next()) {
                ticketUsage = new TicketUsage();
                ticketUsage.setId(resultSet.getInt("id"));
                Ticket ticket = ticketDao.read(resultSet.getInt("ticket_id"));
                ticketUsage.setTicket(ticket);
                ticketUsage.setCount(resultSet.getInt("count"));
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                ticketUsage.setUser(user);
                ticketUsages.add(ticketUsage);
            }
            return ticketUsages;
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
    }


