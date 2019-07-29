package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.DayDaoImpl;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class TableMusicianCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            DayDaoImpl dayDao = new DayDaoImpl();
            List<Day> days = dayDao.readAllDays();
            MusicianDaoImpl musicianDao=new MusicianDaoImpl();
            List<Musician> musicians=new ArrayList<>();
            int COUNT=0;
            for (Day day: days) {
                musicians=musicianDao.readAllMusicianByDay(day);
                request.setAttribute("day"+COUNT,day);
                request.setAttribute("musicians"+COUNT,musicians);
                COUNT++;
            }
            return PAGE_TABLE_FEST;
        }catch(Exception e){
            return PAGE_ERROR;
        }
    }
}