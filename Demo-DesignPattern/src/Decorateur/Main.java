package Decorateur;

import Decorateur.example1.Boisson;
import Decorateur.example1.Deca;
import Decorateur.example1.Espresso;
import Decorateur.example1.dec.Chocolat;
import Decorateur.example1.dec.Lait;

public class Main {

	/**
	 * DESIGN PATTERN - DECORATEUR
	 * =======================================================================
	 * Ce design Pattern montre montre comment ajouter dynamiquement des
	 * responsabilités supplémentaires à un objet.
	 * 
	 * ======================================================================
	 * objectif : attache dynamiquement des responsabilités supplémentaire à un objet.
	 *  sans créer de sous clase spécifique pour chaque configuration possible des objets
	 *  il fournit une alternative souple à la dérivation , pour étendre les fonctionnalité
	 *  
	 * ======================================================================
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// on crée un boisson
		Boisson expresso = new Espresso();
		System.out.println(expresso.getDescription());
		System.out.println(expresso.cout());

		// on décore l'objet boisson avec du lait
		expresso = new Lait(expresso);
		System.out.println(expresso.getDescription());
		System.out.println(expresso.cout());

		// on décore l'objet boisson avec du lait
		expresso = new Chocolat(expresso);
		System.out.println(expresso.getDescription());
		System.out.println(expresso.cout());

		// on crée un boisson
		Boisson deca = new Chocolat(new Lait(new Deca()));
		System.out.println(deca.getDescription());
		System.out.println(deca.cout());

	}

}
