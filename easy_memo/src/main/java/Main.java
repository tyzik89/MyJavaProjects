import java.util.*;

public class Main {

    public static void main(String[] args) {
        Dictionary dictEnRu = new Dictionary();
        dictEnRu.putWord("Dog", "Собака");
        dictEnRu.putWord("Cat", "Кошка");

        Timer timer = new Timer();
        TimersSets timersSets = new TimersSets();
        Task task = new Task(dictEnRu);

        timer.schedule(task, 100, timersSets.getNotLater());
    }
}
