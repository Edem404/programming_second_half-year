package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ComputerDesk extends Desk{

    private boolean hasKeyboardTray;

    public ComputerDesk(int width, int length, int height, int maxHeight, int minHeight, int numOfDrawers, boolean hasKeyboardTray) {
        super(width, length, height, maxHeight, minHeight, numOfDrawers);

        this.hasKeyboardTray = hasKeyboardTray;
    }

    @Override
    public String toString() {
        return "ComputerDesk{" + super.toString() +
                ", hasKeyboardTray=" + hasKeyboardTray +
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