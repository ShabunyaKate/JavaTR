package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.TicketUsageDaoImpl;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.ServiceFactory;
import by.epam.fest.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteUsageCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        String id=request.getParameter("usage_id");
        try {
            userService.unbookTicket(id);
            TicketTableCommandImpl ticketTableCommand=new TicketTableCommandImpl();
            return ticketTableCommand.execute(request);
        } catch (ServiceException e) {
            return PAGE_ERROR;
        }
    }
}
