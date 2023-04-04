package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CoffeeTable extends Desk{
    private double areaOfSurface;
    private int numOfJournals;

    public CoffeeTable(int width, int length, int height, int maxHeight, int minHeight, int numOfDrawers, double areaOfSurface, int numOfJournals) {
        super(width, length, height, maxHeight, minHeight,numOfDrawers);

        this.areaOfSurface = areaOfSurface;
    }

    @Override
    public String toString() {
        return "CoffeeTable{" + super.toString() +
                "numOfJournals=" + numOfJournals +
                ", areaOfSurface=" + areaOfSurface +
                '}';
    }

    @Override
    public void adjustHeight(int centimeters) {
        if (getHeight() + centimeters > getMaxHeight()) {
            return;
        }
        setHeight(getHeight() + centimeters) ;
    }

    @Override
    public void moveDown(int centimeters) {
        if (getHeight() - centimeters < getMinHeight()) {
            return;
        }
        setHeight(getHeight() - centimeters) ;
    }
}
