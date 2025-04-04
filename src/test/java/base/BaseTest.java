package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import drivers.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    public static String selectedBrowser = "chrome"; // default browser

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver(selectedBrowser);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
