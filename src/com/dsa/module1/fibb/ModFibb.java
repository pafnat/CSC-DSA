package com.dsa.module1.fibb;

import java.math.BigInteger;
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
 * http://mathoverflow.net/questions/40816/fibonacci-series-mod-a-number
 *
 */
public class ModFibb {

    public static void main(String[] args) {


        //System.out.println("input < long: " + (Math.pow(10, 18) < Math.pow(2, 63)));

/*

        Scanner in = new Scanner(System.in);
        do {
            //System.out.print("Enter int number: 1<=n<=10^18, 2<=m<=10^5: ");
            n = in.nextLong();
            m = in.nextLong();
        } while ((n<1 || n>Math.pow(10, 18)) && (m<2 || m>Math.pow(10, 5)));
*/


        long n = 11527523930876953L;
        long m = 26673L;



        System.out.println(fibMod(n, m).longValue());


    }

    public static Long fibMod(Long arg1, Long arg2) {

        if (arg1.equals(1L))
            return 1L;

        Long[] result = new Long[]{0L % arg2, 1L % arg2};


        for (Long k = 2L; k < result.length; k++) {
            System.out.println("k" + k);
            result[k.intValue()] = (result[k.intValue() - 2] + result[k.intValue() - 1]) % arg2;


        }

        return arg1.longValue()%arg2;


    }

}
