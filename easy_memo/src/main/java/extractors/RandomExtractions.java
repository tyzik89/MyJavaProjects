package extractors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomExtractions {
    private static Random random = new Random();
    private Map<String, String> dictionary;

    public RandomExtractions(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Получение случайного слова из словаря
     * @return random key from dictionary
     */
    public String getRandomWord() {
        //Получам список всех ключей из словаря
        List<String> keys = new ArrayList<String>(dictionary.keySet());
        //Получаем случайное слово из списка
        String randomKey = keys.get(random.nextInt(keys.size()));
        //Возвращаем случайное слово из словаря
        return dictionary.get(randomKey);
    }
}
