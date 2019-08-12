package by.epam.fest.service.impl;

import by.epam.fest.dao.*;


import by.epam.fest.domain.*;
import by.epam.fest.exception.DaoException;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.AdminService;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements AdminService {
    private DAOFactory factory = DAOFactory.getInstance();

    @Override
    public void deleteUser(String str) throws ServiceException {
        Integer id = Integer.valueOf(str);
        try {
            UserInfoDao userInfoDao = factory.getUserInfoDao();
            UserDao userDao = factory.getUserDao();
            Integer info_id = userDao.getInfoIdByUserId(id);
            userDao.delete(id);
            userInfoDao.delete(info_id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        try {
            UserDao userDao = factory.getUserDao();
            List<User> users = userDao.readAllUsers(Role.USER);
            return users;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Day> getAllDays() throws ServiceException {
        try {
            DayDao dayDao = factory.getDayDao();
            List<Day> days = dayDao.readAllDays();
            return days;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Map<Day, List<Musician>> getDaysMusicians(List<Day> days) throws ServiceException {
        try {
            List<Musician> musicians;
            MusicianDao musicianDao = factory.getMusicianDao();
            Map<Day, List<Musician>> linkedHashMap = new LinkedHashMap<>();
            for (Day day : days) {
                musicians = musicianDao.readAllMusicianByDay(day);
                linkedHashMap.put(day, musicians);
            }
            return linkedHashMap;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Musician> getAllMusicians() throws ServiceException {
        try {
            MusicianDao musicianDao = factory.getMusicianDao();
            List<Musician> musicians = musicianDao.readAllMusician();
            return musicians;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addMusician(String login, String password, String day_str) throws ServiceException {
        try {
            Integer day_id = Integer.valueOf(day_str);
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(Role.MUSICIAN);
            DayDao dayDao = factory.getDayDao();
            MusicianDao musicianDao = factory.getMusicianDao();
            UserDao userDao = factory.getUserDao();
            Day day = dayDao.read(day_id);
            Musician musician = new Musician();
            musician.setUser(user);
            musician.setDay(day);
            Integer user_id = userDao.create(user);
            user.setId(user_id);
            musician.setUser(user);
            musicianDao.create(musician);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteMusician(String str) throws ServiceException {
        try {
            Integer id = Integer.valueOf(str);
            MusicianDao musicianDao = factory.getMusicianDao();
            UserDao userDao = factory.getUserDao();
            Integer user_id = musicianDao.getUserIdByMusicianId(id);
            musicianDao.delete(id);
            userDao.delete(user_id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addDayWithPrice(Date date, BigDecimal vip, BigDecimal fan, BigDecimal dance) throws ServiceException {
        try {
            DayDao dayDao = factory.getDayDao();
            Day day = new Day();
            day.setDate(date);
            Integer day_id = dayDao.create(day);
            day.setId(day_id);
            TicketDao ticketDao = factory.getTicketDao();
            Ticket ticket = new Ticket();
            ticket.setDay(day);
            ticket.setType(TicketType.VIP);
            ticket.setPrice(vip);
            ticketDao.create(ticket);
            ticket.setType(TicketType.FAN_ZONE);
            ticket.setPrice(fan);
            ticketDao.create(ticket);
            ticket.setType(TicketType.DANCE_FlOOR);
            ticket.setPrice(dance);
            ticketDao.create(ticket);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updatePrices(Integer day_id, BigDecimal vip, BigDecimal fan, BigDecimal dance) throws ServiceException {
        try {
            TicketDao ticketDao = factory.getTicketDao();
            ticketDao.updatePriceByDayAndType(day_id,TicketType.VIP,vip);
            ticketDao.updatePriceByDayAndType(day_id,TicketType.FAN_ZONE,fan);
            ticketDao.updatePriceByDayAndType(day_id,TicketType.DANCE_FlOOR,dance);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
