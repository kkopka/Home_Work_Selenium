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

    @FindBy(xpath = "//input[@name='withImagesOnly']")
    private WebElement checkBox;
    @FindBy(xpath = "//button[@data-marker='search-filters/submit-button']")
    private WebElement buttonShow;
    private By namePrintersLocator = By.xpath("//h3[@itemprop='name']");
    private By pricePrintersLocator = By.xpath("//div[@class='iva-item-priceStep-2qRpg']");

    public void selectChexBox()  {
        if (!checkBox.isSelected()){
            driver.findElement(By.xpath("//label[@class='checkbox-checkbox-7igZ6 checkbox-size-s-yHrZq']")).click();
        }
    }

    public void clickButtonShow() {
       buttonShow.click();
    }

    public WebElement tuneFiltr(String filtrName) {
        List<WebElement> arrayList = new ArrayList<WebElement>();
        Select filtr = new Select(driver.findElement(By.xpath("//div[@class='index-content-2lnSO']//select[@class='select-select-3CHiM']")));
        arrayList = filtr.getOptions();
        WebElement filtrButton=null;
        for (WebElement parameter : arrayList) {
            if (parameter.getAttribute("text").equals("Дороже")) {
                filtrButton=parameter;
                break;
            }
        }
        return filtrButton;
    }

    public void printPrinters(int quantity ) {
        List<WebElement> namePrint = driver.findElements(namePrintersLocator);
        List<WebElement> pricePrint = driver.findElements(pricePrintersLocator);
        for (int i = 0; i < quantity; i++) {
            System.out.println("Название товара: " + namePrint.get(i).getAttribute("innerText") + " , его стоимость: " + pricePrint.get(i).getAttribute("innerText"));
        }
    }

}
