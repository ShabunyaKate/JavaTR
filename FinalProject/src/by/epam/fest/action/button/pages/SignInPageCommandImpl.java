package by.epam.fest.action.button.pages;

import by.epam.fest.action.button.BaseCommand;

import javax.servlet.http.HttpServletRequest;

public class SignInPageCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("tempParam", "1");
        return PAGE_SIGN_IN;
    }
}
