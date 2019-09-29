package Day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



/**
 * Created by Administrator on 2019/9/10 0010.
 */
public class OpenBrowser {

    WebDriver driver;
    @Test
    public void openfirefox()throws InterruptedException {

        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        Thread.sleep(5000);
        driver.get("http://192.168.1.176:8090/ranzhi/www/sys/user-login-L3JhbnpoaS93d3cvc3lzL215LXByb2plY3QuaHRtbA==.html");
        Thread.sleep(5000);

        driver.findElement(By.id("account")).sendKeys("qaz");
        Thread.sleep(1000);

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("123456");
        Thread.sleep(1000);

        WebElement submit=driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(5000);

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://192.168.1.176:8090/ranzhi/www/sys/my-project.html");
    }
    @Test
    public void openIE()throws InterruptedException{
        System.setProperty("webdriver.ie.driver", "D:\\workspace\\drivers\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        Thread.sleep(5000);
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
    }

    @AfterMethod
     public void closeB(){

        driver.quit();
        }


}
