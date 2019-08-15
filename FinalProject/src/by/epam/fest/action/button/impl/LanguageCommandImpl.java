package by.epam.fest.action.button.impl;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.action.link.Link;
import by.epam.fest.domain.Lang;
import by.epam.fest.domain.LangHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LanguageCommandImpl implements BaseCommand {
    /**
     * Used for changing language, set in session new lang ,
     * and set new local in programm
     * @param
     * @return
     */
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String s =request.getParameter("change");
        session.setAttribute("lang",s);
        LangHolder langHolder= LangHolder.getInstance();
        langHolder.setLocale(s);
        Link link =new Link();
        link.getPage(request);
        return link.getPage(request);
    }
}
