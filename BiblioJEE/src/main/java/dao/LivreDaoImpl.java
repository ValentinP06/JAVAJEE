package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Auteur;
import model.Livre;

public class LivreDaoImpl implements LivreDao {
	
	private static final String SQL_INSERT = "INSERT INTO livre(id_auteur, titre, nb_pages, categorie) VALUES(?,?,?,?)";
	private static final String SQL_SELECT = "SELECT id, id_auteur, titre, nb_pages, categorie FROM livre";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM livre WHERE id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM livre WHERE id = ? ";
	private static final String SQL_UPDATE_BY_ID = "UPDATE livre SET titre=?, nb_pages=?, categorie=? WHERE id = ?";

	private DaoFactory factory;
	
	public LivreDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}
	

	@Override 
	public void creer(Livre livre) throws DaoException {
		Connection con = null;
		try {
			con = factory.getConnection();

			PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			pst.setLong(1, livre.getIdAuteur());
			pst.setString(2, livre.getTitre());
			pst.setInt(3, livre.getNbPages());
			pst.setString(4, livre.getCategorie());

			int statut = pst.executeUpdate();

			if (statut == 0) {
				throw new DaoException("Echec cr�ation Livre (aucun ajout)");
			}
			ResultSet rsKeys = pst.getGeneratedKeys();
			if (rsKeys.next()) {
				livre.setId(rsKeys.getLong(1));
			} else {
				throw new DaoException("Echec cr�ation Livre (ID non retourn�)");
			}
			rsKeys.close();
			pst.close();

		} catch (SQLException ex) {
			throw new DaoException("Echec cr�ation Auteur", ex);
		} finally {
			factory.releaseConnection(con);
		}

	}

	@Override
	public Livre trouver(long id) throws DaoException {
		Livre livre= null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_SELECT_BY_ID);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				livre = map(rs);
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de recherche BDD Livre", ex);
		} finally {
			factory.releaseConnection(con);
		}
		return livre;
	}

	@Override
	public List<Livre> lister() throws DaoException {
		List<Livre> listeLivres = new ArrayList<Livre>();
		Connection con = null;
		try {
			con = factory.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_SELECT);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				listeLivres.add(map(rs));
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de lecture BDD Livre", ex);
		} finally {
			factory.releaseConnection(con);
		}
		return listeLivres;
	}

	@Override
	public void supprimer(long id) throws DaoException {
		Connection con = null;
		try {
			con = factory.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_DELETE_BY_ID);
			pst.setLong(1, id);
			int statut = pst.executeUpdate();
			if (statut == 0) {
				throw new DaoException("Erreur de suppression Livre(" + id + ")");
			}
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de suppression BDD Livre", ex);
		} finally {
			factory.releaseConnection(con);
		}

	}

	@Override
	public void modifier(long id, Livre livre) throws DaoException {
		Connection con = null;
		
		try {
			con = factory.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_UPDATE_BY_ID, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, livre.getTitre());
			pst.setInt(2, livre.getNbPages());
			pst.setString(3, livre.getCategorie());
			pst.setLong(4, id);

			int statut = pst.executeUpdate();

			if (statut == 0) {
				throw new DaoException("Echec modification Livre(" + id + ")");
			}

			pst.close();

		} catch (SQLException sqlEx) {
			throw new DaoException("Echec BDD modification livre: " + sqlEx);

		} finally {
			factory.releaseConnection(con);
		}

	}
	
	@Override
	public Auteur getAuteur(long idAuteur) throws DaoException {
		Auteur auteur = DaoFactory.getInstance().getAuteurDao().trouver(idAuteur);
		return auteur;
	}
	
	private static Livre map(ResultSet resultSet) throws SQLException {
		Livre a = new Livre();
		a.setId(resultSet.getLong("id"));
		a.setIdAuteur(resultSet.getLong("id_auteur"));
		a.setTitre(resultSet.getString("titre"));
		a.setNbPages(resultSet.getInt("nb_pages"));
		a.setCategorie(resultSet.getString("categorie"));
		return a;
	}

}