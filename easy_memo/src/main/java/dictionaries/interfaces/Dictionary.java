package dictionaries.interfaces;

public interface Dictionary {

    void addNewWord(String word, String translation);

    void delWord(String word);

    void changeWord(String word, String translation);

    String getTranslation(String word);
}
