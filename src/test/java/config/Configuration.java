package config;

public class Configuration {
    public static String getURL(){
        try {
            return PropertiesFile.getProperty("URL");
        }
        catch(Exception ex) {
            return null;
        }
    }
}
