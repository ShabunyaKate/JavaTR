package by.epam.musician.action.impl.admin;

import by.epam.musician.action.BaseCommand;
import by.epam.musician.dao.UserDao;
import by.epam.musician.dao.UserInfoDao;
import by.epam.musician.dao.impl.UserDaoImpl;
import by.epam.musician.dao.impl.UserInfoDaoImpl;
import by.epam.musician.domain.UserInfo;
import by.epam.musician.exception.TaskException;

import javax.servlet.http.HttpServletRequest;


public class RemoveUserCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String str=request.getParameter("user_delete");
        Integer id=Integer.valueOf(str);
        UserInfoDao userInfoDao=new UserInfoDaoImpl();
        UserDao userDao=new UserDaoImpl();
      try {

          userDao.delete(id);
      }catch (Exception e){

      }
      return PAGE_TABLE_USER;
    }
}
