package com.work;

public class TriangleCalculator {

    private int countVertices;

    public TriangleCalculator(int countVertices) {
        this.countVertices = countVertices;
    }

    /**
     * Вычисление количества треугольников в графе
     *
     * @param graph
     * @return
     */
    public int triangleInGraph(int graph[][], boolean isDirected)
    {
        int countTriangle = 0;

        // Рассмотрение каждой возможной тройки отрезков в графе
        for (int i = 0; i < countVertices; i++)
        {
            for (int j = 0; j < countVertices; j++)
            {
                for (int k = 0; k < countVertices; k++)
                {
                    // Если тройка отрезков удовлетворяет условиям
                    if (graph[i][j] == 1
                            && graph[j][k] == 1
                            && graph[k][i] == 1)
                        countTriangle++;
                }
            }
        }

        // Если граф ориентированный, делим результат на 3, иначе делим на 6, т.к. треугольник строится "туда/обратно"
        if(isDirected == true)
        {
            countTriangle /= 3;
        }
        else
        {
            countTriangle /= 6;
        }
        return countTriangle;
    }

}
