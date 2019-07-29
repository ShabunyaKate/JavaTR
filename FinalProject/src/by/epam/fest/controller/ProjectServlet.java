package by.epam.fest.controller;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.action.button.CommandChooser;
import by.epam.fest.action.link.Link;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Link link=new Link();
        String path= link.getPage(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userCommand = request.getParameter("command");
        BaseCommand command = CommandChooser.defineCommand(userCommand);

        String path = command.execute(request);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}

