package com.mricode.leetcode.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMri {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        Cat myCat = new Cat("Fred", 6);
        System.out.println(myCat.toString());

        Field[] catFields = myCat.getClass().getDeclaredFields();

        for (Field field : catFields) {
            System.out.println("Fields are : "+ field.getName());
            if (field.getName().equals("thisIsprivatetaticMethod")) {
                field.setAccessible(true);
                field.set(myCat, "Ronaldo");
            }
        }

        System.out.println(myCat.toString());


        Method[] vatMethods = myCat.getClass().getDeclaredMethods();

        for (Method method : vatMethods) {
            //System.out.println("method are : "+ method.getName());
            if (method.getName().equals("thisIsPublicStaticMethod")) {
                method.setAccessible(true);
                method.invoke(null);
                myCat.meow();
            }
        }


    }
}
