package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

public class Office_equipment {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<WebElement> arrayList = new ArrayList<WebElement>();

    public Office_equipment(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='main-locationWrapper-3C0pT']")
    private WebElement choseCity;

    @FindBy(xpath = "//input[@data-marker='popup-location/region/input']")
    private WebElement writeField;

    @FindBy(xpath = "//ul[@class='suggest-suggests-bMAdj']//li[@data-marker]")
    private WebElement city;

    @FindBy(xpath = "//button[@data-marker='popup-location/save-button']")
    private WebElement buttonShow;

    By buttonShowLocarot = By.xpath("//button[@data-marker='popup-location/save-button']");


    public void writePrinter(String search) {
        searchField.sendKeys(search);
    }

    public void clickChoseCity() {
        choseCity.click();
    }

    public void writeField(String city) {
        writeField.sendKeys(city);
    }

    public void selectFirstCity() {
        city.click();
    }

    public void show() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonShowLocarot));
        buttonShow.click();
    }

    public void pressKeys(String key) {
        switch (key) {
            case "Enter" :
                writeField.sendKeys(Keys.ENTER);
                break;
        }

    }

}
