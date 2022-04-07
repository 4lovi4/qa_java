package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;


import java.util.List;

public class FelineTest {

    Feline feline;

    @Before
    public void initFeline() {
        feline = new Feline();
    }

    @Test
    public void shouldReturnEatMeat() throws Exception {
        List<String> actualFood = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

    @Test
    public void shouldGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void shouldReturnKittens() throws Exception {
        int actualKittensCount = feline.getKittens();
        assertEquals(1, actualKittensCount);
    }

    @Test
    public void shouldGetKittensCount() {
        int actualKittensCount = feline.getKittens(10);
        assertEquals(10, actualKittensCount);
    }
}