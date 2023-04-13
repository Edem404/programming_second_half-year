package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DressingTableTest {

    private DressingTable dressingTableForTest = new DressingTable(80,40,140,
                                        165,120,6, "ellipse");

    @Test
    public void testOfAllArgConstructorOfLombok(){
        DressingTable dressingTableForTestOfConstructor = new DressingTable("ellipse");
        assertEquals("ellipse",dressingTableForTestOfConstructor.getMirrorShape());
    }
    @Test
    public void testToString() {
        assertEquals(dressingTableForTest.toString(),"DressingTable{Desk(width=80, length=40, height=140" +
                                            ", maxHeight=165, minHeight=120, numOfDrawers=6), mirrorShape='ellipse'}");
    }

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