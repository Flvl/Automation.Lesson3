import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Lesson3Contact {

    public static void main(String[] args) {

        String crm_login="Applanatest1";
        String crm_Password="Student2020!";


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
        driver.manage().window().maximize();

        WebElement loginTextInput= driver.findElement(By.name("_username"));
        loginTextInput.sendKeys(crm_login);

        WebElement passwordTextInput= driver.findElement(By.name("_password"));
        passwordTextInput.sendKeys(crm_Password);

        WebElement buttonCreate = driver.findElement(By.name("_submit"));
        buttonCreate.click();

        WebElement menuProject=driver.findElement(By.xpath("//span[contains(.,'Контрагенты')]"));
        menuProject.click();

        WebElement menuMyProject=driver.findElement(By.xpath("//span[contains(.,'Контактные лица')]"));
        menuMyProject.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement buttonCreateProject=driver.findElement(By.linkText("Создать контактное лицо"));
        buttonCreateProject.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement inputLastName=driver.findElement(By.name("crm_contact[lastName]"));
        inputLastName.click();
        inputLastName.sendKeys("Иванов");

        WebElement inputFirstName=driver.findElement(By.name("crm_contact[firstName]"));
        inputFirstName.click();
        inputFirstName.sendKeys("Иван");

        WebElement nameOrganizationDropDown=driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]"));
        nameOrganizationDropDown.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement inputNameOrganization=driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[2]/div"));
        inputNameOrganization.click();

        WebElement inputJobTitle=driver.findElement(By.name("crm_contact[jobTitle]"));
        inputJobTitle.click();
        inputJobTitle.sendKeys("Инженер");


        WebElement buttonSaveProject=driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]"));
        buttonSaveProject.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);





    }
}
