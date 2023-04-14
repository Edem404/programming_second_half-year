package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DressingTableTest {

    private DressingTable dressingTableForTest = new DressingTable(80,40,140,
            165,120,6, "ellipse");

    @Test
    public void testAdjustHeight() {
        dressingTableForTest.adjustHeight(5);
        assertEquals(145,dressingTableForTest.getHeight());
    }

    @Test
    public void testMoveDown() {
        dressingTableForTest.moveDown(5);
        assertEquals(135,dressingTableForTest.getHeight());
    }
}
