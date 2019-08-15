package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.TicketUsageDao;
import by.epam.fest.dao.impl.TicketUsageDaoImpl;
import by.epam.fest.domain.TicketUsage;
import by.epam.fest.domain.User;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.ServiceFactory;
import by.epam.fest.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class TicketTableCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        HttpSession session=request.getSession(false);
        User user=(User)session.getAttribute("user");
        try {
            Integer id=user.getId();
            List<TicketUsage> ticketUsages=userService.getAllTicketsByUserId(id);
            session.setAttribute("usages",ticketUsages);
            return PAGE_USER_TICKET;
        }catch (ServiceException e){
            return PAGE_ERROR;
        }
    }
}
