package ua.lviv.iot.algo.part1.lab3.writers;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab3.models.*;
import ua.lviv.iot.algo.part1.lab3.writer.DeskWriter;

import static org.junit.jupiter.api.Assertions.*;
import static ua.lviv.iot.algo.part1.lab3.writers.AbstractTestUntils.prepareListOfDesks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.File;


class DeskWriterTest {

    private DeskWriter deskWriter;

    private List<Desk> desks;

    public static final String RESULT_FILE_NAME = "src/test/resources/resultFile.csv";
    public static final String EXPECTED_FILE_NAME = "src/test/resources/expectedFile.csv";
    public static final String EMPTY_FILE_NAME = "src/test/resources/emptyFile.csv";

    @BeforeEach
    public void setUp() throws IOException {
        deskWriter = new DeskWriter();
        desks = new ArrayList<>();
    }

    @AfterAll
    public static void deleteFile() throws IOException {
        Files.deleteIfExists(Path.of(RESULT_FILE_NAME));
    }

    @Test
    public void writerTest() throws IOException {
        desks = prepareListOfDesks();
        deskWriter.writeToFile(desks, RESULT_FILE_NAME);
        assertEquals(-1L, Files.mismatch(Paths.get(RESULT_FILE_NAME), Paths.get(EXPECTED_FILE_NAME)));
    }

    @Test
    public void isEmptyFile() throws IOException {
        deskWriter.writeToFile(desks, EMPTY_FILE_NAME);
        File emptyFile = new File(EMPTY_FILE_NAME);

        assertEquals(0, emptyFile.length());
        assertTrue(emptyFile.isFile());
    }

    @Test
    public void prevTestFileAvailable() throws IOException {
        desks = prepareListOfDesks();
        deskWriter.writeToFile(desks, RESULT_FILE_NAME);

        assertEquals(-1L, Files.mismatch(Paths.get(RESULT_FILE_NAME), Paths.get(EXPECTED_FILE_NAME)));
    }
}
