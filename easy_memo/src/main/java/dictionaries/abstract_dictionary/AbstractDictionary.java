package dictionaries.abstract_dictionary;

import dictionaries.interfaces.Dictionary;

import java.util.Map;

public abstract class AbstractDictionary implements Dictionary {
    private Map<String, String> wordToTranslation;

    public AbstractDictionary(Map<String, String> wordToTranslation) {
        this.wordToTranslation = wordToTranslation;
    }

    public void addNewWord(String word, String translation) {
        wordToTranslation.put(word, translation);
    }

    public void delWord(String word) {
        wordToTranslation.remove(word);
    }

    public void changeWord(String word, String translation) {
        wordToTranslation.put(word, translation);
    }

    public String getTranslation(String word) {
        return wordToTranslation.get(word);
    }

    @Override
    public String toString() {
        return "AbstractDictionary{" +
                "wordToTranslation=" + wordToTranslation +
                '}';
    }
}
