package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(of = {"numberOfDrawers", "hasKeyboardTrey", "maxWeightCapacity", "currentHeight", "maxHeight"})
public class WritingDesk {
    private int numberOfDrawers;
    private boolean hasKeyboardTrey;
    private int maxWeightCapacity;
    //height in centimeters;
    private int currentHeight;
    private int maxHeight;
    private static WritingDesk instance = new WritingDesk();
    public static WritingDesk getInstance()
    {
        return instance;
    }
    // increase current height of writing desk not more than the maximum value
    public void adjustHeight(int centimeters)
    {
        if (currentHeight + centimeters > maxHeight)
        {
            System.out.println("U can't increase the height of the writing desk above the possible limit");
        }
        else
        {
            currentHeight += centimeters;
            System.out.println("current height of writing desk: " + currentHeight);
        }

    }

    // decrease current height of writing desk but not lower than 0
    public void moveDawn (int centimeters)
    {
        if (currentHeight - centimeters < 0)
        {
            System.out.println("U can't decrease the height of the writing desk above the possible limit");
        }
        else
        {
            currentHeight -= centimeters;
            System.out.println("current height of writing desk: " + currentHeight);
        }
    }

    public  static void main (String[] args)
    {
        WritingDesk[] arrayOfWritingDesks = new WritingDesk[4];
        arrayOfWritingDesks[0] = new WritingDesk(3, true, 200, 120 , 150);
        arrayOfWritingDesks[1] = new WritingDesk();
        arrayOfWritingDesks[2] = getInstance();
        arrayOfWritingDesks[3] = getInstance();

        for (int i = 0; i < arrayOfWritingDesks.length; i++)
        {
            System.out.println(arrayOfWritingDesks[i].toString());
        }
    }
}