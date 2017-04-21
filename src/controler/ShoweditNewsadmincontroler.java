package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Tintuc;
import model.dao.CategoryDAO;
import model.dao.NewDao;

/**
 * Servlet implementation class ShoweditCatadmincontroler
 */

public class ShoweditNewsadmincontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoweditNewsadmincontroler() {
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

		
		CategoryDAO categoryDAO = new CategoryDAO();
		NewDao newDao = new NewDao();
		request.setAttribute("listcat", categoryDAO.getItems());
		int idnews = Integer.parseInt(request.getParameter("nid"));
		
		Tintuc tintuc1 = newDao.getitemchitiet(idnews);
		request.setAttribute("tin", tintuc1);
		RequestDispatcher rd  = request.getRequestDispatcher("/admin/EditNews.jsp");
		rd.forward(request, response);
	}

}
