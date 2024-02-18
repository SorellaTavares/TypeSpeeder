package se.ju23.typespeeder;

import java.util.Collection;

public class Menu implements MenuService {

    public Collection<Object> getMenuOptions() {
        return null;
    }

    public static void displayMenu() {
        System.out.println("Display menu here");
        // Skapa en switch-sats med 5+ val och skriv ut dem som en meny med sifferval.
    }
}
