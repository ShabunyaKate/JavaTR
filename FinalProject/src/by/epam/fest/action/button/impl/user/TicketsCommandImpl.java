package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.TicketDaoImpl;
import by.epam.fest.domain.Ticket;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.ServiceFactory;
import by.epam.fest.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class TicketsCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        try {
            List<Ticket> tickets = userService.getAllTickets();
            session.setAttribute("tickets",tickets);
            return PAGE_USER_BUY_TICKET;
        } catch (ServiceException e) {
           return PAGE_ERROR;
        }
    }
}
