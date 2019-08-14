package by.epam.fest.service;

import by.epam.fest.domain.Ticket;
import by.epam.fest.domain.TicketUsage;
import by.epam.fest.domain.User;
import by.epam.fest.exception.ServiceException;

import java.util.List;

public interface UserService {
    List<TicketUsage> getAllTicketsByUserId(Integer id) throws ServiceException;

    List<Ticket> getAllTickets() throws ServiceException;

    void bookTicket(String ticket_id, User user, String count) throws ServiceException;

    void unbookTicket(String id) throws ServiceException;
}
