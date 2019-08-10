package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.AdminService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;

public class AddDayCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String day = request.getParameter("day");

        String priceVip = request.getParameter("VIP");
        String  priceFan = request.getParameter("FAN_ZONE");
        String priceDance =request.getParameter("DANCE_FLOOR");
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        AdminService service=serviceFactory.getAdminService();
        try{
            service.addDayWithPrice(Date.valueOf(day), new BigDecimal(priceVip),new BigDecimal(priceFan), new BigDecimal(priceDance));
            FestPageCommandImpl festPageCommand=new FestPageCommandImpl();
            return festPageCommand.execute(request);
        }catch (ServiceException e){
           return PAGE_ERROR;
        }
    }
    }
