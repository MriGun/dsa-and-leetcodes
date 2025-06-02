package com.mricode.leetcode.dsa.tree.advancequestions;

import java.util.*;

public class WordLadder {

    //https://leetcode.com/problems/word-ladder/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        //Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        int length = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return length +1;
                }

                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();
                    for (char ch = 'a'; ch <= 'z' ; ch++) {
                        temp[j] = ch;
                        String newWord = new String(temp);
                        if (newWord.equals(endWord)) {
                            return length +1;
                        }

                        if (wordSet.contains(newWord) ) {

                            queue.offer(newWord);
                            wordSet.remove(current);

                        }

                    }
                }
            }
        }
        return 0;
    }
}
