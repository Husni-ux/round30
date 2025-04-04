package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WorkshopTaskNum5Test {

    @Test
    public void verifyTask4Task() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://duckduckgo.com/");
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchbox_input']"))
            );

            searchBox.sendKeys("Cucumber IO");

//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='-1951744961']")));
            List<WebElement> resultLinks = driver.findElements(By.xpath("//div[contains(@class, 'searchbox_suggestions')]//li"));

            Assert.assertTrue(resultLinks.size() >= 2, "Less than 2 search results found.");

            String secondResultLink = resultLinks.get(1).getAttribute("href");
            System.out.println("Second result link: " + secondResultLink);

            Assert.assertTrue(secondResultLink.contains("https://www.linkedin.com"),
                    "Second result does not contain LinkedIn.");
        } finally {
            driver.quit();
        }

    }

}
