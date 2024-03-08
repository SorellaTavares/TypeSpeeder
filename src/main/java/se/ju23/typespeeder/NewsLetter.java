package se.ju23.typespeeder;

import ch.qos.logback.core.util.CachingDateFormatter;

import javax.crypto.spec.PSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewsLetter {
    private String content;
    private LocalDateTime publishDateTime;
    public NewsLetter() {
        setContent();
        setPublishDateTime(LocalDateTime.now());
    }

    public String getContent() {
        return this.content;
    }

    public void setContent() {
        this.content = "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"; // Får ej se ut så sedan, fil eller db
    }


    public void setPublishDateTime(LocalDateTime publishDateTime) {
            this.publishDateTime = publishDateTime;

            // System.out.println("format:   " + dateTimeValue.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            // format:   2016-10-31 23:59:59
    }

    public LocalDateTime getPublishDateTime() {

        return publishDateTime;
    }
    // Två get-metoder?
    public String getPublishDateTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.publishDateTime.format(formatter);

    }
}

/*
LocalDateTime dateTime = LocalDateTime.now();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

return dateTime.format(formatter);
 */