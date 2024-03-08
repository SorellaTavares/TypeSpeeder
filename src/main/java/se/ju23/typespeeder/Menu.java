package se.ju23.typespeeder;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements MenuService {
    Scanner input = new Scanner(System.in);
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

        System.out.println("Välj språk (svenska/engelska): ");
        String svenska = input.nextLine(); // ge anv möj att svara vilket språk
        System.out.println("Svenska valt.");
        List<String> options = getMenuOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void collectMenuChoice() {

    }
}
