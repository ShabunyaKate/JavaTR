package by.epam.musician.action.impl;

import by.epam.musician.action.BaseCommand;
import by.epam.musician.domain.Role;
import by.epam.musician.domain.User;
import by.epam.musician.service.LoginService;
import by.epam.musician.service.impl.LoginServiceImpl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginCommandImpl implements BaseCommand {

    private LoginService service = new LoginServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String path=null;
        try {
            User user = service.authorizeUser(login, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                switch (user.getRole()) {
                    case ADMINISTRATOR:
                        path=PAGE_ADMIN_INDEX;
                    break;
                    case MUSICIAN:
                        path=PAGE_MUSICIAN_INDEX;
                    break;
                    case USER:
                        path=PAGE_USER_INDEX;
                    break;
                }
                return path;
            }
        } catch (Exception e) {
           path=PAGE_ERROR;
        }
        return path;
    }}


