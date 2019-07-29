package by.epam.fest.action.button.pages;

import by.epam.fest.action.button.BaseCommand;

import javax.servlet.http.HttpServletRequest;

public class RegistrationPageCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return PAGE_REGISTRATION;
    }
}
