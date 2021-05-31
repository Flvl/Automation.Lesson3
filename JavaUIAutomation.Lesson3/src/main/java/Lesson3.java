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

public class Lesson3 {
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

        WebElement menuProject=driver.findElement(By.xpath("//span[contains(.,'Проекты')]"));
        menuProject.click();

        WebElement menuMyProject=driver.findElement(By.xpath("//span[contains(.,'Мои проекты')]"));
        menuMyProject.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement buttonCreateProject=driver.findElement(By.linkText("Создать проект"));
        buttonCreateProject.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Date date = new Date();
        String NameProject="myProject"+date.getTime();
        WebElement inputNameProject=driver.findElement(By.name("crm_project[name]"));
        inputNameProject.click();
        inputNameProject.sendKeys(NameProject);

        WebElement nameOrganizationDropDown=driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]"));
        nameOrganizationDropDown.click();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //"//div[@id='select2-drop']/div[@class='select2-search']/input[@class='select2-input']"
        WebElement inputNameOrganization=driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[1]/div"));
        //WebElement inputNameOrganization=driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input]"));
        inputNameOrganization.click();

        Select businessUnitDropDown= new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitDropDown.selectByVisibleText("Research & Development");

        Select curatorDropDown= new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorDropDown.selectByValue("115");

        Select managerDropDown= new Select(driver.findElement(By.name("crm_project[manager]")));
        managerDropDown.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select rpDropDown= new Select(driver.findElement(By.name("crm_project[rp]")));
        rpDropDown.selectByVisibleText("Applanatest2 Applanatest2 Applanatest2");


        Select administratorDropDown= new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorDropDown.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");


        WebElement buttonSaveProject=driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]"));
        buttonSaveProject.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);





    }


}
