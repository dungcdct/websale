package control.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.product;
import model.DAO;

/**
 * Servlet implementation class loadproducts
 */
@WebServlet("/loadproducts")
public class loadproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
    	HttpSession session = req.getSession();
    	if(session != null) {
    		int idseller = (Integer) session.getAttribute("idseller");
    		List<product> productsOfSeller = DAO.loadProductsBySeller(idseller);
    		
    		req.setAttribute("productofseller", productsOfSeller);
    		
    		req.getRequestDispatcher("showallproductbyseller.jsp").forward(req,resp);
    	}
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
    	doGet(req, resp);
    }

}
