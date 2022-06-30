package dao;

import java.util.List;

import model.Auteur;
import model.Livre;

public interface LivreDao {
	
	void creer(Livre livre) throws DaoException;

	Livre trouver(long id) throws DaoException;

	List<Livre> lister() throws DaoException;

	void supprimer(long id) throws DaoException;

	void modifier(long id, Livre livre) throws DaoException;
	
	Auteur getAuteur(long idAuteur) throws DaoException;

	List<Livre> listerByAuteur(Long idAuteur) throws DaoException;

	void update(Livre livre) throws DaoException;

}