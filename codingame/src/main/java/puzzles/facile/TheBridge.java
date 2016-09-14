package puzzles.facile;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input according to the problem statement.
 **/
public class TheBridge {

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int road = in.nextInt(); // the length of the road road the gap.
	int gap = in.nextInt(); // the length of the gap.
	int platform = in.nextInt(); // the length of the landing platform.

	// game loop
	while (true) {
	    int speed = in.nextInt(); // the motorbike's speed.
	    int coordX = in.nextInt(); // the position on the road of the motorbike.

	    // Write an action using System.out.println()

	    // To debug:
	    System.err.println("CoordX : " + coordX);
	    System.err.println("gap : " + gap);
	    System.err.println("Next Motor Position = coordX + speed 1 = " + (coordX + speed));
	    System.err.println("road : " + (road - 1));

	    // if the bike isn't going fast enough to jump over the gap
	    if ((coordX >= road + gap) || (speed > gap + 1))
		System.out.println("SLOW");
	    // if the bike is going slower than needed : speed
	    else if (speed <= gap)
		System.out.println("SPEED");
	    // if the bike can land platform the gap : jump
	    else if (coordX + speed >= road + gap)
		System.out.println("JUMP");
	    else
		System.out.println("WAIT");

	}
    }
}
