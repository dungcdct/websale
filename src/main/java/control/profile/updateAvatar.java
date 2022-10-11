package control.profile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.DAO;

@MultipartConfig
@WebServlet("/updateAvatar")
public class updateAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pathStored = req.getServletContext().getRealPath("/upload") + File.separator + "/avatar";
		
//		take part of image from user input 
		Part dataimg = req.getPart("avatar");
		System.out.println("name avatar when user input : " + dataimg.getSubmittedFileName());

		String username = (String) req.getSession().getAttribute("username");
		
//		take avatar old to remove when avatar new updated
		String avatarOld =(String) req.getSession().getAttribute("nameavatar");
		String pathavatarOld = pathStored + File.separator + avatarOld;
		
		if (username != null) {
			for (Part part : req.getParts()) {
				
//				change name avatar to hash code of username + name image , avoid same name image
				String nameavatar = username.hashCode()
						+ Paths.get(dataimg.getSubmittedFileName()).getFileName().toString();
				System.out.println(nameavatar);
				
//				stored image to path project
				part.write(pathStored + File.separator + nameavatar);

//				set atttribute name avatar in scope session.
				req.getSession().setAttribute("nameavatar", nameavatar);
				
//				update avatar to db
				boolean result = DAO.updateAvatar(username, nameavatar);
				if (result) {
					
//					remove avatar old
					File avatarolds = new File(pathavatarOld);
					if(avatarolds.exists()) {
						avatarolds.delete();
					}
					
//					req to profile if avatar upload succes
					System.out.println("--Avatar updated succes");
					req.getRequestDispatcher("profile.jsp").forward(req, resp);
				} else {
					resp.sendRedirect("updateAvatar.jsp");
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
