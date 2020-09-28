/**
 * Checks if given <code>value</code> is a power of two.
 *
 * @param value is any number
 * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
 */

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in); //object for reading number from System.in
        System.out.print("Enter a number: ");
        System.out.println ("result: " + isPowerOfTwo(sc.nextInt())); //reading value and call function

    }

    public static boolean isPowerOfTwo(int value) {

        int bitCount = Integer.bitCount(Math.abs(value));
        return bitCount == 1 && Math.abs(value) > 0;
    }
}
