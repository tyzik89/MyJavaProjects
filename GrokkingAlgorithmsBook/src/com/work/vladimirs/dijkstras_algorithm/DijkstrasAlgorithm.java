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
        parentsMap.put("End", null);

        // Отслеживание уже обработанных узлов
        List<String> checkedNode = new ArrayList<>();

        // найти узел с наименьшей стоимостью, среди необработанных
        String node = findLowestCostNode(costsMap, checkedNode);
        // Пока обработаны не все узлы
        while (node != null) {
            Integer cost = costsMap.get(node);
            Map<String, Integer> neighbors = graph.get(node);
            // Перебираем всех соседей текущего узла
            for (String neighborNode : neighbors.keySet()) {
                Integer newCost = cost + neighbors.get(neighborNode);
                // Если предыдущая стоимость была не вычесленной, обновляем его новым значением
                costsMap.putIfAbsent(neighborNode, newCost);
                // тоже самое с родителем
                parentsMap.putIfAbsent(neighborNode, node);
                // Если к соседу можно быстрее добраться через текущий узел
                if (costsMap.get(neighborNode) > newCost) {
                    // обновить стоимость этого узла
                    costsMap.put(neighborNode, newCost);
                    // узел становится новым родителем для соседа
                    parentsMap.put(neighborNode, node);
                }
            }
            // Узел помечается как обработанный
            checkedNode.add(node);
            // Найти следующий узел для обработки и повторить цикл
            node = findLowestCostNode(costsMap, checkedNode);
        }

        // Вывод результата. Собираем цепочку с конца
        List<String> nodeChain = new ArrayList<>();
        String nextNode = "End";
        for (int i = 0; i < parentsMap.size(); i++) {
            nodeChain.add(nextNode);
            nextNode = parentsMap.get(nextNode);
        }
        System.out.print("Start--");
        for (int i = nodeChain.size() - 1; i >= 0; i--) {
            String n = nodeChain.get(i);
            System.out.print(costsMap.get(n) + "-->");
            System.out.print(n);
            if (!n.equals("End")) {
                System.out.print("--");
            }
        }
    }

    private static String findLowestCostNode(Map<String, Integer> costsMap, List<String> checkedNode) {
        Integer lowestCost = null;
        String lowestCostNode = null;
        for (String node : costsMap.keySet()) {
            Integer cost = costsMap.get(node);
            // При встрече обработанного узла или узла с непосчитанной стоимостью, пропускаем
            if (checkedNode.contains(node) || cost == null) {
                continue;
            }
            // Если этот узел с наименьшей стоимостью из уже увиденных
            if (lowestCost == null || cost < lowestCost) {
                // он назначается новым узлом с наименьшей стоимостью
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }
}
