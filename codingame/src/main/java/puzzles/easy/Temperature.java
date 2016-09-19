package puzzles.easy;

import java.util.*;
import java.util.stream.Stream;
import java.io.*;
import java.math.*;

/**
 * The aim of this puzzle is to find the closest temperature to 0 in a list. 
 **/
class Temperature {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        if (n == 0 ) {
            System.out.println("0");
	} 
        else {
            int T;
            int min = Integer.MAX_VALUE;
            int arrayTemps[] = Stream.of(temps.split("\\s+")).mapToInt(Integer::parseInt).toArray(); 
            /* Search the temperature of minimum absolute valueReads*/
            for (int i = 0; i < n; i++) {
                T = arrayTemps[i];
                if (Math.abs(T) < Math.abs(min) || (T == -min && T > 0))
                    min = T;
            }
            System.out.println(min);
        }
    }
}
