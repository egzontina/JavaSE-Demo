package puzzles.easy;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * <pre>
 * Binary with 0 and 1 is good, but binary with only 0, or almost, is even better! 
 * Originally, this is a concept designed by Chuck Norris to send so called unary messages.
 * 
 * Here is the encoding principle:
 * -The input message consists of ASCII characters (7-bit)
 * -The encoded output message consists of blocks of 0
 * -A block is separated from another block by a space
 * -Two consecutive blocks are used to produce a series of same value bits (only 1s or 0s):
 *      -First block: it is always 0 or 00. If it is 0, then the series contains 1s, if not, it contains 0s
 *      -Second block: the number of 0s in this block is the number of bits in the series
 * 
 * Write a program that takes an incoming message as input and displays as output the message encoded 
 * using Chuck Norris’ method.
 * 
 * INPUT:
 * Line 1: the message consisting of N ASCII characters (without carriage return)
 * 
 * OUTPUT:
 * The encoded message
 * 
 * CONSTRAINTS :
 * 0 < N < 100
 * </pre>
 **/
class ChuckNorris {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();

        // Converts the message into its binary code, char by char
        // (without forgetting 0s in the beginning like toBinaryString does)
        StringBuilder binaryMsg = new StringBuilder(""); // sequence of bit
        for (char c : message.toCharArray()) {
            String binChar = Integer.toBinaryString(c); // convert character to its binary ascii code (7 bits)
            while (binChar.length() < 7)
                binChar = "0" + binChar;
            binaryMsg.append(binChar);
        }

        // split binnary between every group of same characters
        String regex = "(?<=(.))(?!\\1)";
        String[] binaryBlocArr = binaryMsg.toString().split(regex);

        // Build the code like chuck norris encoding
        StringJoiner answerJoiner = new StringJoiner(" ");
        for (String c : binaryBlocArr) {
            String temp = new String(new char[c.length()]).replace('\0', '0');
            if (c.startsWith("1")) {
                answerJoiner.add("0 " + temp);
            } else {
                answerJoiner.add("00 " + temp);
            }
        }

        // output
        System.out.println(answerJoiner);

        // Debug
        // System.err.println("Message in input String : " + message);
        // System.err.println("Message in binary String:" + binaryMsg.toString());
        // System.err.println("Message in same binary bloc:" + Arrays.toString(binaryBlocArr));

        // Close Scanner
        in.close();
    }

    /**
     * Other Published Solution - Best Upvoted
     * 
     * @author Malick
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        char[] MESSAGE = in.nextLine().toCharArray();

        boolean pbit = (MESSAGE[0] & 0x40) != 0;
        System.out.print(pbit ? "0 " : "00 ");

        for (char B : MESSAGE) {
            for (char bm = 0x40; bm != 0; bm >>= 1) {
                boolean bit = (B & bm) != 0;
                System.out.print((bit == pbit) ? "0" : (bit ? " 0 0" : " 00 0"));
                pbit = bit;
            }
        }
        // Close Scanner
        in.close();
    }

}
