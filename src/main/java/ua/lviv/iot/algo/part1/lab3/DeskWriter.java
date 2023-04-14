package ua.lviv.iot.algo.part1.lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DeskWriter {

    public void writeToFile (final List<Desk> desksNeedToWrite, final  String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, StandardCharsets.UTF_8);
        for (int i = 0; i < desksNeedToWrite.size(); i++){
            fileWriter.write(desksNeedToWrite.get(i).getTypeOfDesk() + "\n");
            fileWriter.write(desksNeedToWrite.get(i).getHeaders() + "\n");
            fileWriter.write(desksNeedToWrite.get(i).toCSV() + "\n");

            for (int j = i + 1; j < desksNeedToWrite.size(); j++) {
                if (desksNeedToWrite.get(i).getClass() == desksNeedToWrite.get(j).getClass()) {
                    fileWriter.write(desksNeedToWrite.get(j).toCSV() + "\n");

                    desksNeedToWrite.remove(j);

                    j--;
                }
            }
        }
        fileWriter.close();
    }
}
