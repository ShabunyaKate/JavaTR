package by.epam.fest.dao.impl;

import by.epam.fest.domain.Ticket;
import by.epam.fest.domain.TicketType;
import by.epam.fest.dao.TicketDao;
import by.epam.fest.domain.Day;
import by.epam.fest.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl extends DaoImpl implements TicketDao {
    private static Logger logger = LogManager.getLogger(TicketDaoImpl.class);
    @Override
    public Integer create(Ticket ticket) throws DaoException {
        Connection con = null;
        String sql = "INSERT INTO `ticket` (`type`, `day_id`, `price`) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, ticket.getType().getId());
            statement.setInt(2, ticket.getDay().getId());
            statement.setBigDecimal(3, ticket.getPrice());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `ticket`");
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
    public Ticket read(Integer id) throws DaoException {
        Connection con = null;
        String sql = "SELECT `type`, `day_id`, `price` FROM `ticket` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Ticket ticket = null;
            if(resultSet.next()) {
                ticket = new Ticket();
                ticket.setId(id);
                DayDaoImpl dayDao=new DayDaoImpl();
                Day day=dayDao.read(resultSet.getInt("day_id"));
                ticket.setDay(day);
                ticket.setType(TicketType.getById(resultSet.getInt("type")));
                ticket.setPrice(resultSet.getBigDecimal("price"));
            }
            return ticket;
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
    public void update(Ticket ticket) throws DaoException {
        Connection con = null;
        String sql = "UPDATE `ticket` SET `type` = ?, `day_id` = ?, `price` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, ticket.getType().getId());
            statement.setInt(2, ticket.getDay().getId());
            statement.setBigDecimal(3, ticket.getPrice());
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
        String sql = "DELETE FROM `ticket` WHERE `id` = ?";
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

    @Override
    public List<Ticket> readAllTickets() throws DaoException {
        Connection con = null;
        String sql = "SELECT `id`, `type`, `day_id`, `price` FROM `ticket`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Ticket ticket = null;
            List<Ticket> tickets= new ArrayList<>();
            while(resultSet.next()) {
                ticket = new Ticket();
                ticket.setId(resultSet.getInt("id"));
                DayDaoImpl dayDao=new DayDaoImpl();
                Day day=dayDao.read(resultSet.getInt("day_id"));
                ticket.setDay(day);
                ticket.setType(TicketType.getById(resultSet.getInt("type")));
                ticket.setPrice(resultSet.getBigDecimal("price"));
                tickets.add(ticket);
            }
            return tickets;
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
    public void updatePriceByDayAndType(Integer day_id, TicketType type, BigDecimal price) throws DaoException {
        Connection con = null;
        String sql = "UPDATE `ticket` SET `price` = ? WHERE `type` = ? AND `day_id`=?";
        PreparedStatement statement = null;
        try {
            con = getDBConnection();
            statement = con.prepareStatement(sql);
            statement.setBigDecimal(1,price);
            statement.setInt(2,type.getId() );
            statement.setInt(3, day_id);
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
