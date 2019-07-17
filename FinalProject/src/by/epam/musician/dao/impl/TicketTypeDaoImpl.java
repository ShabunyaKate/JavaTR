//package by.epam.musician.dao.impl;
//
//import by.epam.musician.domain.TicketType;
//import by.epam.musician.dao.TicketTypeDao;
//import by.epam.musician.exception.TaskException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class TicketTypeDaoImpl extends BaseDaoImpl implements TicketTypeDao {
//    private static Logger logger = LogManager.getLogger(TicketTypeDao.class);
//
//    @Override
//    public Integer create(TicketType ticketType) throws TaskException {
//        String sql = "INSERT INTO `ticket_type` (`type`) VALUES (?)";
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1, ticketType.getType());
//            statement.executeUpdate();
//            resultSet = statement.getGeneratedKeys();
//            if (resultSet.next()) {
//                return resultSet.getInt(1);
//            } else {
//                logger.error("There is no autoincremented index after trying to add record into table `ticket_type`");
//                throw new TaskException();
//            }
//        } catch (SQLException e) {
//            throw new TaskException(e);
//        } finally {
//            try {
//                resultSet.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
//    }
//
//    @Override
//    public TicketType read(Integer id) throws TaskException {
//        String sql = "SELECT `type` FROM `ticket_type` WHERE `id` = ?";
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            resultSet = statement.executeQuery();
//            TicketType ticketType = null;
//            if (resultSet.next()) {
//                ticketType = new TicketType();
//                ticketType.setId(id);
//                ticketType.setType(resultSet.getString("type"));
//            }
//            return ticketType;
//        } catch (SQLException e) {
//            throw new TaskException(e);
//        } finally {
//            try {
//                resultSet.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
//    }
//
//    @Override
//    public void update(TicketType ticketType) throws TaskException {
//        String sql = "UPDATE `ticket_type` SET `type` = ? WHERE `id` = ?";
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setString(1, ticketType.getType());
//            statement.setInt(2, ticketType.getId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new TaskException(e);
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
//    }
//
//    @Override
//    public void delete(Integer id) throws TaskException {
//        String sql = "DELETE FROM `ticket_type` WHERE `id` = ?";
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new TaskException(e);
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
//    }
//}
