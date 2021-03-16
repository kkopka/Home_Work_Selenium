package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;


public class StartedPage {

    private WebDriver driver;

    private List<WebElement> arrayList = new ArrayList<WebElement>();

    public StartedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(" https://www.avito.ru/");
    }

    public WebElement category(String category) {
        Select select = new Select(driver.findElement(By.id("category")));
        arrayList = select.getOptions();
        WebElement choseCategory=null;
        for (WebElement webElement : arrayList) {
            if (webElement.getAttribute("text").equals(category)){
                choseCategory=webElement;
                break;
            }
        }

        return choseCategory;
    }
}
