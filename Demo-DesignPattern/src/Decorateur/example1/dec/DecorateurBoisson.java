package Decorateur.example1.dec;

import Decorateur.example1.Boisson;

public abstract class DecorateurBoisson extends Boisson {

	protected Boisson boisson;

	public DecorateurBoisson(Boisson boisson) {
		super();
		this.boisson = boisson;
	}

	// on redéfinis la méthode pour obliger les classes fille à le redéfinir
	public abstract String getDescription();

	
	
	
}
