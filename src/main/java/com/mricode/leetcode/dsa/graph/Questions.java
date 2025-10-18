package com.mricode.leetcode.dsa.graph;

import java.util.*;

public class Questions {

    //https://leetcode.com/problems/word-ladder/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();

            for (int i = 0; i <currentLevelSize; i++) {
                String node = queue.poll();
                if (node.equals(endWord)) {
                    return level + 1;
                }
                List<String> neighbours = getNeighbours(node, set);

                for (String neighbour : neighbours) {
                    if (set.contains(neighbour)) {
                        queue.offer(neighbour);
                        set.remove(neighbour);
                    }
                }

            }
            level++;

        }

        return 0;

    }

    private List<String> getNeighbours(String word, HashSet<String> set) {

        List<String> neighbours = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            for (char ch='a'; ch<='z'; ch++) {
                if (ch == word.charAt(i)) {
                   continue;
                }
                String newWord = word.substring(0, i) + ch + word.substring(i+1, word.length());
                if (set.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }
        }

        return neighbours;

    }

    //https://leetcode.com/problems/word-ladder-ii/description/
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        List<List<String>>  resultList = new ArrayList<>();


        if (!set.contains(endWord)) {
            return resultList;
        }

        List<String> dummy = new ArrayList<>();
        dummy.add(beginWord);

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(dummy);

        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        int level = 0;
        int resultLevel = -1;

        while (!queue.isEmpty()) {
            HashSet<String> usedWords = new HashSet<>();
            int currentLevelSize = queue.size();

            for (int i = 0; i <currentLevelSize; i++) {
                List<String> nodeList = queue.poll();
                String node = nodeList.get(nodeList.size()-1);
                if (node.equals(endWord)) {
                    resultLevel = level;
                    resultList.add(nodeList);
                }
                List<String> neighbours = getNeighbours(node, set);

                for (String neighbour : neighbours) {
                    if (set.contains(neighbour)) {
                        nodeList.add(neighbour);
                        queue.offer(new ArrayList<>(nodeList));
                        nodeList.remove(neighbour);
                        usedWords.add(neighbour);
                    }
                }

            }
            for (String visited : usedWords) {
                set.remove(visited);
            }

            if (level == resultLevel) {
                break;
            }
            level++;

        }
        return resultList;
    }

    //https://leetcode.com/problems/evaluate-division/
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);

            if (!map.containsKey(dividend)) {
                map.put(dividend, new HashMap<>());
            }

            if (!map.containsKey(divisor)) {
                map.put(divisor, new HashMap<>());
            }

            double value = values[i];

            map.get(dividend).put(divisor, value);
            map.get(divisor).put(dividend, 1/value);
        }

        double result[] = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List query = queries.get(i);
            if (!map.containsKey(query.get(0)) || !map.containsKey(query.get(1)) ) {
                result[i] = -1.0;
            } else if (query.get(0).equals(query.get(1))) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = calcEquationDfs(query.get(0).toString(), query.get(1).toString(), 1, visited, map);
            }

        }
        return result;
    }

    private double calcEquationDfs(String source, String target, double prod, Set<String> visited, Map<String, Map<String, Double>> map) {

        double result = -1.0;
        visited.add(source);

        if (map.get(source).containsKey(target)) {
            result = map.get(source).get(target);
        }
        else {
            for (String neighbour : map.get(source).keySet()) {
                if (!visited.contains(neighbour)) {
                    //prod = prod * map.get(source).get(neighbour);
                    result = calcEquationDfs(neighbour, target, prod * map.get(source).get(neighbour), visited, map);
                    if (result != -1) {
                        break;
                    }
                    //prod = prod / map.get(source).get(neighbour);
                }
            }
        }

        visited.remove(source);

        return result;
    }

    //https://leetcode.com/problems/get-watched-videos-by-your-friends/description/

    class Pair implements Comparable<Pair>{
        String video;
        int frequency;

        Pair(String video, int frequency) {
             this.video = video;
             this.frequency = frequency;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.frequency == that.frequency) {
                return this.video.compareTo(that.video);
            }
            return this.frequency - that.frequency;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(id);
        visited.add(id);

        int curLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            //iterate level by level
            for (int i = 0; i < size; i++) {
                int curId = queue.poll();
                for (int friend : friends[curId]) {
                    if (!visited.contains(friend)) {
                        visited.add(friend);
                        queue.offer(friend);
                    }
                }
            }

            curLevel++;
            if (curLevel == level) {
                break;
            }
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            for (String video : watchedVideos.get(curId)) {
                frequencyMap.put(video, frequencyMap.getOrDefault(video, 0) + 1);
            }
        }

        List<Pair> videoList = new ArrayList<>();
        for (String video : frequencyMap.keySet()) {
            videoList.add(new Pair(video, frequencyMap.get(video)));
        }

        Collections.sort(videoList);
        List<String> result = new ArrayList<>();
        for (Pair pair : videoList) {
            result.add(pair.video);
        }

        return result;
    }

    //https://leetcode.com/problems/rotting-oranges/description/
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();;
        int freshCount = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                 if (grid[i][j] == 2) {
                     queue.offer(new int[] {i,j});
                 }
                 else if (grid[i][j] == 1) {
                     freshCount++;
                 }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] rottenLoc = queue.poll();
                int row = rottenLoc[0];
                int col = rottenLoc[1];

                int neighbours[][] = {{row-1, col},{row, col+1}, {row+1, col}, {row, col-1}};

                for (int neighbour[] : neighbours) {

                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    //out of bound check
                    if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
                        continue;
                    }

                    //already rotten or empty check
                    if (grid[nr][nc] == 0 || grid[nr][nc] == 2) {
                        continue;
                    }

                    queue.offer(new int[] {nr, nc});
                    grid[nr][nc] = 2;

                    freshCount--;

                    if (freshCount == 0) {
                        return time+1;
                    }

                }

            }
            time++;
            /*if (freshCount == 0) {
                break;
            }*/

        }

        return  -1;

    }


    //https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        //adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        return dfsOfminTime(0, -1, adjList, hasApple);
    }

    private int dfsOfminTime(int src, int parent, List<List<Integer>> adjList, List<Boolean> hasApple) {
        int totalTime=0;

        for (int neighbour : adjList.get(src)) {
            if (neighbour == parent) {
                continue;
            }
            int timeTakenByChild = dfsOfminTime(neighbour, src, adjList, hasApple);

            if (timeTakenByChild > 0 || hasApple.get(neighbour)) {
                totalTime = totalTime + timeTakenByChild + 2;
            }
        }

        return totalTime;
    }

}
