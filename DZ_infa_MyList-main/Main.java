package com.company;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(25);
        list.add(5);
        list.add(20);
        list.add(21);
        list.add(34);
        list.add(55);
        System.out.println(list.toString());
//        list.swap(2, 4);
//        System.out.println(list.toString());
        list.sort();
        System.out.println(list.toString());
    }
}
