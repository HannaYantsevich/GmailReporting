package property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {

    private static String FILE_NAME = "src/test/resources/config/config.properties";
    private static Properties prop = new Properties();

    public static String getProperty(String key) {

        try {
            InputStream ip = new FileInputStream(FILE_NAME);
            prop.load(ip);
            ip.close();
        } catch (IOException e) {
            throw new RuntimeException("Error happened while trying to load props from: " + FILE_NAME, e);
        }
        return prop.getProperty(key);
    }
}
