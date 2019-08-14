package by.epam.fest.service.impl;

import by.epam.fest.dao.DAOFactory;
import by.epam.fest.dao.TicketDao;
import by.epam.fest.dao.TicketUsageDao;
import by.epam.fest.domain.Ticket;
import by.epam.fest.domain.TicketUsage;
import by.epam.fest.domain.User;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.UserService;
import by.epam.fest.validation.Validation;
import by.epam.fest.validation.ValidationImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    DAOFactory factory = DAOFactory.getInstance();

    @Override
    public List<TicketUsage> getAllTicketsByUserId(Integer id) throws ServiceException {
        try {
            TicketUsageDao dao = factory.getTicketUsageDao();
            List<TicketUsage> ticketUsages = dao.readAllTicketsByUserId(id);
            return ticketUsages;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public List<Ticket> getAllTickets() throws ServiceException {
        try {
            TicketDao ticketDao = factory.getTicketDao();
            List<Ticket> tickets = ticketDao.readAllTickets();
            return tickets;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void bookTicket(String ticket_id, User user, String countStr) throws ServiceException {
        try {
            Validation validation=ValidationImpl.getInstance();
            Integer count = Integer.valueOf(countStr);
            if(validation.isPositiveNumber(count)){
            Integer id = Integer.valueOf(ticket_id);
            TicketUsage usage = new TicketUsage();
            Ticket ticket = new Ticket();
            ticket.setId(id);
            usage.setTicket(ticket);
            usage.setUser(user);
            usage.setCount(count);
            TicketUsageDao usageDao = factory.getTicketUsageDao();
            usageDao.create(usage);}
            else throw new ServiceException();
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void unbookTicket(String ticket_id) throws ServiceException {
        try {
            Integer id = Integer.valueOf(ticket_id);
            TicketUsageDao usageDao = factory.getTicketUsageDao();
            usageDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }
    }
