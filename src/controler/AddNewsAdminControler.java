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
import model.dao.NewDao;

/**
 * Servlet implementation class AddCatAdminControler
 */
@MultipartConfig
public class AddNewsAdminControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewsAdminControler() {
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

		String ten = new String(request.getParameter("tentin").getBytes(
				"ISO-8859-1"), "UTF-8");
		int idcat = Integer.parseInt(request.getParameter("danhmuc"));
		String mota = new String(request.getParameter("mota").getBytes(
				"ISO-8859-1"), "UTF-8");
		String chitiet = new String(request.getParameter("chitiet").getBytes(
				"ISO-8859-1"), "UTF-8");
		String picture = "";
		//tạo đường dẫn cho file
		final String path = request.getServletContext().getRealPath("files");
		// kiểm tra xem file đã tồn tại chưa nếu chua thì tạo
		File dirfile = new File(path);
		if (!dirfile.exists()) {
			dirfile.mkdir();
		}
		// lấy hình từ form qua name
		final Part filePart = request.getPart("hinhanh");
		// lấy tên của hình
		final String fileName = FilenameLibrary.getFileName(filePart);
		// kiểm tra xem có chọn ảnh hay ko rồi úp lên
		if (!"".equals(fileName)) {
			OutputStream out = null;
			InputStream filecontent = null;
			//đặt lại tên cho ảnh
			picture = RenameFileLibrary.renameFile(fileName);
			try {
				// khi đặt tên nhớ gán lại tên cho out 
				out = new FileOutputStream(new File(path + File.separator
						+ picture));
				filecontent = filePart.getInputStream();

				int read = 0;
				final byte[] bytes = new byte[1024];

				while ((read = filecontent.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
			} catch (FileNotFoundException fne) {
				fne.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
				if (filecontent != null) {
					filecontent.close();
				}
			}

		}
		
		Tintuc tintuc = new Tintuc(0, idcat, ten, mota, chitiet, "", picture);

		if (newDao.addNews(tintuc) > 0) {
			response.sendRedirect(request.getContextPath()
					+ "/admin/tintuc?msg=1");
			return;
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/admin/tintuc?msg=0");
			return;
		}

	}

}
