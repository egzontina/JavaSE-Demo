package OCA;

/**
 * @see page 166 of study book
 *
 */
public class Chap4_DesigningMethods {

}

//@formatter:off

/**
 * Access Modifiers
 * @see Page 167
 */
class testClasse1 {
    public void walk1() {}
    // default void walk2() {} // DOES NOT COMPILE
    // void public walk3() {} // DOES NOT COMPILE
    void walk4() {}
}

/**
 * Optional Specifiers
 * @see Page 168
 */
class testClasse2 {
    public void walk1() {}
    public final void walk2() {}
    public static final void walk3() {}
    public final static void walk4() {}
    // public modifier void walk5() {} // DOES NOT COMPILE
    // public void final walk6() {} // DOES NOT COMPILE
    final public void walk7() {}
}

/**
 * Return Type
 * @see Page 169
 */
class testClasse3 {
    public void walk1() { }
    public void walk2() { return; }
    public String walk3() { return ""; }
    // public String walk4() { } // DOES NOT COMPILE
    // public walk5() { } // DOES NOT COMPILE
    // String walk6(int a) { if (a == 4) return ""; } // DOES NOT COMPILE
}

/**
 * Method Name
 * @see Page 170
 */
class testClasse4 {
    public void walk1() { }
    // public void 2walk() { } // DOES NOT COMPILE
    // public walk3 void() { } // DOES NOT COMPILE
    public void Walk_$() { }
    // public void() { } // DOES NOT COMPILE
}

/**
 * Parameter List
 * @see Page 171
 */
class testClasse5 {
    public void walk1() { }
    // public void walk2 { } // DOES NOT COMPILE
    public void walk3(int a) { }
    // public void walk4(int a; int b) { } // DOES NOT COMPILE
    public void walk5(int a, int b) { } 
}

/**
 * Optional Exception List
 * 
 * @see Page 171
 */
class testClasse6 {
    public void zeroExceptions() { }
    public void oneException() throws IllegalArgumentException { }
    public void twoExceptions() throws IllegalArgumentException, InterruptedException { }
}

/**
 * Method Body
 * 
 * @see Page 172
 */
class testClasse7 {
    public void walk1() { }
    //public void walk2; // DOES NOT COMPILE
    public void walk3(int a) { int name = 5; }
}


/**
 * Working with Varargs
 * @see Page 172
 */
class testClasse8 {
    
    public void walk0(int ...nums) { }
    public void walk1(int... nums) { }
    public void walk2(int start, int... nums) { }
    // public void walk3(int... nums, int start) { } // DOES NOT COMPILE
    // public void walk4(int... start, int... nums) { } // DOES NOT COMPILE
    
    public static void walk(int start, int... nums) {
        
        System.out.println(nums.length);
        
        if (nums.length > 2) 
        System.out.println(nums[1]);
    }
    
    public static void main(String[] args) {
      walk(1); // 0
      walk(1, 2); // 1
      walk(1, 2, 3); // 2
      walk(1, new int[] {4, 5}); // 2
      walk(1, 11, 22, 33); // 22
      walk(1, null); // throws a NullPointerException
      

    }
}

/**
 * Overloading Methods
 * @see Page 191
 */
class testClasse9 {
    
    public void fly(int numMiles) { }
    public void fly(Integer numMiles) { }
    public void fly(short numFeet) { }
    public boolean fly() { return false; }
    void fly(int numMiles, short numFeet) { }
    public void fly(short numFeet, int numMiles) throws Exception { }
    // public int fly(int numMiles) { } // DOES NOT COMPILE
    // public static void fly(int numMiles) { } // DOES NOT COMPILE

    public void fly(int[] lengths) { }
    // public void fly(int... lengths) { } // DOES NOT COMPILE, Java treats varargs as if they were an array. 

}

//@formatter:on