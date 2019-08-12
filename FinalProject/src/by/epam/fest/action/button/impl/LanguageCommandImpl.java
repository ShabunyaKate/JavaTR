package by.epam.fest.action.button.impl;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.domain.Lang;
import by.epam.fest.domain.LangHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LanguageCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String s =request.getParameter("change");
        session.setAttribute("lang",s);
        LangHolder langHolder= LangHolder.getInstance();
        langHolder.setLocale(s);
        return "index.jsp";
    }
}
