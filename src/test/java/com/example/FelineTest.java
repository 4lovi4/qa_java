package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class FelineTest {

    @Test
    public void shouldReturnEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> actualFood = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

    @Test
    public void shouldGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void shouldReturnKittens() throws Exception {
        Feline feline = new Feline();
        int actualKittensCount = feline.getKittens();
        assertEquals(1, actualKittensCount);
    }

    @Test
    public void shouldGetKittensCount() {
        Feline feline = new Feline();
        int actualKittensCount = feline.getKittens(10);
        assertEquals(10, actualKittensCount);
    }
}