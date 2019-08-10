package by.epam.fest.dao;

import by.epam.fest.dao.impl.*;
import by.epam.fest.service.ServiceFactory;

public final class DAOFactory {

    private final DayDao dayDaoImpl = new DayDaoImpl();
    private final MusicianDao musicianDaoImpl = new MusicianDaoImpl();
    private final SongDao songDaoImpl = new SongDaoImpl();
    private final TicketDao ticketDaoImpl = new TicketDaoImpl();
    private final TicketUsageDao ticketUsageDaoImpl = new TicketUsageDaoImpl();
    private final UserDao userDaoImpl = new UserDaoImpl();
    private final UserInfoDao userInfoDaoImpl = new UserInfoDaoImpl();
    private final AvatarDao avatarDaoImpl = new AvatarDaoImpl();

    private DAOFactory() {
    }

    private static class LazyHolder {
        public static final DAOFactory INSTANCE = new DAOFactory();
    }

    public static DAOFactory getInstance() {
        return DAOFactory.LazyHolder.INSTANCE;
    }

    public DayDao getDayDao() {
        return dayDaoImpl;
    }

    public MusicianDao getMusicianDao() {
        return musicianDaoImpl;
    }

    public SongDao getSongDao() {
        return songDaoImpl;
    }

    public TicketDao getTicketDao() {
        return ticketDaoImpl;
    }

    public TicketUsageDao getTicketUsageDao() {
        return ticketUsageDaoImpl;
    }

    public UserDao getUserDao() {
        return userDaoImpl;
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDaoImpl;
    }

    public AvatarDao getAvatarDaoImpl() {
        return avatarDaoImpl;
    }
}

