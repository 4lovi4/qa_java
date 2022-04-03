package com.example;

import java.util.List;

/*
Наследуем Lion от Feline, чтобы изолировать класс
 */
public class Lion extends Feline{

    boolean hasMane;

    public Lion(String sex) throws Exception {
        super();
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return super.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return getFood("Хищник");
    }
}
