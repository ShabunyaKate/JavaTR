package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.DayDaoImpl;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class TableMusicianCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            DayDaoImpl dayDao=new DayDaoImpl();
            List<Day> days=dayDao.readAllDays();
            MusicianDaoImpl musicianDao=new MusicianDaoImpl();
            List<Musician> musicians=musicianDao.readAllMusician();
            HttpSession session=request.getSession(false);
            session.setAttribute("musicians",musicians);
            session.setAttribute("days",days);
            return PAGE_ADMIN_MUSICIAN;
        }catch(Exception e){
            return PAGE_ERROR;
        }
    }
}