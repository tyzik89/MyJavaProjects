package com.work.vladimirs.breadth_first_search;

import java.util.*;

/**
 * Поиск в ширину
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        // Создаём дерево соседей
        Map<String, List<String>> treeOfNamesNeighbors = new HashMap<String, List<String>>() {{
           put("you", new ArrayList<String>(){{
               add("alice");
               add("bob");
               add("claire");
           }});
           put("bob", new ArrayList<String>(){{
               add("anuj");
               add("peggy");
           }});
           put("alice", new ArrayList<String>(){{
               add("peggy");
           }});
           put("claire", new ArrayList<String>(){{
               add("thom");
               add("jonny");
           }});
           put("anuj", new ArrayList<String>());
           put("peggy", new ArrayList<String>());
           put("thom", new ArrayList<String>());
           put("jonny", new ArrayList<String>());
        }};

        // Ищем соседей, начиная с 'you' и потом соседей этих соседей, каждый раз добавляя соседей в конец очереди.
        // Система должна найти имя, заканчивающееся на 'm'
        Deque<String> dequeOfNames = new ArrayDeque<>(treeOfNamesNeighbors.get("you"));
        // Массив проверенных людей, чтобы не проверять дважды и чтобы небыло бесконечного цикла
        // (например сосед peggy -> anuj, а сосед anuj -> peggy)
        List<String> checkedNames = new ArrayList<>();
        while (!dequeOfNames.isEmpty()) {
            System.out.println("Deque now: " + dequeOfNames);
            String person = dequeOfNames.pollFirst();
            if (checkedNames.contains(person)) {
                System.out.println("This person has been already checked: " + person + ". Skip this");
                continue;
            }
            System.out.println("Polled person: " + person);
            if (person != null && person.endsWith("m")) {
                System.out.println("Person's name ended with 'm' is found: " + person);
                break;
            }
            checkedNames.add(person);
            dequeOfNames.addAll(treeOfNamesNeighbors.get(person));
        }
    }
}
