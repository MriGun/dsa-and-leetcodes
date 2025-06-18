package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    int adjMatrix[][];

    List<List<Integer>> adjList;

    Graph(int nodes) {
        adjMatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // --> [[0,2], [0,4], [0,5]]
    public void addEdgesInMatrix(int edges[][], boolean isDirected) {
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            //directed graph
            if (isDirected) {
                adjMatrix[u][v] = 1;
            }
            else {
                //directed graph
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }


        }
    }


    public void addEdgesWithWeightInMatrix(int edges[][], boolean isDirected) {
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            //directed graph
            if (isDirected) {
                adjMatrix[u][v] = w;
            }
            else {
                //directed graph
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }


        }
    }

    public void addEdgesInList(int edges[][], boolean isDirected) {
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            //directed graph
            if (isDirected) {
                adjList.get(u).add(v);
            }
            else {
                //directed graph
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }


        }
    }

    public  void printMatrix() {
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.print("row " + i + "->");
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    public void printList() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            System.out.print("[");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + ",");
            }
            System.out.print("]");
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int edges[][] = {{0,2}, {0,1}, {1,3}};
        int nodes = 4;
        Graph graph = new Graph(nodes);
        graph.addEdgesInMatrix(edges, false);
        graph.printMatrix();

        System.out.println("Directed Graph -->");

        Graph directedGraph = new Graph(nodes);
        directedGraph.addEdgesInMatrix(edges, true);
        directedGraph.printMatrix();


        int edgesAndWeight[][] = {{0,2, 10}, {0,1, 20}, {1,3, 30}};
        System.out.println("Weighted UnDirected Graph -->");
        Graph weightedUnDirectedGraph = new Graph(nodes);
        weightedUnDirectedGraph.addEdgesWithWeightInMatrix(edgesAndWeight, false);
        weightedUnDirectedGraph.printMatrix();

        System.out.println("Weighted Directed Graph -->");

        Graph weightedDirectedGraph = new Graph(nodes);
        weightedDirectedGraph.addEdgesWithWeightInMatrix(edgesAndWeight, true);
        weightedDirectedGraph.printMatrix();


        System.out.println("UnDirected Graph List-->");
        Graph graphList = new Graph(nodes);
        graphList.addEdgesInList(edges, false);
        graphList.printList();

        System.out.println("Directed Graph List-->");

        Graph directedGraphList = new Graph(nodes);
        directedGraphList.addEdgesInList(edges, true);
        directedGraphList.printList();
    }

}
