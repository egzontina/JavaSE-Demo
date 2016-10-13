package DesignPatterns.Decorateur1;

public abstract class Boisson {
    
	protected String description;
		
	public abstract double cout();
		
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

/** COLOMBIA Boisson */

class Colombia extends Boisson {

    public Colombia() {
        description = "Comlombia";
    }

    @Override
    public double cout() {
        return .89;
    }
}

/** DECA Boisson */

class Deca extends Boisson {
    public Deca() {
        description = "Deca";
    }

    @Override
    public double cout() {
        return 15;
    }
}

/** EXPRESSO Boisson */

class Espresso extends Boisson {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cout() {
        return 7;
    }
}

/** SUMATRA Boisson */

class Sumatra extends Boisson {
    public Sumatra() {
        description = "Sumatra";
    }

    @Override
    public double cout() {
        return 10;
    }
}
