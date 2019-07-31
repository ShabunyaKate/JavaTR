package by.epam.fest.action.link;

import by.epam.fest.action.button.impl.TableFestivalCommandImpl;
import by.epam.fest.action.button.impl.admin.TableMusicianCommandImpl;
import by.epam.fest.action.button.impl.admin.TableUserCommandImpl;
import by.epam.fest.action.button.impl.user.BookTicketCommandImpl;
import by.epam.fest.action.button.impl.user.TicketTableCommandImpl;
import by.epam.fest.action.button.impl.user.TicketsCommandImpl;

import javax.servlet.http.HttpServletRequest;

public class Link {
    String PAGE_SIGN_IN="/WEB-INF/jsp/sign_in.jsp";
    String PAGE_TABLE_FEST="/WEB-INF/jsp/table_fest.jsp";
    String PAGE_ERROR = "/error.jsp";
    String PAGE_REGISTRATION="/WEB-INF/jsp/user/registration.jsp";
    String PAGE_MUSICIAN_INDEX="/WEB-INF/jsp/musician/musician_index.jsp";
    String PAGE_MUSICIAN_SONGS="/WEB-INF/jsp/musician/songs.jsp";
    String PAGE_MUSICIAN_PHOTO="/WEB-INF/jsp/musician/photo.jsp";
    String PAGE_ADMIN_INDEX="/WEB-INF/jsp/admin/admin_index.jsp";

    String PAGE_ADMIN_USER="/WEB-INF/jsp/admin/user_table.jsp";
    String PAGE_ADMIN_MUSICIAN="/WEB-INF/jsp/admin/musician_table.jsp";
    String PAGE_ADMIN_FEST="/WEB-INF/jsp/admin/fest_days_price.jsp";

    String PAGE_USER_INDEX="/WEB-INF/jsp/user/user_index.jsp";
    String PAGE_USER_BUY_TICKET="/WEB-INF/jsp/user/buy_ticket.jsp";
    String PAGE_USER_TICKET="/WEB-INF/jsp/user/user_ticket.jsp";
    String PAGE_USER_EDIT="/WEB-INF/jsp/user/edit_user.jsp";
    public String getPage(HttpServletRequest request) {
        String command=request.getParameter("link");
        String link = PAGE_ERROR;
        switch (command) {
            //index
            case "sign_in":
                link = PAGE_SIGN_IN;
                break;
            case "registration":
                link = PAGE_REGISTRATION;
                break;
            case "table_fest":
                TableFestivalCommandImpl command1=new TableFestivalCommandImpl();
                link= command1.execute(request);
                break;
                //musician
            case "musician_index":
                link = PAGE_MUSICIAN_INDEX;
                break;
            case "songs":
                link=PAGE_MUSICIAN_SONGS;
                break;
            case "musician_photo":
                link = PAGE_MUSICIAN_PHOTO;
                break;
            //admin
            case "admin_index":
                link = PAGE_ADMIN_INDEX;
                break;
            case "admin_users":
                TableUserCommandImpl command2=new TableUserCommandImpl();
                link=command2.execute(request);
                break;
            case "admin_musician":
                TableMusicianCommandImpl command3=new TableMusicianCommandImpl();
                link = command3.execute(request);
                break;
            case "admin_fest":
                link = PAGE_ADMIN_FEST;
                break;
            //user
            case "user_index":
                link = PAGE_USER_INDEX;
                break;
            case "buy_ticket":
                TicketsCommandImpl command4=new TicketsCommandImpl();
                link=command4.execute(request);
                break;
            case "user_ticket":
                TicketTableCommandImpl command5=new TicketTableCommandImpl();
                link=command5.execute(request);
                break;
            case "edit_user":
                link=PAGE_USER_EDIT;
                break;
        }
        return link;
    }
}