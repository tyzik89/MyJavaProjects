package com.work.vladimirs.other.dequeue;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeTest {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        long maxUniqNum = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            if (deque.size() == m) {
//                int currentSize = new HashSet<>(deque).size();
                long currentSize = deque.stream().distinct().count();
                maxUniqNum = Math.max(currentSize, maxUniqNum);
                deque.removeFirst();
            }
        }

        System.out.println(maxUniqNum);
    }
}
