package OCA;

public class Chap4_Encapsulation {

}

/**
 * @see page 205
 */
class Swan {

    private int numberEggs; // private
    boolean happy;

    public boolean isHappy() { // getter for boolean
        return happy;
    }

    public int getNumberEggs() { // getter
        return numberEggs;
    }

    public void setNumberEggs(int numberEggs) { // setter
        if (numberEggs >= 0) // guard condition
            this.numberEggs = numberEggs;
    }
}

/**
 * Immutable class | no setters
 * 
 * @see page 207
 */
class ImmutableSwan {
    private int numberEggs;

    public ImmutableSwan(int numberEggs) {
        this.numberEggs = numberEggs;
    }

    public int getNumberEggs() {
        return numberEggs;
    }
}
