import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class burgerTests {
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient topping;

    @Before
    public void setUpBurger() {
        burger = new Burger();
    }

    @Test
    public void bunTest() {
        burger.setBuns(bun);
        Bun actual = burger.bun;

        assertEquals(bun, actual);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        List<Ingredient> expected = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;

        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());

    }

    @Test
    public void burgerMoveIngredientsCheck() {
        burger.addIngredient(sauce);
        burger.addIngredient(topping);

        burger.moveIngredient(1, 0);

        Ingredient actual = burger.ingredients.get(0);

        assertEquals(topping, actual);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(145.5f);
        Mockito.when(ingredient.getPrice()).thenReturn(200.5f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actual = burger.getPrice();;
        float expected = 491.5f;

        assertEquals(expected, actual, 0.01f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Las Ketchup");
        Mockito.when(bun.getPrice()).thenReturn(145.5f);
        Mockito.when(ingredient.getName()).thenReturn("Asereje");
        Mockito.when(ingredient.getPrice()).thenReturn(200.5f);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);

        String expectedReceipt = String.format("(==== %s ====)%n" +
                "= sauce %s =%n" +
                "(==== %s ====)%n" +
                "%n" +
                "Price: %f%n", bun.getName(), ingredient.getName(), bun.getName(), 491.5f);

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
