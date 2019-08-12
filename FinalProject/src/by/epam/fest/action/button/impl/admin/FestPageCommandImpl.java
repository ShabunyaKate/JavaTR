package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.DayDaoImpl;
import by.epam.fest.domain.Day;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

public class FestPageCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession session=request.getSession(false);
            DayDaoImpl dayDao = new DayDaoImpl();
            List<Day> days = dayDao.readAllDays();
            session.setAttribute("days", days);
            return PAGE_ADMIN_FEST;
        } catch (Exception e) {
            return PAGE_ERROR;
        }
    }

}
