package se.ju23.typespeeder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewsLetter {

    private String content = "Detta är ett nyhetsbrev med minst 100 tecken för att passa testet. Håll dig uppdaterad med senaste nytt!";
    private LocalDateTime publishDateTime = LocalDateTime.now();

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishDateTime() {
        return publishDateTime;
    }

    public String getPublishDateTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return publishDateTime.format(formatter);
    }
}
