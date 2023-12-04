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
//        String target = System.getProperty("target", "prod");
//        String path = String.format("src/test/resources/config.properties", target);
        try(FileReader fileReader = new FileReader("src/test/resources/config.properties")) {
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

//        try (FileInputStream input = new FileInputStream("config.properties")) {
//            // Load the properties file
//            properties.load(input);
//
//            Enumeration<?> propertyNames = properties.propertyNames();
//            while (propertyNames.hasMoreElements()) {
//                String key = (String) propertyNames.nextElement();
//                String value = properties.getProperty(key);
//                System.out.println(key + ": " + value);
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}