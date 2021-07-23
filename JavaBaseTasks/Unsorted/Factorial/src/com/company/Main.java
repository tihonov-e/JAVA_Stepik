/**
 * Function solves factorial N
 * @Autor Tikhonov Eugene
 * 22/09/2020
 */
package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
	int N = 3;
	System.out.println("Factorial(" + N + ")" + " = " + factorial(N));
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        if (value == 1) return BigInteger.valueOf(1);
        BigInteger bigValue = BigInteger.valueOf(value);
        return bigValue.multiply(factorial(value - 1));
    }

}
