package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    private List<Ingredient> ingredients = new ArrayList<>();
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void getPriceOfBurgerTest() {
        burger.bun = bun;
        burger.ingredients = ingredients;
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        ingredients.add(ingredient);
        float expected = 100f + 100f * 2;
        assertEquals(expected, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptOfBurgerTest() {
        burger.bun = bun;
        burger.ingredients = ingredients;
        StringBuilder receipt = new StringBuilder();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");

        ingredients.add(ingredient);
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));

        receipt.append(String.format("(==== %s ====)%n",bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expected = receipt.toString();
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
    @Test
    public void addIngredientInBurger() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        assertNotNull(burger.ingredients);
    }

    @Test
    public void setBunInBurger() {
        burger.bun = bun;
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }
    @Test
    public void removeIngredientFromBurger() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(ingredients.isEmpty());
    }
    @Test
    public void moveIngredientInBurger() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 0);
        assertFalse(ingredients.isEmpty());
    }
}
