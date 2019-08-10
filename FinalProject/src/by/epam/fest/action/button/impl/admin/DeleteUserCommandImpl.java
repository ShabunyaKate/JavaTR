package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.AdminService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        String str=request.getParameter("user_id");
        String path=null;
        try {
            AdminService service=serviceFactory.getAdminService();
            service.deleteUser(str);
            TableUserCommandImpl tableUserCommand=new TableUserCommandImpl();
            path= tableUserCommand.execute(request);
            return path;
        }catch (ServiceException e){
            String s="User has tickets";
            request.setAttribute("excep_id",Integer.valueOf(str));
            request.setAttribute("exception",s);
            path = PAGE_ADMIN_USER;
        }
        finally {
            return path;
        }
    }
}
