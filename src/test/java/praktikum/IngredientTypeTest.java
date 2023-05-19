package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void sauceEnumReturnSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void fillingEnumReturnFilling() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

}