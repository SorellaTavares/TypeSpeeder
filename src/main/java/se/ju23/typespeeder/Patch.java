package se.ju23.typespeeder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patch {

    private String patchVersion = "v1.0.0";
    private LocalDateTime realeaseDateTime = LocalDateTime.now();

    public String getPatchVersion() {
        return patchVersion;
    }

    public LocalDateTime getRealeaseDateTime() {
        return realeaseDateTime;
    }

    public String getRealeaseDateTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return realeaseDateTime.format(formatter);
    }
}
