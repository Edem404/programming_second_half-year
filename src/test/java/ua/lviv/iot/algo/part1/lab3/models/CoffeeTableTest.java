package ua.lviv.iot.algo.part1.lab3.models;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab3.models.CoffeeTable;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTableTest {

    private CoffeeTable coffeeTableForTest = new CoffeeTable(70, 50, 120, 130,
            90, 0, 140.5, 4);

    @Test
    public void testOfAdjustHeight() {
        coffeeTableForTest.adjustHeight(5);
        assertEquals(125, coffeeTableForTest.getHeight());
    }

    @Test
    void testOfMoveDown() {
        coffeeTableForTest.moveDown(5);
        assertEquals(115, coffeeTableForTest.getHeight());
    }
}