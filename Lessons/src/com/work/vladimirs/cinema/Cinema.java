package com.work.vladimirs.cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Считываем размерность массива NxM
        String[] strSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(strSize[0]);
        int seats = Integer.parseInt(strSize[1]);

        //Создаём массив с заданрой размерностью
        String[] cinema = new String[rows];
        //Бежим по строкам
        for (int j = 0; j < rows; j++) {
            //Считываем очередную строку матрицы, получаем элементы этой строки
            cinema[j] = scanner.nextLine().replaceAll(" ", "");
        }

        //Считываем количество требуемых для поиска мест
        int k = scanner.nextInt();
        //Формируем строку нулей по кол-ву требуемых мест
        StringBuilder strSeats = new StringBuilder();
        for (; k > 0; k--) {
            strSeats.append(0);
        }

        //Бежим по рядам кинотеатра
        for (int j = 0; j < rows; j++) {
            //В каждом ряде проверяем наличие свободныx мест
            if (cinema[j].indexOf(strSeats.toString()) != -1) {
                System.out.println(j+1);
                return;
            }
        }
        System.out.println(0);
    }
}
