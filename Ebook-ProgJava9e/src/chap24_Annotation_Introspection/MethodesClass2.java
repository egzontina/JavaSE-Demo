package chap24_Annotation_Introspection;

import java.lang.reflect.*;

public class MethodesClass2 {
	public static void main(String args[]) {
		Point p = new Point();
		Class<?> c = p.getClass();
		Field champs[] = c.getDeclaredFields();
		// affichage des informations relatives aux champs de la classe de p
		for (Field champ : champs) {
			System.out.println("---- Champ de nom : " + champ.getName());
			System.out.println("type : " + champ.getType().getName());
			int mod = champ.getModifiers();
			System.out.println("modificateurs : " + mod);
			if (Modifier.isPrivate(mod))
				System.out.println("prive");
			if (Modifier.isStatic(mod))
				System.out.println("static");

		}
	}
}
