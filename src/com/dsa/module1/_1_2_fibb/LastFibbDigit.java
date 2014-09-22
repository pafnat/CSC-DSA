package com.dsa.module1._1_2_fibb;

import java.util.Scanner;

/**
 * Задача на программирование. Дано число n (1 ≤ n ≤ 10^7), необходимо найти последнюю цифру n-го числа Фибоначчи.
 *
 * Как мы помним, числа Фибоначчи растут очень быстро, поэтому при их вычислении нужно быть аккуратным с переполнением.
 * В данной задаче, впрочем, этой проблемы можно избежать,поскольку нас интересует только последняя цифра числа
 * Фибоначчи: если 0 ≤ a,b ≤ 9 – последние цифры чисел Fi и Fi+1 соответственно, то (a+b)mod 10 – последняя цифра числа Fi+2.
 * Sample Input:
 * 294590
 * Sample Output:
 * 5
 * Memory Limit: 256 MB
 * Time Limit: 5 seconds
 */
public class LastFibbDigit {
    public static void main(String[] args) {


        int n = 0;

        Scanner in = new Scanner(System.in);
        do {
            //System.out.print("Enter int number: 1<=n<=10^7: ");
            n = in.nextInt();
        } while (n<1 || n>Math.pow(10, 7));

        System.out.println(fib2(n));


    }

    private static int fib2(int arg) {

        if (arg == 1)
            return 1;

        int[] result = new int[arg + 1];
        result[0] = 0 % 10;
        result[1] = 1 % 10;
        for (int k = 2; k < result.length; k++) {
            result[k] = (result[k - 2] + result[k - 1]) % 10;
        }

        return result[arg];

    }
}
