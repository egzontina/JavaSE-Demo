package chap22_Collections;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * exemple de programme manipulant une liste de chaînes (String) qui illustre les principales fonctionnalités de la
 * classe ListIterator 
 * @author Malick
 */
public class List_ListOfString {
    public static void main(String args[]) {
	
	LinkedList<String> l = new LinkedList<String>();
	System.out.print("Liste en A : ");
	affiche(l);
	l.add("a");
	l.add("b"); // ajouts en fin de liste
	System.out.print("Liste en B : ");
	affiche(l);

	ListIterator<String> it = l.listIterator();
	it.next(); // on se place sur le premier �lement
	it.add("c");
	it.add("b"); // et on ajoute deux elements
	System.out.print("Liste en C : ");
	affiche(l);

	it = l.listIterator();
	it.next(); // on progresse d'un element
	it.add("b");
	it.add("d"); // et on ajoute deux elements
	System.out.print("Liste en D : ");
	affiche(l);

	it = l.listIterator(l.size()); // on se place en fin de liste
	while (it.hasPrevious()) // on recherche le dernier b
	{
	    String ch = it.previous();
	    if (ch.equals("b")) {
		it.remove(); // et on le supprime
		break;
	    }
	}
	System.out.print("Liste en E : ");
	affiche(l);

	it = l.listIterator();
	it.next();
	it.next(); // on se place sur le deuxieme element
	it.set("x"); // qu'on remplace par "x"
	System.out.print("Liste en F : ");
	affiche(l);
    }

    /**
     * affichant le contenu d’une liste reçue en argument
     */
    public static void affiche(LinkedList<String> l) {
	ListIterator<String> iter = l.listIterator();
	while (iter.hasNext())
	    System.out.print(iter.next() + " ");
	System.out.println();
    }
}
