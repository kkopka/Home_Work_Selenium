package AT_Cucumber;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {



    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        MyStepdefs.driver=new ChromeDriver();
        MyStepdefs.wait=new WebDriverWait(MyStepdefs.driver, 10);
        MyStepdefs.driver.manage().window().maximize();
        MyStepdefs.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }



   @After
    public void close() {
        MyStepdefs.driver.close();
    }
}