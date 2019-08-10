package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;

import by.epam.fest.dao.impl.MusicianDaoImpl;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.AdminService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class DeleteMusicianCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        String str=request.getParameter("musician_id");
        try {
           AdminService adminService= serviceFactory.getAdminService();
           adminService.deleteMusician(str);
            TableMusicianCommandImpl tableMusicianCommand=new TableMusicianCommandImpl();
            return tableMusicianCommand.execute(request);
        }catch (ServiceException e){
            return PAGE_ERROR;
        }
    }

}
