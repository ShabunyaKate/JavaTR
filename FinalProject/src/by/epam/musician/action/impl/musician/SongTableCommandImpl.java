package by.epam.musician.action.impl.musician;

import by.epam.musician.action.BaseCommand;
import by.epam.musician.dao.SongDao;
import by.epam.musician.dao.impl.SongDaoImpl;
import by.epam.musician.domain.Musician;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SongTableCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Musician musician = (Musician) session.getAttribute("musician");
        SongDao songDao = new SongDaoImpl();
        try {
            if (musician.getSongs().isEmpty()) {
                musician.setSongs(songDao.readAllSongsByMusician(musician.getId()));
            }
            request.setAttribute("songs",musician.getSongs());
            return PAGE_SONG_TABLE;
        } catch (Exception e) {
            return PAGE_ERROR;
        }
    }
}