package chap05_Control_Instruction_Bloc;

public class For {
    public static void main(String args[]) {
        for1();
        for2();
        for3();
    }

    public static void for1() {
        int i;
        for (i = 1; i <= 5; i++) {
            System.out.print("bonjour ");
            System.out.println(i + " fois");
        }
    }

    public static void for2() {
        int i;
        i = 1;
        while (i <= 5) {
            System.out.print("bonjour ");
            System.out.println(i + " fois");
            i++;
        }
    }

    private static void for3() {
        int i, j;
        for (i = 1, j = 3; i <= 5; i++, j += i) {
            System.out.println("i = " + i + "  j = " + j);
        }
    }
    
    public static void for4() {
        for (int i = 1, j = 3; i <= 5; i++, j += i) {
            System.out.println("i = " + i + "  j = " + j);
        }
    }

}
