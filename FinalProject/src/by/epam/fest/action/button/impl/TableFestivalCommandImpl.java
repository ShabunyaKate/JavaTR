package by.epam.fest.action.button.impl;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.DayDaoImpl;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.AdminService;
import by.epam.fest.service.ServiceFactory;

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
            ServiceFactory serviceFactory=ServiceFactory.getInstance();
            AdminService service=serviceFactory.getAdminService();
            List<Day> days=service.getAllDays();
            Map<Day,List<Musician>> linkedHashMap=service.getDaysMusicians(days);
            request.setAttribute("map",linkedHashMap);
            return PAGE_TABLE_FEST;
        }catch(ServiceException e){
            return PAGE_ERROR;
        }
    }
}
