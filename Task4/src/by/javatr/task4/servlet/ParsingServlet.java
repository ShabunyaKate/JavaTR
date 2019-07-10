package by.javatr.task4.servlet;

import by.javatr.task4.entity.Flower;
import by.javatr.task4.parser.AbstractFlowersBuilder;
import by.javatr.task4.parser.FlowersBuilderFactory;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class ParsingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String file_name = request.getParameter("name");
        String parser = request.getParameter("parser");
        FlowersBuilderFactory fFactory = new FlowersBuilderFactory();
        AbstractFlowersBuilder builder = fFactory.createFlowersBuilder(parser);
        builder.buildSetFlowers(file_name);
        Set<Flower> s = builder.getFlowers();
        for (Flower d : s) {
            writer.println(s);
        }
    }
}


