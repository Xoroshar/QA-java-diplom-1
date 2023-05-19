package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class BurgerTest {
    Burger burger = new Burger();

    private final float bunPrice = 100;
    private final float ingrPrice = 100;
    private final float totalPrice = 300;
    private final String bunName = "black bun";
    private final String ingrType = String.valueOf(IngredientType.SAUCE);
    private final String ingrName = "sour cream";

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Burger burgerMock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingrPrice);
    }

    @Test
    public void getPriceReturnCorrectValue()  {
        assertEquals(totalPrice, burger.getPrice(),0);
    }

    @Test
    public void getReceiptReturnCorrectValue()  {
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf(ingrType));
        Mockito.when(ingredient.getName()).thenReturn(ingrName);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        receipt.append(String.format("= %s %s =%n", ingrType.toLowerCase(), ingrName));
        receipt.append(String.format("(==== %s ====)%n", bunName));
        receipt.append(String.format("%nPrice: %f%n", totalPrice));
        assertEquals(receipt.toString(), burger.getReceipt());
    }
    @Test
    public void setBunIsSuccessful() {
        burgerMock.setBuns(bun);
        Mockito.verify(burgerMock, Mockito.times(1)).setBuns(bun);
    }
    @Test
    public void addIngredientIsSuccessful() {
        burgerMock.addIngredient(ingredient);
        Mockito.verify(burgerMock, Mockito.times(1)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientIsSuccessful() {
        Burger b = new Burger();
        b.addIngredient(ingredient);
        b.removeIngredient(0);
        assertEquals(0, b.ingredients.size());
    }

    @Test
    public void moveIngredientIsSuccessful() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "test",10));
        burger.moveIngredient(1,0);
        assertEquals(2, burger.ingredients.size());
        assertEquals("test", burger.ingredients.get(0).getName());
        assertEquals(10, burger.ingredients.get(0).getPrice(),0);
        assertEquals(IngredientType.SAUCE, burger.ingredients.get(0).getType());
    }
}