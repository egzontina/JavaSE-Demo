package technichalTest.cpeLyon.ds1.part1;

public class Main {

	public static void main(String[] args) {

		FigureGeometrique f1, f2, f3, f4;

		// 1. 
		f1 = new FigureGeometrique("Rouge", "Noir");
		f2 = new Cercle("Bleu", "Blanc");
		f3 = new Triangle();
		f4 = new Cercle(f2);
		f2.setCouleurContour("Noir");

		System.out.println(f1.getCouleurSurface());
		System.out.println(f3.getCouleurSurface());
		System.out.println(f2.getCouleurContour());
		System.out.println(FigureGeometrique.getNbFigures());
		System.out.println(f3.getNbFigures());

	}

}
