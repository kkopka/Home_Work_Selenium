import Pages.Office_equipment;
import Pages.ResultSearchPage;
import Pages.StartedPage;
import org.junit.Test;

public class TestStart extends WebDriverSettings {
    @Test
    public void PositiveTest() {
        StartedPage startedPage = new StartedPage(driver);
        startedPage.clickOfficeEquiprnent();
        startedPage.clickOfficeEquiprnent();
        Office_equipment equipments = new Office_equipment(driver);
        equipments.writePrinter("Принтер");
        equipments.clickChoseCity();
        equipments.writeField("Владивосток");
        equipments.selectFirstCity();
        equipments.Show();
        ResultSearchPage searchPage = new ResultSearchPage(driver);
        searchPage.selectChexBox();
        searchPage.clickButtonShow();
        searchPage.tuneFiltr();
        searchPage.printPrinters();
    }
}
