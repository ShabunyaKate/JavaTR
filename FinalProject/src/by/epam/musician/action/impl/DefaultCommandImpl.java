package by.epam.musician.action.impl;


import by.epam.musician.action.BaseCommand;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return RESPONSE_PAGE_ERROR;
    }

}
