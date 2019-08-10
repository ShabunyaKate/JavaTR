package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.DayDaoImpl;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.AdminService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class TableMusicianCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        AdminService service=serviceFactory.getAdminService();
        try {
            List<Day> days=service.getAllDays();
            List<Musician> musicians=service.getAllMusicians();
            HttpSession session=request.getSession(false);
            session.setAttribute("musicians",musicians);
            request.setAttribute("days",days);
            return PAGE_ADMIN_MUSICIAN;
        }catch(ServiceException e){
            return PAGE_ERROR;
        }
    }
}