package Decorateur.example1.dec;

import Decorateur.example1.Boisson;

public class Sucre extends DecorateurBoisson {
	
	public Sucre(Boisson boisson) {
		super(boisson);
	}

	public double cout() {
		return boisson.cout();
	}

	public String getDescription() {
		return boisson.getDescription() + ", sucrée";
	}
	
}
	
	
