package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LivreDao;
import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;
import model.Auteur;
import model.Livre;

/**
 * Servlet implementation class AjouterAuteur
 */
@WebServlet("/ModifierLivre")
public class ModifierLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AuteurDao auteurDao;
	private LivreDao LivreDao;
	
    public ModifierLivre() {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
        LivreDao = DaoFactory.getInstance().getLivreDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		long id = Long.parseLong(request.getParameter("id"));

		try { 
			
			request.setAttribute("Auteurs", auteurDao.lister());
			request.setAttribute("Livre", LivreDao.trouver(id));
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModifierLivre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String titre = request.getParameter("titreLivre");
		String categorie = request.getParameter("categorieLivre");
		Long id = Long.parseLong(request.getParameter("id"));
		int NbPages = Integer.parseInt(request.getParameter("NbPages"));
		Long idAuteur = Long.parseLong(request.getParameter("idAuteur"));
	
		
		try {
			Auteur auteur = auteurDao.trouver(idAuteur);
			Livre Livre = LivreDao.trouver(id);
			Livre.setTitre(titre);
			Livre.setNbPages(NbPages);
			Livre.setCategorie(categorie);
			Livre.setAuteur(auteur);
			LivreDao.update(Livre);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect( request.getContextPath() + "/ListeLivres" );
	}

}
