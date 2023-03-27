package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

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

    public abstract void adjustHeight(int centimeters);

    public abstract void moveDown(int centimeters);
}