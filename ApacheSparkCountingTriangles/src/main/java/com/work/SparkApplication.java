package com.work;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;
import org.apache.spark.storage.StorageLevel;

import java.util.Arrays;
import java.util.List;

/**
 * ЗАДАНИЕ: По данному файлу содержащему список ребер (неориентированного) графа написать Spark-приложение, считающее в этом графе количество треугольников.
 * Файл состоит из строк, каждая содержит два числа - вершины соответствующего ребра. Файл graph.txt прилагается.
 * Для этого вам надо, например, создать RDD из файла, потом преобразовать его в список пар при помощи map, затем несколькими операциями join выделить в нем треугольники и возвратить результат при помощи действия count. Для ускорения работы промежуточное RDD со списком ребер можно закешировать операцией cashe.
 * Скачать Spark можно здесь, рекомендуется скачивать собранную версию со встроенным хадупом, т.к. ее можно с ходу запускать. Инструкции по написанию и запуску приложений на Spark здесь. С моей точки зрения, легче всего реализовывать на питоне т.к. можно не компилировать, а просто отправлять .py файл на выполнение. Для java надо сначала скомпилировать в jar, а потом уже запускать jar. Файл с графом Spark может брать прямо из (запущенного) Hadoop-кластера, для это файл надо указывать по его сетевому имени в Hadoop, например так
 * val file = sc.textFile("hdfs://localhost:9000/mr_test/input/anonymous-msweb.data").
 */
public class SparkApplication {

    /**
     * 1. Построение SparkConf объекта, содержащего информацию о нашем приложении
     * 2. Построение объекта JavaSparkContext, для доступа Spark к кластеру
     *    В setMaster("URL") указать URL: это Spark, Mesos или YARN cluster URL
     *    Например: local - Run Spark locally with one worker thread (i.e. no parallelism at all).
     *    см. http://spark.apache.org/docs/latest/submitting-applications.html#master-urls
     */
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("Counting Triangles").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Читаем текстовый файл с диска и преобразуем данные в RDD (Resilient Distributed Datasets)
        JavaRDD<String> distFile = sc.textFile("src\\main\\resources\\data.txt");

        JavaRDD<String[]> listEdgesRDD = distFile
                .map(s -> s.split(" "))
                .cache();

        //Для повторного использования объекта listEdgesRDD
        listEdgesRDD.persist(StorageLevel.MEMORY_ONLY());

        List<String[]> listEdges = listEdgesRDD.collect();
        System.out.println("Count of edges: " + listEdges.size());

        long countVertices = listEdges.stream().flatMap(Arrays::stream).distinct().count();
        System.out.println("Count Vertex: " + countVertices);

        // Матрица смежности для неориентированного графа
        AdjMatrixOfGraph adjMatrixOfGraph = new AdjMatrixOfGraph((int)countVertices);

//        // Если вершины начинаются с 1, то добавляем тут '- 1' чтобы не выйти за границы массива
//        listEdgesRDD.foreach(
//                strings -> adjMatrixOfGraph.addEdge(Integer.parseInt(strings[0]) - 1, Integer.parseInt(strings[1]) - 1)
//        );

        // Традиционный способ
        for (String[] listEdge : listEdges) {
            // Если вершины начинаются с 1, то добавляем тут '- 1' чтобы не выйти за границы массива
            adjMatrixOfGraph.addEdge(Integer.parseInt(listEdge[0]) - 1, Integer.parseInt(listEdge[1]) - 1);
        }
        System.out.println(adjMatrixOfGraph.toString());

        TriangleCalculator triangleCalculator = new TriangleCalculator((int)countVertices);
        System.out.println("Count of triangle: " + triangleCalculator.triangleInGraph(adjMatrixOfGraph.getAdjMatrix(), false));
    }

}
