package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WorkshopTasksNum3Test {
                                                                                                                                                                                                                                                                                                         @Test
    public void verifyFirstSearchResult() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://duckduckgo.com/");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchbox_input']")));


            searchBox.sendKeys("Selenium WebDriver");


            driver.findElement(By.xpath("//button[@aria-label='Search']")).click();


            WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.selenium.dev/documentation/webdriver/']//span[normalize-space()='WebDriver - Selenium']")));

            linkElement.click();


            String firstResultUrl = driver.getCurrentUrl();


            String expectedUrl = "https://www.selenium.dev/documentation/webdriver/";
            Assert.assertEquals(firstResultUrl, expectedUrl, "The link's URL does not match the expected URL!");

            System.out.println("The link result is found and matches the expectation: " + firstResultUrl);
        } finally {
            driver.quit();
        }

    }
}
