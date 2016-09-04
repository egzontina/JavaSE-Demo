package ITwTest.ds1.part1;

public class Main {

	public static void main(String[] args) {

		FigureGeometrique f1, f2, f3, f4;

		// 1.
		// f1 = new FigureGeometrique("Rouge", "Noir");

		// 2.
		f2 = new Cercle("Bleu", "Blanc");

		// 3.
		// f3 = new Triangle();

		// 4.
		// Cercle f8  = new Cercle("Bleu", "Blanc");
		// f4 = new Cercle(f2);

		// f2.setCouleurContour("Noir");

		// 5.
		// System.out.println(f1.getCouleurSurface());
		
		// 6.
		// System.out.println(f3.getCouleurSurface());
		
		// 7.
		System.out.println(f2.getCouleurContour());
		
		// 8.
		System.out.println(FigureGeometrique.getNbFigures());
		
		// 9.
		// System.out.println(f3.getNbFigures());

	}

}
