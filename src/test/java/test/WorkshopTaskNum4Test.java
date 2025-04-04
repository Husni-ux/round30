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

public class WorkshopTaskNum4Test {

    @Test
    public void verifyFourthDropDwnElement() {


        WebDriver driver = new FirefoxDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://duckduckgo.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchbox_input']")));

            searchBox.sendKeys("TestNG");

            WebDriverWait ddWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> optionList = ddWait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//div[contains(@class, 'searchbox_suggestions')]//li")
                    )
            );

            System.out.println("Total suggestions found: " + optionList.size());

            if (optionList.size() >= 4) {
                for (WebElement element : optionList) {

                    System.out.println(element.getText());
                }
            }


            if (optionList.size() > 3) {
                String fourthElement = optionList.get(3).getText();
                System.out.println("Fourth suggestion: " + fourthElement);

                Assert.assertEquals(fourthElement.toLowerCase(), "testng tutorial", "Fourth suggestion text did not match!");

                System.out.println("Test Passed: Verified that the fourth element is 'TestNG Tutorial'.");
            } else {
                System.out.println("Error: Less than 4 suggestions found.");
                Assert.fail("Less than 4 suggestions were found.");
            }
        } finally {
            driver.quit();
        }
    }
}
