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
import dao.LivreDao;
import model.Auteur;
import model.Livre;

/**
 * Servlet implementation class AjouterLivre
 */
@WebServlet("/AjouterLivre")
public class AjouterLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LivreDao livreDao;
	private AuteurDao auteurDao;
	
    public AjouterLivre() {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("auteurs", auteurDao.lister());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterLivre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titre = request.getParameter("titreLivre");
		int nbPages = Integer.parseInt(request.getParameter("nbPagesLivre"));
		String categorie = request.getParameter("categorieLivre");
		long idAuteur = Long.parseLong(request.getParameter("auteurLivre"));
		
		
		Livre livre = new Livre();
		livre.setTitre(titre);
		livre.setNbPages(nbPages);
		livre.setCategorie(categorie);
		
		try {
			Auteur auteur = auteurDao.trouver(idAuteur);
			
			livre.setAuteur(auteur);
			
			livreDao.creer(livre);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect( request.getContextPath() + "/ListeLivres" );
	}

}