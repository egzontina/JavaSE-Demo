package puzzles.easy;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * The aim of this puzzle is to find the minimum difference between 2 values a list. Auto-generated code below aims at
 * helping you parse the standard input according to the problem statement.
 **/
class HorseRacingDuals {

    /**
     * Main Method - My solution
     * @param args
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] powerOfHorses;
        powerOfHorses = new int[N];

        for (int i = 0; i < N; i++)
            powerOfHorses[i] = in.nextInt();

        Arrays.sort(powerOfHorses);

        int currentMinDistance = -1;

        for (int i = 0; i < powerOfHorses.length - 1; i++) {
            int differences = powerOfHorses[i + 1] - powerOfHorses[i];
            if (differences < currentMinDistance || currentMinDistance == -1) {
                currentMinDistance = differences;
            }

            if (currentMinDistance == 1) {
                //break;
                return;
            }
        }
        System.out.println(currentMinDistance);
    }

    /**
     * Other Published Solution - Best Upvoted
     * 
     * @author Malick
     */
    public static void solution() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] pi = new boolean[10000000];

        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            if (pi[s]) {
                System.out.println(0);
                return;
            } else
                pi[s] = true;
        }

        int min = pi.length + 1;
        int l = 0 - min;
        for (int i = 0; i < pi.length; i++) {
            if (pi[i]) {
                min = Math.min(min, i - l);
                l = i;
            }
        }

        System.out.println(min);
    }
}
