package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    static Properties properties = new Properties();
    public static String getProperty(String param) {
        if(properties.toString().equals("{}")){
            initProperty();
        }
        return properties.getProperty(param);
    }
    private static void initProperty(){
        String target = System.getProperty("target", "prod");
        String path = String.format("src/test/resources/%s.properties", target);
        try(FileReader fileReader = new FileReader(path)) {
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
