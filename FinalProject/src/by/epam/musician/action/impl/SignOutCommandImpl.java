package by.epam.musician.action.impl;

import by.epam.musician.action.BaseCommand;

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
