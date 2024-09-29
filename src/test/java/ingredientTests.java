import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.SAUCE;

public class ingredientTests {
      Ingredient ingredient = new Ingredient(SAUCE, "Blink", 182.0f);

      @Test
      public void getPriceTest() {
          float expectedPrice = 182.0f;
          float actualPrice = ingredient.getPrice();
          Assert.assertEquals(expectedPrice, actualPrice, 0);
      }

    @Test
    public void getNameTest() {
        String expectedName = "Blink";
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getTypeTest() {
        String expectedType = String.valueOf(SAUCE);
        String actualType = String.valueOf(ingredient.getType());
        Assert.assertEquals(expectedType, actualType);
    }
}
