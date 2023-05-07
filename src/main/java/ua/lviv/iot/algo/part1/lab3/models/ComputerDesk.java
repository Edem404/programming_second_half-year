package ua.lviv.iot.algo.part1.lab3.models;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@Setter
@Getter
public class ComputerDesk extends Desk {

    private boolean hasKeyboardTray;

    public ComputerDesk(final int width, final int length, final int height,
                        final int maxHeight, final int minHeight,
                        final int numOfDrawers, final boolean hasKeyboardTray) {

        super(width, length, height, maxHeight, minHeight, numOfDrawers);

        this.hasKeyboardTray = hasKeyboardTray;
    }

    @Override
    public String toString() {
        return "ComputerDesk{" + super.toString()
                + ", hasKeyboardTray=" + hasKeyboardTray
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
    public String getHeaders() {
        return super.getHeaders() + "hasKeyboardTrey";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", "
                + hasKeyboardTray;
    }
}
