package by.epam.fest.controller;
import by.epam.fest.domain.Musician;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.MusicianService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;


@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory=ServiceFactory.getInstance();
        MusicianService service= factory.getMusicianService();
        HttpSession session=request.getSession(false);
        Musician musician=(Musician) session.getAttribute("musician");
        Integer musician_id=musician.getId();
        try {
            for (Part part : request.getParts()) {
                InputStream inputStream = part.getInputStream();
                service.downloadImageIntoDB(inputStream,musician_id);
            }
        }catch(ServiceException e){
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/musician/photo.jsp");
        requestDispatcher.forward(request, response);
    }
}