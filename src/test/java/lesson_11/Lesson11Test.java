package lesson_11;

import lesson_11.BinarySearch;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;


public class Lesson11Test {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite - set env to initial state");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite - Clean env after suite");
    }

    @BeforeTest
    public void beforeTest(XmlTest xmlTest) {
        System.out.printf("Before Test %s %s", getClass().getSimpleName(), xmlTest.getName());
    }

    @AfterTest
    public void afterTest(XmlTest xmlTest) {
        System.out.printf("After Test %s %s", getClass().getSimpleName(), xmlTest.getName());
    }


    @BeforeGroups(groups = {"perftest", "first-group", "second-group", "functest"})
    public void beforeGroups() {
        System.out.println("\tBeforeGroups");
    }


    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.printf("\t\tBeforeMethod %s %s\n", getClass().getSimpleName(), method.getName());
    }

    @AfterMethod
    public void afterMethod(Method method) {
        System.out.printf("\t\t\tAfterMethod %s %s\n", getClass().getSimpleName(), method.getName());
    }

    @DataProvider(name = "testData")
    public Object[][] FuncData() {
        return new Object[][]{
                {10, 10, 10},
                {20, 20, 30},
                {20000, 20000, 20000},
                {200000, 200000, 200000},
                {1000000, 1000000, 1000000},
                {10000000, 1000, 1000},
        };
    }

    @DataProvider(name = "testDataTime")
    public Object[][] TimeData() {
        return new Object[][]{
                {10, 10, 10000},
                {20, 20, 30},
                {20000, 20000, 20000},
                {200000, 200000, 200000},
                {1000000, 1000000, 1000000},
                {10000000, 1000, 1000},
                {100000000, 1000, 1000},
                {1000000000, 1000, 1000},
        };
    }


    @Test(groups = {"perftest", "first-group"}, dataProvider = "testDataTime", priority = 1, threadPoolSize = 1, invocationCount = 2, timeOut = 10000)
    public void testArr1000Perf(int arr_size, int x, int expected_time, Method method) {
        BinarySearch bs = new BinarySearch();
        int[] arr = new int[arr_size + 1];
        for (int z = 0; z <= arr_size; z++) {
            arr[z] = z;
        }
        long start = System.nanoTime();
        bs.binarySearch(arr, 5);
        long end = System.nanoTime();
        long diff = end - start;
        System.out.println("\t\t\t\tResult: " + start + " " + end + " " + diff);
        Assert.assertTrue(diff < expected_time, "diff lower than expected");
    }


    @Test(groups = {"functest", "second-group"},dataProvider = "testData", description = "Functionality test")
    public void testArr1000Func(int arr_size, int x, int expected_element) {
        int[] arr = new int[arr_size + 1];
        for (int z = 0; z <= arr_size; z++) {
            arr[z] = z;
        }
        BinarySearch ob = new BinarySearch();
        int result = ob.binarySearch(arr, x);
        Assert.assertEquals(result, expected_element);
    }
}

