package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;


public class ConfigReader {

    public ConfigReader() {
    }

    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("config.properties")) {
            // Load the properties file
            properties.load(input);

            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String key = (String) propertyNames.nextElement();
                String value = properties.getProperty(key);
                System.out.println(key + ": " + value);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}