package utils;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ConfigReaderCSV {
    public static Iterator<Object[]> provideTestData(String csvFile) {
        List<Object[]> testDataList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                testDataList.add(new Object[]{nextLine[0], nextLine[1]});
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return testDataList.iterator();
    }


}
