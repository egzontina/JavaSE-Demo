package tmp;

import java.util.List;

/**
 * EXEMPLES D’OPTIMISATIONS DE CODE
 */

public class BestPracticeOptimisation {

	static final int t = 5;
	
	/**
	 * ********************************************************************************************* Utilisation des
	 * membres statiques d’une classe accéder aux membres statiques d’une classe (attributs ou méthodes) directement
	 * depuis le nom de la classe au lieu de l’instancier dans un objet.
	 */
	/*
	class test {
		static int afficher() {
			
		}
	}
	// TODO
	Optim.afficher();
	// NOT TODO
	MaClasse maClasse = new MaClasse();
	maClasse.afficher();
	*/

	/**
	 * ********************************************************************************************* Constantes pas
	 * utiliser des constantes numériques en dur dans le code mais de déclarer des constantes avec des noms explicites.
	 * Une exception concerne les valeurs -1, 0 et 1 dans les boucles for.
	 */
	// TODO
	private static final int MYCONSTANTE = 5;
	int test = MYCONSTANTE;
	// NOT TODO
	int test2 = 5;

	/**
	 * ********************************************************************************************* Usage des
	 * parenthèses utiliser les parenthèses lors de l’usage de plusieurs opérateurs pour éviter des problèmes liés à la
	 * priorité des opérateurs.
	 
	// TODO
	if((i==j)&&(m==n))
	// NOT TODO
	if(i==j&&m==n)
	
	*/

	/**
	 * ***********************************************************************************************************
	 * Valeurs de retour minimiser le nombre d’instruction « return » dans un bloc de code.
	 */
	// TODO
	public int testisvalid() {
		int x = 5, y = 6;
		return isValide11() ? x : y;
	}

	// NOT TODO
	public boolean testisvalid2() {
		if (isValide11()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValide11() {
		return true;
	}

	/**
	 * ************************************************************************************************************
	 * APPELS DE MÉTHODES DANS UNE BOUCLE Une méthode retournant toujours le même résultat, indépendamment des objets
	 * sur lesquels on itère, doit impérativement être appelée à l’extérieur d’une boucle.
	 */

	public void method(final List<String> list) {
		Object obj = this.doSomething();
		for (int i = 0; i < list.size(); i++) {
			// ... Utilisation de obj
		}
	}

	public String doSomething() {
		String str = "test";
		return str;
	}

}
