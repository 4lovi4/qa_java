package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;
import java.util.List;

@RunWith(Enclosed.class)
public class LionTest {

    @RunWith(Parameterized.class)
    public static class LionTestParameterizedGender {

        private String gender;
        private final boolean expectedMane;

        public LionTestParameterizedGender(String gender, boolean expectedMane) {
            this.gender = gender;
            this.expectedMane = expectedMane;
        }

        @Parameterized.Parameters
        public static Object[][] getLionGenders() {
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false},
                    {"Нечто", false}
            };
        }

        @Test
        public void shouldReturnHaveMane() throws Exception {
            try {
                Lion lion = new Lion(gender);
                boolean actualHasMane = lion.doesHaveMane();
                assertEquals(expectedMane, actualHasMane);
            } catch (Exception e) {
                assertEquals("Используйте допустимые значения пола животного - самец или самка",
                        e.getMessage());
            }
        }
    }

    public static class LionTestKittensAndFood {
        @Test
        public void shouldReturnKittensWithoutCount() throws Exception {
            Lion lion = new Lion("Самец");
            int actualKittensCount = lion.getKittens();
            assertEquals(1, actualKittensCount);
        }

        @Test
        public void shouldReturnFood() throws Exception {
            Lion lion = new Lion("Самка");
            List<String> actualFood = lion.getFood();
            assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
        }
    }
}