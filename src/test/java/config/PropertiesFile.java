package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static String getProperty(String name) throws IOException {

        Properties prop = new Properties();
        String projectPath = System.getProperty("user.dir");
        InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
        prop.load(input);
        String value = prop.getProperty(name);
        return value;

    }
}
