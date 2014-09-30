package com.dsa.module1._1_4_sort_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Первая строка содержит число n (1≤n≤10000), вторая – n натуральных чисел, не превышающих 10.
 * Необходимо вывести упорядоченную по неубыванию последовательность этих чисел
 * (числа должны быть разделены пробелами).
 * Sample Input:
 * 5
 * 2 3 9 2 9
 * Sample Output:
 * 2 2 3 9 9
 *
 * Сортировка подсчетом
 *
 */
public class SequenceCount {
    public static void main(String[] args) {

        int m = 10000;
        int n = 0;
        String s = "";

        Scanner in = new Scanner(System.in);
        do {
            System.out.print("enter n = ");
            n = in.nextInt();
        } while ((n<1) || (n>m));

        in = new Scanner(System.in);
        while (s.split(" ").length != n) {
            System.out.print("type your sequence = ");
            s = in.nextLine();
        }

        System.out.println("seq = " + s);


        // convert String to int[] array
        int[] result = new int[s.split(" ").length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(s.split(" ")[i]);
        }

        countSort(result, m);

        //System.out.println(Arrays.toString(result));
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }






    }


    /**
     * Сортировка подсчетом
     * 1 фаза, время работы O(m)
     * 2 фаза, время работы O(n)
     * 3 фаза, время работы O(n)
     * Результирующее время алгоритма сортировки подсчетов O(n+m)
     *
     * 2 1 1 1 3 2 2 2 3 2 3 2 2 1 1
     *          |
     *          V
     *        5 7 3
     *          |
     *          V
     * 1 1 1 1 1 2 2 2 2 2 2 2 3 3 3
     *
     *
     * @param a[] - input array
     * @param m - new array size
     */
    private static void countSort(int[] a, int m) {

        int[] b = new int[m];


        for (int i = 0; i < m; i++) {
            b[i] = 0;
        }

        for (int j = 0; j < a.length; j++) {
            b[a[j]] = b[a[j]] + 1;
        }

        System.out.println("b = " + Arrays.toString(b));

        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < b[i]; j++) {
                a[k] = i;
                k = k + 1;
            }

        }



    }
}
