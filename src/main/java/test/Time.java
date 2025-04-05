package test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class Time {
    public static void main(String[] args) {
        Instant now = Instant.now();
        Timestamp st = Timestamp.from(now); // Conversión directa desde Instant
        System.out.println(st);
    }
}
