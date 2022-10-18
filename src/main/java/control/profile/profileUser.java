package control.profile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.product;
import entity.user;
import model.DAO;

@WebServlet("/profileUser")
public class profileUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		List<product> a = DAO.loadProductInMain();
		Iterator<product> b = a.iterator();
		while (b.hasNext()) {
			System.out.println(b.next().getNameproduct());
		}
		
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			user user = DAO.fetchAllInforUser(username);
			if(user != null) {
				
			String nameAvatar =  user.getNameAvatar();
			System.out.println("name image  :" + nameAvatar);
			session.setAttribute("loadInforUser", user);
			
//			set attribute for name avatar in scope session
			session.setAttribute("nameavatar", nameAvatar);
			
			System.out.println("check user succes. continue will req infor user to page profile");
			
//			check log success , request information user to profile
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
			}
			else {
				System.out.println("fetch infor wrong, redirect to home");
				resp.sendRedirect("home.jsp");
			}
		}
		else{
			System.out.println("user not log, load infor wrong , redirect to home");
			resp.sendRedirect("home.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
