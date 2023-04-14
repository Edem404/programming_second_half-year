package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


class DeskWriterTest {
    private DeskManager deskManagerForDeskWriterTest;

    private DeskWriter deskWriter;
    private Desk deskFirst, deskSecond, deskThird, deskFourth, deskFifth, deskSixth, deskSeventh, deskEighth;

    @BeforeEach
    public void setUp() {
        deskManagerForDeskWriterTest = new DeskManager();
        deskWriter = new DeskWriter();
        deskFirst = new WritingDesk(40, 50, 120, 200, 110, 2, true, 300);
        deskSecond = new WritingDesk(50, 60, 140, 180, 100, 2, true, 250);
        deskThird = new ComputerDesk(70, 90, 140, 200, 100, 3, false);
        deskFourth = new ComputerDesk(60, 120, 135, 145, 120, 3, true);
        deskFifth = new DressingTable(80, 40, 140, 165, 120, 6, "ellipse");
        deskSixth = new DressingTable(60, 90, 135, 145, 110, 4, "circle");
        deskSeventh = new CoffeeTable(70, 50, 120, 130, 90, 0, 140.5, 4);
        deskEighth = new CoffeeTable(50, 50, 80, 100, 80, 0, 90.7, 7);

        deskManagerForDeskWriterTest.addDesk(deskFirst);
        deskManagerForDeskWriterTest.addDesk(deskSecond);
        deskManagerForDeskWriterTest.addDesk(deskThird);
        deskManagerForDeskWriterTest.addDesk(deskFourth);
        deskManagerForDeskWriterTest.addDesk(deskFifth);
        deskManagerForDeskWriterTest.addDesk(deskSixth);
        deskManagerForDeskWriterTest.addDesk(deskSeventh);
        deskManagerForDeskWriterTest.addDesk(deskEighth);
    }


    @Test
    public void fileWritingTest() throws IOException {
        String fileNameTest = "src/test/resources/resultFile.csv";
        deskWriter.writeToFile(deskManagerForDeskWriterTest.getDesks(), fileNameTest);
        BufferedReader bufferedReaderResultFile = new BufferedReader(new FileReader(fileNameTest));
        BufferedReader bufferedReaderExpectedFile = new BufferedReader(new FileReader("src/test/resources/expectedFile.csv"));

        List<String> expectedList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        String lineExpected;
        for(Desk desk: deskManagerForDeskWriterTest.getDesks()) {
            lineExpected = bufferedReaderExpectedFile.readLine();
            expectedList.add(lineExpected);
        }

        String lineResult;
        for (Desk desk: deskManagerForDeskWriterTest.getDesks()) {
            lineResult = bufferedReaderResultFile.readLine();
            resultList.add(lineResult);
        }

        assertEquals(expectedList, resultList);
    }

    @Test
    public void isEmptyFile() throws IOException {
        DeskManager emptyFileManager = new DeskManager();
        DeskWriter emptyFileWriter = new DeskWriter();

        String fileNameTest = "src/test/resources/emptyFile.csv";

        emptyFileWriter.writeToFile(emptyFileManager.getDesks(), fileNameTest);
        File emptyFile = new File(fileNameTest);


        assertEquals(0, emptyFile.length());
        assertTrue(emptyFile.isFile());
    }

    @Test
    public void prevTestFileAvailable() throws IOException {
        String fileNameTest = "src/test/resources/resultFile.csv";
        deskWriter.writeToFile(deskManagerForDeskWriterTest.getDesks(), fileNameTest);
        BufferedReader bufferedReaderResultFile = new BufferedReader(new FileReader(fileNameTest));
        BufferedReader bufferedReaderExpectedFile = new BufferedReader(new FileReader("src/test/resources/expectedFile.csv"));

        assertNotNull(bufferedReaderExpectedFile);
        assertNotNull(bufferedReaderResultFile);

        List<String> expectedList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        String lineExpected;
        for(Desk desk: deskManagerForDeskWriterTest.getDesks()) {
            lineExpected = bufferedReaderExpectedFile.readLine();
            expectedList.add(lineExpected);
        }

        String lineResult;
        for (Desk desk: deskManagerForDeskWriterTest.getDesks()) {
            lineResult = bufferedReaderResultFile.readLine();
            resultList.add(lineResult);
        }

        assertEquals(expectedList, resultList);
    }
}