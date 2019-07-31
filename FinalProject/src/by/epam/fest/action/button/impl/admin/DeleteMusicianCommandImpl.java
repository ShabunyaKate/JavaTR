package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;

import by.epam.fest.dao.impl.MusicianDaoImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteMusicianCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String str=request.getParameter("musician_id");
        Integer id=Integer.valueOf(str);
        MusicianDaoImpl musicianDao=new MusicianDaoImpl();
        try {
            musicianDao.delete(id);
            TableMusicianCommandImpl tableMusicianCommand=new TableMusicianCommandImpl();
            return tableMusicianCommand.execute(request);
        }catch (Exception e){
            return PAGE_ERROR;
        }
    }

}
