package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.TicketUsageDao;
import by.epam.fest.dao.impl.TicketUsageDaoImpl;
import by.epam.fest.domain.TicketUsage;
import by.epam.fest.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class TicketTableCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        User user=(User)session.getAttribute("user");
        TicketUsageDao usageDao=new TicketUsageDaoImpl();
        List<TicketUsage> ticketUsages;
        try {
           ticketUsages= usageDao.readAllTicketsByUserId(user.getId());
            session.setAttribute("usages",ticketUsages);
            return PAGE_USER_TICKET;
        }catch (Exception e){
            return PAGE_ERROR;
        }
    }
}
