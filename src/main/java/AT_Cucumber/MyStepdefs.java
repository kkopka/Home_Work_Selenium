package AT_Cucumber;

import Pages.Office_equipment;
import Pages.ResultSearchPage;
import Pages.StartedPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepdefs {
    public static WebDriver driver;
    public static WebDriverWait wait;
    StartedPage startedPage;
    Office_equipment office_equipment;
    ResultSearchPage resultSearchPage = new ResultSearchPage(driver);

    @Пусть("открыт ресурс авито")
    public void открытРесурсАвито() {
        startedPage = new StartedPage(driver);
        startedPage.openPage();
    }

    @ParameterType(".*")
    public WebElement category(String category) {
        return startedPage.category(category);
    }


    @И("в выпадающем списке категорий выбрана {category}")
    public void вВыпадающемСпискеКатегорийВыбранаОргтехника(WebElement category) {
        category.click();
    }

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
       // office_equipment.selectFirstCity();
        office_equipment.pressKeys("Enter");
    }

    @И("нажата кнопка показать объявления")
    public void нажатаКнопкаПоказатьОбъявления() {
        office_equipment.show();
    }

    @Тогда("открылась страница результаты по запросу принтер")
    public void открыласьСтраницаРезультатыПоЗапросуПринтер() {
        Assert.assertTrue(driver.getTitle().equals("принтер - Купить оргтехнику и расходники в Владивостоке с доставкой: принтер, сканер, МФУ, бумага | Недорогая электроника | Авито"));
    }

    @И("активирован чекбокс только с фотографией")
    public void активированЧекбоксТолькоСФотографией() {
        resultSearchPage.selectChexBox();
    }

    @ParameterType(".*")
    public WebElement filtr(String fitr) {
        return resultSearchPage.tuneFiltr(fitr);
    }

    @И("в выпадающем списке сортировка выбрано значение {filtr}")
    public void вВыпадающемСпискеСортировкаВыбраноЗначениеДороже(WebElement webElement) {
        webElement.click();
    }

    @И("в консоль выведено значение название и цены {int} первых товаров")
    public void вКонсольВыведеноЗначениеНазваниеИЦеныПервыхТоваров(int quantity) {
        resultSearchPage.printPrinters(quantity);
    }
}
