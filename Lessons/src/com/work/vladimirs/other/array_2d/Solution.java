package com.work.vladimirs.other.array_2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();

        System.out.println(getHourglassLargestSum(arr));
    }

    private static int getHourglassLargestSum(List<List<Integer>> arr) {
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = 0; j < arr.get(i).size() - 2; j++) {
                int a = arr.get(i).get(j);
                int b = arr.get(i).get(j + 1);
                int c = arr.get(i).get(j + 2);

                int d = arr.get(i + 1).get(j + 1);

                int e = arr.get(i + 2).get(j);
                int f = arr.get(i + 2).get(j + 1);
                int g = arr.get(i + 2).get(j + 2);

               sum = Math.max(sum, a + b + c + d + e + f + g);
            }
        }
        return sum;
    }
}