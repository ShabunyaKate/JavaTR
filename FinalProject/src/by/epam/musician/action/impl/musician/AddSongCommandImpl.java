package by.epam.musician.action.impl.musician;

import by.epam.musician.action.BaseCommand;
import by.epam.musician.domain.Musician;
import by.epam.musician.domain.Song;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddSongCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Musician musician = (Musician) session.getAttribute("musician");
        String name=request.getParameter("song");
        Song song=new Song();
        song.setSong(name);
        //переделать дао, чтобы дао нормально выводило сонги и сетало музыкантов
        //посмотреть на уникальность
        return PAGE_ERROR;
    }

}
