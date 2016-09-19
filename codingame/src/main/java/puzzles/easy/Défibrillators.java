package puzzles.easy;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * The aim of this puzzle is to find the closest defibrillators in a list. Auto-generated code below aims at helping you
 * parse the standard input according to the problem statement.
 **/
public class Défibrillators {

    /**
     * Main Method
     * 
     * @param args
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        /*
         * as the latitude and the longitude are given with ',' instead of '.' it isn't possible to use nextFloat()
         */
        Double userLon = new Double(in.next().replace(',', '.'));
        Double userLat = new Double(in.next().replace(',', '.'));
        int N = in.nextInt();
        in.nextLine();

        // simple min search amongst defibrillators
        double closestDistance = Double.POSITIVE_INFINITY;
        String closestDef = "";
        Double d;
        for (int i = 0; i < N; i++) {
            String[] defib = in.nextLine().replace(',', '.').split("\\;");
            d = distance(userLon, userLat, new Double(defib[4]), new Double(defib[5]));
            if (d < closestDistance) {
                closestDistance = d;
                closestDef = defib[1];
            }
        }
        System.out.println(closestDef);
    }

    /**
     * Returns the distance between a point A and a point B
     */
    private static double distance(double longA, double latA, double longB, double latB) {
        double earthRadius = 6371.0;
        double x = (longB - longA) * Math.cos((latA + latB) / 2);
        double y = latB - latA;
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * earthRadius;
    }

    /**
     * Other Published Solution - Best Upvoted
     * 
     * @author Malick
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        double userLon = Double.parseDouble(in.next().replace(',', '.'));
        double userLat = Double.parseDouble(in.next().replace(',', '.'));
        int defibrillatorsCount = in.nextInt();
        in.nextLine();

        double earthRadius = 6371.0;
        String closestDef = "none";
        double closestDistance = Double.MAX_VALUE;

        for (int i = 0; i < defibrillatorsCount; i++) {
            String[] def = in.nextLine().split("\\;");
            double defLon = Double.parseDouble(def[4].replace(',', '.'));
            double defLat = Double.parseDouble(def[5].replace(',', '.'));
            double x = (userLon - defLon) * Math.cos((userLat + defLat) * 0.5);
            double y = userLat - defLat;
            double d = Math.sqrt(x * x + y * y) * earthRadius;
            if (d < closestDistance) {
                closestDistance = d;
                closestDef = def[1];
            }
        }
        System.out.println(closestDef);
    }

}
