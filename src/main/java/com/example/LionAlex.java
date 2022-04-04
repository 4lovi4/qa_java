package com.example;

import java.util.List;

public class LionAlex extends Lion {
    public LionAlex() throws Exception {
        super("Самец");
    }

    public List<String> getFriends() {
        return List.of("зебра Марти", "бегемотиха Глории", "жираф Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return super.getKittens(0);
    }
}
