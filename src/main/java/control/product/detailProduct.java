package control.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.product;
import model.DAO;

/**
 * Servlet implementation class detailProduc
 */
@WebServlet({"/detailProduct", "/detailProductUser"})
public class detailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {

    	String idparam = req.getParameter("id");
    	int idproduct = Integer.valueOf(idparam);
    	product product = DAO.Product(idproduct);
    	if(product != null) {
    		req.setAttribute("loadProduct", product);
    	}
    	
    	String pathreq = req.getRequestURI();
    	System.out.println("request from page : " + pathreq);
    	if(pathreq.equals("/websport/detailProductUser")) {
    		req.getRequestDispatcher("detailProduct.jsp").forward(req, resp);
    	}
    	else {
    		
    		req.getRequestDispatcher("detailProductBySeller.jsp").forward(req, resp);
    	}
    	
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	
    	doGet(req, resp);
    }
}
