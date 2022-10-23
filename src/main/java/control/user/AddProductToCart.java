package control.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddProductToCart")
public class AddProductToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		String username = (String) request.getSession().getAttribute("username");
		if(username == null) {
			response.sendRedirect("login.jsp");
		}
		else {
			
		String idsellrparam = request.getParameter("idseler");
		int idseller = Integer.valueOf(idsellrparam);
		String id = request.getParameter("id");
		int idproduct = Integer.valueOf(id);
		System.out.println(username);
		System.out.println(idseller);
		System.out.println(idproduct);
		
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
