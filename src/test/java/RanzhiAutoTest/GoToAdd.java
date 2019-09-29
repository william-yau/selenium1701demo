package RanzhiAutoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/9/27 0027.
 */
public class GoToAdd {
    WebDriver driver;

    @BeforeTest
    public void OpenB()throws InterruptedException{
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        Thread.sleep(5000);
    }

    @Test
    public void A1_Login()throws InterruptedException{

        driver.get("http://192.168.1.176:8090/ranzhi/www/sys/user-login-L3JhbnpoaS93d3cvc3lzL215LXByb2plY3QuaHRtbA==.html");
        Thread.sleep(3000);
        driver.findElement(By.id("account")).sendKeys("qaz");
        Thread.sleep(1000);
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("123456");
        Thread.sleep(1000);
        WebElement submit=driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(5000);
    }
    @Test
    public  void A2_edit()throws InterruptedException{


        //进入客户管理
        driver.findElement(By.xpath(".//*[@id='s-menu-1']/button")).click();
        driver.switchTo().frame("iframe-1");
        Thread.sleep(3000);
        //点击联系人
        driver.findElement(By.xpath(".//*[@id='mainNavbar']/div[2]/ul/li[5]/a")).click();
        Thread.sleep(5000);





    }
}
