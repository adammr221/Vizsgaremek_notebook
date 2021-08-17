package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;


import java.util.concurrent.TimeUnit;

public class baseTest {
    protected static WebDriver driver;
    protected HomePage homePage;

    /*
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = getDriver(options);
        homePage = new HomePage(driver);
        homePage.navigate();
    }
     */
    @BeforeEach
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.navigate();
    }


    @AfterEach
    public void tearDown(){
            driver.quit();
    }


    //singleton pattern
    private static WebDriver getDriver(ChromeOptions options){
        if(driver == null){
            driver = new ChromeDriver(options);
            //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //driver.manage().window().maximize();
        }
        return driver;
    }

}
