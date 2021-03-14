package AT_Cucumber;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public ChromeDriver driver;
    public WebDriverWait wait;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bin\\chromedriver.exe");
        MyStepdefs.driver=new ChromeDriver();
        MyStepdefs.wait=new WebDriverWait(MyStepdefs.driver, 10);
        MyStepdefs.driver.manage().window().maximize();
        MyStepdefs.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

     @After
    public void close() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyStepdefs.driver.close();
    }
}
