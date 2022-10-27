package com.work.vladimirs.mcdowell_book_exercises.symbol_permutations;

import java.util.ArrayList;
import java.util.List;


/**
 * Разработать алгоритм для вывода всех возможных перестановок символов в строке (для
 * простоты считайте, что все символы встречаются только один раз).
 */
public class SymbolPermutations {

    public List<String> getAllPermutation(String source) {
        List<String> result = new ArrayList<>(); // Результирующй массив, обновляется на каждой итерации
        result.add(String.valueOf(source.charAt(0))); // Вставляем первый символ сразу

        for (int i = 1; i < source.length(); i++) { // Начинаем идти по строке со второго символа
            char symbol = source.charAt(i); // Получаем очередной символ из строки
            List<String> temp = new ArrayList<>(); // Временный массив для хранения результатов конкотенации на данной итерации
            for (int j = 0; j < result.size(); j++) { // Берём предыдущие результаты итерации и бежим по каждой собранный строке
                String anotherStr = result.get(j); // Берём очередной, собранный на предыдущей итерации, результат
                for (int k = 0; k <= anotherStr.length(); k++) { // В этом цикле бежим посимвольно
                    StringBuilder sb = new StringBuilder(anotherStr); // добавляем целиком строку в результат
                    sb.insert(k, symbol); // вставляем символ в очереную позицию
                    temp.add(sb.toString()); // Сохраняем результат во временный массив
                }
            }
            result = temp; // Сохраняем все результаты временного массива в результирующий
        }
        return result; // Последняя итерация это и есть конечный результат
    }

    public static void main(String[] args) {
        String source = "abcd";
        SymbolPermutations permutations = new SymbolPermutations();
        System.out.println(permutations.getAllPermutation(source));
    }
}
