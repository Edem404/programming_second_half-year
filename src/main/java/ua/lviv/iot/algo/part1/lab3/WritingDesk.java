package ua.lviv.iot.algo.part1.lab3;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@AllArgsConstructor
@Setter
@Getter
public class WritingDesk extends Desk {

    private boolean hasKeyboardTrey;

    private int maxWeightCapacity;

    public WritingDesk(final int width, final int length, final int height,
                       final int maxHeight, final int minHeight, final int numOfDrawers,
                       final boolean hasKeyboardTrey, final int maxWeightCapacity) {
        super(width, length, height, maxHeight, minHeight, numOfDrawers);

        this.hasKeyboardTrey = hasKeyboardTrey;
        this.maxWeightCapacity = maxWeightCapacity;
    }


    @Override
    public String toString() {
        return "WritingDesk{" + super.toString()
                + ", hasKeyboardTrey=" + hasKeyboardTrey
                + ", maxWeightCapacity=" + maxWeightCapacity
                + "}";
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
}
