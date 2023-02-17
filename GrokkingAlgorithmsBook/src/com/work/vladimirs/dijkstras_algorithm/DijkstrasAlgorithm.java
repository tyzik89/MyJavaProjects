package com.work.vladimirs.dijkstras_algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Алгоритм Дейкстры (работает только с направленными ациклическими графами)
 * 1) Найти узел с наименьшей стоимостью (т.е. узел, до которого можно добраться за минимальное время)
 * 2) Проверить, существует ли более дешевый путь к соседям этого узла, и если существует, обновить их стоимости
 * 3) Повторять, пока это не будет сделано для всех узлов графа
 * 4) Вычислить итоговый путь
 *
 * Алгоритм не работает с рёбрами отрицательного веса!
 * (Для отрицательного веса есть алгоритм Беллмана-Форда)
 */
public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        // Создаём граф
        Map<String, Map<String, Integer>> graph = new HashMap<String, Map<String, Integer>>() {{
            put("start", new HashMap<String, Integer>(){{
                put("A", 6);
                put("B", 2);
            }});
            put("A", new HashMap<String, Integer>(){{
                put("End", 1);
            }});
            put("B", new HashMap<String, Integer>(){{
                put("A", 3);
                put("End", 5);
            }});
            put("End", new HashMap<String, Integer>());
        }};

        // Таблица стоимостей
        Map<String, Integer> costsMap = new HashMap<>();
        costsMap.put("A", 6);
        costsMap.put("B", 2);
        costsMap.put("End", null);

        // Таблица родителей
        Map<String, String> parentsMap = new HashMap<>();
        parentsMap.put("A", "Start");
        parentsMap.put("B", "Start");
        parentsMap.put("End", "");

        // Отслеживание уже обработанных узлов
        List<String> checkedNode = new ArrayList<>();


    }
}
