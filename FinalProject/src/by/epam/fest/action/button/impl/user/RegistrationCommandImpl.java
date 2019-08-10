package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.UserDao;
import by.epam.fest.dao.impl.UserDaoImpl;
import by.epam.fest.dao.impl.UserInfoDaoImpl;
import by.epam.fest.domain.Role;
import by.epam.fest.domain.User;
import by.epam.fest.domain.UserInfo;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.ClientService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class RegistrationCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        ClientService service=serviceFactory.getClientService();
        try {
            if(!service.cheakUniqueLogin(login)){
            String s="Такой логин уже существует";
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

            UserInfo userInfo=new UserInfo();
            userInfo.setName(name);
            userInfo.setSurname(surname);
            userInfo.setBirthdate(Date.valueOf(birthday));
            userInfo.setPhone(phone);
            userInfo.setEmail(email);

            User user=new User();
            user.setRole(Role.USER);
            user.setLogin(login);
            user.setPassword(password);
            user.setAvatar(avatar);
            user= service.registerNewUser(user,userInfo);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return PAGE_USER_INDEX;
        }
        catch (ServiceException e){
            return PAGE_ERROR;
        }
    }
}