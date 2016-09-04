package DesignPattern.State;

import DesignPattern.State.example1.Avion;

public class MainExample1 {

	public static void main(String[] args) {
		Avion avion = new Avion();
		avion.makeAction();
		avion.decoler();
		avion.makeAction();
		
		avion.sortirDuGrage();
		System.out.println("Carburant : " + avion.getCarburant());
		avion.decoler();
		avion.setCarburant(1000);
		System.out.println("Carburant : " + avion.getCarburant());
		avion.decoler();

	}

}
