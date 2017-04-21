package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dao.UserDao;

/**
 * Servlet implementation class DelcatadminControler
 */
public class DeluseradminControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeluseradminControler() {
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
		
		if ("admin".equalsIgnoreCase(userDao.getitemuser(iduser).getUsername())) {
			response.sendRedirect(request.getContextPath() + "/admin/trangchu-user?msg=4");
			return;
		}else{
		if (userDao.deleteuser(iduser) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/trangchu-user?msg=3");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/trangchu-user?msg=0");
			return;
		}
		}
	}

}
