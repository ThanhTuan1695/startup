package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.Stringlibrary;
import model.bean.Category;
import model.bean.User;
import model.dao.CategoryDAO;
import model.dao.UserDao;

/**
 * Servlet implementation class AddCatAdminControler
 */

public class EdituserAdminControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EdituserAdminControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao userDao = new UserDao();
		
		int iduser = Integer.parseInt(request.getParameter("uid"));
		
		String pass = new String(request.getParameter("pass").getBytes("ISO-8859-1"),"UTF-8");
		String fullname = new String(request.getParameter("fullname").getBytes("ISO-8859-1"),"UTF-8");
		
		if (!"".equals(pass)) {
			pass = Stringlibrary.md5(new String(request.getParameter("pass").getBytes("ISO-8859-1"),"UTF-8"));
		} else {
			
			pass = userDao.getitemuser(iduser).getPassword();
		}
		
		
		
		User user = new  User(iduser, "", fullname, pass);
	
		if (userDao.edituser(user) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/trangchu-user?msg=2");
			return;
		}else{
			response.sendRedirect(request.getContextPath() + "/admin/trangchu-user?msg=0");
			return;
		}
		
	}

}
