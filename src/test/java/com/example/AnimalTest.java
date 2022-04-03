package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;
import java.util.List;

@RunWith(Enclosed.class)
public  class AnimalTest {

    @RunWith(Parameterized.class)
    public static class AnimalFoodTest {

        private String animalType;
        private List<String> expectedFood;

        public AnimalFoodTest(String animalType, List<String> expectedFood) {
            this.expectedFood = expectedFood;
            this.animalType = animalType;
        }

        @Parameterized.Parameters
        public static Object[][] getAnimalType() {
            return new Object[][] {
                    {"Травоядное", List.of("Трава", "Различные растения")},
                    {"Хищник", List.of("Животные", "Птицы", "Рыба")}
            };
        }

        @Test
        public void shouldGetFood () {
            try {
                Animal animal = new Animal();
                List<String> actualFood = animal.getFood(animalType);
                assertEquals(expectedFood, actualFood);
            }
            catch (Exception e) {
                assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                        e.getMessage());
            }
        }
    }

    public static class AnimalFamilyTest {
        @Test
        public void shouldGetFamily() {
            Animal animal = new Animal();
            assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                    animal.getFamily());
        }
    }
}