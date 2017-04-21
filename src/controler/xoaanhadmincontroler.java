package controler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import library.FilenameLibrary;
import library.RenameFileLibrary;
import model.bean.Tintuc;
import model.dao.CategoryDAO;
import model.dao.NewDao;

/**
 * Servlet implementation class Editcatadmincontroler
 */
@MultipartConfig
public class xoaanhadmincontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xoaanhadmincontroler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		NewDao newDao = new NewDao();
		int idnews = Integer.parseInt(request.getParameter("nid"));
		String picture = newDao.getitemchitiet(idnews).getPicture();
		System.out.println(idnews);
		if (!"".equals(picture)) {
			final String path = request.getServletContext()
					.getRealPath("files");
			String urlfile = path + File.separator
					+ newDao.getitemchitiet(idnews).getPicture();
			// tạo ra file để xóa
			File delfile = new File(urlfile);
			// xóa file
			delfile.delete();
		}
		response.sendRedirect(request.getContextPath()+ "/admin/show-editnews?msg=5&nid="+idnews);
		return;

	}
}
