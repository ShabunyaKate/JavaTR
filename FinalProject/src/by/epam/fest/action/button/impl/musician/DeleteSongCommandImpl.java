package by.epam.fest.action.button.impl.musician;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.SongDao;
import by.epam.fest.dao.impl.SongDaoImpl;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Song;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteSongCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String str= request.getParameter("delete_id_song");
        Integer id=Integer.valueOf(str);
        SongDao songDao=new SongDaoImpl();
        try {
            Song song=songDao.read(id);
            songDao.delete(id);
           HttpSession session= request.getSession(false);
            Musician musician=(Musician)session.getAttribute("musician");
            musician.remove(song);
            session.setAttribute("musician",musician);
        }catch (Exception e){
        }
        return PAGE_SONG_TABLE;
    }
}
