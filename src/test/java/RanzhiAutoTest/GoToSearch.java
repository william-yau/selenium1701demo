package RanzhiAutoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Administrator on 2019/9/23 0023.
 */
public class GoToSearch {
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
        Thread.sleep(5000);
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
    public void A2_ContactsSearch()throws InterruptedException{

        //点击[客户管理]
        driver.findElement(By.xpath(".//*[@id='s-menu-1']/button")).click();
        Thread.sleep(5000);
        //实例化一个随机函数，要导入
        Random rdm = new Random();
        int rdm1=rdm.nextInt(29);
        //进入表单
        driver.switchTo().frame("iframe-1");
        Thread.sleep(1000);
        //点击【联系人】
        driver.findElement(By.xpath(".//*[@id='mainNavbar']/div[2]/ul/li[5]/a")).click();
        Thread.sleep(5000);
        //点击下级【搜索】
        driver.findElement(By.xpath(".//*[@id='bysearchTab']/a")).click();
        Thread.sleep(5000);
        //+时间戳，用于执行相同脚本而用不同数据的方式，类似随机数
        String time=String.valueOf(System.currentTimeMillis()/100);
        //点击搜索条件
        driver.findElement(By.xpath(".//*[@id='value4']")).sendKeys(time);
        Thread.sleep(5000);
        //点击【搜索】
        driver.findElement(By.xpath(".//*[@id='submit']")).click();
        Thread.sleep(5000);


    }


}
