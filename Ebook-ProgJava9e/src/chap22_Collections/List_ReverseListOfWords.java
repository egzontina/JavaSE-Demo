package chap22_Collections;

import java.util.LinkedList;
import java.util.ListIterator;

import Annexe_Utils.Clavier;

/**
 * exemple montrant comment utiliser une liste chaînée pour afficher à l’envers une suite de chaînes lues au clavier
 * 
 * @author Malick
 */
public class List_ReverseListOfWords {
    public static void main(String args[]) {
	LinkedList<String> l = new LinkedList<String>();
	/* on ajoute a la liste tous les mots lus au clavier */
	System.out.println("Donnez une suite de mots (vide pour finir)");
	while (true) {
	    String ch = Clavier.lireString();
	    if (ch.length() == 0)
		break;
	    l.add(ch);
	}

	System.out.println("Liste des mots a l'endroit :");

	ListIterator<String> iter = l.listIterator();
	while (iter.hasNext()) {
	    System.out.print(iter.next() + " ");
	}

	System.out.println("\n Liste des mots a l'envers :");
	iter = l.listIterator(l.size()); // iterateur en fin de liste
	while (iter.hasPrevious())
	    System.out.print(iter.previous() + " ");
	System.out.println();
    }
}
