package com.company;

import java.util.Collection;

public class Randomer {

    public static boolean randomFillInteger(Collection<Integer> collection, long number) {
        if (number < 0) {
            return false;
        }
        for (int i = 0; i < number; i++) {
            collection.add((int)(Math.random() * 10000));
        }
        return true;
    }

    public static boolean randomFillDouble(MyTree<Double> collection, long number) {
        if (number < 0) {
            return false;
        }
        for (int i = 0; i < number; i++) {
            collection.add(Math.random());
        }
        return true;
    }

    public static boolean randomFillString(Collection<String> collection, long number) {
        if (number < 0) {
            return false;
        }
        for (int i = 0; i < number; i++) {
            collection.add(Integer.toString(i));
        }
        return true;
    }
}