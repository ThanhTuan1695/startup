package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.User;
import model.dao.CategoryDAO;
import model.dao.UserDao;

/**
 * Servlet implementation class ShoweditCatadmincontroler
 */

public class Showedituseradmincontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showedituseradmincontroler() {
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
		
		User user = userDao.getitemuser(iduser);
		request.setAttribute("users", user);
		
		RequestDispatcher rd  = request.getRequestDispatcher("/admin/EditUser.jsp");
		rd.forward(request, response);
	}

}
