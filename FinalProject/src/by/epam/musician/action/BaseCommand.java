package by.epam.musician.action;

import javax.servlet.http.HttpServletRequest;

public interface BaseCommand {

    String RESPONSE_PAGE_USER_MAIN = "/WEB-INF/jsp/main.jsp";
    String PAGE_SIGN_IN="/WEB-INF/jsp/sign_in.jsp";
    String PAGE_ERROR = "/error.jsp";
    String PAGE_REGISTRATION="/WEB-INF/jsp/user/registration.jsp";
    String PAGE_TABLE_FEST="/WEB-INF/jsp/table_fest.jsp";
    String PAGE_SONG_TABLE="/WEB-INF/jsp/musician/song_table.jsp";
    String PAGE_DEFAULT="/index.jsp";
    String PAGE_TABLE_USER="/WEB-INF/jsp/admin/user_table.jsp";
    String execute(HttpServletRequest request);
}