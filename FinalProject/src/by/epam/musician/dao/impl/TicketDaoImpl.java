//package by.epam.musician.dao.impl;
//
//import by.epam.musician.domain.Ticket;
//import by.epam.musician.domain.TicketType;
//import by.epam.musician.dao.TicketDao;
//import by.epam.musician.domain.Day;
//import by.epam.musician.exception.TaskException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class TicketDaoImpl extends DaoImpl implements TicketDao {
//    private static Logger logger = LogManager.getLogger(TicketDaoImpl.class);
//    @Override
//    public Integer create(Ticket ticket) throws TaskException {
//        String sql = "INSERT INTO `ticket` (`type_id`, `day_id`, `price`) VALUES (?, ?, ?)";
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            statement.setInt(1, ticket.getType().getId());
//            statement.setInt(2, ticket.getDay().getId());
//            statement.setBigDecimal(3, ticket.getPrice());
//            statement.executeUpdate();
//            resultSet = statement.getGeneratedKeys();
//            if(resultSet.next()) {
//                return resultSet.getInt(1);
//            } else {
//                logger.error("There is no autoincremented index after trying to add record into table `ticket`");
//                throw  new TaskException();
//            }
//        } catch(SQLException e) {
//            throw new TaskException(e);
//        } finally {
//            try {
//                resultSet.close();
//            } catch(SQLException | NullPointerException e) {}
//            try {
//                statement.close();
//            } catch(SQLException | NullPointerException e) {}
//        }
//    }
//
//    @Override
//    public Ticket read(Integer id) throws TaskException {
//        String sql = "SELECT `type_id`, `day_id`, `price` FROM `ticket` WHERE `id` = ?";
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            resultSet = statement.executeQuery();
//            Ticket ticket = null;
//            if(resultSet.next()) {
//                ticket = new Ticket();
//                ticket.setId(id);
//                Day day=new Day();
//                day.setId(resultSet.getInt("day_id"));
//                ticket.setDay(day);
//                TicketType ticketType=new TicketType();
//                ticketType.setId(resultSet.getInt("type_id"));
//                ticket.setType(ticketType);
//                ticket.setPrice(resultSet.getBigDecimal("price"));
//            }
//            return ticket;
//        } catch(SQLException e) {
//            throw new TaskException(e);
//        } finally {
//            try {
//                resultSet.close();
//            } catch(SQLException | NullPointerException e) {}
//            try {
//                statement.close();
//            } catch(SQLException | NullPointerException e) {}
//        }
//    }
//
//    @Override
//    public void update(Ticket ticket) throws TaskException {
//        String sql = "UPDATE `ticket` SET `type_id` = ?, `day_id` = ?, `price` = ? WHERE `id` = ?";
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, ticket.getType().getId());
//            statement.setInt(2, ticket.getDay().getId());
//            statement.setBigDecimal(3, ticket.getPrice());
//            statement.executeUpdate();
//        } catch(SQLException e) {
//            throw new TaskException(e);
//        } finally {
//            try {
//                statement.close();
//            } catch(SQLException | NullPointerException e) {}
//        }
//    }
//
//    @Override
//    public void delete(Integer id) throws TaskException {
//        String sql = "DELETE FROM `ticket` WHERE `id` = ?";
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        } catch(SQLException e) {
//            throw new TaskException(e);
//        } finally {
//            try {
//                statement.close();
//            } catch(SQLException | NullPointerException e) {}
//        }
//    }
//}
