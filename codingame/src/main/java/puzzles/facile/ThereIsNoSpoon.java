package puzzles.facile;

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

        // To debug: System.err.println("Debug messages...");
        System.err.println("width...: " + width);
        System.err.println("height...:" + height);

        // matrice : row = height, column = width
        String strPuceArray[][] = new String[height][width];

        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .

            System.err.println("line...:" + line);
            String strArray[] = line.split(""); // // array lengt = width
            System.err.println("strArray[]...: " + Arrays.toString(strArray));

            for (int j = 0; j < strArray.length; j++) {
                strPuceArray[i][j] = strArray[j];
            }
        }

        // To debug: System.err.println("Debug messages...");
        System.err.println("Matrice strPuceArray[][]...:" + Arrays.deepToString(strPuceArray));

        // note : diferrently in table data structure, the rign on current node is i+1, (eg: for (0,0) it's (1,0) not
        // (0,1)
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
                stringJoiner.add(String.valueOf(i)).add(String.valueOf(j));

                // Cell contain node
                if (celChar.equals("0")) {

                    // THE RIGTH
                    // if it's last cell in width, no righ cell
                    if (j == width - 1) {
                        stringJoiner.add("-1 -1");
                    }
                    // the righ of current node
                    else {
                        // check until first node in right
                        boolean isNodeFoundOnTheBottom = false;
                        int counter = 0;
                        int z = j + 1;
                        while (!isNodeFoundOnTheBottom && z < width) {
                            counter++;
                            if (strPuceArray[i][z].equals("0")) {
                                // stringJoiner.add(String.valueOf(i)).add(String.valueOf(j+counter));
                                stringJoiner.add(String.valueOf(u + counter)).add(String.valueOf(v));
                                isNodeFoundOnTheBottom = true;
                            }
                            z++;
                        }
                        // si on arrive au dernier à droite sans avoir trouvé de node
                        if (isNodeFoundOnTheBottom = false) {
                            stringJoiner.add("-1 -1");
                        }
                    }

                    // THE BOTTOM
                    // if it's last cell in eight, no bottom cell
                    if ((i == height - 1)) {
                        stringJoiner.add("-1 -1");
                    }
                    // the righ of current node
                    else {
                        // check until first node in right
                        boolean isNodeFoundOnTheRight = false;
                        int counter = 0;
                        int z = i + 1;
                        while (!isNodeFoundOnTheRight && z < height) {
                            counter++;
                            if (strPuceArray[z][j].equals("0")) {
                                // the bottom of current node
                                // stringJoiner.add(String.valueOf(i + counter)).add(String.valueOf(j));
                                stringJoiner.add(String.valueOf(u)).add(String.valueOf(v + counter));
                                isNodeFoundOnTheRight = true;
                            }
                            z++;
                        }
                        // si on arrive au dernier à droite sans avoir trouvé de node
                        if (isNodeFoundOnTheRight = false) {
                            stringJoiner.add("-1 -1");
                        }
                    }

                }

                // Cell empty
                else
                    stringJoiner.add("-1 -1 -1 -1");

                // print line with Three coordinates: a node, its right neighbor, its bottom neighbor
                String outputLineForNode = stringJoiner.toString();
                System.out.println(outputLineForNode);
            }

        }

    }
}