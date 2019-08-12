package by.epam.fest.action.button.impl;

import by.epam.fest.action.button.BaseCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignOutCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        session.removeAttribute("user");
        session.removeAttribute("musician");
        session.removeAttribute("admin");
        return PAGE_DEFAULT;
    }
}
