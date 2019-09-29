package Day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/9/12 0012.
 */
public class PopupWindow {
    WebDriver driver;

    @BeforeMethod
    public void openFirefox() throws InterruptedException {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        Thread.sleep(5000);
    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///D:/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(1000);
        Alert alert1 =driver.switchTo().alert();
        alert1.accept();
    }

}
