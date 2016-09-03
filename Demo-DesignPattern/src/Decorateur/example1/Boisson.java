package Decorateur.example1;

public abstract class Boisson {

	// propriétés
	
	protected String description;
	
	
	// methode 
	
	public abstract double cout();
	
	// getters and setters
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
