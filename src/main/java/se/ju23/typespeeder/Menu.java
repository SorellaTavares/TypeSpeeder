package se.ju23.typespeeder;

import se.ju23.typespeeder.service.UserService;

import java.util.List;
import java.util.Scanner;

public class Menu implements MenuService {

    private final UserService userService;
    private final Challenge challenge;

    private Scanner scanner;
    private String language = "svenska"; // default
    private boolean loggedIn = false;
    private String currentUser;

    public Menu(Challenge challenge, UserService userService) {
        this.challenge = challenge;
        this.userService = userService;
    }

    public Menu(Challenge challenge, UserService userService, Scanner scanner) {
        this.challenge = challenge;
        this.userService = userService;
        this.scanner = scanner;
    }

    private Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    @Override
    public void displayMenu() {
        Challenge challenge = new Challenge();
        Scanner scanner = getScanner();

        if (!loggedIn) {
            System.out.println("Välj språk (svenska/engelska):");
            if (scanner.hasNextLine()) {
                String langInput = scanner.nextLine();
                selectLanguage(langInput);
                System.out.println("Du valde: " + langInput);
            }
        }

        List<String> options = getMenuOptions();

        boolean running = true;
        while (running) {
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.println("0. Avsluta");

            if (!scanner.hasNextLine()) {
                break;
            }

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    challenge.startChallenge(scanner);
                    break;
                case "0":
                    running = false; // avsluta menyn
                    break;
                default:
                    System.out.println("Felaktigt val, försök igen.");
            }
        }
    }

    @Override
    public List<String> getMenuOptions() {
        return List.of(
                "Starta utmaning",
                "Visa ranking",
                "Visa nyheter",
                "Visa patch-info",
                "Avsluta"
        );
    }

    private void registerUser() {
        System.out.print("Ange användarnamn: ");
        String username = getScanner().hasNextLine() ? getScanner().nextLine() : "";
        System.out.print("Ange lösenord: ");
        String password = getScanner().hasNextLine() ? getScanner().nextLine() : "";

        if (userService.registerUser(username, password)) {
            System.out.println("Användare registrerad! Logga in för att fortsätta.");
        } else {
            System.out.println("Användarnamn upptaget. Försök igen.");
        }
    }

    private void loginUser() {
        System.out.print("Ange användarnamn: ");
        String username = getScanner().nextLine();
        System.out.print("Ange lösenord: ");
        String password = getScanner().nextLine();

        if (userService.loginUser(username, password)) {
            loggedIn = true;
            currentUser = username;
            System.out.println("Inloggning lyckades! Välkommen " + username);
            // TA BORT selectLanguage här!
        } else {
            System.out.println("Fel användarnamn eller lösenord.");
        }
    }

    public void selectLanguage(String input) {
        if (input == null) input = "";
        input = input.trim().toLowerCase();

        if (input.equals("s") || input.equals("svenska")) {
            language = "svenska";
            System.out.println("Svenska valt.");
        } else if (input.equals("e") || input.equals("engelska")) {
            language = "engelska";
            System.out.println("English selected.");
        } else {
            System.out.println("Ogiltigt val. Standard svenska.");
            language = "svenska";
        }
    }

    private void showRanking() {
        System.out.println("Visa ranking (exempel):");
    }

    private void showNews() {
        System.out.println("Visa nyheter (exempel).");
    }

    private void showPatchInfo() {
        System.out.println("Visa patch-info (exempel).");
    }
}
