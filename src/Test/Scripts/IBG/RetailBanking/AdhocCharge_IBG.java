package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdhocCharge_IBG extends BaseClass {

    @Test(groups = {"Inputter"})

    public void AdhocChargeFixedRate() throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Adhoc Charges");
        PageObject.childmenu_Link("With delivery (FIXED RATE) ", 2);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgname = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCOUNT","1004401839");
        PageObject.textinput_Locator("fieldName:CHARGE.DATE","20221230");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgname);
        PageObject.switchFrame(2);
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgname);
        PageObject.switchFrame(2);
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgname);
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:CHARGE.CCY","PKR");
        driver.findElement(By.xpath("//input[@id='fieldName:CHARGE.CODE:1']")).sendKeys("CCRS");
        driver.findElement(By.xpath(" //input[@id='fieldName:EXTRA.DETAILS:1']")).sendKeys("Testing");

        PageObject.commitDeal("AdhocChargeFixedRate");
        String txn = PageObject.getTxn();
        System.out.println(txn);
    }


    @Test(groups = {"Inputter"})
    public void AdhocChargeChangeableRate() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Adhoc Charges");
        PageObject.childmenu_Link("With delivery (CHANGEABLE RATE) ", 2);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCOUNT","1006632966");
        PageObject.textinput_Locator("fieldName:CHARGE.CCY","PKR");

        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        driver.findElement(By.xpath("//input[@id='fieldName:CHARGE.CODE:1']")).sendKeys("ASP");
        driver.findElement(By.xpath(" //input[@id='fieldName:EXTRA.DETAILS:1']")).sendKeys("Testing");

        PageObject.commitDeal("AdhocChargeChangeableRate");
        String txn = PageObject.getTxn();
        System.out.println(txn);
    }

    @Test(groups = {"Inputter"})
    public void ListAdhocChargeRequest() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Adhoc Charges");
        PageObject.childmenu_Link("List of ADHOC Charges ", 2);

        PageObject.switchToChildWindow();
        PageObject.find_Button();
    }

    @Test(groups = {"Inputter"})
    public void UnauthoriseListAdhocChargeRequest() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Adhoc Charges");
        PageObject.menu_Link("Unauthorise List for AC.Charge.Request ");

        PageObject.switchToChildWindow();
        PageObject.find_Button();
    }
}
