package by.epam.fest.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageFilter implements Filter {


    public LanguageFilter() {
        // TODO Auto-generated constructor stub
    }


    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest frequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) frequest;
        HttpSession session = request.getSession();

        request.getParameter("language");
        String s="en_US";
        request.setAttribute("language",s);
        chain.doFilter(request, response);
    }


    public void init(FilterConfig fConfig) throws ServletException {
    }

}
