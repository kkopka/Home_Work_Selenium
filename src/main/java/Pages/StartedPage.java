package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

public class StartedPage {
    private WebDriver driver;
    private List<WebElement> arrayList = new ArrayList<WebElement>();
    public StartedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOfficeEquiprnent() {
        Select select = new Select(driver.findElement(By.id("category")));
        arrayList = select.getOptions();
        for (WebElement webElement : arrayList) {
            if (webElement.getAttribute("text").equals("Оргтехника и расходники")){
                webElement.click();
                break;
            }
        }
    }
}
