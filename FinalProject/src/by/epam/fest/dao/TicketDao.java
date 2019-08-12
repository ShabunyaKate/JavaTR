package by.epam.fest.dao;

import by.epam.fest.domain.Day;
import by.epam.fest.domain.Ticket;
import by.epam.fest.domain.TicketType;
import by.epam.fest.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface TicketDao extends Dao<Ticket> {
    List<Ticket> readAllTickets()throws DaoException;
    void updatePriceByDayAndType(Integer day_id,TicketType type, BigDecimal price) throws DaoException;
}
