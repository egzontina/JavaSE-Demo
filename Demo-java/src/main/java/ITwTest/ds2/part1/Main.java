package ITwTest.ds2.part1;

public class Main {

	public static void main(String args[]) {
		
		Barmans barman = new Barman("Bob", "Le cowboy solitaire");
		
		
		Brigands brigand = new Brigand("Joe");
		
		
		Dames dame = new Dame("Lily");
		Sherifs sherif2 = new Sherif("John");
		Personnage sherif1 = new Sherif("Clint");

		brigand.kidnappe(dame);
		sherif2.recherche(brigand);
		//sherif1.tire(brigand);
		//sherif1.libere(dame);
		sherif2.coffre(brigand);
		barman.sert(sherif1);
		
	}
}
