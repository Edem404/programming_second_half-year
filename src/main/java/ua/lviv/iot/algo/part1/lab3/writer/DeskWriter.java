package ua.lviv.iot.algo.part1.lab3.writer;

import ua.lviv.iot.algo.part1.lab3.models.Desk;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;

public class DeskWriter {

    public void writeToFile(final List<Desk> desksNeedToWrite, final String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName, StandardCharsets.UTF_8)) {
            desksNeedToWrite.sort(Comparator.comparing(object -> object.getClass().getName()));
            Class currentClassOfObject = null;
            for (Desk desk : desksNeedToWrite) {

                if (desk.getClass() != currentClassOfObject) {
                    fileWriter.write(desk.getHeaders() + "\n");
                    currentClassOfObject = desk.getClass();
                }

                fileWriter.write(desk.toCSV() + "\n");
            }
        }
    }
}
