package ua.lviv.iot.algo.part1.lab3.writers;

import ua.lviv.iot.algo.part1.lab3.models.*;

import java.util.ArrayList;
import java.util.List;

public class AbstractTestUntils {

    public static List<Desk> prepareListOfDesks(){
        List<Desk> desks = new ArrayList<>();

        desks.add(new WritingDesk(40, 50, 120, 200, 110, 2, true, 300));
        desks.add(new WritingDesk(50, 60, 140, 180, 100, 2, true, 250));
        desks.add(new ComputerDesk(70, 90, 140, 200, 100, 3, false));
        desks.add(new ComputerDesk(60, 120, 135, 145, 120, 3, true));
        desks.add(new DressingTable(80, 40, 140, 165, 120, 6, "ellipse"));
        desks.add(new DressingTable(60, 90, 135, 145, 110, 4, "circle"));
        desks.add(new CoffeeTable(70, 50, 120, 130, 90, 0, 140.5, 4));
        desks.add(new CoffeeTable(50, 50, 80, 100, 80, 0, 90.7, 7));

        return desks;
    }

}
