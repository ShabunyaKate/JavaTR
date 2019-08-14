package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.domain.LangHolder;
import by.epam.fest.domain.User;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.ClientService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;

public class RegistrationCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        ClientService service=serviceFactory.getClientService();
        try {
            if(!service.cheakUniqueLogin(login)){
            String s=" ";
            request.setAttribute("exception",s);
            return PAGE_REGISTRATION;
            }
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String birthday = request.getParameter("birthday");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String avatar =request.getParameter("avatar");
            User user= service.registerNewUser(name,surname,birthday,phone,email,login,password, avatar);
            session.setAttribute("user", user);
            return PAGE_USER_INDEX;
        }
        catch (ServiceException e){
            String str = (String)session.getAttribute("lang");
            LangHolder langHolder=LangHolder.getInstance();
            ResourceBundle bundle=ResourceBundle.getBundle("language", langHolder.getLocale());
            String s=bundle.getString("exception.repeat");
            request.setAttribute("repeat",s);
            return PAGE_REGISTRATION;
        }
    }
}