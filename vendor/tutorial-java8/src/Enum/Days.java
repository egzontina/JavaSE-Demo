package Enum;

public enum Days {
	LUNDI("Lundi"), 
	
	MARDI("Mardi"), 
	
	MERCREDI("Mercredi"), 
	
	JEUDI("Jeudi"), 
	
	VENDREDI("Vendredi"), 
	
	SAMEDI("Samedi"), 
	
	DIMANCHE("Dimanche");
	
	private String name;

	Days(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}