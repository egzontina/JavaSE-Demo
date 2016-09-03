package chap24_Annotation_Introspection;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class IntroAnnot2 {
	public static void main(String args[]) throws NoSuchMethodException {
		Annotation[] annotationsDeA = A2.class.getAnnotations();
		System.out.println("Annotations de la classe A2 : ");
		for (Annotation a : annotationsDeA)
			System.out.println(a.annotationType().getName());

		Method m1 = A2.class.getDeclaredMethod("f");
		Annotation[] annotationsDEf = m1.getAnnotations();
		System.out.println("Annotations de la methode A2.f : ");
		for (Annotation a : annotationsDEf)
			System.out.println(a.annotationType().getName());

		Annotation[] annotationsDeB = B2.class.getAnnotations();
		System.out.println("Annotations de la classe B2 : ");
		for (Annotation a : annotationsDeB)
			System.out.println(a.annotationType().getName());
		Annotation[] annotationsDeclDeB = B2.class.getDeclaredAnnotations();
		System.out.println("Annotations declarees de la classe B2 : ");
		for (Annotation a : annotationsDeclDeB)
			System.out.println(a.annotationType().getName());
	}
}

@Deprecated
@Infos2(message = "Message Classe A2", value = 20)
class A2 {
	@Deprecated
	@Infos2(message = "Message methode f")
	void f() {
	}
}

class B2 extends A2 {
	@Override
	void f() {
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Infos2 {
	String message() default "Rien";

	int value() default 0;
}
