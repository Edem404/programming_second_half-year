package ua.lviv.iot.algo.part1.lab3;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@Setter
@Getter
public class DressingTable extends Desk {

    private String mirrorShape;

    public DressingTable(final int width, final int length, final int height,
                         final int maxHeight, final int minHeight,
                         final int numOfDrawers, final String mirrorShape) {
        super(width, length, height, maxHeight, minHeight, numOfDrawers);

        this.mirrorShape = mirrorShape;
    }

    @Override
    public String toString() {
        return "DressingTable{" + super.toString()
                + ", mirrorShape='" + mirrorShape + '\''
                + '}';
    }

    @Override
    public void adjustHeight(final int centimeters) {
        if (getHeight() + centimeters > getMaxHeight()) {
            return;
        }
        setHeight(getHeight() + centimeters);
    }

    @Override
    public void moveDown(final int centimeters) {
        if (getHeight() - centimeters < getMinHeight()) {
            return;
        }
        setHeight(getHeight() - centimeters);
    }

    @Override
    public String getTypeOfDesk() {
        return "Dressing table";
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + "mirrorShape";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", "
                + mirrorShape;
    }
}
