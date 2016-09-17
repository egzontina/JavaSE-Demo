package puzzles.facile;

import java.util.*;
import java.io.*;
import java.math.*;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * L'art ASCII permet de représenter des formes en utilisant des caractères. 
 * <pre>
 * ASCII : American Standard Code for Information Interchange
 * contient les caractères nécessaires pour écrire en anglais
 * définit 128 caractères numérotés de 0 à 127 et codés en binaire de 0000000 à 1111111.
 *  7 bits suffisent pour représenter un caractère codé en ASCII
 * </pre>
 * @see https://www.codingame.com/ide/5254062c7332a8af3f50058007ff7e609b39fb4
 * 
 * @author Malick
 *
 */
class AsciiArt {

    /**
     * Main MEHTOD
     * <p>
     * programme capable d'afficher une ligne de texte en art ASCII.
     * @param args
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
        }

        
     // Regular expression pattern to test input        
        if (T.matches("[a-zA-Z]+")) {
            
        }
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("answer");
    }
}
