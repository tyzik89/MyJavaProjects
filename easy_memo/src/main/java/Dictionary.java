import java.util.*;

public class Dictionary {
    HashMap<String, String> buffer;

    public Dictionary() {
        this.buffer = new HashMap<String, String>();
    }

    /**
     * Добавить новое слово
     * @param word новое слово
     * @param translate перевод
     */
    public void putWord(String word, String translate) {
        buffer.put(word, translate);
    }

    /**
     * Получить перевод слова
     * @param word слово
     * @return перевод заданного слова
     */
    public String getTranslate(String word) {
        return buffer.get(word);
    }

    /**
     * Получение случайного перевода слова из словаря
     * @return random value from dictionary
     */
    public String getRandomTranslation() {
        //Получам список всех ключей из словаря
        List<String> keys = new ArrayList<String>(buffer.keySet());
        //Получаем случайное слово из списка
        String randomKey = keys.get(new Random().nextInt(keys.size()));
        //Возвращаем случайный перевод из словаря
        return buffer.get(randomKey);
    }

    /**
     * Получение случайного слова из словаря
     * @return random key from dictionary
     */
    public String getRandomWord() {
        //Получам список всех ключей из словаря
        List<String> keys = new ArrayList<String>(buffer.keySet());
        //Получаем случайное слово из списка
        return keys.get(new Random().nextInt(keys.size()));
    }
}
