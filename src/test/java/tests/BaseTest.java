package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void init() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass
    public void quit() {
        DriverSingleton.closeDriver();
    }
}
