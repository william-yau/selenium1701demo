package Day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/9/16 0016.
 */
public class WaitingYou {
    WebDriver driver;

    @BeforeMethod
    public void openFirefox() throws InterruptedException {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        Thread.sleep(5000);

    }

    @Test
    public void WaitTestA()throws InterruptedException{
        driver.get("file:///D:/selenium_html/index.html");
        //点击Wait按钮
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //全局等待，（超时时间，时间单位）
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //获取到 wait按钮的返回值
        String display=driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();

        Assert.assertEquals(display,"wait for display");
        Thread.sleep(5000);
    }

    @Test
    public void WaitTestB()throws InterruptedException{
        driver.get("file:///D:/selenium_html/index.html");
        //点击Wait按钮
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //显示等待，实例化这个类（driver，时间）
        WebDriverWait wait=new WebDriverWait(driver,10);//（）要传入参数
        //使用wait对象下的方法（导入的类、下的方法）
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));//（）入参：定位方式
        String display=driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(display,"wait for display");

    }

}
