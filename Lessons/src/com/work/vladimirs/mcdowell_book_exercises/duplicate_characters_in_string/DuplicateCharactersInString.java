package com.work.vladimirs.mcdowell_book_exercises.duplicate_characters_in_string;

import java.util.HashMap;
import java.util.Map;

/**
 * Реализуйте алгоритм, определяющий, все ли символы в строке встречаются
 * только один раз. А если при этом запрещено использование дополнительных
 * структур данных? (Битовый вектор)
 */
public class DuplicateCharactersInString {

    public boolean checkStringWithHasMap(String source) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char c : source.toCharArray()) {
            Integer count = characterIntegerMap.computeIfAbsent(c, k -> 0);
            count += 1;
            characterIntegerMap.put(c, count);
            if (count > 1) {
                System.out.println(characterIntegerMap);
                return true;
            }
        }
        System.out.println(characterIntegerMap);
        return false;
    }

    public boolean checkStringWithBitsVector(String source) {
        int checker = 0;
        for (char c : source.toCharArray()) {
            int val = c - 'a';   // Вычисляем индекс бита, соответствующего текущей букве
            System.out.printf("%d it's bit index corresponding to the character %s\n", val, c);
            // Смещаемся на кол-во битов символа делая сдвиг влево 1 << val (т.е. умножая на степень 2, т.е. включаем один бит)
            // 1 << 0 = 1 * 1 = 2 (1 в двоичном виде);
            // 1 << 1 = 1 * 2 = 2 (10);
            // 1 << 2 = 1 * 4 = 4 (100);
            // 1 << 3 = 1 * 8 = 8 (1000)
            // вычислив & (побитовое И) определяем, включен ли выбранный бит, т.е. 1 И 0 = 0, а 1 И 1 = 1
            if((checker & (1 << val)) > 0) {
                return true;
            } else {
                // Если найдена новая буква, то надо включить правильный бит в checker.
                // Делаем побитовое | ( ИЛИ ), т.е. 0 ИЛИ 1 = 1
                checker |= (1 << val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String source = "aabcdfghj";
        DuplicateCharactersInString checker = new DuplicateCharactersInString();
        System.out.println(checker.checkStringWithHasMap(source));
        System.out.println(checker.checkStringWithBitsVector(source));
    }
}
