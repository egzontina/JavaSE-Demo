package DesignPattern;

/**
 * DESIGN PATTERN - TEMPLATE METHOD
 * =====================================================================
 * D�finit la structure d'un algorithme, mais laisse certains d�tails
 * d'impl�mntation aux sous classes
 * =====================================================================
 * d�finir le squelette d'un algorithme et de d�l�guer aux classes d�riv�es
 * l'impl�mentation des parties abstraites de cet algorithme
 * =====================================================================
 * similaire au pattern STRATEGY, � la diff�rence que ce dernier s'appuie
 * sur la composition et externallise le traitemetn des methodes de l'algo �
 * d'utre classe externe
 */

class TemplateMethod1TestClass {

    public static void main(String[] args) {
        
        TemplateClass t1 = new TemplateMethod1();
        System.out.println("Template1 : "+ t1.templateMethod());
        
        TemplateClass t2 = new Template2();
        System.out.println("Template2 : "+ t2.templateMethod());
    }

}


public class TemplateMethod1 extends TemplateClass {

	@Override
	protected int etape1() {
		return 2;
	}

	@Override
	protected int etape2() {
		return 5;
	}

}

class Template2 extends TemplateClass {

    @Override
    protected int etape1() {
        return 5;
    }

    @Override
    protected int etape2() {
        return 5;
    }

}

abstract class TemplateClass {

    public double templateMethod() {

        double somme = 0;

        int a = etape1();

        for (int i = 0; i < a; i++) {
            somme += etape2();
        }
        return somme;
    }

    
    protected abstract int etape1();

    protected abstract int etape2();

}

