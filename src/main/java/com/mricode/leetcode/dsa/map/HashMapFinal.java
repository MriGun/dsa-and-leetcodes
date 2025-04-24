package com.mricode.leetcode.dsa.map;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapFinal <K, V>{

    ArrayList<LinkedList<Entity>> list;


    private class Entity {
        String key;
        String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
