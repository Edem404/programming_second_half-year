package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeskManagerTest {

    DeskManager deskManagerForTest = new DeskManager();

    @Test
    void testAddDesk() {
        deskManagerForTest.addDesk(new WritingDesk(40,50,120,200,110,2,true,300));
        assertEquals(1, deskManagerForTest.getDesks().size());
        assertTrue(deskManagerForTest.getDesks().contains(deskManagerForTest.getDesks().get(0)));
        deskManagerForTest.addDesk(new WritingDesk(50,60,140,180,100,2,true,250));
        assertEquals(2,deskManagerForTest.getDesks().size());
        assertTrue(deskManagerForTest.getDesks().contains(deskManagerForTest.getDesks().get(1)));
    }

    @Test
    void findAllWithMinHeightGreaterThan() {
        deskManagerForTest.addDesk(new WritingDesk(40,50,120,200,110,2,true,300));
        deskManagerForTest.addDesk(new WritingDesk(50,60,100,180,100,2,true,250));
        List<Desk> foundedDesksByMinHeightGreaterThanFirst = deskManagerForTest.findAllWithMinHeightGreaterThan(105);
        assertEquals(1, foundedDesksByMinHeightGreaterThanFirst.size());
    }

    @Test
    void findAllWithWidthMoreThan() {
        deskManagerForTest.addDesk(new WritingDesk(40,50,120,200,110,2,true,300));
        deskManagerForTest.addDesk(new WritingDesk(50,60,100,180,100,2,true,250));
        List<Desk> foundedDesksByWidthMoreThan = deskManagerForTest.findAllWithWidthMoreThan(35);
        assertEquals(2, foundedDesksByWidthMoreThan.size());
    }

}