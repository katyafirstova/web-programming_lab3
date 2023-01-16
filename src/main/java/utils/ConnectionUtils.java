
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConnectionUtils {
    private static final Properties PROPERTIES = new Properties();


    static {
        loadProperties();
    }

    private ConnectionUtils() { }

    private static void loadProperties() {
        try (InputStream inputStream = ConnectionUtils.class
                .getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("application.properties file loading error", e);
        }

    }
    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}