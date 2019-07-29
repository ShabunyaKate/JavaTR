package by.epam.fest.action.button.impl;


import by.epam.fest.action.button.BaseCommand;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return PAGE_ERROR;
    }

}
