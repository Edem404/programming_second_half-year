package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerDeskTest {
    private Desk computerDeskForTest = new ComputerDesk(70,90,130,
            200,100,3,false);

    @Test
    public void testAdjustHeight(){
        Desk computerDeskForTestError = new ComputerDesk(70,90,130,200,100,3,false);
        computerDeskForTestError.adjustHeight(5);
        assertEquals(135,computerDeskForTestError.getHeight());
    }

    @Test
    public void testOfMoveDown() {
        computerDeskForTest.moveDown(5);
        assertEquals(125,computerDeskForTest.getHeight());
    }
}