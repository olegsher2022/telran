![programming.png](src%2Fprogramming.png)


### [Lesson 13: Lombok, continue coding]()

[Project Lombok](https://projectlombok.org/)


* add dependencies to build.gradle
```java
dependencies {
    implementation 'org.testng:testng:7.4.0'
    implementation 'org.seleniumhq.selenium:selenium-java:4.12.0'
    implementation 'io.qameta.allure:allure-testng:2.14.0'
    implementation 'io.github.bonigarcia:webdrivermanager:5.3.2'
        // added new dependencies
    compileOnly 'org.projectlombok:lombok:1.18.28'
    annotationProcessor 'org.projectlombok:lombok:1.18.28'

    testCompileOnly 'org.projectlombok:lombok:1.18.28'
    testAnnotationProcessor 'org.projectlombok:lombok:1.18.28'
```


* Automatic constructors getters, setters etc by lombok
```java
package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserDTOLombok {

    String name;
    String lastName;
    String email;
    String password;

}
```

* What is JavaScriptExecutor?
<br>JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. JavaScriptExecutor provides two methods “executescript” & “executeAsyncScript” to run javascript on the selected window or current page.
<br>[JavaScriptExecutor in Selenium with Example
](https://www.guru99.com/execute-javascript-selenium-webdriver.html)


* Actions
To test an application, one needs to perform a number of user actions on it. To perform any operations on the web application such as double-click, selecting drop-down boxes, etc. the actions class is required
<br>[How to handle Action class in Selenium](https://www.browserstack.com/guide/action-class-in-selenium)

* BaseHelper
```java
    public void jsClickBase(String locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(locator);
    }

    public void clickByXY(By locator, int down, int right) {  // 10  12
        Rectangle rect = findElementBase(locator).getRect();
        int x = rect.getX() + rect.getWidth() / 8;
        int y = rect.getY() + rect.getHeight() / 2;
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).click().perform();
    }
```
* HomeWork for lesson 13:
* - TODO in the project PhoneBook:
* - - Add & Run  registration tests (userDTO, userDTOWith, userDTOLombok)
* - - Research and add code to connect [ConfigReader.java](src%2Ftest%2Fjava%2Futils%2FConfigReader.java) to [UserHelper.java](src%2Ftest%2Fjava%2Fmanager%2FUserHelper.java)



### [Lesson 12: Test Architecture]()

- Lecture [Recording ](https://tel-ran.zoom.us/rec/play/zjkDJciY93s0M8l7ytuA6Yfq8Yv6AbmFc0h4Xgjv5-A8ig-NlqhAiI9VCtddIlI-FHmjimqqHW3Q7wRc.AFPic0G24JLcvK6P)
- Discussions: [Slack Channel Lesson 12](https://app.slack.com/client/T05E2JDKN5D/C06620CFWDB)

* Our Applications [ilCarro](https://ilcarro.web.app/) [PhoneBook](https://telranedu.web.app/home)
* Helpers [ChatGPT](https://chat.openai.com/) | [Bard](https://bard.google.com/chat) | [stackoverflow.com](https://stackoverflow.com/)

* Check HomeWork


* Refactoring for scale...


![H5_B2MXs.png](src%2FH5_B2MXs.png)

Create class ApplicationManager in package "manager" and offload startUp and tearDown functions
<br>Driver per browser/database/server etc... added to @BeforeSuite
![H5_B2MXs (1).png](src%2FH5_B2MXs%20%281%29.png)
![H5_B2MXs (2).png](src%2FH5_B2MXs%20%282%29.png)
![H5_B2MXs (3).png](src%2FH5_B2MXs%20%283%29.png)

Ctrl-Alt-Shift-U - create UML diagram
![classes.png](src%2Fclasses.png)
![class-diagram-1.png](src%2Fclass-diagram-1.png)
![classes-diagram-2.png](src%2Fclasses-diagram-2.png)
![classes-diagram-3.png](src%2Fclasses-diagram-3.png)



* add package manager to src/test/java 
* - add class ApplicationManager.java
- add class BaseHelper.java
* add package tests to src/test/java
* add package dto to src/test/java

in ApplicationManager.java define global init and teardown functions:
```java
    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public void tearDown() {driver.quit();
    }
```

in BaseTest.java define object from ApplicationManager class and add @BeforeSuite and @AfterSuite:
```java
    static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setup(){
        app.init();
    }
    @AfterSuite
    public void stop(){
        app.tearDown();
    }
```

in BaseHelper redefine:
```java
    private WebElement findElementBase(By locator){
        return driver.findElement(locator);
    }
    
    private List<WebElement> findElementsBase(By locator){
        return driver.findElements(locator);
    }
```



* HomeWork for lesson 12:
* - TODO in the project PhoneBook:
* - - Create folder manager and there: class ApplicationManager, BaseHelper, UserHelper and fill the, like on the lesson
* - - Create folder tests and add there LoginTests and BaseTests and connect them with the applicationManager and Helpers, like on the lesson
* - - Create folder DTO and add there to types for objects – object and object with, like on the lesson, and create for both objects tests positiveLogin
* - - Run tests login (one run for test with userDto and one for test with userDTOWith)


### [Lesson 11: TestNG Overview](src/main/java/lesson_11)

- [Record](https://tel-ran.zoom.us/rec/share/H1elh1pE055rvkkV-mfX5QVRaapG2Zy7oMt2GEd_I9i8ELwAWDCFkvDKmwpjYWEJ.v7xCHjHqN2thQBen?startTime=1700150418000)
- [TestNG Home site](https://testng.org/doc/)
- [Selenium and TestNG](https://testng.org/doc/selenium.html)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- Additional info: [Course TestNG by QA Automation и SDET](https://www.youtube.com/watch?v=xx0CYt03_bc&list=PLABk5HoxRaQIk89RgVhlaP3v7r21jJ4Qg)
- Discussions: [Slack Channel Lesson 11](https://app.slack.com/client/T05E2JDKN5D/C065HDQ69ST)

* Our Applications [ilCarro](https://ilcarro.web.app/) [PhoneBook](https://telranedu.web.app/home)
* Helpers [ChatGPT](https://chat.openai.com/) | [Bard](https://bard.google.com/chat) | [stackoverflow.com](https://stackoverflow.com/)


* Basics of TestNG
* - Data Driven
* - Annotations
* - Attributes


* Steps to create and run tests:
* - Write the business logic of your test and insert TestNG annotations in your code.
* - Add the information about your test (e.g. the class name, the groups you wish to run, etc...) in a testng.xml file or in build.xml.
* - Run TestNG.

____
* TestNG Annotations
<br>Аннотация — это метка, которая предоставляет дополнительную информацию о классе
или методе Для аннотаций используется префикс «@». TestNG использует аннотации,
чтобы помочь в создании надeжной структуры тестов.<br>

![hierarchy-of-testng-annotations.jpg](src%2Fhierarchy-of-testng-annotations.jpg)
* __<span style="color:red">@BeforeSuite</span>__: аннотированный метод будет запущен до того, как будут
запущены все тесты в этом наборе.
* __<span style="color:red">@AfterSuite</span>__: аннотированный метод будет запущен после выполнения всех
тестов в этом наборе.
* __<span style="color:red">@BeforeClass</span>__ : аннотированный метод будет запущен до вызова первого
тестового метода в текущем классе.
* __<span style="color:red">@AfterClass</span>__ : аннотированный метод будет запущен после того, как будут
запущены все методы тестирования в текущем классе.
* __<span style="color:red">@BeforeMethod</span>__ : аннотированный метод будет запускаться перед каждым
тестовым методом.
* __<span style="color:red">@AfterMethod</span>__ : аннотированный метод будет запускаться после каждого
метода тестирования.
* __<span style="color:red">@BeforeTest</span>__ : аннотированный метод будет запущен до запуска любого
тестового метода, принадлежащего классам внутри тега <test>.
* __<span style="color:red">@AfterTest</span>__ : аннотированный метод будет запущен после того, как будут
запущены все методы тестирования, принадлежащие классам внутри тега
<test>.
* __<span style="color:red">@BeforeGroups</span>__ : список групп, которые этот метод конфигурации будет
запускать раньше. Этот метод гарантированно запускается незадолго до
вызова первого тестового метода, принадлежащего любой из этих групп.
* __<span style="color:red">@AfterGroups</span>__: список групп, после которых будет выполняться этот метод
настройки. Этот метод гарантированно запускается вскоре после вызова
последнего тестового метода, принадлежащего любой из этих групп.


___
* TestNG Attributes

![testng-annotation-attributes.png](src%2Ftestng-annotation-attributes.png)

* __<span style="color:red">description</span>__: можно указать описание тестового метода.
<br>Например, @Test(description=”этот тест проверяет вход в систему”). <hr>

* __<span style="color:red">alwaysRun</span>__: этот атрибут гарантирует, что тестовый метод будет выполнен всегда,
даже в случае падения тестов, от которых он зависит. Когда значение атрибута true,
этот метод будет запускаться всегда. <br>Например, @Test(alwaysRun= true). <hr>

* __<span style="color:red">dataProvider</span>__: задаёт имя поставщика данных (data provider) для метода.
Предположим, что вы собираетесь запускать свои тесты в нескольких браузерах,
тогда в тестовом методе с атрибутом dataProvider, можно добавить параметры для
браузера и его версии. В этом случае тест, содержащий этот атрибут, будет
использовать эти входные данные для запуска тестов в нескольких браузерах.
<br>Например, @Test(dataProvider=”cross-browser-testing”). <hr>

* __<span style="color:red">dependsOnMethods</span>__: предоставляет информацию о порядке выполнения тестов. Тест
с этим атрибутом будет выполнен, только если успешно выполниться тест, от
которого он зависит. Если тест, от которого зависит метод, падает, то тест не
запускается. <br>Например, @Test (depenOnmethod = “login”). <hr>


* __<span style="color:red">groups</span>__: помогает сгруппировать ваши тестовые методы, ориентированные на одну
функциональность, в одну группу.
<br>Например, @Test(groups={”Payment_Module”}).
Этот атрибут также позволяет управлять тем, какие тесты запускать. При запуске тестов
можно игнорировать какие-то группы или, наоборот, запустить только некоторые группы.
Тут нужно указать нужные группы в файле TestNG.xml. В теге include указать группы,
которые необходимо запустить, а в теге exclude, которые надо игнорировать. <hr>

* __<span style="color:red">priority</span>__: помогает определить приоритет тестовых методов. Когда TestNG выполняет
тестовые методы, он может делать это в произвольном порядке. В сценарии, где вы
хотите, чтобы ваши тесты выполнялись в нужном порядке, вы можете использовать
атрибут priority. Приоритет по умолчанию для всех тестовых методов равен 0. Сначала
выполняются тесты с меньшим значением priority.
<br>Например, @Test (priority = 1), @Test (priority = 2). В этом случае сначала будет выполнен
тест с приоритетом, равным единице, а потом тест с приоритетом два.TestNG атрибуты
 <hr>

* __<span style="color:red">enabled</span>__: этот атрибут используется, когда вам нужно игнорировать и не запускать
определённый тест. Всё, что вам нужно сделать, это установить его в false.
<br>Например, @Test(enabled= false). <hr>

* __<span style="color:red">timeout</span>__: определяет время, за которое должен выполниться тест. Если выполнение
теста превышает время, определённое атрибутом, то тест завершится с ошибкой с
выбросом исключения org.testng.internal.thread.ThreadTimeoutException. <br>Например,
@Test(timeOut= 500). Обратите внимание, что время указывается в миллисекундах.
 <hr>

* __<span style="color:red">invocationCount</span>__: работает точно так же, как цикл. Тест будет запущен столько раз,
сколько указано в invocationCount. <br>Например, @Test(invocationCount = 5), будет
запущен 5 раз.TestNG атрибуты <hr>

* __<span style="color:red">invocationTimeOut</span>__: используется вместе с вышеуказанным атрибутом
invocationCount. Значение этого атрибута вместе с invocationCount указывает на то,
что тест будет запущен столько раз, сколько указано в invocationCount, и в течение
времени, указанного в атрибуте invocationTimeOut.
<br>Например, @Test(invocationCount = 5, invocationTimeOut = 20). <hr>

* __<span style="color:red">expectedExceptions</span>__: помогает обрабатывать исключения, выброс которых ожидается
в тестовом методе. Если исключение, указанное в атрибуте, выброшено тестовым
методом, то тест прошёл успешно. В противном случае, отсутствие исключения или
выброс другого исключения, не указанного в атрибуте, провалит тест.
<br>Например: <br>_@Test(expectedExceptions = {ArithmeticException.class })_. <hr>


* DataProviders
```java
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Test;
```
```java
    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][] {
            {"username1", "password1"},
            {"username2", "password2"},
            {"username3", "password3"}
        };
    }
```
```java
    @Test(dataProvider = "testData")
    public void loginTest(String username, String password) {
        System.out.println("Logging in with username: " + username + ", password: " + password);
        // Your test logic goes here
    }
```

* Some commonly used assertion methods in TestNG
* - Assert.assertTrue
```java
    int result = 2 + 2;
    Assert.assertTrue(result == 4, "Expected result to be 4, but found " + result);
```

* - assertFalse
```java
    int result = 2 + 2;
    Assert.assertFalse(condition, message);
```

* - assertEquals
```java
    int result = 2 + 2;
    Assert.assertEquals(result, 4, "Expected result to be 4, but found " + result);
```




Запись в build.gradle для запуска из разных Xml
```
task reg(type: Test){
    useTestNG {
    def suite = System.getProperty('suite', '')
        if (suite.equals('quick')) {
            suites 'src/test/resources/quick.xml'
        } else if (suite.equals('smoke')) {
            suites 'src/test/resources/smoke.xml'
        } else {
            suites 'src/test/resources/testng.xml'
        }
        if (project.hasProperty('browser')) {
            systemProperty 'browser', "${browser}"
        }
    }
}
```

* Parallel tests
```java
    @Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
```

* Графический результат можно найти в папке <br>
build->reports->tests->reg->index.html

* Example

BinarySearch Algorithm

![BinarySearch Algorithm](src%2F1_0OJ3eF9eO3FlPl5A_RtCSw.png)
```java
public class BinarySearch {
    public int binarySearch(int[] arr, int x)
	{
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;

			// Check if x is present at mid
			if (arr[m] == x)
				return m;

			// If x greater, ignore left half
			if (arr[m] < x)
				l = m + 1;

			// If x is smaller, ignore right half
			else
				r = m - 1;
		}

		// If we reach here, then element was
		// not present
		return -1;
	}
```

Test:
```java
@Test(groups = {"perftest", "checkintest"}, dataProvider = "testDataTime", priority = 1, threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
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
    System.out.println(start + " " + end + " " + diff);
    Assert.assertTrue(diff < expected_time, "diff lower than expected");
    }
}
```

```java

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
```

* HomeWork:
* - Refactor code [SeleniumXpathIcarro.java](src%2Ftest%2Fjava%2Flesson_11%2FSeleniumXpathIcarro.java) and [SeleniumCssIcarro.java](src%2Ftest%2Fjava%2Flesson_11%2FSeleniumCssIcarro.java) using @Test and Asserts 
* - Write code [SeleniumXpathPhoneBook.java](src%2Ftest%2Fjava%2Flesson_11%2FSeleniumXpathPhoneBook.java)
* - Fix errors in [LoginTests.java](src%2Ftest%2Fjava%2Flesson_11%2FLoginTests.java)
- commit and Pull Request for review (All questions and discussions here, try team work for solving issues: [Slack Channel Lesson 11](https://app.slack.com/client/T05E2JDKN5D/C065HDQ69ST))