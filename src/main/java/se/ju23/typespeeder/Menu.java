package se.ju23.typespeeder;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuService {

    public static List<String> getMenuOptions() {
        List<String> options = new ArrayList<>();
        options.add("op 1");
        options.add("op 2");
        options.add("op 3");
        options.add("op 4");
        options.add("op 5");
        return options;
    }

    public static void displayMenu() {
        System.out.println("Display menu here");
        List<String> options = getMenuOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }
}
