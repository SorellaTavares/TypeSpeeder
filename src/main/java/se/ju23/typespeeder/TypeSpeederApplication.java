package se.ju23.typespeeder;

import se.ju23.typespeeder.data.UserRepository;
import se.ju23.typespeeder.service.UserService;
import java.util.Scanner;

public class TypeSpeederApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        Challenge challenge = new Challenge();
        Menu menu = new Menu(challenge, userService);

        System.out.println("Välkommen till TypeSpeeder!");
        menu.displayMenu();
        System.out.println("Hejdå!");
    }
}
