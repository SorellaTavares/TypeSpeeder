package se.ju23.typespeeder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Challenge {


    private final List<String> letters = Arrays.asList("w", "X", "G", "c", "o", "W", "W", "a", "K", "L");

    public void startChallenge() {
        startChallenge(new Scanner(System.in));
    }

    public void startChallenge(Scanner scanner) {
        System.out.println("Startar utmaning...");
        System.out.println("Skriv följande bokstäver: " + String.join(" ", letters));

        long startTime = System.currentTimeMillis();

        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine().trim();
        }

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        String correct = String.join(" ", letters);
        if (input.equals(correct)) {
            System.out.println("Rätt!");
        } else {
            System.out.println("Fel. Du skrev: " + input);
            System.out.println("Rätt var: " + correct);
        }

        System.out.println("Tid: " + timeTaken + " ms");
        System.out.println("Utmaning avslutad!");
    }


    public List<String> lettersToType() {
        return letters;
    }
}
