package by.epam.musician.action.impl;

import by.epam.musician.action.BaseCommand;
import by.epam.musician.dao.UserInfoDao;
import by.epam.musician.dao.impl.UserDaoImpl;
import by.epam.musician.dao.impl.UserInfoDaoImpl;
import by.epam.musician.domain.Role;
import by.epam.musician.domain.User;
import by.epam.musician.domain.UserInfo;
import by.epam.musician.service.LoginService;
import by.epam.musician.service.impl.LoginServiceImpl;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class RegistrationCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserInfo userInfo=new UserInfo();
        //Это в фабрику и валидацию
        userInfo.setName(name);
        userInfo.setSurname(surname);
        userInfo.setBirthdate(Date.valueOf(birthday));
        userInfo.setPhone(phone);
        userInfo.setEmail(email);
        UserInfoDaoImpl userInfoDao=new UserInfoDaoImpl();
        User user=new User();
        user.setRole(Role.USER);
        user.setLogin(login);
        user.setPassword(password);
        UserDaoImpl userDao=new UserDaoImpl();
        try{
           Integer info_id=userInfoDao.create(userInfo);
            userInfo=userInfoDao.read(info_id);
             user.setUserInfo(userInfo);
             userDao.create(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return RESPONSE_PAGE_USER_MAIN;
            //половину кинуть в сервис
            }catch (Exception e){

        }

        return RESPONSE_PAGE_ERROR;
    }

}