package by.epam.musician.action.impl.admin;

import by.epam.musician.action.BaseCommand;
import by.epam.musician.dao.UserDao;
import by.epam.musician.dao.impl.UserDaoImpl;
import by.epam.musician.domain.Role;
import by.epam.musician.domain.User;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TableUserCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
            try {
                UserDao userDao=new UserDaoImpl();
                List<User> users=userDao.readAllUsers(Role.USER);
                request.setAttribute("users",users);
                return PAGE_TABLE_USER;
            }catch(Exception e){
                return PAGE_ERROR;
            }
        }
    }

