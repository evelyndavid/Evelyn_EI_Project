package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggingUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static String timestamp() {
        return LocalDateTime.now().format(formatter);
    }

    public static void logInfo(String message) {
        System.out.println("[" + timestamp() + "] [INFO] " + message);
    }

    public static void logWarn(String message) {
        System.out.println("[" + timestamp() + "] [WARN] " + message);
    }

    public static void logError(String message) {
        System.out.println("[" + timestamp() + "] [ERROR] " + message);
    }
}
