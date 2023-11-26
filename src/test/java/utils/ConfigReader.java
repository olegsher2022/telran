package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

    public ConfigReader() {
    }

    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("config.properties")) {
            // Load the properties file
            properties.load(input);
            String btnLoginNavigatorMenu = properties.getProperty("btnLoginNavigatorMenu");
            System.out.println("btnLoginNavigatorMenu " + btnLoginNavigatorMenu);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}