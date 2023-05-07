package ua.lviv.iot.algo.part1.lab3.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab3.models.WritingDesk;

class WritingDeskTest {
    private WritingDesk writingDeskForTest = new WritingDesk(40, 50, 120, 200, 110
            , 2, true, 300);

    @Test
    public void testOfAdjustHeight() {
        writingDeskForTest.adjustHeight(5);
        assertEquals(125, writingDeskForTest.getHeight());
    }

    @Test
    public void testOfMoveDown() {
        writingDeskForTest.moveDown(5);
        assertEquals(115, writingDeskForTest.getHeight());
    }
}
