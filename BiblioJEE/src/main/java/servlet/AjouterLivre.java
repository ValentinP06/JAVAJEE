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
 * Servlet implementation class AjouterAuteur
 */
@WebServlet("/AjouterLivre")
public class AjouterLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LivreDao LivreDao;
	
    public AjouterLivre() {
        super();
        LivreDao = DaoFactory.getInstance().getLivreDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterLivre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int nbPages = Integer.parseInt(request.getParameter("nbPages"));

		Auteur auteur = request.getParameter("AuteurLivre");
		String titre = request.getParameter("titreLivre");
		int nbPages = request.getParameter("nbPasgesLivre");
		String categorie = request.getParameter("categoreLivre");
		
		

		Livre Livre = new Livre();
		Livre.setAuteur(auteur);
		Livre.setTitre(titre);
		Livre.setNbPages(nbPages);
		Livre.setCategorie(categorie);
		
		try {
		LivreDao.creer(Livre);
		
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect( request.getContextPath() + "/ListeAuteurs" );
	}

}