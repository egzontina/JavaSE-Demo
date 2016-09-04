package chap27_JDBC;

import java.sql.*; // pour SQLException, DriverManager, Statement, ResultSet

public class ModifBase {
    // recherche et enregistrement du pilote et etablissement connexion
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	Connection connec = DriverManager.getConnection("jdbc:derby:C:/Documents and Settings/claude/stocks1");
	// cr�ation de l'objet de type Statement associ� � la connexion, avec
	// parcours bidirectinnel et r�sultats actualisables
	String requete = "SELECT * FROM produits";
	Statement stmt = connec.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	// ex�cution de la requ�te SQL de s�lection de donn�es
	ResultSet res;
	res = stmt.executeQuery(requete);
	// actualisation de la base, via les r�sultats :
	// on ajoute 10 unit�s au produit de r�f�rence A521
	String refCherchee = "A521"; // r�f�rence dont on veut modifier la
				     // quantit�
	while (res.next()) {
	    String ref = res.getString(2);
	    if (ref.equals(refCherchee)) {
		int ancienneQuantite = res.getInt(4);
		res.updateInt(4, ancienneQuantite + 10);
		res.updateRow();
	    }
	}
	// liste de la table modifi�e, dans l'ordre inverse
	System.out.println("--- La table stocks1 apr�s modification");
	res.afterLast();
	while (res.previous()) {
	    String nom = res.getString("nom");
	    String reference = res.getString("REFERENCE");
	    int quantite = res.getInt("quantite");
	    System.out.println(quantite + " " + reference + " " + nom);
	}
	// lib�ration des ressources
	stmt.close();
	res.close();
	connec.close();
    }
}
