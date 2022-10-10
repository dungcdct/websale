package control.profile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.user;
import model.DAO;

@WebServlet("/profileUser")
public class profileUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		ServletContext context = req.getServletContext();
		String realpath = context.getRealPath("/upload");	
		
		File file = new File(realpath);
		System.out.println(file.canRead());
		System.out.println(realpath);
		
		System.out.println("real path :" + realpath);
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			user user = DAO.fetchAllInforUser(username);
			
			String nameAvatar =  user.getNameAvatar();
			System.out.println("path :" + nameAvatar);
			req.setAttribute("loadInforUser", user);
			req.setAttribute("nameavatar", nameAvatar);
			System.out.println("check user succes. continue will req infor user to page profile");
			
//			check log success , request information user to profile
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
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
