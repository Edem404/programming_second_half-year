package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeskManagerTest {

    private DeskManager deskManagerForTest;
    private Desk deskForTestFirst;
    private Desk deskForTestSecond;

    @BeforeEach
    public void setUp() {
        deskManagerForTest = new DeskManager();
        deskForTestFirst = new WritingDesk(40, 50, 120, 200, 110, 2, true, 300);
        deskForTestSecond = new WritingDesk(50, 60, 140, 180, 100, 2, true, 250);
        deskManagerForTest.addDesk(deskForTestFirst);
        deskManagerForTest.addDesk(deskForTestSecond);
    }

    @Test
    public void testAddDesk() {
        assertEquals(2, deskManagerForTest.getDesks().size());
        assertTrue(deskManagerForTest.getDesks().contains(deskManagerForTest.getDesks().get(1)));
    }

    @Test
    public void findAllWithMinHeightGreaterThan() {
        List<Desk> foundedDesksByMinHeightGreaterThanFirst = deskManagerForTest.findAllWithMinHeightGreaterThan(105);
        assertEquals(1, foundedDesksByMinHeightGreaterThanFirst.size());
    }

    @Test
    public void findAllWithWidthMoreThan() {
        List<Desk> foundedDesksByWidthMoreThan = deskManagerForTest.findAllWithWidthMoreThan(35);
        assertEquals(2, foundedDesksByWidthMoreThan.size());
        var result = deskManagerForTest.findAllWithWidthMoreThan(60);
        assertEquals(0, result.size());
    }

}
