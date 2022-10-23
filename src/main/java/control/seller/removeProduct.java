package control.seller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;


@WebServlet("/deleteproductbyseller")
public class removeProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
    	String idproduct = (String) req.getParameter("id");
    	int id = Integer.valueOf(idproduct);
    	boolean resultRemoveProduct = DAO.removeProduct(id);
    	

    	if(resultRemoveProduct) {
    		req.setAttribute("messenger", "remove product succes");
    	}

    	else {
    		req.setAttribute("messenger", "remove product wrong");
    	}
    	
    	req.getRequestDispatcher("/loadproducts").forward(req, resp);
    	
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doGet(req, resp);
	}
    
}
