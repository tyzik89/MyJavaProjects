import java.util.HashMap;
import java.util.Scanner;
import java.util.TimerTask;

public class Task extends TimerTask {
    private Dictionary dictionary;

    public Task(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public void run() {
        String word = dictionary.getRandomWord();
        System.out.println(word);
        Scanner in = new Scanner(System.in);
        if (in.nextLine().equals(dictionary.getTranslate(word))) {
            System.out.println("Верно!");
        } else {
            System.out.println("Ошибка!");
        }
    }
}
