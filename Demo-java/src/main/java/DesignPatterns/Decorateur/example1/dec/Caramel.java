package DesignPatterns.Decorateur.example1.dec;

import DesignPatterns.Decorateur.example1.Boisson;

public class Caramel extends DecorateurBoisson {
	
	public Caramel(Boisson boisson) {
		super(boisson);
	}

	public double cout() {
		return 0.22 + boisson.cout();
	}

	public String getDescription() {
		return boisson.getDescription() + ", Caramel";
	}
}
