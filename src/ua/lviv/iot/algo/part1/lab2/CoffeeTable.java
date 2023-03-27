package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CoffeeTable extends Desk{
    private int numOfJournals;
    private double areaOfSurface;
    private int numOfDrawers;

    public CoffeeTable(int width, int length, int height, int maxHeight, int minHeight, int numOfJournals, double areaOfSurface, int numOfDrawers) {
        super(width, length, height, maxHeight, minHeight);

        this.numOfJournals = numOfJournals;
        this.areaOfSurface = areaOfSurface;
        this.numOfDrawers = numOfDrawers;
    }

    @Override
    public String toString() {
        return "CoffeeTable{" + super.toString() +
                "numOfJournals=" + numOfJournals +
                ", areaOfSurface=" + areaOfSurface +
                ", numOfDrawers=" + numOfDrawers +
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
