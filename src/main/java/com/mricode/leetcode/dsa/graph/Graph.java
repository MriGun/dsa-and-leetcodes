package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {


    class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            node = n;
            weight = w;
        }

        @Override
        public String toString() {
            return "(" + node +  ","+ weight + ')';
        }
    }

    int adjMatrix[][];

    List<List<Integer>> adjList;
    List<List<Pair>> adjListWithWeight;

    Graph(int nodes) {
        adjMatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        adjListWithWeight = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
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

    public void addEdgesWithWeightInList(int edges[][], boolean isDirected) {
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            //directed graph
            if (isDirected) {
                Pair pair = new Pair(v, w);
                adjListWithWeight.get(u).add(pair);
            }
            else {
                //directed graph
                Pair pair1 = new Pair(v, w);
                Pair pair2 = new Pair(u, w);
                adjListWithWeight.get(u).add(pair1);
                adjListWithWeight.get(v).add(pair2);
            }


        }
    }

    public void findDegreeInUndirectedGraph(int edges[][], int nodes) {

        int degree[] = new int[nodes];
        for (int edge[]  :edges) {
            int u = edge[0];
            int v = edge[1];

            degree[u]++;
            degree[v]++;
        }

        for (int i = 0; i < nodes; i++) {
            System.out.println("node -> " + i + " degree -> " + degree[i]);
        }
    }

    public void findDegreeDirectedGraph(int edges[][], int nodes) {

        int inDegree[] = new int[nodes];
        int outDegree[] = new int[nodes];
        for (int edge[]  :edges) {
            int from = edge[0];
            int to = edge[1];

            inDegree[to]++;
            outDegree[from]++;
        }

        for (int i = 0; i < nodes; i++) {
            System.out.print("node -> " + i + " indegree -> " + inDegree[i] + " - ");
            System.out.print("node -> " + i + " outdegree -> " + outDegree[i] + " - ");
            System.out.println();
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
                System.out.print(adjList.get(i).get(j));
                if (j != adjList.get(i).size() -1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();

        }
    }

    public void printWeightedList() {
        for (int i = 0; i < adjListWithWeight.size(); i++) {
            System.out.print(i + " -> ");
            System.out.print("[");
            for (int j = 0; j < adjListWithWeight.get(i).size(); j++) {
                System.out.print(adjListWithWeight.get(i).get(j));
                if (j != adjListWithWeight.get(i).size() -1) {
                    System.out.print(",");
                }
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

        graph.findDegreeInUndirectedGraph(edges, nodes);
        graph.findDegreeDirectedGraph(edges, nodes);

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

        System.out.println();

        System.out.println("UnDirected Graph List-->");
        Graph graphListWithWeight = new Graph(nodes);
        graphListWithWeight.addEdgesWithWeightInList(edgesAndWeight, false);
        graphListWithWeight.printWeightedList();

        System.out.println("Directed Graph List-->");

        Graph directedGraphListWithWeight = new Graph(nodes);
        directedGraphListWithWeight.addEdgesWithWeightInList(edgesAndWeight, true);
        directedGraphListWithWeight.printWeightedList();
    }

}
