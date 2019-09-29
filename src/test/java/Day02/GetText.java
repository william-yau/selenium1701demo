package Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/9/10 0010.
 */
public class GetText {
    @Test
    public void GetTextTest() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver driver=new FirefoxDriver();
        Thread.sleep(5000);
        driver.get("http://192.168.1.176:8090/ranzhi/www/sys/user-login-L3JhbnpoaS93d3cvc3lzL215LXByb2plY3QuaHRtbA==.html");
        Thread.sleep(5000);
        WebElement account=driver.findElement(By.id("account"));
        account.sendKeys("qaz");
        String text1= account.getText();
       // System.out.println("拿到的词语是："+text1);
        Assert.assertEquals(text1,"qaz");

    }
}
