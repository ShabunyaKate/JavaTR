package by.epam.fest.dao;

import by.epam.fest.domain.Ticket;
import by.epam.fest.exception.TaskException;

import java.util.List;

public interface TicketDao extends Dao<Ticket> {
    List<Ticket> readAllTickets()throws TaskException;
}
