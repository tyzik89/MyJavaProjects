package com.work.vladimirs.mcdowell_book_exercises.duplicate_characters_in_string;

/**
 * Реализуйте алгоритм, определяющий, все ли символы в строке встречаются
 * только один раз. А если при этом запрещено использование дополнительных
 * структур данных?
 */
public class DuplicateCharactersInString {

    public boolean checkString(String source) {

        return false;
    }

    public static void main(String[] args) {
        String source = "abcd";
        DuplicateCharactersInString checker = new DuplicateCharactersInString();
        System.out.println(checker.checkString(source));
    }
}
