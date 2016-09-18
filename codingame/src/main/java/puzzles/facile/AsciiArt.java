package puzzles.facile;

import java.util.*;
import java.io.*;
import java.math.*;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * L'art ASCII permet de représenter des formes en utilisant des caractères.
 * 
 * <pre>
 * ASCII : American Standard Code for Information Interchange
 * contient les caractères nécessaires pour écrire en anglais
 * définit 128 caractères numérotés de 0 à 127 et codés en binaire de 0000000 à 1111111.
 * 7 bits suffisent pour représenter un caractère codé en ASCII
 * </pre>
 * 
 * <pre>
 * In stations and airports you often see this type of screen. Have you ever asked yourself how it might be possible to simulate this display on a good old terminal? We have: with ASCII art!
 * 
 * ASCII art allows you to represent forms by using characters. To be precise, in our case, these forms are words. For example, the word "MANHATTAN" could be displayed as follows in ASCII art:
 * # #  #  ### # #  #  ### ###  #  ###
 * ### # # # # # # # #  #   #  # # # #
 * ### ### # # ### ###  #   #  ### # #
 * # # # # # # # # # #  #   #  # # # #
 * # # # # # # # # # #  #   #  # # # #
 * ​Your mission is to write a program that can display a line of text in ASCII art.
 * 
 * INPUT:
 * Line 1: the width L of a letter represented in ASCII art. All letters are the same width.
 * Line 2: the height H of a letter represented in ASCII art. All letters are the same height.
 * Line 3: The line of text T, composed of N ASCII characters.
 * Following Lines: the string of characters ABCDEFGHIJKLMNOPQRSTUVWXYZ? Represented in ASCII art.
 * 
 * OUTPUT:
 * The text T in ASCII art.
 * The characters a to z are shown in ASCII art by their equivalent in upper case.
 * The characters which are not in the intervals [a-z] or [A-Z] will be shown as a question mark in ASCII art.
 * 
 * CONSTRAINTS :
 * 0 < L < 30
 * 0 < H < 30
 * 0 < N < 200
 * </pre>
 * 
 * @see https://www.codingame.com/ide/5254062c7332a8af3f50058007ff7e609b39fb4
 * @author Malick
 */
class AsciiArt {

    // ASCII-art representation of the whole alphabet + ?
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";

    static final char FIRST_CHAR = 'A';
    static final char LAST_CHAR = 'Z';

    /**
     * Main Method
     * <p>
     * My Solution
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // width and height of the ASCII-art representation of 1 character
        int L = in.nextInt();
        int H = in.nextInt();

        // text to convert
        in.nextLine();
        String T = in.nextLine();

        // To prevent minuscule char like 'a'
        String text = T.toUpperCase();

        // ASCII art representations of the whole alphabet + ?
        ArrayList<String> ascii = new ArrayList<String>();

        for (int i = 0; i < H; i++) {
            ascii.add(in.nextLine());
        }

        // Debug Messages
        // System.err.println("L : Width ... :" + L);
        // System.err.println("H : Higth ... :" + H);
        // System.err.println("T : Text Line... :" + T);
        // System.err.println("List ASCII");
        // ascii.forEach(System.err::println);

        // find the necessary indexes of letters in alphabet string
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (char c : text.toCharArray()) {
            // Add index of '?'if character is out of delimited alphabet
            if (c < 'A' || c > 'Z')
                indexes.add(26); //
            else {
                for (char letter : alphabet.toCharArray()) {
                    if (c == letter) {
                        indexes.add(alphabet.indexOf(letter));
                    }
                }
            }
        }

        // prints the result line by line, character by character
        for (int j = 0; j < H; j++) {
            for (int k = 0; k < indexes.size(); k++) {
                System.out.print(ascii.get(j).substring(indexes.get(k) * L, indexes.get(k) * L + L));
            }
            System.out.println();
        }

        // close scanner
        in.close();

    }

    /**
     * Other Published Solution - Best Upvoted 
     * 
     * @author Malick
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine().toUpperCase();
        for (int i = 0; i < H; i++) {
            String row = in.nextLine();
            for (int j = 0; j < T.length(); ++j) {
                int index = T.charAt(j) - 'A'; // 'E'=69, 'A' = 65, 'Z'=90
                if (index < 0 || index >= 26) {
                    index = 26; // '?'
                }
                System.out.print(row.substring(index*L, (index*L) + L));
            }
            System.out.println();
        }
    }

}