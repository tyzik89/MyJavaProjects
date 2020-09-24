package com.work.vladimirs.algorithms;

import java.util.Set;
import java.util.TreeSet;

public final class SetOperations {

    public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> union = new TreeSet<T>(setA);
        union.addAll(setB);
        return union;
    }

    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> intersection = new TreeSet<T>(setA);
        intersection.retainAll(setB);
        return intersection;
    }

    public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
        Set<T> difference = new TreeSet<T>(setA);
        difference.removeAll(setB);
        return difference;
    }

    public static <T> Set<T> symmetricDifference(Set<T> setA, Set<T> setB) {
        Set<T> tmpA;
        Set<T> tmpB;

        tmpA = union(setA, setB);
        tmpB = intersection(setA, setB);
        return difference(tmpA, tmpB);
    }

    public static <T> boolean isSubset(Set<T> setA, Set<T> setB) {
        return setB.containsAll(setA);
    }

    public static <T> boolean isSuperset(Set<T> setA, Set<T> setB) {
        return setA.containsAll(setB);
    }
}
