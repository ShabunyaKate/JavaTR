package by.epam.fest.action.button.impl;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.DayDaoImpl;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TableFestivalCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            DayDaoImpl dayDao = new DayDaoImpl();
            List<Day> days = dayDao.readAllDays();
            MusicianDaoImpl musicianDao=new MusicianDaoImpl();
            List<Musician> musicians;
            Map<Day,List<Musician>> linkedHashMap = new LinkedHashMap<>();
            for (Day day: days) {
                 musicians=musicianDao.readAllMusicianByDay(day);
                 linkedHashMap.put(day, musicians);
            }
            request.setAttribute("map",linkedHashMap);
            return PAGE_TABLE_FEST;
        }catch(Exception e){
            return PAGE_ERROR;
        }
    }
}
