package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.UserDao;
import by.epam.fest.dao.impl.UserDaoImpl;
import by.epam.fest.domain.Role;
import by.epam.fest.domain.User;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TableUserCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
            try {
                UserDao userDao=new UserDaoImpl();
                List<User> users=userDao.readAllUsers(Role.USER);
                request.setAttribute("users",users);
            }catch(Exception e){
                return PAGE_ERROR;
            }
        return PAGE_TABLE_USER;
        }
    }

