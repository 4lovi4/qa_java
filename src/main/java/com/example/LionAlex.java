package com.example;

import java.util.List;

public class LionAlex extends Lion {
    public LionAlex(String sex) throws Exception {
        super(sex);
    }

    public List<String> getFriends() {
        return List.of("зебра Марти", "бегемотиха Глории", "жираф Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}
