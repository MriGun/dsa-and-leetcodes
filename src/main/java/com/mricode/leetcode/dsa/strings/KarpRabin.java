package com.mricode.leetcode.dsa.strings;

public class KarpRabin {

    private final int PRIME = 101;

    private double calculateHashOfString(String str) {
        double hash = 0;

        for (int i =0; i < str.length(); i++) {
            hash = hash + str.charAt(i) * Math.pow(PRIME, i);
        }

        return hash;
    }

    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
        double newHsh = (prevHash - oldChar) / PRIME;
        newHsh = newHsh + newChar * Math.pow(PRIME, patternLength -1);
        return newHsh;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        double patternHash = calculateHashOfString(pattern);
        double textHash = calculateHashOfString(text.substring(0, patternLength));

        for (int i = 0; i <= text.length() - patternLength; i++) {
           if (textHash == patternHash) {
               if (text.substring(i, i+patternLength).equals(pattern)) {
                   System.out.println("Pattern found at string " + i);
               }
           }

           if (i < text.length() - patternLength) {
               textHash = updateHash(textHash, text.charAt(i), text.charAt(i+ patternLength), patternLength);
           }
        }
    }

    public static void main(String[] args) {
        KarpRabin algo = new KarpRabin();
        algo.search("ArupOviMrinmoy",  "Ovi");
    }
}
