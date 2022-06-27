import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Launcher {

	public static void main(String[] args) {
		
		/*
		1 - Créer un Java Project "TestJDBC"
		2 - Créer un dossier "RESSOURCES" à la racine et y placer le fichier "postgresql*.jar"
		3 - Ajouter le driver au classpath de votre projet
		4 - Ajouter la classe Auteur.java et le Launcher.java dans le dossier "src"
		5 - Completez le fichier Launcher.java pour faire les actions suivantes en JAVA depuis la base : 
		
	- Afficher la liste des auteurs 
	Select * FROM Auteur;
	
	- Afficher le détail d'un auteur 
	SELECT nom,prenom, telephone,email FROM Auteur;
	
	- Ajouter un auteur (et constatez en BDD via pgAdmin)
	INSERT INTO Auteur (nom,prenom,telephone,email)
     VALUES ('pierre', 'Cart','0987652243','etsbrtbbt@rtrb');
     
	- Modifier un auteur existant (et constatez en BDD via pgAdmin)
	
	- Supprimer un auteur existant (et constatez en BDD via pgAdmin)
		 */
		
		String url = "jdbc:postgresql://localhost/biblio";
		String user = "postgres";
		String password = "12345";
		
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		
		//Lister les auteurs 
		
		List <Auteur> listeAuteurs = new ArrayList<Auteur>();
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection("jdbc:postgresql://localhost/biblio","postgres","12345");
			  
			  sta = con.createStatement();
			  rs = sta.executeQuery("Select * from Auteur");
			  
		      while ( rs.next() ) {
		    	  Auteur temporaire = new Auteur();
		    	  temporaire.setId(rs.getLong( "id" ));
		    	  temporaire.setNom(rs.getString( "nom" ));
		    	  temporaire.setPrenom(rs.getString( "prenom" ));
		    	  temporaire.setTelephone(rs.getString( "telephone" ));
		    	  temporaire.setEmail(rs.getString( "email" ));
		    	  listeAuteurs.add( temporaire );
		      }
		      rs.close();
		      sta.close();
		      
			    Iterator <Auteur> i = listeAuteurs.iterator();
			    while (i.hasNext()) {
			    	
			      System.out.println(i.next());
			    }
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("---------------------------------" );
		System.out.println("la liste des auteurs est : "+ listeAuteurs );
		System.out.println("---------------------------------" );
		
		
		
		//Récupérer un auteur à partir d'un ID
		
		
		Auteur auteur = new Auteur();
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection (url, user, password);
			  rs = sta.executeQuery("Select * from Auteur Where id=5");
			  
		      if( rs.next() ) {
		    	  auteur.setId(rs.getLong( "id" ));
		    	  auteur.setNom(rs.getString( "nom" ));
		    	  auteur.setPrenom(rs.getString( "prenom" ));
		    	  auteur.setTelephone(rs.getString( "telephone" ));
		    	  auteur.setEmail(rs.getString( "email" ));
		      }
		      
		      rs.close();
		      sta.close();
		      
			  System.out.println(auteur);
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("l'auteur qui a ete recupérer est celui de l'id 6");
		
		//Ajouter un auteur
		
		
		auteur = new Auteur("Tito", "Toa", "0699996060", "titotoa@tata.fr");
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  
			  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("-------------------");
		
		//Modifier un auteur
				try {
					  Class.forName("org.postgresql.Driver");
					  con = DriverManager.getConnection("jdbc:postgresql://localhost/biblio","postgres","12345");
					  sta = con.createStatement();
				      
					  auteur.setPrenom("pierre");
					  
					  sta.executeUpdate("UPDATE Auteur SET nom='"+auteur.getNom()+"', prenom='"+auteur.getPrenom()+"', telephone='"+auteur.getTelephone()+"', email='"+auteur.getEmail()+"' WHERE id="+auteur.getId());

				      sta.close();
				      
					  System.out.println(auteur);
					  
			    } catch(SQLException ex) {
			    	ex.printStackTrace();
			    } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("-------------------");
				System.out.println("toa a ete changer en pierre");
				
				//Supprimer un auteur
				
				try {
					
					  Class.forName("org.postgresql.Driver");
					  con = DriverManager.getConnection("jdbc:postgresql://localhost/biblio","postgres","12345");
					  sta = con.createStatement();
					  
					  int statut = sta.executeUpdate("DELETE FROM auteur WHERE id=3");

				      sta.close();
				      
					  System.out.println(listeAuteurs);
					  
			    } catch(SQLException ex) {
			    	ex.printStackTrace();
			    } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}

		}