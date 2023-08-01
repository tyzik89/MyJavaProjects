package com.work.vladimirs.other.bit_set;

import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");
        int n = Integer.parseInt(num[0]); // Длина векторов B1 И B2
        int m = Integer.parseInt(num[1]); // Количество операций

        BitSet B1 = new BitSet(n);
        BitSet B2 = new BitSet(n);
        System.out.println("B1 = " + toBinaryString(B1) + ", B2 = " + toBinaryString(B2));

        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            BitSet activeBitSet;

            int firstIdx = Integer.parseInt(line[1]); // Над каким BitSet операция
            activeBitSet = firstIdx == 1 ? B1 : B2;

            int secondIdx = Integer.parseInt(line[2]); // Какой бит меняем, или номер второго сета
            switch (line[0].toUpperCase()) {
                case "AND":
                    activeBitSet.and(secondIdx == 1 ? B1 : B2);
                    break;
                case "OR":
                    activeBitSet.or(secondIdx == 1 ? B1 : B2);
                    break;
                case "XOR":
                    activeBitSet.xor(secondIdx == 1 ? B1 : B2);
                    break;
                case "FLIP":
                    activeBitSet.flip(secondIdx);
                    break;
                case "SET":
                    activeBitSet.set(secondIdx, true);
                    break;
                default:
                    System.out.println("Unsupported command");
                    throw new UnsupportedOperationException("Unsupported command");
            }
            System.out.print("B1 = " + toBinaryString(B1) + ", B2 = " + toBinaryString(B2) + ", cardinality = ");
            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }
    }

    /**
     * @param bitSet bitset
     * @return "01010000" binary string
     */
    public static String toBinaryString(BitSet bitSet) {
        if (bitSet == null) {
            return null;
        }
        return IntStream.range(0, bitSet.length())
                .mapToObj(b -> String.valueOf(bitSet.get(b) ? 1 : 0))
                .collect(Collectors.joining());
    }
}
