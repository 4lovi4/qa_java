package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class LionAlexTest {

    @Test
    public void shouldReturnFriends() throws Exception {
        LionAlex alexLion = new LionAlex();
        List<String> actualFriends = alexLion.getFriends();
        assertEquals(List.of("зебра Марти", "бегемотиха Глории", "жираф Мелман"), actualFriends);
    }

    @Test
    public void shouldReturnPlaceOfLiving() throws Exception {
        LionAlex alexLion = new LionAlex();
        assertEquals("Нью-Йоркский зоопарк", alexLion.getPlaceOfLiving());
    }

    @Test
    public void shouldReturnNoKittens() throws Exception {
        LionAlex alexLion = new LionAlex();
        assertEquals(0, alexLion.getKittens());
    }

}