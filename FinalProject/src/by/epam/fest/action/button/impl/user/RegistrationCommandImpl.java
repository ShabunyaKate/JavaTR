package by.epam.fest.action.button.impl.user;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.impl.UserDaoImpl;
import by.epam.fest.dao.impl.UserInfoDaoImpl;
import by.epam.fest.domain.Role;
import by.epam.fest.domain.User;
import by.epam.fest.domain.UserInfo;

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
        String avatar =request.getParameter("avatar");
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
        user.setAvatar(avatar);
        UserDaoImpl userDao=new UserDaoImpl();
        try{
           Integer info_id=userInfoDao.create(userInfo);
            userInfo=userInfoDao.read(info_id);
             user.setUserInfo(userInfo);
             userDao.create(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return PAGE_SIGN_IN;/// переределеть
            //половину кинуть в сервис
            }catch (Exception e){

        }
        return PAGE_ERROR;
    }

}