package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.DayDao;
import by.epam.fest.dao.MusicianDao;
import by.epam.fest.dao.UserDao;
import by.epam.fest.dao.impl.DayDaoImpl;
import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.dao.impl.UserDaoImpl;
import by.epam.fest.domain.Day;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Role;
import by.epam.fest.domain.User;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.AdminService;
import by.epam.fest.service.ClientService;
import by.epam.fest.service.ServiceFactory;
import by.epam.fest.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddMusicianCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String day = request.getParameter("day_id");
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        try {
            AdminService service=serviceFactory.getAdminService();
            ClientService clientService=serviceFactory.getClientService();
                if(!clientService.cheakUniqueLogin(login)){
                    String s="Такой музыкант уже есть";
                    request.setAttribute("exception",s);
                    return PAGE_ADMIN_MUSICIAN;
                }
                service.addMusician(login,password,day);
            TableMusicianCommandImpl tableMusicianCommand=new TableMusicianCommandImpl();
            return tableMusicianCommand.execute(request);
        }catch (ServiceException e){
            return PAGE_ERROR;
        }
    }
}
