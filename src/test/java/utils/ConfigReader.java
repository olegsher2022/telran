package utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;


public class ConfigReader {

    static Properties properties = new Properties();

        public static String getProperty(String param) {
        if(properties.toString().equals("{}")){
            initProperty();
        }
        return properties.getProperty(param);
    }
    private static void initProperty(){
        try(FileReader fileReader = new FileReader("src/test/resources/config.properties")) {
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
    }




}