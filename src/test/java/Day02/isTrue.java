package Day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2019/9/12 0012.
 */
public class isTrue {
    WebDriver driver;

    @BeforeMethod
    public void openFirefox() throws InterruptedException {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        Thread.sleep(5000);
    }
    @Test
    public void isDisplayTest(){
        driver.get("https://www.baidu.com");
        //判断元素是否显示
        Boolean bd = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(bd);
    }

    @Test
    public void isSelected() {

        driver.get("file:///D:/index.html");
        // Boolean a= driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]")).isSelected();
        //Assert.assertTrue(a);
        WebElement b = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        b.click();
        //获取是否被选中
        Boolean c = b.isSelected();
        Assert.assertTrue(c);
    }

    @Test
    public void CatchPic() throws IOException {
        driver.get("file:///D:/index.html");

        File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D:\\TestPic01.png"));
        //关闭浏览器
        driver.quit();
        }


}
