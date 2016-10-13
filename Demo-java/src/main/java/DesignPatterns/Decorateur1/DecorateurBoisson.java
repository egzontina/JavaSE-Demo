package DesignPatterns.Decorateur1;

public abstract class DecorateurBoisson extends Boisson {

	protected Boisson boisson;

	public DecorateurBoisson(Boisson boisson) {
		super();
		this.boisson = boisson;
	}
	// on red�finis la m�thode pour obliger les classes fille � le red�finir
	public abstract String getDescription();
}

/** Chocolat Decorateur */
class Chocolat extends DecorateurBoisson {
    public Chocolat(Boisson boisson) {
        super(boisson);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double cout() {
        return 1.5 + boisson.cout();
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + " au chocolat";
    }
}

/** Lait Decorateur */
class Lait extends DecorateurBoisson {

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

/** Sucre Decorateur */
class Sucre extends DecorateurBoisson {
    
    public Sucre(Boisson boisson) {
        super(boisson);
    }

    public double cout() {
        return boisson.cout();
    }

    public String getDescription() {
        return boisson.getDescription() + ", sucr�e";
    }
}

/** Caramel Decorateur */
class Caramel extends DecorateurBoisson {
    
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