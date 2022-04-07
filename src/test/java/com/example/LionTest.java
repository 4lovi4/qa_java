package com.example;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;
import java.util.List;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;

// В тесте используются и параметризированные тесты и простые, поэтому использую аннотацию @RunWith Enclosed
@RunWith(Enclosed.class)
public class LionTest {

    @RunWith(Parameterized.class)
    public static class LionTestParameterizedGender {

        @Rule public MockitoRule rule = MockitoJUnit.rule();
        @Mock Feline feline;

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
                lion.setFeline(feline);
                boolean actualHasMane = lion.doesHaveMane();
                assertEquals(expectedMane, actualHasMane);
            } catch (Exception e) {
                assertEquals("Используйте допустимые значения пола животного - самец или самка",
                        e.getMessage());
            }
        }
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class LionTestKittensAndFood {

        @Mock
        Feline feline;

        @Test
        public void shouldReturnKittensWithoutCount() throws Exception {
            Lion lion = new Lion("Самец");
            lion.setFeline(feline);
            Mockito.when(feline.getKittens()).thenReturn(1);
            int actualKittensCount = lion.getKittens();
            assertEquals(1, actualKittensCount);
        }

        @Test
        public void shouldReturnFood() throws Exception {
            Lion lion = new Lion("Самка");
            lion.setFeline(feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String> actualFood = lion.getFood();
            assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
        }
    }
}