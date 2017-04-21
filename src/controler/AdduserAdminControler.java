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

public class AdduserAdminControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdduserAdminControler() {
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
		
		String ten = new String(request.getParameter("tennguoidung").getBytes("ISO-8859-1"),"UTF-8");
		String pass = Stringlibrary.md5(new String(request.getParameter("pass").getBytes("ISO-8859-1"),"UTF-8"));
		String fullname = new String(request.getParameter("fullname").getBytes("ISO-8859-1"),"UTF-8");
		User user = new  User(0, ten, fullname, pass);
		if (userDao.Checkuser(ten) != null ) {
			response.sendRedirect(request.getContextPath() + "/admin/Show-them-user?msg=4");
			return;
			
		}else{
		if (userDao.adduser(user) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/trangchu-user?msg=1");
			return;
		}else{
			response.sendRedirect(request.getContextPath() + "/admin/trangchu-user?msg=0");
			return;
		}
		}
	}

}
