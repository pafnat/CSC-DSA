package com.dsa.module1.fibb;

import java.util.Scanner;
/**
В данной задаче достаточно просто реализовать рассмотренный алгоритм Fib2
(в его псевдокоде на предыдущем степе внимательный слушатель уже заметил опечатку: цикл должен начинаться с i=2).

Задача на программирование. Дано целое число n (1≤n≤40), необходимо вычислить n-е число Фибоначчи.

Sample Input:
3
Sample Output:
2
Memory Limit: 256 MB
Time Limit: 5 seconds



        ⎧
        ⎪ 0, n = 0 ,
Fn =    ⎨ 1, n = 1
        ⎪ Fn−1+Fn−2, n > 1.
        ⎩

0,1,1,2,3,5,8,13,21,34,...

*/

class Main {

    public static void main(String[] args) {

        int n = 0;

        Scanner in = new Scanner(System.in);
        do {
            //System.out.print("Enter int number: 1<=n<=40: ");
            n = in.nextInt();
        } while (n<1 || n>40);

        System.out.println(fib2(n));


    }

    public static int fib2(int arg) {

        if (arg == 1)
            return 1;

        int[] result = new int[arg + 1];
        result[0] = 0;
        result[1] = 1;
        for (int k = 2; k < result.length; k++) {
            result[k] = result[k - 2] + result[k - 1];
        }

        return result[arg];

    }

}
