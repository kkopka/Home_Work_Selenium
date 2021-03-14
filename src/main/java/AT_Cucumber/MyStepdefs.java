package AT_Cucumber;
import Enums.Categories;
import Pages.Office_equipment;
import Pages.ResultSearchPage;
import Pages.StartedPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;


public class MyStepdefs {
    public static WebDriver driver;
    public static WebDriverWait wait;
    StartedPage startedPage;
    Office_equipment office_equipment;
    ResultSearchPage resultSearchPage = new ResultSearchPage(driver);

    @AfterStep
    public void screenshot(){
        Allure.addAttachment("Скришот",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }


    @Пусть("открыт ресурс авито")
    public void открытРесурсАвито() {
        startedPage = new StartedPage(driver);
        startedPage.openPage();
    }

    @ParameterType(".*")
    public WebElement category(String category) {
        return startedPage.category(Categories.valueOf(category).getValue());
    }


    @И("в выпадающем списке категорий выбрана {category}")
    public void вВыпадающемСпискеКатегорийВыбранаОргтехника(WebElement category) {
        category.click();
    }

    @Step("Вводим значение в поле поиска {name}")
    @И("в поле поиска введено значение {string}")
    public void вПолеПоискаВведеноЗначениеПринтер(String name) {
        office_equipment = new Office_equipment(driver, wait);
        office_equipment.writePrinter(name);
    }



    @Тогда("кликнуть по выпадающему списку региона")
    public void кликнутьПоВыпадающемуСпискуРегиона() {
        office_equipment.clickChoseCity();
    }


    @Тогда("в поле регион введено значение {string}")
    public void вПолеРегионВведеноЗначениеВладивосток(String city) {
        office_equipment.writeField(city);
    }


    @И("нажата кнопка показать объявления")
    public void нажатаКнопкаПоказатьОбъявления() throws InterruptedException {
        Thread.sleep(500);
        office_equipment.show();
    }


    @Тогда("открылась страница результаты по запросу принтер")
    public void открыласьСтраницаРезультатыПоЗапросуПринтер() {
        System.out.println(driver.getTitle());
    }

    @Step("Активировали чебокс только с фотографией")
    @И("активирован чекбокс только с фотографией")
    public void активированЧекбоксТолькоСФотографией() throws InterruptedException {
        resultSearchPage.selectChexBox();
    }

    @ParameterType(".*")
    public WebElement filtr(String fitr) {
        return resultSearchPage.tuneFiltr(Categories.valueOf(fitr).getValue());
    }


    @И("в выпадающем списке сортировка выбрано значение {filtr}")
    public void  вВыпадающемСпискеСортировкаВыбраноЗначениеДороже(WebElement webElement) {
        webElement.click();
    }

    @И("в консоль выведено значение название и цены {string} первых товаров")
    public void вКонсольВыведеноЗначениеНазваниеИЦеныПервыхТоваров(String quantity) {
        resultSearchPage.printPrinters(Integer.parseInt(quantity));
    }


    @И("нажать на кнопку показать объявления")
    public void нажатьНаКнопкуПоказатьОбъявления() {
        resultSearchPage.clickButtonShow();
    }
}
