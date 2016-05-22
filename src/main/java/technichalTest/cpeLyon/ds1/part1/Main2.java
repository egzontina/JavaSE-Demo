package technichalTest.cpeLyon.ds1.part1;

public class Main2 {

	public static void main(String[] args) {

		FigureGeometrique f1, f2, f3, f4;

		// 1.
		// f1 = new FigureGeometrique("Rouge", "Noir");

		// 2.
		f2 = new Cercle("Bleu", "Blanc");

		// 3.
		f3 = new Triangle();
		f3.setCouleurSurface("Jaune");
		
		// 4.
		// f4 = new Cercle(f2);

		f2.setCouleurSurface("Rouge");
		f2.dessine();
		f3.dessine();


	}

}
