package controler;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class DanhMucpubliccontroler
 */

public class DanhMucpubliccontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhMucpubliccontroler() {
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
		
		NewDao  newDao = new NewDao();
		CategoryDAO categoryDAO = new CategoryDAO();
		
		int idcat = Integer.parseInt(request.getParameter("dmid"));
		
		ArrayList<Tintuc> listtin = newDao.getitemTin(idcat);
		request.setAttribute("list",listtin);
		
		Category  dm = categoryDAO.getitemdm(idcat);
		request.setAttribute("dm", dm);
		RequestDispatcher rd = request.getRequestDispatcher("/danhmuc.jsp");
		rd.forward(request, response);
	}

}
