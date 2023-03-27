package ua.lviv.iot.algo.part1.lab2;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WritingDesk extends Desk {
    private int numOfDrawers;

    private boolean hasKeyboardTrey;

    private int maxWeightCapacity;

    private static WritingDesk instance = new WritingDesk();

    public static WritingDesk getInstance() {
        return instance;
    }

    public WritingDesk(int width, int length, int height, int maxHeight, int minHeight, int numOfDrawers, boolean hasKeyboardTrey, int maxWeightCapacity) {
        super(width, length, height, maxHeight, minHeight);

        this.numOfDrawers = numOfDrawers;
        this.hasKeyboardTrey = hasKeyboardTrey;
        this.maxWeightCapacity = maxWeightCapacity;
    }


    @Override
    public String toString() {
        return "WritingDesk{" + super.toString() +
                "numberOfDrawers=" + numOfDrawers +
                ", hasKeyboardTrey=" + hasKeyboardTrey +
                ", maxWeightCapacity=" + maxWeightCapacity +
                "}" ;
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