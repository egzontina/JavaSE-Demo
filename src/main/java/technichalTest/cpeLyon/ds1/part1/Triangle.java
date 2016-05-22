package technichalTest.cpeLyon.ds1.part1;

public class Triangle extends FigureGeometrique {
	
	public Triangle(String uneCouleur, String autreCouleur) {
		super(uneCouleur, autreCouleur);
	}

	public Triangle(Triangle autreTriangle) {
		super(autreTriangle);
	}

	public Triangle() {
	}

	public void dessine() {
		super.dessine();
		System.out.println("toute pointue");
	}
}
