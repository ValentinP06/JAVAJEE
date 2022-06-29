package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;
import dao.LivreDao;
import model.Auteur;
import model.Livre;

/**
 * Servlet implementation class ListeLivres
 */
@WebServlet("/ListeLivres")
public class ListeLivres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//lister les auteurs 

		LivreDao LivreDao = DaoFactory.getInstance().getLivreDao();
		List<Livre> ListeLivres = null;
		
		try {
			ListeLivres = LivreDao.lister();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		request.setAttribute("ListeLivres", ListeLivres);
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeLivres.jsp").forward(request, response);

	}

}