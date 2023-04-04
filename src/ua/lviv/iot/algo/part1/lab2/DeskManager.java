package ua.lviv.iot.algo.part1.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.*;


@Setter
@Getter
@ToString
public class DeskManager{
    private static List <Desk> desks = new ArrayList<Desk>();

    public void addDesk(final Desk desk)
    {
        desks.add(desk);
    }

    public List<Desk> findAllWithMinHeightGreaterThan (int minHeightInCentimeters)
    {
        return desks.stream().filter(desks -> desks.getMinHeight() > minHeightInCentimeters).collect(Collectors.toList());
    }

    public List<Desk> findAllWithWidthMoreThan (int widthInCentimeters)
    {
        return desks.stream().filter(desks -> desks.getWidth() > widthInCentimeters).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Desk writingDeskFirst = new WritingDesk(40,50,120,200,110,2,true,300);
        Desk writingDeskSecond = new WritingDesk(50,60,140,180,100,2,true,250);
        Desk computerDeskFirst = new ComputerDesk(70,90,140,200,100,3,false);
        Desk computerDeskSecond = new ComputerDesk(60,120,135,145,120,3,true);
        Desk dressingTableFirst = new DressingTable(80, 40,140,165,120,6,"ellipse");
        Desk dressingTableSecond =  new DressingTable(60, 90,135,145,110,4,"circle");
        Desk coffeeTableFirst = new CoffeeTable(70,50,120,130,90,0,140.5,4);
        Desk coffeeTableSecond = new CoffeeTable(50,50,80,100,80,0,90.7,7);

        DeskManager deskManager = new DeskManager();

        deskManager.addDesk(writingDeskFirst);
        deskManager.addDesk(writingDeskSecond);
        deskManager.addDesk(computerDeskFirst);
        deskManager.addDesk(computerDeskSecond);
        deskManager.addDesk(dressingTableFirst);
        deskManager.addDesk(dressingTableSecond);
        deskManager.addDesk(coffeeTableFirst);
        deskManager.addDesk(coffeeTableSecond);

        for (Desk manager: desks){
            System.out.println(manager.toString());
        }

        System.out.println("find all with minimal height greater than -> 110");

        List<Desk> foundedDesksByMinHeightGreaterThan = deskManager.findAllWithMinHeightGreaterThan(105);
        for (Desk desk : foundedDesksByMinHeightGreaterThan) {
            System.out.println(desk.toString());
        }

        System.out.println("find all with width greater than -> 70");

        List<Desk> foundedDesksByWidthMoreThan = deskManager.findAllWithWidthMoreThan(65);
        for (Desk desk : foundedDesksByWidthMoreThan) {
            System.out.println(desk.toString());
        }

        System.out.println("adding 5 centimeters to height of all desks");
        for (Desk desk: desks){
            desk.adjustHeight(5);
        }
        for (Desk manager: desks){
            System.out.println(manager.toString());
        }

        System.out.println("decrease height of all desks on 10 centimeters");
        for (Desk desk1: desks){
            desk1.moveDown(10);
        }
        for (Desk manager: desks){
            System.out.println(manager.toString());
        }
    }
}
