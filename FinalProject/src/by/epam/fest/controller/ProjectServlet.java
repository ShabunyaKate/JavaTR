package by.epam.fest.controller;

import by.epam.fest.action.button.BaseCommand;
import by.epam.fest.action.button.CommandChooser;
import by.epam.fest.action.link.Link;
import by.epam.fest.dao.pool.ConnectionPool;
import by.epam.fest.exception.DaoException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.layout.PatternLayout;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**Servlet is used in all program
 */

public class ProjectServlet extends HttpServlet {
    public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/shop?serverTimezone=EST5EDT&verifyServerCertificate=false&useSSL=true";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";
    public static final int DB_POOL_START_SIZE = 10;
    public static final int DB_POOL_MAX_SIZE = 1000;
    public static final int DB_POOL_CHECK_CONNECTION_TIMEOUT =0;

    /**
     * @method init
     * download Connection pool and lock
     */

    public void init() {
        try {
            ConnectionPool.INSTANCE.init(DB_DRIVER_CLASS, DB_URL, DB_USER, DB_PASSWORD, DB_POOL_START_SIZE, DB_POOL_MAX_SIZE, DB_POOL_CHECK_CONNECTION_TIMEOUT);
            Lock lock =ConnectionPool.INSTANCE.getLock();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    /**Used for links
     * @param request has param link that forward in other page, if param link is unvalid or null, servlet will forward into page 404
     * actually download smt for start page, just like all users, days, that used in some tables or etc. in page
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Link link=new Link();
        String path= link.getPage(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    /**Used for button
     * @param request has param command, that forward in CommandChooser class and choose function that program needs
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userCommand = request.getParameter("command");
        CommandChooser commandChooser=CommandChooser.getInstance();
        BaseCommand command = commandChooser.defineCommand(userCommand);

        String path = command.execute(request);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}

