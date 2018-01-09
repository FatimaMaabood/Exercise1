import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class exercise_2a {
    public WebDriver driver=null;


   @BeforeMethod
    public void setup(){

        ChromeDriverManager.getInstance().arch32().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //This URL("http://localhost:3000/") needs to be pages URL.
        driver.navigate().to("http://localhost:3000/");
        driver.manage().window().maximize();
    }


    @Test
    public void displayItem(){
        String thirdItem=driver.findElement(By.xpath(".//div/span[@class='title ng-binding'][3]")).getText();
        System.out.println(thirdItem);
        String fifthItem=driver.findElement(By.xpath(".//div/span[@class='title ng-binding'][5]")).getText();
        System.out.println(fifthItem);
    }

    @AfterMethod
    public void shutDown(){
        driver.close();
        driver.quit();

    }
}
