package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "sour cream", 100},
                {FILLING, "cutlet", 200}
        };
    }

    @Test
    public void getPriceReturnCorrectValue()  {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ожидается, что вернется " + price, price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameReturnCorrectValue()  {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ожидается, что вернется " + name, name, ingredient.getName());
    }

    @Test
    public void getTypeReturnCorrectValue()  {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ожидается, что вернется " + type, type, ingredient.getType());
    }

}