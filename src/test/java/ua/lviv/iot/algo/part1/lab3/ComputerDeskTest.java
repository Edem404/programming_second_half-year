package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerDeskTest {
    private Desk computerDeskForTest = new ComputerDesk(70,90,130,
                                                200,100,3,false);

    @Test
    public void testOfAllArgConstructorOfLombok(){
        ComputerDesk computerDeskForTestConstructor = new ComputerDesk(true);
        assertEquals(true, computerDeskForTestConstructor.isHasKeyboardTray());
    }
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

    @Test
    public void testOfToString() {
        assertEquals(computerDeskForTest.toString(),"ComputerDesk{Desk(width=70, length=90, height=130, maxHeight=200, minHeight=100, numOfDrawers=3), hasKeyboardTray=false}");
    }
}