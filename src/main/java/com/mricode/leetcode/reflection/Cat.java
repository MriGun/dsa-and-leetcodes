package com.mricode.leetcode.reflection;

public class Cat {

    private final String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void meow() {
        System.out.println("Meow!!!");
    }

    private void thisIsPrivate() {
        System.out.println("This is private method");
    }

    public static void thisIsPublicStaticMethod() {
        System.out.println("THis is public and static");
    }

    private static void thisIsprivatetaticMethod() {
        System.out.println("THis is private and static");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
