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
    protected WebDriver driver;
    protected HomePage homePage;


    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        driver = getDriver(options);
        homePage = new HomePage(driver);
        homePage.navigate();
    }


    @AfterEach
    public void tearDown(){
            driver.quit();
    }




    //Singleton pattern
    private WebDriver getDriver(ChromeOptions options){
        if(driver == null){
            driver = new ChromeDriver(options);
            //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

}
