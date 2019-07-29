package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.UserDao;
import by.epam.fest.dao.UserInfoDao;
import by.epam.fest.dao.impl.UserDaoImpl;
import by.epam.fest.dao.impl.UserInfoDaoImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String str=request.getParameter("user_id");
        Integer id=Integer.valueOf(str);
        UserInfoDao userInfoDao=new UserInfoDaoImpl();
        UserDao userDao=new UserDaoImpl();
        try {
            userDao.delete(id);
            TableUserCommandImpl tableUserCommand=new TableUserCommandImpl();
            return tableUserCommand.execute(request);
        }catch (Exception e){
            return PAGE_ERROR;
        }

    }
}
