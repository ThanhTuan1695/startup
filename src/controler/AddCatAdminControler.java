package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;

/**
 * Servlet implementation class AddCatAdminControler
 */

public class AddCatAdminControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCatAdminControler() {
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
		
		String tendanhmuc = new String(request.getParameter("tendanhmuc").getBytes("ISO-8859-1"),"UTF-8");
		
		Category category = new Category(0, tendanhmuc);
		
		if (categoryDAO.additem(category) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/danh-muc?msg=1");
			return;
		}else{
			response.sendRedirect(request.getContextPath() + "/admin/danh-muc?msg=0");
			return;
		}
	
	}

}
