package ua.lviv.iot.algo.part1.lab3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class WritingDeskTest {
    private WritingDesk writingDeskForTest = new WritingDesk(40,50,120,200,110
                                                     ,2,true,300);

    @Test
    public void testOfAllArgConstructorOfLombok(){
        WritingDesk writingDeskForTestConstructor = new WritingDesk(true,200);
        assertEquals(true, writingDeskForTestConstructor.isHasKeyboardTrey());
        assertEquals(200, writingDeskForTestConstructor.getMaxWeightCapacity());
    }
    @Test
    public void testOfAdjustHeight() {
        writingDeskForTest.adjustHeight(5);
        assertEquals(125,writingDeskForTest.getHeight());
    }

    @Test
    public void testOfMoveDown() {
        writingDeskForTest.moveDown(5);
        assertEquals(115,writingDeskForTest.getHeight());
    }

    @Test
    public void testOfToString() {
        assertEquals(writingDeskForTest.toString(),"WritingDesk{Desk(width=40, length=50, height=120, " +
                "maxHeight=200, minHeight=110, numOfDrawers=2), hasKeyboardTrey=true, maxWeightCapacity=300}");
    }
}