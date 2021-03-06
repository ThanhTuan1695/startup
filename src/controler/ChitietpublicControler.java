package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Tintuc;
import model.dao.NewDao;

/**
 * Servlet implementation class ChitietpublicControler
 */

public class ChitietpublicControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChitietpublicControler() {
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
		int did = Integer.parseInt(request.getParameter("idct"));
		int idcat =Integer.parseInt(request.getParameter("idcat"));
		NewDao newDao = new NewDao();
		
		Tintuc tin = newDao.getitemchitiet(did);
		request.setAttribute("chitiet", tin);
		
		ArrayList<Tintuc> listtin = newDao.getitemTin(idcat);
		request.setAttribute("list", listtin);
		
		RequestDispatcher rd = request.getRequestDispatcher("/chitiet.jsp");
		rd.forward(request, response);
	}

}
