package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.DayDao;
import by.epam.fest.dao.MusicianDao;
import by.epam.fest.dao.UserDao;
import by.epam.fest.dao.impl.DayDaoImpl;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.dao.impl.UserDaoImpl;
import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Role;
import by.epam.fest.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddMusicianCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String str = request.getParameter("day_id");
        Integer day_id = Integer.valueOf(str);
        User user=new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(Role.MUSICIAN);
        user.setAvatar("img/avatar/bird.jpg");
        DayDao dayDao=new DayDaoImpl();
        try {
            Day day= dayDao.read(day_id);
            Musician musician=new Musician();
            musician.setUser(user);
            musician.setDay(day);
            MusicianDao musicianDao=new MusicianDaoImpl();
            HttpSession session = request.getSession(false);
            UserDao userDao=new UserDaoImpl();
            Integer user_id=userDao.create(user);
            user.setId(user_id);
            musician.setUser(user);
            musicianDao.create(musician);
            TableMusicianCommandImpl tableMusicianCommand=new TableMusicianCommandImpl();
            return tableMusicianCommand.execute(request);
        }catch (Exception e){
            return PAGE_ERROR;
        }
    }
}
