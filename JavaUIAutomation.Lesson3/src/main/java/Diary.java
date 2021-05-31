import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Diary {

    public static void main(String[] args) {

        String login="Flvl";
        String password="GeekBrains92";
        Date date = new Date();


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement pageLogin = driver.findElement(By.xpath("//a[@href=\"https://diary.ru/user/login\"]"));
        pageLogin.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement loginTextInput= driver.findElement(By.name("LoginForm[username]"));
        loginTextInput.sendKeys(login);

        WebElement passwordTextInput= driver.findElement(By.name("LoginForm[password]"));
        passwordTextInput.sendKeys(password);

        WebElement reCaptcha = driver.findElement(By.className("recaptcha-checkbox-border"));
        reCaptcha.click();

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();



    }
}
