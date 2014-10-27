package com.dsa.module2._3_count;

import java.util.*;

/**
 * Задача на программирование. Дано натуральное число 1≤n≤105 и массив целых чисел A[1…n], не превосходящих по модулю 109.
 * Необходимо вывести 1, если в массиве A есть число, встречающееся строго больше n/2 раз, и 0 в противном случае.
 *
 * Sample Input:
 * 5
 * 2 3 9 2 2
 * Sample Output:
 * 1
 *
 */
public class NumCounter {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = 0;
        String s = "";
        do {
            try {
                //System.out.println("type input: ");
                n = in.nextInt();
            } catch (NoSuchElementException e) { /* MOP */}
        } while (in.hasNextLine() && (n<1 || n>Math.pow(10, 9)));

        //System.out.println(" n = " + n);

        int[] a = new int[n];

        in = new Scanner(System.in);
        String str = "";
        // Read First input line
        do {
            try {
                //System.out.print(" Enter the first sequence: ");
                str = in.nextLine();
            } catch (NoSuchElementException e) { /* NOP */ }
        } while (!checkInput(str, n));

        strToArray(str, a);

        //System.out.println(Arrays.toString(a));

        if (checkArr(a)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }


    }

    private static boolean checkArr(int[] a) {

        int p = a.length / 2;


        Map<Integer, Integer> map = new HashMap<Integer, Integer>();


        for (int key : a) {
            //System.out.println(k);
            if (map.containsKey(key)) {
                int val = map.get(key);
                map.put(key, ++val);
            } else {
                map.put(key, 1);
            }
        }


        Arrays.toString(a);

        for (int k : a) {
            if (map.get(k) > p) {
                return true;
            }
         }


        return false;
    }

    private static boolean checkInput(String str, int n) {

        boolean flag = false;
        String[] items = str.split(" ");

        try {
            if (items.length !=n) {
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
        System.arraycopy(tmp, 0, result, 0, tmp.length);

    }

}
