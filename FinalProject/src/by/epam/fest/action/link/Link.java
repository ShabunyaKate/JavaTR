package by.epam.fest.action.link;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.action.button.impl.TableFestivalCommandImpl;
import by.epam.fest.action.button.impl.admin.FestPageCommandImpl;
import by.epam.fest.action.button.impl.admin.TableMusicianCommandImpl;
import by.epam.fest.action.button.impl.admin.TableUserCommandImpl;

import by.epam.fest.action.button.impl.user.TicketTableCommandImpl;
import by.epam.fest.action.button.impl.user.TicketsCommandImpl;
import by.epam.fest.domain.Musician;
import by.epam.fest.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Link {
    String PAGE_INDEX="/index.jsp";
    String PAGE_SIGN_IN="/WEB-INF/jsp/sign_in.jsp";
    String PAGE_ERROR = "/error.jsp";
    String PAGE_REGISTRATION="/WEB-INF/jsp/user/registration.jsp";
    String PAGE_MUSICIAN_INDEX="/WEB-INF/jsp/musician/musician_index.jsp";
    String PAGE_MUSICIAN_SONGS="/WEB-INF/jsp/musician/songs.jsp";
    String PAGE_ADMIN_INDEX="/WEB-INF/jsp/admin/admin_index.jsp";
    String PAGE_USER_INDEX="/WEB-INF/jsp/user/user_index.jsp";

    /**
     *
     * @param request get from that param link, and all roles that is in session
     * @return string that used for forwarding into new page
     * if client want to get page that is not his function or smt garbage ,set error page
     */
    public String getPage(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        Musician musician=(Musician) session.getAttribute("musician");
        User user=(User) session.getAttribute("user");
        User admin=(User) session.getAttribute("admin");
        String requestLink=request.getParameter("link");
        if (requestLink==null){
            return PAGE_ERROR;
        }
        BaseCommand command;
        String link = PAGE_ERROR;
        switch (requestLink) {
            //index
            case "index":
                link = PAGE_INDEX;
                break;
            case "sign_in":
                link = PAGE_SIGN_IN;
                break;
            case "registration":
                link = PAGE_REGISTRATION;
                break;
            case "table_fest":
                command=new TableFestivalCommandImpl();
                link= command.execute(request);
                break;
                //musician
            case "musician_index":
                if (musician != null) {
                    link = PAGE_MUSICIAN_INDEX;
                }
                break;
            case "songs":
                if (musician!=null){
                link=PAGE_MUSICIAN_SONGS;
                }
                break;
            //admin
            case "admin_index":
                if(admin!=null) {
                    link = PAGE_ADMIN_INDEX;
                }
                break;
            case "admin_users":
                if(admin!=null) {
                    command = new TableUserCommandImpl();
                    link = command.execute(request);
                }
                break;
            case "admin_musician":
                if(admin!=null) {
                    command = new TableMusicianCommandImpl();
                    link = command.execute(request);
                }
                break;
            case "admin_fest":
                if(admin!=null) {
                    command = new FestPageCommandImpl();
                    link = command.execute(request);
                }
                break;
            //user
            case "user_index":
                if(user!=null) {
                    link = PAGE_USER_INDEX;
                }
                break;
            case "buy_ticket":
                if(user!=null) {
                    command = new TicketsCommandImpl();
                    link = command.execute(request);
                }
                break;
            case "user_ticket":
                if(user!=null) {
                    command = new TicketTableCommandImpl();
                    link = command.execute(request);
                }
                break;
        }
        return link;
    }
}