package se.ju23.typespeeder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patch {
    //Instansvariabler
    private String patchVersion;
    private LocalDateTime realeaseDateTime;
    // konstruktor
    public Patch() {
     setRealeaseDateTime(LocalDateTime.now());
    }
    // Getters och setters
    private void setRealeaseDateTime(LocalDateTime now) {
        this.realeaseDateTime = now;
    }

    public LocalDateTime getRealeaseDateTime() {
        return this.realeaseDateTime;
    }

    // Två get-metoder?
    public String getRealeaseDateTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return realeaseDateTime.format(formatter);
    }
}
