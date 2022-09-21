package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    public IngredientTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;

    }
    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getType() {
        return new Object[][] {
             {SAUCE},
             {FILLING}
     };
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "hot sauce", 100f);
        float expected = 100f;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0f);
    }
    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "cutlet", 100f);
        String expected = "cutlet";
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "sour cream", 200f);
        String expected = String.valueOf(ingredientType);
        String actual = String.valueOf(ingredient.getType());
        assertEquals(expected, actual);
    }
}
