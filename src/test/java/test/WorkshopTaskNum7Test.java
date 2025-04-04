package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WorkshopTaskNum7Test {

    @Test
    public void VerifiedCompanyCountry() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.w3schools.com/html/html_tables.asp");

            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));

            String colF = "//table[@id='customers']//tr[";
            String colL = "]//td";
            String column;
            List<WebElement> tableColumns;

            boolean found = false;
            for (int i = 1; i <= rows.size(); i++) {
                column = colF + i + colL;
                tableColumns = driver.findElements(By.xpath(column));

                if(tableColumns.size()==3){
                    String company = tableColumns.get(0).getText().trim();
                    String country = tableColumns.get(2).getText().trim();

                    if(company.equals("Ernst Handel")){
                        System.out.println("Found Company  " + company + ", Country:  " +country);
                        Assert.assertEquals(country, "Austria", " Country does not match!");
                        found =true;
                        break;
                    }
                }

            }
            if(!found){
                Assert.fail("Company ' Ernst Handel' Was not found in the table. ");
            }
        } finally {
         //   driver.quit();
        }
    }
}
