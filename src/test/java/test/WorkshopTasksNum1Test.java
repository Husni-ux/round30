package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkshopTasksNum1Test {

    @Test
    public void verifyDuckDuckGoTitle() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://duckduckgo.com/");
        String actualTitle = driver.getTitle();
        System.out.println("Page title: " + actualTitle);

        String expectedTitle = "Google"; // As per the question
        assertEquals(actualTitle, expectedTitle); // This will fail intentionally

        driver.quit();
    }
}
