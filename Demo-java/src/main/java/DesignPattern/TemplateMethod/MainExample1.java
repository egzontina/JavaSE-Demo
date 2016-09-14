package DesignPattern.TemplateMethod;

import DesignPattern.TemplateMethod.example1.Template1;
import DesignPattern.TemplateMethod.example1.Template2;
import DesignPattern.TemplateMethod.example1.TemplateClass;

public class MainExample1 {

	public static void main(String[] args) {
		
		TemplateClass t1 = new Template1();
		System.out.println("Template1 : "+ t1.templateMethod());
		
		TemplateClass t2 = new Template2();
		System.out.println("Template2 : "+ t2.templateMethod());
	}

}
