package se.ju23.typespeeder;

import org.junit.jupiter.api.Test;
import se.ju23.typespeeder.service.UserService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuPerformanceTest {

    private static final int MAX_EXECUTION_TIME_MENU = 1;
    private static final int MAX_EXECUTION_TIME_LANGUAGE_SELECTION = 100;
    private static final int MILLISECONDS_CONVERSION = 1_000_000;

    private Challenge challenge = new Challenge();

    private void setDummyInput() {
        String input = "svenska\n".repeat(10);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testGetMenuOptionsExecutionTime() {
        long startTime = System.nanoTime();
        Menu menu = new Menu(challenge, new UserService());
        menu.getMenuOptions();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / MILLISECONDS_CONVERSION;
        assertTrue(duration <= MAX_EXECUTION_TIME_MENU, "Menu display took too long. Execution time: " + duration + " ms.");
    }

    @Test
    public void testUserCanChooseSwedishLanguageAndPerformance() {
        setDummyInput();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        long startTime = System.nanoTime();
        Menu menu = new Menu(challenge, new UserService());
        menu.displayMenu();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / MILLISECONDS_CONVERSION;
        String consoleOutput = outContent.toString();

        assertTrue(consoleOutput.contains("Välj språk (svenska/engelska):"), "Menu should prompt for language selection.");
        assertTrue(consoleOutput.contains("Svenska valt."), "Menu should confirm Swedish language selection.");
        assertTrue(duration <= MAX_EXECUTION_TIME_LANGUAGE_SELECTION, "Menu display and language selection took too long. Execution time: " + duration + " ms.");
    }
}
