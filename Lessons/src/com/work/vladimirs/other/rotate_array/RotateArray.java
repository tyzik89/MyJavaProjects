package com.work.vladimirs.other.rotate_array;

import java.util.Scanner;

public class RotateArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Считываем размерность массива NxM
        String[] strSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(strSize[0]);
        int cols = Integer.parseInt(strSize[1]);

        //Создаём массив с заданрой размерностью
        int[][] array = new int[rows][cols];
        //Бежим по строкам
        for (int j = 0; j < rows; j++) {
            //Считываем очередную строку матрицы, получаем элементы этой тсроки
            String[] col = scanner.nextLine().split(" ");
            //Бежим по колонкам
            for (int i = 0; i < cols; i++){
                //В каждую ячейку записываем элемент считанной строки
                //Кол-во элементов считанной строки равно кол-ву столбцов матрицы
                array[j][i] = Integer.parseInt(col[i]);
            }
        }

        //Создаём результирующий с заданной размерностью
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - i - 1] = array[i][j];
            }
        }

        //Вывод массива
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
