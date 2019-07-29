package by.epam.fest.action.button.impl;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.MusicianDao;
import by.epam.fest.dao.SongDao;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.dao.impl.SongDaoImpl;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.User;
import by.epam.fest.service.LoginService;
import by.epam.fest.service.impl.LoginServiceImpl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SignInCommandImpl implements BaseCommand {

    private LoginService service = new LoginServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String path = null;
        try {
            HttpSession session = request.getSession(false);
            User user = service.authorizeUser(login, password);
            if (user != null) {
                switch (user.getRole()) {
                    case ADMINISTRATOR:
                        session.setAttribute("user", user);
                        path = PAGE_ADMIN_INDEX;
                        break;
                    case MUSICIAN:
                        MusicianDao musicianDao=new MusicianDaoImpl();
                        Musician musician = musicianDao.read(user);
                        SongDao songDao = new SongDaoImpl();
                        musician.setSongs(songDao.readAllSongsByMusician(musician.getId()));
                        session.setAttribute("musician",musician);
                        path = PAGE_MUSICIAN_INDEX;
                        break;
                    case USER:
                        session.setAttribute("user", user);
                        path = PAGE_USER_INDEX;
                        break;
                }
            } else {
                String s="Oшибка входа, введите данные повторно";
                session.setAttribute("exception",s);
                path = PAGE_SIGN_IN;
            }
            return path;
        } catch (Exception e) {
            return PAGE_ERROR;
        }
    }
}


