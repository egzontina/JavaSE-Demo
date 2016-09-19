package chap04_Operator_Expression;

public class Increment {

    public static void main(String args[]) {
       
        // incrémentation
        
        int x=7;
        int y;
        
        y=x++; // y est initialisé à 7, puis x est incrémené à 8
        System.out.println("x : " + x + "\n" + "y : " + y + "\n");

        y=++x; // x est incrémenté à 8, puis y est initialisé à 8
        System.out.println("x : " + x + "\n" + "y : " + y + "\n");
    }

        
}
