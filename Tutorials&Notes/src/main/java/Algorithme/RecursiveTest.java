package Algorithme;

import java.util.ArrayList;
import java.util.List;

public class RecursiveTest {

	public static void main(String[] args) {
		System.out.println("Calcul factorielle 5 : " + fact(5));
	}
	
	/**
	 * Calcul factorielle
	 */
	public static int fact(int n) {
		if (n==0) return 1;
		return (n==1) ? 1 : n + fact(n-1);
		
	}
	
	/**
	 * problème : je dispose d'une liste de joueurs d'un jeu à deux joueurs (échecs, ping-pong, etc.), et je veux créer une liste de matches, de telle sorte que chaque joueur joue contre tous les autres joueurs une seule fois.
	 * 
	 */
	public static List<String> MatchTwoPlayerOfListPlayer(List<String> joueurs) {
		
		List<String> matches = new ArrayList<>(); 
		/* s'il n'y a qu'un seul joueur, on n'organise aucun match */
		if (joueurs != null && !joueurs.isEmpty()) {
			return matches;
		}
		/* on enleve le dernier joueur de la liste, et on demande les matchs sans lui */
	    String dernierJoueur = joueurs.remove(joueurs.size() - 1);
//	    $matches = MatchTwoPlayerOfListPlayer($joueurs);
	 
	    /* on rajoute un match entre lui et tous les autres joueurs */
	    for(String autreJoueurs : joueurs) {
//	        $matches[] = array($autre_joueur, $dernier_joueur);
	    	matches.add(autreJoueurs + dernierJoueur);
	    }
	 
	    /* on le remet dans la liste des joueurs, et on renvoie la liste des matchs */
//	    array_push($joueurs, $dernier_joueur);
	    return matches;		
	}

}
