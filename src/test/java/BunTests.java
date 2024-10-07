import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {

    private Bun bun;
    private final String name;
    private final float price;

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object [][] getData () {
        return new Object[][] {
                {"orange bun", 1100},
                {"blue bun", 20},
                {"yellow bun", 1},
                {null, 0},
        };
    }

    @Before
    public void setUpBun () {bun = new Bun(name, price);}

    @Test
    public void getNameTest() {assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {assertEquals(price, bun.getPrice(), 0.0f);
    }

}
