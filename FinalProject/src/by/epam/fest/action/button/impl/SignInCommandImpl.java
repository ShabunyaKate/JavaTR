package by.epam.fest.action.button.impl;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.domain.Lang;
import by.epam.fest.domain.LangHolder;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.User;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.ClientService;
import by.epam.fest.service.MusicianService;
import by.epam.fest.service.ServiceFactory;
import sun.util.locale.LocaleUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;


public class SignInCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String path = null;
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        try {
            HttpSession session = request.getSession(false);
            ClientService clientService = serviceFactory.getClientService();
            User user = clientService.authorizeUser(login, password);
            if (user != null) {
                switch (user.getRole()) {
                    case ADMINISTRATOR:
                        session.setAttribute("admin", user);
                        path = PAGE_ADMIN_INDEX;
                        break;
                    case MUSICIAN:
                        MusicianService musicianService=serviceFactory.getMusicianService();
                        Musician musician= musicianService.getMusician(user);
                        session.setAttribute("musician",musician);
                        path = PAGE_MUSICIAN_INDEX;
                        break;
                    case USER:
                        session.setAttribute("user", user);
                        path = PAGE_USER_INDEX;
                        break;
                }
            } else {
                 String str = (String)session.getAttribute("lang");
                 LangHolder langHolder=LangHolder.getInstance();
                 ResourceBundle bundle=ResourceBundle.getBundle("language", langHolder.getLocale());
                 String s=bundle.getString("exception.signin");
                 request.setAttribute("exception",s);
                 path = PAGE_SIGN_IN;
            }
        } catch (ServiceException e) {
            String s="Oшибка входа, введите данные повторно";
            request.setAttribute("exception",s);
            path = PAGE_SIGN_IN;
        }
        finally {
            return path;
        }
    }
}


