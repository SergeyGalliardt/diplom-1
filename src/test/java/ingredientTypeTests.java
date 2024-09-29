import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class ingredientTypeTests {

    @Test
    public void enumSauceTest() {
        Assert.assertNotNull(IngredientType.SAUCE);
    }

    @Test
    public void enumFillingTest() {
        Assert.assertNotNull(IngredientType.FILLING);
    }
}
