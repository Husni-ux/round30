package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class WorkshopTasksNum2Test {

    @Test
    public void verifyDuckDuckGoLogo() {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://duckduckgo.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[2]/div[1]/header[1]/div[1]/section[1]/a[1]/img[1]")
            ));
            boolean isLogoFound = logo.isDisplayed();
            System.out.println("Is the logo found : " + isLogoFound);


            if (!isLogoFound) {
                throw new AssertionError("DuckDuckGo logo is not displayed!");
            }

            System.out.println("Success: DuckDuckGo logo is displayed.");

        } finally {

            driver.quit();
        }
    }
}

