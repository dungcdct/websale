package control.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/login", "/register", "/registerSeller"})
public class login implements Filter {

	public void init(FilterConfig fConfig) 
			throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
