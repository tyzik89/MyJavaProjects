

import java.util.Arrays;

/**
 * Алгоритм сортировка вставками (Верхняя оценка работы O(n*n), т.к. два цикла и в худшем случае мы пересмотрим массив из
 * n-элементов дважды)
 */
class InsertionSort extends AbstractSort {

    public InsertionSort(int[] unsortArray) {
        this.sortArray = Arrays.copyOf(unsortArray, unsortArray.length);
    }

    @Override
    int[] doSorting() {
        // Начинаем рассматривать массив со второго элемента
        for (int i = 1; i <= sortArray.length - 1; i++) {
            // Индекс предыдущего элемента
            int j = i - 1;
            //Пока Не дошли до начала уже отсортированного куска, сравниваем предыдущий и текущий элемент
            while (j >= 0 && (sortArray[j] > sortArray[j + 1])) {
                // Меняем местами, если текущий элемент меньше пердыдущего, в итоге текущий меньший элемент движется в начало массива
                swap(j, j + 1);
                j--;
            }
        }
        return sortArray;
    }

}
