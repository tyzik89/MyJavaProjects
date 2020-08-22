package com.work.vladimirs.sortings;

abstract class AbstractSort {
    int[] sortArray;

    abstract int[] doSorting();

    protected void swap(int i, int j) {
        int temp = sortArray[i];
        sortArray[i] = sortArray[j];
        sortArray[j] = temp;
    }

}
