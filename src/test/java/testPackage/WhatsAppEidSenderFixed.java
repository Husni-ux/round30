import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WhatsAppEidSenderFixed {
    public static void main(String[] args) {
        // إعداد WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/mosa1/selenium-profile"); // تأكد من المسار الصحيح
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://web.whatsapp.com/");
            System.out.println("⏳ برجاء مسح QR أو التأكد من تسجيل الدخول...");

            // انتظار حتى يتم تسجيل الدخول من خلال ظهور شريط البحث
            new WebDriverWait(driver, Duration.ofSeconds(60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='بحث أو بدء دردشة جديدة']")));

            System.out.println("✅ تم تسجيل الدخول بنجاح!");

            // الانتظار حتى تظهر المحادثات
            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='grid']")));

            // جلب جميع المحادثات الظاهرة
            List<WebElement> contacts = driver.findElements(By.cssSelector("div[role='grid'] div[role='row']"));

            System.out.println("📩 عدد جهات الاتصال الظاهرة: " + contacts.size());

            int counter = 0;
            for (WebElement contact : contacts) {
                try {
                    // فتح المحادثة
                    contact.click();
                    Thread.sleep(3000); // الانتظار قليلاً حتى تفتح المحادثة

                    // انتظار اسم جهة الاتصال
                    WebElement nameElement = new WebDriverWait(driver, Duration.ofSeconds(15))
                            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='conversation-info-header']//span[@title]")));

                    String contactName = nameElement.getAttribute("title");
                    System.out.println("🔁 إرسال رسالة إلى: " + contactName);

                    // إرسال الرسالة
                    WebElement messageBox = driver.findElement(By.xpath("//div[@contenteditable='true' and @data-tab='10']"));
                    messageBox.sendKeys("🌙 Eid Mubarak! كل عام وأنت بخير 🌙");

                    // زر الإرسال
                    WebElement sendButton = driver.findElement(By.xpath("//button[@aria-label='إرسال']"));
                    sendButton.click();

                    System.out.println("✅ تم الإرسال إلى: " + contactName);
                    counter++;

                    // وقت انتظار بين الرسائل (اختياري لتجنب الحظر)
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("❌ فشل في الإرسال إلى جهة اتصال. الخطأ: " + e.getMessage());
                }
            }

            System.out.println("🎉 انتهى الإرسال! تم إرسال الرسائل لـ: " + counter + " جهة اتصال.");

        } catch (Exception e) {
            System.out.println("❌ حدث خطأ أثناء إرسال الرسائل.");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
