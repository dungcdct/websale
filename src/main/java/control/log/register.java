package control.log;

import java.io.IOException;
import java.io.PrintWriter;

import handleInforUser.*;
import model.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import entity.user;
import exception.log.addressException;
import exception.log.emailException;
import exception.log.fullnameException;
import exception.log.passwordException;
import exception.log.phoneException;
import exception.log.usernameException;

@WebServlet(urlPatterns = {"/register", "/registerSeller"})
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String fullname = req.getParameter("fullname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String IDcard = req.getParameter("idcard");
		String category = "user";
		
		if(IDcard != null) {
			category ="seller";
		}
		try {
			boolean checkfullname = log.fullname(fullname);
			boolean checkusername = log.username(username);
			boolean checkpass = log.password(password);
			boolean checkaddress =log.address(address);
			boolean checkemail = log.email(email);
			boolean checkphone = log.phone(phone);
			
			if(checkfullname && checkusername && 
					checkaddress && checkemail && checkpass && checkphone) {
				
//				take last name
				String[] arrayFullname = fullname.split(" ");
				String lastname = arrayFullname[arrayFullname.length-1];
				
//				hash password 
				String passwordhashed = BCrypt.hashpw(password, BCrypt.gensalt(15));
				
				
//				create object user when information checked 
				user user = new user(username, fullname, address, phone, category, email);
				
//				will this is insert account of user , should be ID card is null.
				Boolean result = DAO.register(user, passwordhashed, IDcard);
				if(result) {
					
//					authentication account if loged
					HttpSession session = req.getSession();
					session.setAttribute("username", username);
					session.setAttribute("lastname", lastname);
					session.setAttribute("category", category);
					
//					request to home 
//					req.getRequestDispatcher("home.jsp").forward(req, resp);
					resp.sendRedirect("home.jsp");
				}
				else {
					String test = req.getRequestURI();
					System.out.println(test);
					
//					if view page is user 
					if(test.equals("/websport/register")) {
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
					else {
						
//					if view page is seller
						req.getRequestDispatcher("loginSeller.jsp").forward(req, resp);
					}
				}
			}
		} catch(fullnameException e) {
			out.println(e);
			e.printStackTrace();
		}catch (usernameException e) {
			out.println(e);
			e.printStackTrace();
		}catch (passwordException e) {
			out.println(e);
			e.printStackTrace();
		}catch (addressException e) {
			out.println(e);
			e.printStackTrace();
		}catch (emailException e) {
			out.println(e);
			e.printStackTrace();
		}catch(phoneException e) {
			out.println(e);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
