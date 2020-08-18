package Clicktrans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class JuniorTaskCT {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\48604\\Desktop\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev-1.clicktrans.pl/register-test/courier");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        By companyName = By.xpath("//*[@id=\"user_register_company_name\"]");
        By email = By.xpath("//*[@id=\"user_register_email\"]");
        By name = By.xpath("//*[@id=\"user_register_name\"]");
        By phone = By.xpath("//*[@id=\"user_register_phone\"]");
        By passwd = By.xpath("//*[@id=\"user_register_plainPassword\"]");
        By agreeRegulations = By.xpath("//*[@id=\"user_register_settings_agreementRegulations\"]");
        By agreePersonalData = By.xpath("//*[@id=\"user_register_settings_agreementPersonalData\"]");
        By submit = By.xpath("//*[@id=\"user_register_submit\"]");
        By message = By.xpath("/html/body/div[6]/div");

        driver.findElement(companyName).sendKeys("Testowy Przewoźnik sp. z o.o.");
        driver.findElement(email).sendKeys("przewoznik.testowy@yopmail.com");
        driver.findElement(name).sendKeys("Andrzej Testerski");
        driver.findElement(phone).sendKeys("657898123");
        driver.findElement(passwd).sendKeys("MySecretPass123");
        driver.findElement(agreeRegulations).click();
        driver.findElement(agreePersonalData).click();
        driver.findElement(submit).click();

        try {
            Assert.assertEquals(driver.findElement(message).getText(), "OK - some registration logic is mocked");
        } catch (AssertionError e) {
            System.out.println("Registration failed due to error.");
            throw e;
        }
        System.out.println("Registration successful.");

        driver.quit();
    }
}
