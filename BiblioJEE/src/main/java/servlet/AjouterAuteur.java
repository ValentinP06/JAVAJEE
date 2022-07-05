package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    
	private AuteurDao auteurDao;
	
    public AjouterAuteur() {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterAuteur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> erreurs = new HashMap<String, String>();
		
		String nom = request.getParameter("nomAuteur");
		String prenom = request.getParameter("prenomAuteur");
		String telephone = request.getParameter("telephoneAuteur");
		String email = request.getParameter("emailAuteur");
		
		if(nom != null) {
			if(nom.length() < 2 || nom.length() > 20) {
				erreurs.put("nomAuteur", "Un nom d'auteur doit contenir entre 2 et 20 caractères.");
			}
		} else {
			erreurs.put("nomAuteur", "Merci d'entrer un nom d'auteur.");
		}
		
		if(prenom != null) {
			if(prenom.length() > 10) {
				erreurs.put("prenomAuteur", "Un prénom d'auteur doit avoir au maximum 20 caractères.");
			}
		}
		
		if(telephone != null) {
			if(telephone.length() > 11) {
				erreurs.put("telephoneAuteur", "Un numéro de téléphone doit avoir au maximum 10 caractères.");
			}
			if(!telephone.matches("^\\d+$")) {
				erreurs.put("telephoneAuteur", "Un numéro de téléphone doit contenir uniquement des chiffres.");
			}
		} else {
			erreurs.put("telephoneAuteur", "Merci d'entrer un numéro de téléphone.");
		}
		
		if(email != null) {
			if(email.length() > 30) {
				erreurs.put("emailAuteur", "Un email doit avoir au maximum 60 caractères.");
			}
			if(!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				erreurs.put("emailAuteur", "merci de saisir une adresse mail valide.");
			}
		}
		
		Auteur auteur = new Auteur();
		auteur.setNom(nom);
		auteur.setPrenom(prenom);
		auteur.setTelephone(telephone);
		auteur.setEmail(email);
		
		if(erreurs.isEmpty()) {
			try {
				auteurDao.creer(auteur);
				
				request.getSession().setAttribute("confirmMessage", "L'auteur a bien été ajouté !");
				
			} catch (DaoException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect( request.getContextPath() + "/ListeAuteurs" );
		} else {
			request.setAttribute("auteur", auteur);
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("resultat", "Echec de la sauvegarde de l'auteur.");
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterAuteur.jsp").forward(request, response);
		}
		
	}

}