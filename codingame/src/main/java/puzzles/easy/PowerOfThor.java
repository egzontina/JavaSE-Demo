package puzzles.easy;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input according to the problem statement. --- Hint:
 * You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 * 
 * @see https://www.codingame.com/ide/523252159d1d009f37b455c6341932d1c363ca8
 **/
class PowwerOfThor {

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int lightX = in.nextInt(); // the X position of the light of power
	int lightY = in.nextInt(); // the Y position of the light of power
	int initialTX = in.nextInt(); // Thor's starting X position
	int initialTY = in.nextInt(); // Thor's starting Y position

	// game loop
	while (true) {
	    int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

	    // Write an action using System.out.println()
	    // To debug: System.err.println("Debug messages...");

	    // TODO  use new varaible : 
	    int directionX = lightX -  initialTX;
	    int directionY = lightY -  initialTY;
	    
	    String directionToMove = ""; // the move to be made
	    System.err.println("Thor position = " + initialTY + " - Light position = " + initialTY);
	    // angle facile
	    if (directionY > 0) {
		if (directionX > 0) {
		    directionToMove = "SE";
		    initialTX++;
		    initialTY++;
		} else if (directionX < 0) {
		    directionToMove = "SW";
		    initialTX--;
		    initialTY++;
		} else {
		    directionToMove = "S"; // ligne droite
		    initialTY++;
		}
	    } else if (directionY < 0) {
		if (directionX > 0) {
		    directionToMove = "NE";
		    initialTX++;
		    initialTY--;
		} else if (directionX < 0) {
		    directionToMove = "NW";
		    initialTX--;
		    initialTY--;
		} else {
		    directionToMove = "N"; // ligne droite
		    initialTY--;
		}
	    } // Haut
	    else {
		if (lightX > initialTX) {
		    directionToMove = "E";
		    initialTX++;
		} else {
		    directionToMove = "W";
		    initialTX--;
		}
	    }

	    // A single line providing the move to be made: N NE E SE S SW W or NW
	    System.out.println(directionToMove);
	}
    }
}