package chap07_Arrays;

public class Ellipse {
    public static void main(String args[]) {
        System.out.println(somme(2, 8, 9)); // => 19
        System.out.println(somme()); // => 0
        System.out.println(somme(3)); // => 3
    }

    static int somme(int... valeurs) {
        int s = 0;
        for (int v : valeurs)
            s += v;
        return s;
    }
}
