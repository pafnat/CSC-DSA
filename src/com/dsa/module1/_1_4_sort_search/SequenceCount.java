package com.dsa.module1._1_4_sort_search;

import java.util.NoSuchElementException;
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

        //System.out.print("enter n = ");
        Scanner in = new Scanner(System.in);
        do {
            n = in.nextInt();
        } while ((n<1) || (n>m));

        do {
            try {
                //System.out.print("type input: ");
                s = in.nextLine();
            } catch (NoSuchElementException e) { /* MOP */}
        } while (!checkInput(s, n) && in.hasNextLine());

        // split the line by space " "
        String[] items = s.split(" ");

        // convert String to int[] array
        int[] result = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            try {
                result[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {};
        }

        countSort(result, m);

        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }


    }

    /**
     * Check the input string
     * @param s - string to check
     * @param n - length which should be equals input string length
     * @return
     */
    private static boolean checkInput(String s, int n) {

        boolean flag = false;
        int cnt = 0;

        // split the line by space " "
        String[] items = s.split(" ");

        if (items.length != n) {
            return false;
        }

        // convert String to int[] array
        int[] result = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            try {
                result[i] = Integer.parseInt(items[i]);
                if (result[i]<1 || result[i]>10) {
                    return false;
                }
            } catch (NumberFormatException nfe) {};
        }

        return true;
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
     * @param a - input array
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

        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < b[i]; j++) {
                a[k] = i;
                k = k + 1;
            }
        }


    }
}
