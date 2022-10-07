package control.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/logout")
public class logout implements Filter {

	
	
	public void init(FilterConfig fConfig)
			throws ServletException {
	}
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		if(session != null) {
			String username = (String) session.getAttribute("username");
			if(username != null) {
				chain.doFilter(request, response);
			}
			else {
				resp.sendRedirect("home.jsp");
			}
		}
	}

	public void destroy() {
		
	}

}
