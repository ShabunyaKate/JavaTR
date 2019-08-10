package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.TicketUsageDaoImpl;
import by.epam.fest.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteUsageCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        TicketUsageDaoImpl usageDao=new TicketUsageDaoImpl();
      Integer id=Integer.valueOf(request.getParameter("usage_id"));
        try {
            usageDao.delete(id);
            TicketTableCommandImpl ticketTableCommand=new TicketTableCommandImpl();
            return ticketTableCommand.execute(request);
        } catch (DaoException e) {
            return PAGE_ERROR;
        }
    }
}
