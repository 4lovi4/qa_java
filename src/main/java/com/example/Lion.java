package com.example;

import java.util.List;

/*
Инъекция зависимостей через setter метод, чтобы изолировать класс Lion от Feline
 */
public class Lion {

    private Feline feline;
    boolean hasMane;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public void setFeline(Feline feline) {
        this.feline = feline;
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public int getKittens(int kittensCount) {
        return feline.getKittens(kittensCount);
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}

