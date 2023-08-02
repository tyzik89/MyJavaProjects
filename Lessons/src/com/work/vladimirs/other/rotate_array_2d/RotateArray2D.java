package com.work.vladimirs.other.rotate_array_2d;

import java.util.Scanner;

public class RotateArray2D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Считываем размерность массива NxM
        String[] strSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(strSize[0]);
        int cols = Integer.parseInt(strSize[1]);

        //Создаём массив с заданрой размерностью
        int[][] matrix = new int[rows][cols];
        //Бежим по строкам
        for (int j = 0; j < rows; j++) {
            //Считываем очередную строку матрицы, получаем элементы этой тсроки
            String[] col = scanner.nextLine().split(" ");
            //Бежим по колонкам
            for (int i = 0; i < cols; i++){
                //В каждую ячейку записываем элемент считанной строки
                //Кол-во элементов считанной строки равно кол-ву столбцов матрицы
                matrix[j][i] = Integer.parseInt(col[i]);
            }
        }
        print(matrix);
        rotate(matrix);
        print(matrix);
    }

    private static void rotate(int[][] matrix) {
        // Транспонируем матрицу
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("Transposed matrix");
        print(matrix);
        // Меняем столбцы матрицы местами - первый столбец на последнее место, а последний столбец на первое и т.д.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }
    }

    private static void print(int[][] matrix) {
        //Вывод массива
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
