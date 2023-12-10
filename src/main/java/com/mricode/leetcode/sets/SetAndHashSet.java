package com.mricode.leetcode.sets;

import java.util.*;

public class SetAndHashSet {
    public static void main(String[] args) {

        Set<String> names = new LinkedHashSet<>();
        names.add("Sherlock");
        names.add("Feluda");
        names.add("Kakababu");
        names.add("Mrinmoy");


        for (String name : names) {
            System.out.println("name : " + name);
        }

        names.forEach( name -> System.out.println("name , : " + name));

        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
        }

        //Removing duplicate from list
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(2);
        numberList.add(3);
        System.out.println(numberList);

        Set<Integer> numberSet = new HashSet<>();
        numberSet.addAll(numberList);
        System.out.println(numberSet);

        //Clear all the fields
        names.clear();
        names.remove("Mrinmoy");

        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.contains("Kakababu"));
        System.out.println(names.contains("Kakababu2"));
        System.out.println(names.isEmpty());
    }
}
