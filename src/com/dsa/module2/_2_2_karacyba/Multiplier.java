package com.dsa.module2._2_2_karacyba;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Задача на программирование повышенной сложности. Реализуйте умножение двух чисел алгоритмом Карацубы.
 * Первые две строки содержат два числа в десятичной записи, по длине не превышающих 50000.
 * Выведите их произведение.
 *
 * Внимание: данную задачу можно сдавать только на c++, java, octave
 * (поскольку в haskell и python есть встроенная длинная арифметика).
 *
 * Сроки сдачи задания:
 *
 * Soft дедлайн 06.10.2014 23:59 MSK
 *
 * Hard дедлайн 13.10.2014 23:59 MSK
 *
 *
 * Sample Input:
 *  239030239030566179
 *   56617956617923930
 *
 * Sample Output:
 *  13533403703804583268316967452763470
 *
 * Memory Limit: 256 MB
 * Time Limit: 5 seconds
 *
 *
 * Алгоритм Карацупы
 * http://nayuki.eigenstate.org/res/karatsuba-multiplication/KaratsubaMultiplication.java
 *
 *
 */
public class Multiplier {

    // Requirement: CUTOFF >= 64, or else there will be infinite recursion.
    private static final int CUTOFF = 50_000;

    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);

        BigInteger x = in.nextBigInteger();
        BigInteger y = in.nextBigInteger();

        long startTime = System.nanoTime();
        //BigInteger result = x.multiply(y);
        BigInteger result = karatsuba(x, y);
        long endTime = System.nanoTime();

        System.out.println("Total execution time: " + (endTime-startTime));

        System.out.println(result);


    }



    /**
     * Returns {@code x * y}, the product of the specified integers. This gives the same result as {@code x.multiply(y)} but should be faster.
     * @param x
     * @param y
     * @return {@code x} times {@code} y
     */
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        if (x.bitLength() <= CUTOFF || y.bitLength() <= CUTOFF) {  // Base case
            return x.multiply(y);

        } else {
            int n = Math.max(x.bitLength(), y.bitLength());
            int half = (n + 32) / 64 * 32;  // Number of bits to use for the low part
            BigInteger mask = BigInteger.ONE.shiftLeft(half).subtract(BigInteger.ONE);
            BigInteger xlow = x.and(mask);
            BigInteger ylow = y.and(mask);
            BigInteger xhigh = x.shiftRight(half);
            BigInteger yhigh = y.shiftRight(half);

            BigInteger a = karatsuba(xhigh, yhigh);
            BigInteger b = karatsuba(xlow.add(xhigh), ylow.add(yhigh));
            BigInteger c = karatsuba(xlow, ylow);
            BigInteger d = b.subtract(a).subtract(c);
            return a.shiftLeft(half).add(d).shiftLeft(half).add(c);
        }
    }



}
