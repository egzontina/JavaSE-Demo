package chap05_Control_Instruction_Bloc;

public class TernaryOperator {

    public static void main(String[] args) {
        int x = 10, y = 20;

        int max = (x < y) ? y : x; // Maintenant, max vaut 20
        System.out.println("max : " + max);

        max = (x < y) ? ((y < 10) ? y % 10 : y * 2) : x; // Max vaut 40
        System.out.println("max : " + max);

    }

}
