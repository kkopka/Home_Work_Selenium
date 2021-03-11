package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



import java.util.ArrayList;
import java.util.List;

public class ResultSearchPage {
    private WebDriver driver;


    public ResultSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-marker='fieldset/d']//input[@type='checkbox']")
    private WebElement checkBox;
    @FindBy(xpath = "//button[@data-marker='search-filters/submit-button']")
    private WebElement buttonShow;
    private By namePrintersLocator = By.xpath("//h3[@itemprop='name']");
    private By pricePrintersLocator = By.xpath("//div[@class='iva-item-priceStep-2qRpg']");

    public void selectChexBox()  {
        if (!checkBox.isSelected()){
            WebElement element = driver.findElement(By.xpath("//div[@data-marker='fieldset/d']//input[@type='checkbox']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            driver.findElement(By.xpath("//div[@data-marker='fieldset/d']//label")).click();
        }
    }

    public void clickButtonShow() {
       buttonShow.click();
    }

    public void tuneFiltr() {
        List<WebElement> arrayList = new ArrayList<WebElement>();
        Select filtr = new Select(driver.findElement(By.xpath("//div[@class='index-content-2lnSO']//select[@class='select-select-3CHiM']")));
        arrayList = filtr.getOptions();
        for (WebElement parameter : arrayList) {
            if (parameter.getAttribute("text").equals("Дороже")) {
                parameter.click();
                break;
            }
        }
    }

    public void printPrinters() {
        List<WebElement> namePrint = driver.findElements(namePrintersLocator);
        List<WebElement> pricePrint = driver.findElements(pricePrintersLocator);
        for (int i = 0; i < 3; i++) {
            System.out.println("Название принтера: " + namePrint.get(i).getAttribute("innerText") + " , его стоимость: " + pricePrint.get(i).getAttribute("innerText"));
        }
    }

}
