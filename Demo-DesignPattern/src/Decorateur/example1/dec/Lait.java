package Decorateur.example1.dec;

import Decorateur.example1.Boisson;

public class Lait extends DecorateurBoisson {

	public Lait(Boisson boisson) {
		super(boisson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double cout() {
		return 2 + boisson.cout();
	}

	@Override
	public String getDescription() {
		return boisson.getDescription() + " au lait";
	}

}
