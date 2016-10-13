package ITwTest.other;

abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

}

class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

}

class Application {

    static String getAnimalName(Animal a) {
        String name = null;
        if (a instanceof Dog) {
            name = ((Dog) a).getName();
        } else if (a instanceof Cat) {
            name = ((Cat) a).getName();
        }

        return name;
    }
}

/** simplified version of App*/
class Application2 {
    static String getAnimalName(Animal a) {
        return a.getName();
    }    
}

/**
 * Class with Main 
 */
public class Exo8 {
    public static void main(String args[]) {
        System.out.println(Application.getAnimalName(new Dog("myDog")));
        System.out.println(Application.getAnimalName(new Cat("myCat")));
        
        System.out.println("\n" + Application.getAnimalName(new Dog("myDog")));
        System.out.println(Application.getAnimalName(new Cat("myCat")));
    }
    
}
