package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class FeeCollection_IBG extends BaseClass {

    @Test(groups = {"Inputter"})
    public void FeeCollectionAgainstAccount_IBG() throws IOException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Fee Collection - Against Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgname = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:INSTITUTE", "5.0031");
        PageObject.click_Locator("fieldName:DEBIT.ACCT.NO");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", "1006593695");
        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER", "250202235");
        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE", "20221220");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT", "10");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgname);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT", "2");

        PageObject.commitDeal("Fee Collection");
        String txn = PageObject.getTxn();
        System.out.println(txn);

    }


    @Test(groups = {"Inputter"})
    public void FeeCollectionAgainstCash_IBG() throws IOException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Fee Collection - Against Cash ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgname = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:INSTITUTE", "5.0031");
        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "100");
        PageObject.click_Locator("fieldName:VALUE:1");
        PageObject.textinput_Locator("fieldName:VALUE:1", "1");
        PageObject.click_Locator("fieldName:DEN.AMT:4");
        PageObject.textinput_Locator("fieldName:DEN.AMT:4", "1");

        PageObject.commitDeal("Fee Collection");
        String txn = PageObject.getTxn();
        System.out.println(txn);

    }


    @Test(groups = {"Inputter"})
    public void MultiFeeCollection_IBG() throws IOException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Multi Fee Collection - Against Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.img_Button("Expand Sub Value");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPES:1']")).sendKeys("5.0031");
        PageObject.click_Locator("fieldName:BILL.AMOUNT:1");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.AMOUNT:1']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPES:2']")).sendKeys("5.0031");
        PageObject.click_Locator("fieldName:BILL.AMOUNT:2");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.AMOUNT:2']")).sendKeys("2");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", "1006593695");
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);

        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER", "6200021458");
        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE", "20221220");

    }


    @Test(groups = {"Inputter"})
    public void FeeCollectionReport_IBG() throws IOException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Fee Collection Report ");
        PageObject.switchToChildWindow();

        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).clear();
        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).sendKeys("5.0031");
        PageObject.find_Button();
        driver.close();
    }

}
