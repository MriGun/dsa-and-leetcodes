package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;

public class DisjointSet {

    int parent[];

    int rank[];

    int size[];

    int components;

    DisjointSet(int nodes) { // 0 based (5) 0 to 4
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.size = new int[nodes];
        this.components = nodes;

        for (int i = 0; i < nodes; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
            this.size[i] = 1;
        }
    }

    //path compression
    public int findRootParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }

    public void unionByRank(int node1, int node2) {
        //1. find the root parent

        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if (rootParent1 == rootParent2) {
            return;
        }

        components--;

        //2. union of components
        if (rank[rootParent1] < rank[rootParent2]) {
           parent[rootParent1] = rootParent2;
        }
        else if (rank[rootParent2] < rank[rootParent1]) {
            parent[rootParent2] = rootParent1;
        }
        else {
            parent[rootParent2] = rootParent1;
            rank[rootParent1]++;
        }

    }


    public void unionBySize (int node1, int node2) {
        //1. find the root parent

        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if (rootParent1 == rootParent2) {
            return;
        }

        components--;

        //2. union of components
        //smaller will be added to the bigger one

        if (size[rootParent1] < size[rootParent2]) {
            parent[rootParent1] = rootParent2;
            size[rootParent2] += parent[rootParent1];
        }
        else {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }

    }

    public static void main(String[] args) {
        /*DisjointSet dsu = new DisjointSet(4);
        System.out.println("total components ==> " + dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
        dsu.unionByRank(0, 3);

        System.out.println("total components ==> " + dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));*/

        DisjointSet dsu = new DisjointSet(4);
        System.out.println("total components ==> " + dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
        dsu.unionBySize(0, 3);

        System.out.println("total components ==> " + dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
    }


    //https://leetcode.com/problems/redundant-connection/description/

    int totalNoddes;
    public int[] findRedundantConnection(int[][] edges) {
        totalNoddes = edges.length;
        int res[] = new int[2];
        DisjointSet disjointSet = new DisjointSet(totalNoddes);
        for (int [] edge : edges) {
            if (!disjointSet.unionBySize2(edge[0] -1, edge[1] - 1)) {
                res = edge;
            }
        }
        return res;
    }

    public boolean unionBySize2 (int node1, int node2) {
        //1. find the root parent

        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if (rootParent1 == rootParent2) {
            return false;
        }

        components--;

        //2. union of components
        //smaller will be added to the bigger one

        if (size[rootParent1] < size[rootParent2]) {
            parent[rootParent1] = rootParent2;
            size[rootParent2] += parent[rootParent1];
        }
        else {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }

        return true;

    }


    //https://leetcode.com/problems/satisfiability-of-equality-equations/description/
    public boolean equationsPossible(String[] equations) {

        DisjointSet dsu = new DisjointSet(26);

        ArrayList<int[]> notEqualEdges = new ArrayList<>();

        for (String equation : equations) {
            int u = equation.charAt(0) - 'a';
            int v = equation.charAt(3) - 'a';

            //construct graphs using "equal to" equations
            if (equation.charAt(1) == '=') {
                dsu.unionBySize(u, v);
            }
            else {
                //store. not equal equations
                notEqualEdges.add(new int[]{u, v});
            }
        }

        for (int edge[] : notEqualEdges) {
            int u = edge[0];
            int v = edge[1];
            if (dsu.findRootParent(u) == dsu.findRootParent(v)) {
                return false;
            }
        }

        return true;

    }

}
