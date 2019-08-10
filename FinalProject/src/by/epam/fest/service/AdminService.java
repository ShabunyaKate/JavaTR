package by.epam.fest.service;

import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.User;
import by.epam.fest.exception.ServiceException;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface AdminService {
    void deleteUser(String string) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    List<Day> getAllDays() throws ServiceException;

    Map<Day,List<Musician>> getDaysMusicians(List<Day> days) throws ServiceException;

    List<Musician> getAllMusicians() throws ServiceException;

    void addMusician(String login, String password,String day_id) throws ServiceException;

    void deleteMusician(String string) throws ServiceException;

    void addDayWithPrice(Date date, BigDecimal vip, BigDecimal fan, BigDecimal dance) throws ServiceException;
}

