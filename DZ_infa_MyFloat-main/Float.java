package com.company;

public class Float {
    private long mantisa;
    int exponet;

    //если man = 123, exp = 0 => num = 0,123
    //если man = 1234, exp = 1 => num = 1,234
    //если man = 1234, exp = -1 => num = 0,01234
    //если man = 1234, exp = 4 => num = 1234,0
    Float() {
        this.exponet = 0;
        this.mantisa = 0;
    }

    Float(long mantisa, int exp) {
        this.exponet = exp;
        this.mantisa = mantisa;
    }

    void sum(Float b) {
        int resulExp = (this.exponet > b.getExponet() ? this.exponet : b.getExponet());
        long resultLow = (long)(this.mantisa % Math.pow(10, Long.toString(this.mantisa).length() - this.exponet));
        long resultBig = (long)(b.getMantisa() % Math.pow(10, Long.toString(this.mantisa).length() - this.exponet));
        System.out.println(resulExp);
        System.out.println(resultLow);
        System.out.println(resultBig);


    }

    public long getMantisa() {
        return mantisa;
    }

    public int getExponet() {
        return exponet;
    }
}


