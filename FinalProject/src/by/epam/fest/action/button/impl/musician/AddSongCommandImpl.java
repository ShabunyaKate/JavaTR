package by.epam.fest.action.button.impl.musician;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.SongDao;
import by.epam.fest.dao.impl.SongDaoImpl;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Song;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.MusicianService;
import by.epam.fest.service.ServiceFactory;
import by.epam.fest.service.impl.MusicianServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddSongCommandImpl implements BaseCommand {
    ServiceFactory serviceFactory=ServiceFactory.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        MusicianService service = serviceFactory.getMusicianService();
        String name = request.getParameter("add_new_song");
        HttpSession session = request.getSession(false);
        Musician musician = (Musician) session.getAttribute("musician");
        Song song = new Song();
        song.setSong(name);
        song.setMusician_id(musician.getId());
        try {
           Integer id_new_song= service.addSong(song);
           song.setId(id_new_song);
            musician.add(song);
            session.setAttribute("musician", musician);
        } catch (ServiceException e) {
        } finally {
            return PAGE_SONG_TABLE;
        }
    }

}
