package data;

import dto.AddCarDTO;
import dto.UserDtoLombok;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderLogin {

    @DataProvider
    public Iterator<Object[]> positiveDataLogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .email("testqa20@gmail.com")
                        .password("123456Aa$")
                        .build()
        });
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .email("testqa20@gmail.com")
                        .password("123456Aa$")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativePasswordDataLogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .email("testqa20@gmail.com")
                        .password("123456A88")
                        .build()
        });
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .email("testqa20@gmail.com")
                        .password("123456Aaa")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginCSV() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/datalogin.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        UserDtoLombok.builder()
                                .email(split[0])
                                .password(split[1])
                                .build()
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativeLoginCSV() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/negativedatalogin.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        UserDtoLombok.builder()
                                .email(split[0])
                                .password(split[1])
                                .build()
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> negativeAddCarCSV() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/negativeaddcar.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        AddCarDTO.builder()
                                .serialNumber(split[0])
                                .manufacture(split[1])
                                .model(split[2])
                                .year(Integer.parseInt(split[3]))
                                .fuel(split[4])
                                .seats(Integer.parseInt(split[5]))
                                .carClass(split[6])
                                .pricePerDay(Double.parseDouble(split[7]))
                                .about(split[8])
                                .city(split[9])
                                .build()
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }
}