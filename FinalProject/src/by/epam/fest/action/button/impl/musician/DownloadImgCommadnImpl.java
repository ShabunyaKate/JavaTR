package by.epam.fest.action.button.impl.musician;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.domain.Musician;
import by.epam.fest.service.MusicianService;
import by.epam.fest.service.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.InputStream;

public class DownloadImgCommadnImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
//        ServiceFactory factory=ServiceFactory.getInstance();
//        MusicianService service= factory.getMusicianService();
//        HttpSession session=request.getSession(false);
//        Musician musician=(Musician) session.getAttribute("musician");
//        Integer musician_id=musician.getId();
//        try {
//            for (Part part : request.getParts()) {
//                InputStream inputStream = part.getInputStream();
//                service.downloadImageIntoDB(inputStream,musician_id);
//            }
//        }catch(Exception e){
//            String s="Ошибка загрузки файла, повторите еще раз";
//            request.setAttribute("exception",s);
//        }
        return PAGE_SONG_TABLE;
    }
}
