package OCA.chap1;

/**
 * Page 19 : Chapter 1 ■ Java Building Blocks
 * 
 * @author Malick
 *
 */
public class Chick {

    private String name = "Fluffy";

    {
        System.out.println("setting field");
    }

    public Chick() {
        name = "Tiny";
        System.out.println("setting constructor");
    }

    public static void main(String[] args) {
        Chick chick = new Chick();
        String a;
        System.out.println(chick.name);
    }
}
/*
 * Running this example prints this: setting field setting constructor Tiny
 */