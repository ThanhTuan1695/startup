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
public class EditNewsadmincontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNewsadmincontroler() {
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
		

		String ten = new String(request.getParameter("tentin").getBytes(
				"ISO-8859-1"), "UTF-8");
		int idcat = Integer.parseInt(request.getParameter("danhmuc"));
		int idnews = Integer.parseInt(request.getParameter("nid"));
		String mota = new String(request.getParameter("mota").getBytes(
				"ISO-8859-1"), "UTF-8");
		String chitiet = new String(request.getParameter("chitiet").getBytes(
				"ISO-8859-1"), "UTF-8");
		String picture ="";
		//tạo đường dẫn ảnh
		 final String path =request.getServletContext().getRealPath("files");
		 // kiểm tra file có tồn tài hay ko.. nếu ko thì thêm vào
		 System.out.println(path);
		 File dirfile = new File(path); 
		 if (!dirfile.exists()) {
			dirfile.mkdir();
		}
		 //lấy ảnh từ form
		 final  Part filepart = request.getPart("hinhanh");
		 // lấy tên cho ảnh
		 final String filename =  FilenameLibrary.getFileName(filepart);
		 //kiểm tra xem nếu file rỗng thì mình không thêm còn nếu có thì thêm
		 
		 if (!"".equals(filename)) {
			 OutputStream out = null;
			InputStream filecontent = null;
			// đổi tên ảnh
			picture = RenameFileLibrary.renameFile(filename);
			// nếu như thêm vào thì xóa ảnh cũng trong file đi
			
			 String pictureold = newDao.getitemchitiet(idnews).getPicture();
			 if (!"".equals(pictureold)) {
				 // tạo đường dẫn đến file
				 String urlfile = path+ File.separator + pictureold;
				 // tạo ra file để xóa
					File delfile = new File(urlfile);
					//xóa file
					delfile.delete();
			}
			 //up len lại
				try {
					out = new FileOutputStream(new File(path + File.separator + picture));
					
					filecontent = filepart.getInputStream();

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
			
			
		}else {
			picture =  newDao.getitemchitiet(idnews).getPicture();
			
		}
		 
		Tintuc tin = new Tintuc(idnews, idcat, ten, mota, chitiet, "", picture);
		
		if (newDao.edititem(tin) > 0) {
			response.sendRedirect(request.getContextPath()+ "/admin/tintuc?msg=2");
			return ;
		}else {
			response.sendRedirect(request.getContextPath()+ "/admin/tintuc?msg=0");
			return ;
		}
	}
	
}
