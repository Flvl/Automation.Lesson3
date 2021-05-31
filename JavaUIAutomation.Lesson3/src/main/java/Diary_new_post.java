import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Diary_new_post {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");
       // options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement pageLogin = driver.findElement(By.xpath("//a[@href=\"https://flvl.diary.ru/?newpost\"]"));
        pageLogin.click();

        WebElement titleInput= driver.findElement(By.id("postTitle"));
        titleInput.sendKeys("Тест");

        WebElement msgInput= driver.findElement(By.id("tinymce"));
        msgInput.sendKeys("Тест");

        WebElement rewriteButton= driver.findElement(By.id("rewrite"));
        rewriteButton.click();

    }
}
