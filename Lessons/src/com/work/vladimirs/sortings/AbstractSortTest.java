

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractSortTest {
    private static int[] unsortArray;
    private static int[] sortArray;

    @BeforeAll
    static void initialize() {
        unsortArray = new int[] {5, 2, 4, 6, 1, 3, 8, 7, 10, 9};
        sortArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @DisplayName("Сортировка вставками")
    @Test
    void doInsertionSort() {
        AbstractSort sort = new InsertionSort(unsortArray);
        int[] result = sort.doSorting();
        Assertions.assertArrayEquals(sortArray, result);
    }
}