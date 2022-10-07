package control.log;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		Boolean resultCheckAcc = DAO.checkLog(username, password);
		if (resultCheckAcc) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			response.sendRedirect("home.jsp");
			System.out.println("log succes , account with user name is :" + username);
//				not complete set attribute last name and category

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

}
