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

public class exercise_2b {
    public WebDriver driver=null;


   @BeforeMethod
    public void setup(){

        ChromeDriverManager.getInstance().arch32().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:3000/");    //This URL("http://localhost:3000/") needs to be pages URL.
       driver.manage().window().maximize();
    }

    @Test
    public void storeInMap(){
        HashMap<String, String> map=new HashMap<String, String>();
        List<WebElement> foods = driver.findElements(By.xpath(".//div/span[@class='title ng-binding']"));
        List<WebElement> servings = driver.findElements(By.xpath(".//div/span[@class='description ng-binding']"));

        for(int i = 0; i< foods.size(); i++) {
            map.put(foods.get(i).getText(), servings.get(i).getText());
        }
        for(Map.Entry<String,String> entryMap:map.entrySet()) {
            System.out.println(entryMap.getKey()+" "+ entryMap.getValue());
        }
    }
    @AfterMethod
    public void shutDown(){
        driver.close();
        driver.quit();

    }
}
