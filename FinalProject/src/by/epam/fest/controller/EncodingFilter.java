package by.epam.fest.controller;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {


    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**Used for encoding response and request
	 * without that can be problems with Russian language
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 response.setCharacterEncoding("UTF-8");
	     request.setCharacterEncoding("UTF-8");
	     chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
