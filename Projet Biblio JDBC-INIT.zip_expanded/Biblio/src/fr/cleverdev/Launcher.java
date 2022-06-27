package fr.cleverdev;

import java.util.Iterator;
import java.util.List;

import fr.cleverdev.dao.AuteurDao;
import fr.cleverdev.dao.DaoException;
import fr.cleverdev.dao.DaoFactory;
import fr.cleverdev.model.Auteur;

public class Launcher {

	public static void main(String[] args) throws DaoException {

		AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
		List<Auteur> listAuteurs;
		Auteur auteuramodifier = new Auteur ("uiop","iop","65478903","fdtyèçokytg");
		long idtomodify = 2;
		
		try {
			listAuteurs = auteurDao.lister();
			
		    Iterator<Auteur> i = listAuteurs.iterator();
		    while (i.hasNext()) {
		      System.out.println(i.next());
		    }

		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		try {
			auteurDao.modifier(idtomodify, auteuramodifier);
		} catch (DaoException DaoExc) 
		{
		
			DaoExc.printStackTrace();
		}
	}

}
