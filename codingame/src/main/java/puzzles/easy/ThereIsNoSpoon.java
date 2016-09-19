package puzzles.easy;

import java.util.*;
import java.util.stream.Stream;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class ThereIsNoSpoon {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();

        // matrice : row = height, column = width
        String strPuceArray[][] = new String[height][width];

        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .

            String strArray[] = line.split(""); // // array lengt = width
            
            for (int j = 0; j < strArray.length; j++) {
                strPuceArray[i][j] = strArray[j];
            }
        }

        // note : diferrence node loop
        // in table data structure : route of the loop is : (i,j) -> (i,j+1) .. -> (i+1,j), (i+1, j+1)...last
        // in game ennonciate text : route of the loop is : (u,v) -> (u+1,v) .. -> (u,v+1), (u+1, v+1)...
        // solution : make corrspondance
        // U evolve/increment together J
        // V evolve/increment together I
        int u = 0;
        int v = 0;

        for (int i = 0; i < height; i++) {
            v = i;

            for (int j = 0; j < width; j++) {
                u = j;

                String celChar = strPuceArray[i][j];
                StringJoiner stringJoiner = new StringJoiner(" ");

                // Cell contain node
                if (celChar.equals("0")) {

                    // stringJoiner.add(String.valueOf(i)).add(String.valueOf(j));
                    stringJoiner.add(String.valueOf(u)).add(String.valueOf(v));

                    // THE RIGTH
                    // if it's last cell in width, no righ cell
                    if (j == width - 1) {
                        stringJoiner.add("-1 -1");
                    }
                    // the righ of current node
                    else {
                        // check until first node in right
                        boolean isNodeFoundOnTheRight = false;
                        int counterRight = 1;
                        int z = j + 1;
                        while (!isNodeFoundOnTheRight && z < width) {
                            if (strPuceArray[i][z].equals("0")) {
                                // stringJoiner.add(String.valueOf(i)).add(String.valueOf(j+counter));
                                stringJoiner.add(String.valueOf(u + counterRight)).add(String.valueOf(v));
                                isNodeFoundOnTheRight = true;
                            }
                            z++;
                            counterRight++;
                        }
                        // si on arrive au dernier à droite sans avoir trouvé de node
                        if (isNodeFoundOnTheRight == false) {
                            stringJoiner.add("-1 -1");
                        }
                    }

                    // THE BOTTOM
                    // if it's last cell in eight, no bottom cell
                    if (i == height - 1) {
                        stringJoiner.add("-1 -1");
                    }
                    // the Bottom of current node
                    else {
                        // check until first node in ottom
                        boolean isNodeFoundOnTheBottom = false;
                        int counterBottom = 1;
                        int z = i + 1;
                        while (!isNodeFoundOnTheBottom && z < height) {
                            if (strPuceArray[z][j].equals("0")) {
                                // the bottom of current node
                                // stringJoiner.add(String.valueOf(i + counter)).add(String.valueOf(j));
                                stringJoiner.add(String.valueOf(u)).add(String.valueOf(v + counterBottom));
                                isNodeFoundOnTheBottom = true;
                            }
                            z++;
                            counterBottom++;
                        }
                        // si on arrive au dernier à droite sans avoir trouvé de node
                        if (isNodeFoundOnTheBottom == false) {
                            stringJoiner.add("-1 -1");
                        }
                    }

                    // print line with Three coordinates: a node, its right neighbor, its bottom neighbor
                    String outputLineForNode = stringJoiner.toString();
                    System.out.println(outputLineForNode);

                }

            }

        }

    }
}