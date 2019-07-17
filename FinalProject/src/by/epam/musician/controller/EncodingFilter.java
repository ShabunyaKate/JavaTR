package by.epam.musician.controller;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

   
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 response.setCharacterEncoding("UTF-8");
	     request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
