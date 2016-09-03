package technichalTest.cpeLyon.ds1.part1;

public class Cercle extends FigureGeometrique {
	
	public Cercle(String uneCouleur, String autreCouleur) {
		super(uneCouleur, autreCouleur);
	}

	public Cercle(Cercle autreCercle) {
		super(autreCercle);
	}

	public void dessine() {
		super.dessine();
		System.out.println("toute ronde");
	}
}
