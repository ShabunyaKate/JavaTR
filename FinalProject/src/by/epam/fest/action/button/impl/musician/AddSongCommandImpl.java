package by.epam.fest.action.button.impl.musician;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.dao.SongDao;
import by.epam.fest.dao.impl.SongDaoImpl;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.Song;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddSongCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String name=request.getParameter("add_new_song");
        Song song=new Song();
        song.setSong(name);
        SongDao songDao=new SongDaoImpl();
        try {
            HttpSession session= request.getSession(false);
            Musician musician=(Musician)session.getAttribute("musician");
            song.setMusician_id(musician.getId());
            songDao.create(song);
            musician.add(song);
            session.setAttribute("musician",musician);
        }
        catch(Exception e){
        }
        //посмотреть на уникальность
        return PAGE_SONG_TABLE;
    }

}
