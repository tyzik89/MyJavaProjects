package com.work.vladimirs.mkad;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MKAD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        scanner.nextLine();
        int t = scanner.nextInt();

        System.out.println(evaluateDistance(v, t));
    }

    protected static int evaluateDistance (int v, int t) {
        //Путь, пройденный Васей
        int s = Math.abs(v * t);

        //Генерируем массив километровых отметок МКАДА
        int[] mkadMarks = IntStream.range(0, 110).toArray();

        int result = 0;
        if (v > 0) {
            for (int i = 0, k = 0; i < s; i++, k++) {
                if (k >= mkadMarks.length - 1) k = 0;
                result = k + 1;
            }
        } else if (v < 0) {
            for (int i = 0, k = 0; i < s; i++, k++) {
                if (k >= mkadMarks.length - 1) k = 0;
                result = 109 - k - 1;
            }
        }


        return result;

        /*if (v > 0) {
            return s - (s / 109) * 109;
        } else if (v < 0){
            int temp = 109 - (s - (s / 109) * 109);
            return  temp >= 109 ? 109 : temp + 1;
        } else {
            return 0;
        }*/


    }
}
