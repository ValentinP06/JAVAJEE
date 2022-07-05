package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;
import model.Auteur;

/**
 * Servlet implementation class maservlet
 */
@WebServlet("/ListeAuteurs")
public class ListeAuteurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//lister les auteurs 

		AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
		List<Auteur> ListeAuteurs = null;
		
		
		try {
			ListeAuteurs = auteurDao.lister();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		request.setAttribute("ListeAuteurs", ListeAuteurs);
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeAuteurs.jsp").forward(request, response);
		request.getSession().removeAttribute("confirmerMessage");
	}

}
