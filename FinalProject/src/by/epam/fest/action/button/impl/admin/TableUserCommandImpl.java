package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.UserDao;
import by.epam.fest.dao.impl.UserDaoImpl;
import by.epam.fest.domain.Role;
import by.epam.fest.domain.User;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.AdminService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class TableUserCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        HttpSession session=request.getSession(false);
            try {
               AdminService service=serviceFactory.getAdminService();
               List<User> users= service.getAllUsers();
                session.setAttribute("users",users);
                return PAGE_TABLE_USER;
            }catch(ServiceException e){
                return PAGE_ERROR;
            }
        }
    }

