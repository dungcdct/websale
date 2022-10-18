package control.log;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.seller;
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
		

		System.out.println("log input user:");
		System.out.println(username);
		System.out.println(password);
//		check account 
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

//			check page logging 
			String pathOfRequest = request.getRequestURI();
			System.out.println("request from page had path is : " + pathOfRequest);
			
			
//			if view page is user 
			if(pathOfRequest.equals("/websport/loguser")) {
				user user = DAO.fetchAllInforUser(username);
				if(user != null && user.getCategory().equals("user")) {
					HttpSession sesion = request.getSession();
					sesion.setAttribute("nameavatar", user.getNameAvatar());
					sesion.setAttribute("loadInforUser", user);
					
					System.out.println("log succes , account with user name is :" + username);
					System.out.println("log succes , account with full name is :" + fullname);
					response.sendRedirect("home.jsp");
				}
				else {
					response.sendRedirect("login.jsp");
				}
			}
			else {
				
//			if view page is seller
				
				seller seller = DAO.fetchAllInforSeller(username);
				
//				take id of seller
				int idseller = DAO.takeIdByUsername(username);
				
				System.out.println("id of seller logging is : " + idseller);
				
				if(seller != null && seller.getCategory().equals("seller")) {
					HttpSession sesion = request.getSession(true);
					session.setAttribute("idseller", idseller);
					sesion.setAttribute("nameavatar", seller.getNameAvatar());
					sesion.setAttribute("loadInforUser", seller);
					session.setAttribute("category", seller.getCategory());
					System.out.println("log succes , account with user name is :" + username);
					System.out.println("log succes , account with full name is :" + fullname);
					response.sendRedirect("homeSeller.jsp");
				}
				else {
					System.out.println("log wrong!");
					response.sendRedirect("loginSeller.jsp");
				}
				
			}
			
		}
		else {
			String test = request.getRequestURI();
			System.out.println("check account wrong : "  + test);
			
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
