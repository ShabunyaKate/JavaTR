package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.SongDao;
import by.epam.fest.dao.TicketUsageDao;
import by.epam.fest.dao.impl.SongDaoImpl;
import by.epam.fest.dao.impl.TicketUsageDaoImpl;
import by.epam.fest.domain.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BookTicketCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session= request.getSession(false);
        String str= request.getParameter("book_id_ticket");
        Integer id=Integer.valueOf(str);
        String str1= request.getParameter("count");
        Integer count=Integer.valueOf(str1);
        TicketUsageDao usageDao=new TicketUsageDaoImpl();
        TicketUsage usage=new TicketUsage();
        Ticket ticket=new Ticket();
        ticket.setId(id);
         User user=(User)session.getAttribute("user");
         usage.setTicket(ticket);
         usage.setUser(user);
         usage.setCount(count);
        try {
            usageDao.create(usage);
           return PAGE_USER_BUY_TICKET;
        }
        catch(Exception e){
            return PAGE_ERROR;
        }
        //посмотреть на уникальность

    }
}
