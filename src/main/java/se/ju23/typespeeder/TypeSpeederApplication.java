package se.ju23.typespeeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class TypeSpeederApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TypeSpeederApplication.class, args);
        Menu m = new Menu();
        m.displayMenu();
        NewsLetter n = new NewsLetter();

    }

    @Override
    public void run(String... args) throws Exception {

    }

}
