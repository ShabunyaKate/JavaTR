package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.TicketDaoImpl;
import by.epam.fest.domain.Ticket;
import by.epam.fest.exception.TaskException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class TicketsCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        TicketDaoImpl ticketDao=new TicketDaoImpl();
        List<Ticket> tickets= null;
        try {
            tickets = ticketDao.readAllTickets();
            session.setAttribute("tickets",tickets);
            return PAGE_USER_BUY_TICKET;
        } catch (TaskException e) {
           return PAGE_ERROR;
        }
    }
}
