package com.dsa.module1._1_4_sort_search;


import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * В первой строке даны целое число n (1≤n≤100000) и массив A[1…n] из n различных натуральных чисел,
 * не превышающих 109, в порядке возрастания, во второй – целое число k (1≤k≤100000) и
 * k натуральных чисел b1,…,bk, не превышающих 109.
 * Для каждого i от 1 до k необходимо вывести индекс 1≤j≤n, для которого A[j]=bi, или −1, если такого j нет.
 *
 * Sample Input:
 * 5 1 5 8 12 13
 * 5 8 1 23 1 11
 *
 * Sample Output:
 * 3 1 -1 1 -1
 *
 * Бинарный поиск в массиве
 *
 */
public class BinarySearchCount {

    public static void main(String[] args) {

        String s1 = "";
        String s2 = "";

        int[] rs1 = null;
        int[] rs2 = null;

        Scanner in = new Scanner(System.in);

        // Read First input line
        do {
            try {
                //System.out.print(" Enter the first sequence: ");
                s1 = in.nextLine();
            } catch (NoSuchElementException e) { /* NOP */ }
        } while (!checkInput(s1));

        // Read Second input line
        do {
            try {
                //System.out.print(" Enter the second sequence: ");
                s2 = in.nextLine();
            } catch (NoSuchElementException e) { /* NOP */ }
        } while (!checkInput(s2));

/*
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
*/

        rs1 = new int[s1.split(" ").length - 1];
        strToArray(s1, rs1);

        rs2 = new int[s2.split(" ").length - 1];
        strToArray(s2, rs2);

/*
        System.out.println("rs1 = " + Arrays.toString(rs1));
        System.out.println("rs2 = " + Arrays.toString(rs2));
*/


        // BinarySearchCount.
        // Searching the index of rs2 element in rs1 array

/*        System.out.println("RESULTS");*/
        int pos = 0;
        for (int i = 0; i < rs2.length; i++) {
            // Instead of using Arrays.binarySearch(rs1, rs2[i]),
            // we will make own method for binary search
            //Arrays.binarySearch(rs1, rs2[i]);
            pos = binarySearch(rs1, rs2[i]);
            if (pos >= 0) {
                System.out.print(++pos + " ");
            } else {
                System.out.print("-1 ");
            }
        }





    }

    private static boolean checkInput(String str) {

        boolean flag = false;
        String[] items = str.split(" ");

        // check if the first num equals to the count of following numbers.
        // if not, return false
        try {
            if ((items.length - 1) != Integer.parseInt(items[0])) {
                return false;
            }
        } catch (NumberFormatException nfe) { /* NOP */ }

        return true;
    }

    private static void strToArray(String str, int[] result) {
        // split the line by space " "
        String[] items = str.split(" ");
        // convert String to int[] array

        int[] tmp = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            try {

                tmp[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {};
        }

        // use arraycopy method to populate source array
        System.arraycopy(tmp, 1, result, 0, tmp.length-1);

    }

    private static int binarySearch(int[] a, int k) {

        int l = 0;
        int r = a.length-1;

        while (l <= r) {
            //int m = (l + r) >>> 2;
            // для того, чтобы избежать переполнение следует делать так
            // http://googleresearch.blogspot.ru/2006/06/extra-extra-read-all-about-it-nearly.html
            int m = l + (r - l) / 2;
            if (a[m]==k) {
                return m;
            } else if (a[m]>k) {
                r = m - 1;
            } else if (a[m]<k) {
                l = m + 1;
            }
        }

        return -1;
    }

}
