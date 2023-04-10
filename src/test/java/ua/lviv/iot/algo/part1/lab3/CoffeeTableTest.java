package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTableTest {

    private CoffeeTable coffeeTableForTest = new CoffeeTable(70,50,120,
                                            130,90,0,140.5,4);

    @Test
    public void testOfAllArgConstructorOfLombok(){
        CoffeeTable coffeeTableForTestConstructor = new CoffeeTable(140.5,4);
        assertEquals(140.5, coffeeTableForTestConstructor.getAreaOfSurface());
        assertEquals(4,coffeeTableForTestConstructor.getNumOfJournals());
    }

    @Test
    public void testToString() {
        assertEquals(coffeeTableForTest.toString(),"CoffeeTable{Desk(width=70, length=50, height=120, " +
                "maxHeight=130, minHeight=90, numOfDrawers=0)areaOfSurface=140.5, numOfJournals=4}");
    }

    @Test
    public void testOfAdjustHeight() {
        coffeeTableForTest.adjustHeight(5);
        assertEquals(125,coffeeTableForTest.getHeight());
    }

    @Test
    public void testOfMoveDown() {
        coffeeTableForTest.moveDown(5);
        assertEquals(115, coffeeTableForTest.getHeight());
    }
}