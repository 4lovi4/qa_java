package com.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    /*
    Мок для класса Feline, объект которого инжектится через сеттер метод класса Lion.
    А от класса Lion наследуется LionAlex.
    */
    @Mock
    Feline feline;

    @Test
    public void shouldReturnFriends() throws Exception {
        LionAlex alexLion = new LionAlex();
        alexLion.setFeline(feline);
        List<String> actualFriends = alexLion.getFriends();
        assertEquals(List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман"), actualFriends);
    }

    @Test
    public void shouldReturnPlaceOfLiving() throws Exception {
        LionAlex alexLion = new LionAlex();
        alexLion.setFeline(feline);
        assertEquals("Нью-Йоркский зоопарк", alexLion.getPlaceOfLiving());
    }

    @Test
    public void shouldReturnNoKittens() throws Exception {
        LionAlex alexLion = new LionAlex();
        alexLion.setFeline(feline);
        // Здесь делаю заглушку для метода getKittens(int kittensCount) класса Feline
        Mockito.when(feline.getKittens(0)).thenReturn(0);
        assertEquals(0, alexLion.getKittens());
    }

}