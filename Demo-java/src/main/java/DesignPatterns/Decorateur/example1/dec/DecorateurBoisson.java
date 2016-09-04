package DesignPatterns.Decorateur.example1.dec;

import DesignPatterns.Decorateur.example1.Boisson;

public abstract class DecorateurBoisson extends Boisson {

	protected Boisson boisson;

	public DecorateurBoisson(Boisson boisson) {
		super();
		this.boisson = boisson;
	}

	// on red�finis la m�thode pour obliger les classes fille � le red�finir
	public abstract String getDescription();

	
	
	
}
