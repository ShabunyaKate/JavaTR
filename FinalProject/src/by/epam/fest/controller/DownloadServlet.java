package by.epam.fest.controller;
import by.epam.fest.domain.Musician;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.MusicianService;
import by.epam.fest.service.ServiceFactory;
import by.epam.fest.validation.Validation;
import by.epam.fest.validation.ValidationImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;


@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServiceFactory factory=ServiceFactory.getInstance();
        MusicianService service= factory.getMusicianService();
        HttpSession session=request.getSession(false);
        Musician musician=(Musician) session.getAttribute("musician");
        Integer musician_id=musician.getId();
        Validation validation= ValidationImpl.getInstance();
        try {
            for (Part part : request.getParts()) {
               if(validation.isFormatFle( part.getSubmittedFileName())) {
                   InputStream inputStream = part.getInputStream();
                   service.downloadImageIntoDB(inputStream, musician_id);
               } else throw new ServiceException();
            }
        }catch(Exception e){
            String s="Ошибка загрузки файла, повторите еще раз";
            request.setAttribute("exceptionD",s);
        }
        response.sendRedirect("ProjectServlet?link=songs");
    }
}