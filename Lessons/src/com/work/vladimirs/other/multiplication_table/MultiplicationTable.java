package com.work.vladimirs.other.multiplication_table;

import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Считываем 4-ре числа
        int a = scanner.nextInt();
        scanner.nextLine();
        int b = scanner.nextInt();
        scanner.nextLine();
        int c = scanner.nextInt();
        scanner.nextLine();
        int d = scanner.nextInt();

        for (int k = c; k <= d; k++ )
            System.out.printf("\t%d", k);
        System.out.println();

        for (int i = a; i <= b; i++) {
            System.out.printf("%d\t", i);
            for(int j = c; j <= d; j++) {
                System.out.printf("%d\t", i*j);
            }
            System.out.println();
        }
    }
}
