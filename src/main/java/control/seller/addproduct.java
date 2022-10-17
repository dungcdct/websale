package control.seller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sound.midi.Soundbank;

import org.apache.catalina.Server;

import entity.product;
import model.DAO;

@MultipartConfig
@WebServlet("/addproduct")
public class addproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = (String) req.getSession().getAttribute("username");

		String realpathserver = req.getServletContext().getRealPath("/upload");
		System.out.println(realpathserver);
		String name = req.getParameter("name");

		String priceinDB = req.getParameter("price");
		int price = Integer.valueOf(priceinDB);

		String decribe = req.getParameter("describe");

//    	debug , check infor input seller input 
		System.out.println("infor product of seller input :");
		System.out.println("name product: " + name);
		System.out.println("price of product" + price);
		System.out.println("describe of product : " + decribe);

//    	handle video or image of product 
		Part introOfProduct = req.getPart("introduceProduct");

//    	check price and stored image or video to server
		boolean checkdigits = priceinDB.matches("[0-9]+");
		if (checkdigits && priceinDB.length() > 3 && introOfProduct != null && username != null) {

//			fetch id max in db and +1 equivalent id of product current adding
			int idProductCurrent = DAO.fetchIDmaxOfProduct() + 1;
			System.out.println("id of product : " + idProductCurrent);
			
			String filename = introOfProduct.getSubmittedFileName();
			
//			handle name of image or video to avoid duplicate name file 
			String fileNameHandled = username.hashCode() + "idproduct" + idProductCurrent + filename;
			System.out.println(filename +" and " + fileNameHandled);

//    		fetch id seller by user name
			int IDseller = DAO.takeIdByUsername(username);
			if (IDseller > 0) {

//    		create object stored infor of product
				product product = new product(name, price, decribe, IDseller, filename);

//    		insert product to Db
				boolean result = DAO.addproduct(product);
//				when product add to DB succes, image or video will stored to server
				if (result) {

//    		if file not exits will create new file 
					String pathStored = realpathserver + File.separator + "product" + File.separator + fileNameHandled;
					File file = new File(pathStored);
					if (!file.exists()) {
						file.createNewFile();
					}

					InputStream inputofFile = introOfProduct.getInputStream();
					byte[] byteofimg = new byte[inputofFile.available()];

					inputofFile.read(byteofimg);

					FileOutputStream fileoutput = new FileOutputStream(file);
					fileoutput.write(byteofimg);
					System.out.println("image or video of product added to server");
					
//					dispatcher to home if product added succes
					req.getRequestDispatcher("homeSeller.jsp").forward(req, resp);
				}
				else {
					resp.sendRedirect("addproduct.jsp");
				}
			}
		} else {
			resp.sendRedirect("addproduct.jsp?addproduct=false");
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
