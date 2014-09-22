package com.dsa.module1._1_2_fibb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Задача на программирование повышенной сложности. Даны целые числа n и m (1≤n≤10^18, 2≤m≤10^5),
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * Sample Input:
 * 11527523930876953 26673
 * Sample Output:
 * 10552
 * Memory Limit: 256 MB
 * Time Limit: 5 seconds
 *
 * http://stackoverflow.com/questions/20300537/nth-fibonacci-number-in-dynamic-programming
 *
 */
public class ModFibb {

    public static void main(String[] args) {


        //System.out.println("input < long: " + (Math.pow(10, 18) < Math.pow(2, 63)));
        
        long n, mod;


        Scanner in = new Scanner(System.in);
        do {
            //System.out.print("Enter int number: 1<=n<=10^18, 2<=mod<=10^5: ");
            n = in.nextLong();
            mod = in.nextLong();
        } while ((n<1 || n>Math.pow(10, 18)) && (mod<2 || mod>Math.pow(10, 5)));



        long[][] T = new long[2][2];
        long[][] res = new long[2][2];
        long[][] cur = new long[2][2];
        long m = mod;

        T[0][0] = T[0][1] = T[1][0] = 1;  //  T = (1 1
        T[1][1] = 0;                      //       1 0)

        // res = identity matrix  (the same as T^0)
        res[0][0] = res[1][1] = 1;
        res[0][1] = res[1][0] = 0;

        
        long pow = n-1;
        ArrayList<Long> bits = new ArrayList<>();

        // Get pow in binary and store it in bits
        while (pow > 0) {
            bits.add(pow % 2);
            pow = pow / 2;
        }

        // now we have the bits in reversed o
        Collections.reverse(bits);

        // Calculate T^(n-1) with
        // exponentation by squaring - O(log n)
        for (int i=0; i < bits.size(); ++i) {
            for (int r=0; r < 2; ++r)
                for (int c=0; c < 2; ++c)
                    cur[r][c] = 0;

            for (int x=0; x < 2; ++x) // matrix multiplication res * res
                for (int y=0; y < 2; ++y)
                    for (int z=0; z < 2; ++z) {
                        cur[x][y] += res[x][z] * res[z][y];
                        if (cur[x][y] >= m)
                            cur[x][y] %= m;
                    }

            for (int r=0; r < 2; ++r)
                for (int c=0; c < 2; ++c)
                    res[r][c] = cur[r][c];

            if (bits.get(i) == 1) {
                for (int r=0; r < 2; ++r)
                    for (int c=0; c < 2; ++c)
                        cur[r][c] = 0;

                for (int x=0; x < 2; ++x) // matrix multiplication res * T
                    for (int y=0; y < 2; ++y)
                        for (int z=0; z < 2; ++z) {
                            cur[x][y] += res[x][z] * T[z][y];
                            if (cur[x][y] >= m)
                                cur[x][y] %= m;
                        }

                for (int r=0; r < 2; ++r)
                    for (int c=0; c < 2; ++c)
                        res[r][c] = cur[r][c];
            }
        }

        long fibn = res[0][0]; // our vector is (fib1 = 1, fib0 = 0)
        // so we would have (matrix multiplication)
        // fibn = res[0][0]*fib1 + res[0][1]*fib0 =
        System.out.println(fibn);     //      = res[0][0]



    }




}
