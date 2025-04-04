package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WorkshopTaskNum6Test {

    @Test
    public void VerifiedCheckBox() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("http://the-internet.herokuapp.com/checkboxes");


//            List<WebElement> checkboxes = driver.findElements(By.cssSelector("//form[@id='checkboxes']"));

            WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
            WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));
            if (!checkbox1.isSelected()) {
                checkbox1.click();
            }

            if(checkbox2.isSelected()){
                System.out.println("selected ");
            }



            Assert.assertTrue(checkbox1.isSelected(), "Checkbox 1 should be checked.");
            Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 should be checked.");

            System.out.println("Both checkboxes are checked.");

        } finally {
         //   driver.quit();
        }
    }
}
