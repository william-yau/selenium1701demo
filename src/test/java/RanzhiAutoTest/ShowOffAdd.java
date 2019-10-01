package RanzhiAutoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Administrator on 2019/9/29 0029.
 */
public class ShowOffAdd {
    WebDriver driver;

    @BeforeTest
    public void OpenB()throws InterruptedException{
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        Thread.sleep(5000);
    }

    @Test
    public void A1_Login()throws InterruptedException{
        driver.get("http://demo.ranzhi.org/sys/index.php?m=user&f=login&referer=L3N5cy9pbmRleC5waHA=");
        Thread.sleep(5000);
//        driver.findElement(By.id("account")).sendKeys("qaz");
//        Thread.sleep(1000);
//        WebElement password=driver.findElement(By.id("password"));
//        password.sendKeys("123456");
//        Thread.sleep(1000);
        WebElement submit=driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(5000);
    }
    @Test
    public void A2_Accounting()throws InterruptedException{
        //+时间戳，用于执行相同脚本而用不同数据的方式，类似随机数
        String time=String.valueOf(System.currentTimeMillis()/10000);
        //点击[现金记账]
        driver.findElement(By.xpath(".//*[@id='s-menu-2']/button")).click();
        Thread.sleep(2000);
        //进入表单
        driver.switchTo().frame("iframe-2");
        Thread.sleep(1000);
        //点击【账户】
        driver.findElement(By.xpath(".//*[@id='mainNavbar']/ul/li[10]/a")).click();
        Thread.sleep(5000);
        //点击【添加账户】
        driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[1]/a[2]")).click();
        Thread.sleep(5000);
        //输入简称
        driver.findElement(By.id("abbr")).sendKeys(time);
        Thread.sleep(2000);
        //确定按钮
        driver.findElement(By.xpath(".//*[@id='submit']")).click();
        Thread.sleep(5000);
        }

    @AfterTest
    public void CloseB()throws InterruptedException{
        driver.quit();
    }


}
