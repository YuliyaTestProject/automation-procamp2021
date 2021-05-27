package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static PropertiesUtil util;

    private PropertiesUtil() {
    }

    public static synchronized PropertiesUtil getInstance() {
        if (util == null) {
            util = new PropertiesUtil();
        }
        return util;
    }

    private String readProperty(String fileName, String id) {
        Properties property = new Properties();
        try {
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);
            property.load(inputStream);
            return property.getProperty(id);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read Property properties", e);
        }
    }

    public String get(String property, String title) {
        return readProperty(property, title);
    }

}
