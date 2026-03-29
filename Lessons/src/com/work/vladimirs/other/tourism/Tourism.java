package com.work.vladimirs.other.tourism;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tourism {

    /**
     * Алгоритм префиксной суммы
     * Метод префиксных сумм — это техника, которая позволяет мгновенно (за O(1)) находить сумму чисел на любом отрезке массива.
     * Вместо того чтобы каждый раз запускать цикл для подсчета суммы между индексами L и R,
     * мы один раз готовим специальный вспомогательный массив pref.
     * Каждое число в новом массиве pref — это сумма всех предыдущих чисел из оригинала.
     *  pref[0] = 0 (обычно добавляют ноль в начало для удобства).
     *  pref[i+1] = pref[i] + arr[i];
     * Считаем сумму на отрезке: Чтобы найти сумму элементов с L по R, нужно просто вычесть один префикс из другого:
     *  Sum(L:R) = pref[R] - pref[L];
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        int numC = Integer.parseInt(reader.readLine());
        List<Coordinate> coordinates = new ArrayList<>(numC);
        for (int i = 0; i < numC; i++) {
            String[] sc = reader.readLine().trim().split(" ");
            Coordinate coordinate = new Coordinate(
                    Long.parseLong(sc[0]),
                    Long.parseLong(sc[1]));
            coordinates.add(coordinate);
        }

        int numR = Integer.parseInt(reader.readLine());
        List<Route> routes = new ArrayList<>(numR);
        for (int i = 0; i < numR; i++) {
            String[] sr = reader.readLine().trim().split(" ");
            Route route = new Route(
                    Integer.parseInt(sr[0]),
                    Integer.parseInt(sr[1]));
            routes.add(route);
        }

        long[] prefUp = new long[numC];
        long[] prefDown = new long[numC];
        for (int i = 1; i < numC; i++) {
            long y = coordinates.get(i).y;
            long y1 = coordinates.get(i - 1).y;

            long diff = y - y1;
            prefUp[i] = prefUp[i - 1] + (diff > 0 ? diff : 0);

            diff = y1 - y;
            prefDown[i] = prefDown[i - 1] + (diff > 0 ? diff : 0);
        }

        for (Route route : routes) {
            long result = 0;
            int startPoint = route.startPoint - 1;
            int endPoint = route.endPoint - 1;
            if (startPoint == endPoint) {
                writer.write(result + "\n");
                continue;
            }
            if (startPoint < endPoint) {
                result = prefUp[endPoint] - prefUp[startPoint];
                writer.write(result + "\n");
            } else {
                result = prefDown[startPoint] - prefDown[endPoint];
                writer.write(result + "\n");
            }
        }

        reader.close();
        writer.close();
    }

    private static class Coordinate {

        private final long x;
        private final long y;

        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }
    }

    private static class Route {

        private final int startPoint;
        private final int endPoint;

        public Route(int startPoint, int endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        public int getStartPoint() {
            return startPoint;
        }

        public int getEndPoint() {
            return endPoint;
        }
    }
}
