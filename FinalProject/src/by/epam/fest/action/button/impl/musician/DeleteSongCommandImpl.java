package by.epam.fest.action.button.impl.musician;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.SongDao;
import by.epam.fest.dao.impl.SongDaoImpl;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Song;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.MusicianService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteSongCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        String str= request.getParameter("delete_id_song");
        Integer id=Integer.valueOf(str);
        MusicianService service = serviceFactory.getMusicianService();
        try {
            service.deleteSong(id);
            HttpSession session= request.getSession(false);
            Musician musician=(Musician)session.getAttribute("musician");
            musician= service.updateMusicianSongs(musician);
            session.setAttribute("musician",musician);
        }catch (ServiceException e){
        }
        finally {
            return PAGE_SONG_TABLE;
        }
    }
}
