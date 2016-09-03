package chap24_Annotation_Introspection;

public class ClasseClass {
	public static void main(String args[]) {
		PointXY p = new PointXY();
		Class<?> c = p.getClass(); // ou c = Point.class ;
		System.out.println("classe de c = " + c.getName());
		// affichage de la conversion de c en String (métode toString)
		System.out.println("classe de c (obtenue par toString) = " + c);

		Couple<PointXY> cp = new Couple<PointXY>();
		Couple<?> cj = new Couple<PointXY>();
		System.out.println("classe Couple<Point> = " + cp.getClass().getName());
		System.out.println("classe Couple<?> = " + cj.getClass().getName());
	}
}

class PointXY {
	private int x, y;
}

class Couple<T> {
	private T x, y;
}