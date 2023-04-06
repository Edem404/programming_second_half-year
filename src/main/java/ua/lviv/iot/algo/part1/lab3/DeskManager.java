package ua.lviv.iot.algo.part1.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class DeskManager {
    private List <Desk> desks = new ArrayList<>();

    public void addDesk(final Desk desk) {
        desks.add(desk);
    }

    public List<Desk> findAllWithMinHeightGreaterThan(final int minHeightInCentimeters) {
        return desks.stream()
                     .filter(desks -> desks.getMinHeight() > minHeightInCentimeters)
                     .collect(Collectors.toList());
    }

    public List<Desk> findAllWithWidthMoreThan(final int widthInCentimeters) {
        return desks.stream()
                     .filter(desks -> desks.getWidth() > widthInCentimeters)
                     .collect(Collectors.toList());
    }
}
