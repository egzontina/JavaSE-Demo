package DesignPatterns.Decorateur;

import DesignPatterns.Decorateur.example1.Boisson;
import DesignPatterns.Decorateur.example1.Deca;
import DesignPatterns.Decorateur.example1.Espresso;
import DesignPatterns.Decorateur.example1.dec.Chocolat;
import DesignPatterns.Decorateur.example1.dec.Lait;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// on cr�e un boisson
		Boisson expresso = new Espresso();
		System.out.println(expresso.getDescription());
		System.out.println(expresso.cout());

		// on d�core l'objet boisson avec du lait
		expresso = new Lait(expresso);
		System.out.println(expresso.getDescription());
		System.out.println(expresso.cout());

		// on d�core l'objet boisson avec du lait
		expresso = new Chocolat(expresso);
		System.out.println(expresso.getDescription());
		System.out.println(expresso.cout());

		// on cr�e un boisson
		Boisson deca = new Chocolat(new Lait(new Deca()));
		System.out.println(deca.getDescription());
		System.out.println(deca.cout());

	}

}


