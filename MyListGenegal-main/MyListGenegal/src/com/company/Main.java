
package com.company;

public class Main {

    public static void main(String[] args) {

        MyListGeneral<Integer> list = new MyListGeneral<>((a, b) -> {
            if((int)a.getValue() - (int)b.getValue() > 0)
                return 1;
            else if ((int)a.getValue() - (int)b.getValue() < 0)
                return -1;
            else
                return 0;
        });
        list.addL(61);
        list.addL(2);
        list.addL(3);
        list.addL(31);
        System.out.println(list.toString());
        list.sort();
        System.out.println(list.toString());
    }
}
