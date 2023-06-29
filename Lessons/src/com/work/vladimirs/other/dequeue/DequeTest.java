package com.work.vladimirs.other.dequeue;

import java.io.IOException;
import java.util.*;

public class DequeTest {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        long maxUniqNum = 0;
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            integerSet.add(num);
            if (deque.size() == m) {
//                int currentSize = new HashSet<>(deque).size(); // too slow
//                long currentSize = deque.stream().distinct().count(); // too slow
                maxUniqNum = Math.max(integerSet.size(), maxUniqNum);
                Integer removedElem = deque.removeFirst();
                if (!deque.contains(removedElem)) {
                    integerSet.remove(removedElem);
                }
            }
        }

        System.out.println(maxUniqNum);
    }
}
