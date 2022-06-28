package fr.cleverdev;

import java.util.Iterator;
import java.util.List;

import fr.cleverdev.dao.AuteurDao;
import fr.cleverdev.dao.AuteurDaoImpl;
import fr.cleverdev.dao.DaoException;
import fr.cleverdev.dao.DaoFactory;
import fr.cleverdev.dao.LivreDao;
import fr.cleverdev.model.Auteur;
import fr.cleverdev.model.Livre;

public class Launcher {

	public static void main(String[] args) throws DaoException {

//		AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
//		List<Auteur> listAuteurs;
////		
//		try {
//			listAuteurs = auteurDao.lister();
//			
//		    Iterator<Auteur> i = listAuteurs.iterator();
//		    while (i.hasNext()) {
//		      System.out.println(i.next());
//		    }
//
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		
		LivreDao livreDao = DaoFactory.getInstance().getLivreDao();
		List<Livre> listLivres;
		
		
		// lister
		try {
			listLivres = livreDao.lister();
			
			Iterator<Livre> i = listLivres.iterator();
			
			while(i.hasNext()) {
				System.out.println(i.next());
			}
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		// Ajouter un livre
		Livre livre = new Livre(1, "Il est frais mon poisson", 123456, "Chasse et Peche");
		//Livre livre2 = new Livre("Il est frais mon poisson", 123456, "Chasse et Peche"); // Ne fonctionne pas sans spécifier l'id d'un auteur meme si constructeur le permet
		
		try {
			livreDao.creer(livre);
			// Ne fonctionne pas sans spécifier l'id d'un auteur meme si constructeur le permet
			
		//	livreDao.creer(livre2);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		// Trouver un livre
		try {
			Livre livreATrouver = livreDao.trouver(10);
			Livre livreATrouver2 = livreDao.trouver(2);
			System.out.println("C'est ici que mes livers sont aficher"+ livreATrouver+livreATrouver2);
		
			System.out.println(livre);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		// Modifier un livre

		Livre livreAChanger = new Livre("Il est frais mon poisson pêchée", 5,"Peche et Chasse");
		
		
		try {
			livreDao.modifier(9, livreAChanger);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		try {
			livreDao.supprimer(10);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}

}