package com.work.vladimirs.other.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String s = bufferedReader.readLine();

                    int result = Result.anagram(s);

                    System.out.print("\n" + result);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }
}
