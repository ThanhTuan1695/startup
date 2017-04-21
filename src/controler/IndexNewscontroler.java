package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

import model.bean.Tintuc;
import model.bean.User;
import model.dao.NewDao;
import model.dao.UserDao;

/**
 * Servlet implementation class Indexusercontroler
 */

public class IndexNewscontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexNewscontroler() {
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
		
		ArrayList<Tintuc> list = newDao.getitemnews();
		
		request.setAttribute("list", list);
		
		
		RequestDispatcher  rd=  request.getRequestDispatcher("/admin/indexNews.jsp");
		rd.forward(request, response);
	}

}
