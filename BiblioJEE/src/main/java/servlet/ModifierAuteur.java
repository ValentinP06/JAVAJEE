package servlet;

import java.io.IOException;
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
 * Servlet implementation class AjouterAuteur
 */
@WebServlet("/ModifierAuteur")
public class ModifierAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AuteurDao AuteurDao;
	
    public ModifierAuteur() {
        super();
        AuteurDao = DaoFactory.getInstance().getAuteurDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModifierAuteur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nomAuteur");
		String prenom = request.getParameter("prenomAuteur");
		String telephone = request.getParameter("telephoneAuteur");
		String email = request.getParameter("emailAuteur");
		
		Auteur auteur = new Auteur();
		auteur.setNom(nom);
		auteur.setPrenom(prenom);
		auteur.setTelephone(telephone);
		auteur.setEmail(email);
		
		try {
			AuteurDao.creer(auteur);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect( request.getContextPath() + "/ListeAuteurs" );
	}

}
