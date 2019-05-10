package com.work.vladimirs.polygonal_curve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PolygonalCurve {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        List<Point> points = new ArrayList<Point>();
        String[] strings;
        for (int i = 0; i < count; i++) {
            strings = scanner.nextLine().split(" ");
            points.add(
                    new Point(
                            Integer.parseInt(strings[0]),
                            Integer.parseInt(strings[1])));
        }

        Collections.sort(points);
        for (Point point : points) {
            System.out.println(point.toString());
        }
    }
}
