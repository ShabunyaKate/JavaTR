package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.SongDao;
import by.epam.fest.dao.TicketUsageDao;
import by.epam.fest.dao.impl.SongDaoImpl;
import by.epam.fest.dao.impl.TicketUsageDaoImpl;
import by.epam.fest.domain.*;
import by.epam.fest.service.ServiceFactory;
import by.epam.fest.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BookTicketCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        String str= request.getParameter("book_id_ticket");
        String str1= request.getParameter("count");
        User user=(User)session.getAttribute("user");
        try {
            userService.bookTicket(str, user,str1);
           return PAGE_USER_BUY_TICKET;
        }
        catch(Exception e){
            return PAGE_ERROR;
        }
    }
}
