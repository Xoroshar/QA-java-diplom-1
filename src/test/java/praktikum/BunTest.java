package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"black bun", 100},
                {"", 200},
                {null, 300},
                {"bun with !@#$%^&*((((()_-+=}{][|';/?><< ", 300},
                {"Съешь ещё этих мягких французских булок,  да выпей чаю," +
                        "съешь ещё этих мягких французских булок,   да выпей чаю," +
                        "съешь ещё этих мягких французских булок,   да выпей чаю.", 100},
                {"white bun", 0},
                {"white bun", -1},
                {"white bun", 1.34567F},
                {"test", 1.4E-45f},
                {"test", 3.4E38f},
        };
    }

    @Test
    public void getNameReturnCorrectValue() {
        assertEquals("Ожидалось, что название будет " + name, name, (new Bun(name, price)).getName());
    }

    @Test
    public void getPriceReturnCorrectValue() {
        assertEquals("Ожидалось, что цена будет = " + price, price, (new Bun(name, price)).getPrice(), 0);
    }
}