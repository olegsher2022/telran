package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CarConfigReader {
    static Properties properties = new Properties();

    public static String getProperty(String param) {
        if(properties.toString().equals("{}")){
            initProperty();
        }
        return properties.getProperty(param);
    }
    private static void initProperty(){
        try(FileReader fileReader = new FileReader("src/test/resources/car.properties")) {
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
