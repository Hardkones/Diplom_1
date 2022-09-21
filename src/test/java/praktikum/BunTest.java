package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun("name", 100f);
        String expected = "name";
        String actual = bun.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun("name", 100f);
        float priceExpected = 100f;
        float priceActual = bun.getPrice();
        assertEquals(priceExpected, priceActual, 0);
    }
}
