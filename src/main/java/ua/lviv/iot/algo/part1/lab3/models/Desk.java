package ua.lviv.iot.algo.part1.lab3.models;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public abstract class Desk {

    private int width;
    private int length;
    private int height;
    private int maxHeight;
    private int minHeight;

    private int numOfDrawers;

    public abstract void adjustHeight(int centimeters);

    public abstract void moveDown(int centimeters);

    public String getHeaders() {
        return "width, length, height, maxHeight, minHeight, numOfDrawers, ";
    }

    public String toCSV() {
        return width + ", "
                + length + ", "
                + height + ", "
                + maxHeight + ", "
                + minHeight + ", "
                + numOfDrawers;
    }
}
