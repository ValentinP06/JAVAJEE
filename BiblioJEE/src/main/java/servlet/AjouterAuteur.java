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
@WebServlet("/AjouterAuteur")
public class AjouterAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AuteurDao AuteurDao;
	
    public AjouterAuteur() {
        super();
        AuteurDao = DaoFactory.getInstance().getAuteurDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterAuteur.jsp").forward(request, response);
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
		
		if(email != null) {
			if(email.length() > 60) {
                erreurs.put("emailAuteur", "Un email doit avoir au maximum 60 caractères.");
            }
            if(!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                erreurs.put("emailAuteur", "merci de saisir une adresse mail valide.");
            }
        }
		try {
			AuteurDao.creer(auteur);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect( request.getContextPath() + "/ListeAuteurs" );
	}

}