package by.epam.musician.action;

import javax.servlet.http.HttpServletRequest;

public interface BaseCommand {

    String RESPONSE_PAGE_USER_MAIN = "/WEB-INF/jsp/main.jsp";
    String PAGE_SIGN_IN="/WEB-INF/jsp/sign_in.jsp";
    String RESPONSE_PAGE_ERROR = "/error.jsp";
    String PAGE_REGISTRATION="/WEB-INF/jsp/user/user_registration.jsp";
    public String execute(HttpServletRequest request);
}