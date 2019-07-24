package by.epam.musician.action.pages;

import by.epam.musician.action.BaseCommand;

import javax.servlet.http.HttpServletRequest;

public class SignInPageCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return PAGE_SIGN_IN;
    }
}
