package by.epam.fest.action.button.impl.admin;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.exception.ServiceException;
import by.epam.fest.service.AdminService;
import by.epam.fest.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class UpdatePricesCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String day_str = request.getParameter("day_id");
        Integer day_id=Integer.valueOf(day_str);
        String priceVip = request.getParameter("VIP");
        String  priceFan = request.getParameter("FAN_ZONE");
        String priceDance =request.getParameter("DANCE_FLOOR");
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        AdminService service=serviceFactory.getAdminService();
        try{
            service.updatePrices(day_id, new BigDecimal(priceVip),new BigDecimal(priceFan), new BigDecimal(priceDance));
            return PAGE_ADMIN_FEST;
        }catch (ServiceException e){
            return PAGE_ERROR;
        }
    }
    }
