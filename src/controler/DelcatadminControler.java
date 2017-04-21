package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;

/**
 * Servlet implementation class DelcatadminControler
 */
public class DelcatadminControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelcatadminControler() {
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
	
		CategoryDAO categoryDAO  = new CategoryDAO();
		
		int idcat = Integer.parseInt(request.getParameter("cid"));
		
		if (categoryDAO.deleteitem(idcat) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/danh-muc?msg=3");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/danh-muc?msg=0");
			return;
		}
	
	}

}
