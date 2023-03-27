package ua.lviv.iot.algo.part1.lab2;

import lombok.*;


@NoArgsConstructor
@Setter
@Getter

public class DressingTable extends Desk{
    private int numOfDrawers;
    private String mirrorShape;



    public DressingTable(int width, int length, int height, int maxHeight, int minHeight, int numOfDrawers, String mirrorShape) {
        super(width, length, height, maxHeight, minHeight);

        this.numOfDrawers = numOfDrawers;
        this.mirrorShape = mirrorShape;
    }

    @Override
    public String toString() {
        return "DressingTable{" + super.toString() +
                "numberOfDrawers=" + numOfDrawers +
                ", mirrorShape='" + mirrorShape + '\'' +
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
