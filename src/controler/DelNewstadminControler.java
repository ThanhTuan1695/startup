package controler;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewDao;

/**
 * Servlet implementation class AddCatControler
 */

public class DelNewstadminControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelNewstadminControler() {
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
		NewDao newDao = new NewDao();
		final String path = request.getServletContext().getRealPath("files");
		
		int idnews = Integer.parseInt(request.getParameter("nid"));
		String pictureold =newDao.getitemchitiet(idnews).getPicture();
		
		if (newDao.delitem(idnews)>0) {
			if (!"".equals(pictureold)) {
				String urlfile = path+ File.separator + pictureold;
				File delfile = new File(urlfile);
				delfile.delete();
			}
			response.sendRedirect(request.getContextPath() + "/admin/tintuc?msg=3");
			return;
		}else{
			response.sendRedirect(request.getContextPath() + "admin/tintuc?msg=0");
			return;
		}
		
		
	}

}
