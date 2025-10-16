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

        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine().trim();
        }

        if (!input.isEmpty()) {
            System.out.println("Du skrev: " + input);
        }

        System.out.println("Utmaning avslutad!");
    }

    public List<String> lettersToType() {
        return letters;
    }
}
