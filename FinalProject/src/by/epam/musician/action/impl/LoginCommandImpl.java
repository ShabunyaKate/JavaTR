package by.epam.musician.action.impl;

import by.epam.musician.action.BaseCommand;
import by.epam.musician.domain.User;
import by.epam.musician.service.LoginService;
import by.epam.musician.service.impl.LoginServiceImpl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class LoginCommandImpl implements BaseCommand {

    private LoginService service = new LoginServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        User user = service.authorizeUser(login, password);
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return RESPONSE_PAGE_USER_MAIN;
        }
        // проверяем роль
        return RESPONSE_PAGE_ERROR;
    }

}
