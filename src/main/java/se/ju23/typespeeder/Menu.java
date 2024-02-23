package se.ju23.typespeeder;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuService {
    private List<String> options;
    public Menu() {
        this.options = new ArrayList<>();
        this.options.add("op 1");
        this.options.add("op 2");
        this.options.add("op 3");
        this.options.add("op 4");
        this.options.add("op 5");
    }
    public List<String> getMenuOptions() {
        return this.options;
    }

    public void displayMenu() {
        System.out.println("Display menu here");
        List<String> options = getMenuOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }
}
