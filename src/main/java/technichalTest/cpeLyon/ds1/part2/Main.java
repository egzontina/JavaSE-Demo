package technichalTest.cpeLyon.ds1.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * Question 1
		 */
		
		Refuge maison = new Refuge();
		Animal a1 = null;
		Chien c1 = new Chien();

		// (a) 
		maison.setAnimal(c1) ;

		// (b) 	
		// maison.setAnimal(new Animal());

		// (c) 	
		maison.setAnimal(a1);

		// (d) 	
		// Chat c2 = maison.getAnimal();
		
		/** 
		 * Question 2
		 */
		
		Refuge2 refugeChien = new Refuge2();
		Refuge2 refugeChat = new Refuge2();
				
		List<Animal> listeChien = new ArrayList<>();
		listeChien.add(new Chien());
		listeChien.add(new Chien());
		refugeChien.setListeAnimal(listeChien);
		
		System.out.println("nombre d'animaux présents dans ce refuge CHIEN : " + refugeChien.getNombreAnimauxDuRefuge());
		
		/*
		refugeChat.ajouterUnAnimal(new Chat()); // => error
		*/
		List<Animal> listeChat = new ArrayList<>(Arrays.asList(new Chat(), new Chat(), new Chat()));
		refugeChat.setListeAnimal(listeChat);
		
		System.out.println("nombre d'animaux présents dans ce refuge CHAT : " + refugeChat.getNombreAnimauxDuRefuge());
		
		System.out.println("le nombre d’animaux accueillis dans tous les refuges existants : " + Refuge2.getNbTotalAmimaux());
		

	}

}
