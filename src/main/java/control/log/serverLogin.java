package control.log;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.user;
import model.DAO;

/**
 * Servlet implementation class log
 */
@WebServlet(urlPatterns = { "/loguser", "/logseller" })
public class serverLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String fullname = DAO.checkLog(username, password);
		
		if (fullname != null) {
//			take last name
			String[] plansFullname = fullname.split(" ");
			String lastname = plansFullname[plansFullname.length-1];
//			uppercase first letter
			String LastNameStandard = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("lastname", LastNameStandard);
			
			user user = DAO.fetchAllInforUser(username);
			if(user != null) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("nameavatar", user.getNameAvatar());
				sesion.setAttribute("loadInforUser", user);
				
			}
			response.sendRedirect("home.jsp");
			System.out.println("log succes , account with user name is :" + username);
			System.out.println("log succes , account with full name is :" + fullname);

		}
		else {
			String test = request.getRequestURI();
			System.out.println(test);
			
//			if view page is user 
			if(test.equals("/websport/loguser")) {
				response.sendRedirect("login.jsp");
			}
			else {
				
//			if view page is seller
				response.sendRedirect("loginSeller.jsp");
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

}
