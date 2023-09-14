package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class UtilityBills_IBG extends BaseClass {

    @Test(groups = {"Inputter"})

    public void UtilityBillsAgainstCash() throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Utility Bills");
        PageObject.menu_Link("Utility Bills Recieved Against Cash ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPE:1']")).sendKeys("1.5512");
        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1","10");
        PageObject.click_Locator("fieldName:CONSUMER.NO");
        PageObject.textinput_Locator("fieldName:CONSUMER.NO","522012488");
        PageObject.click_Locator("fieldName:DEN.AMT:8");
        PageObject.textinput_Locator("fieldName:DEN.AMT:8","1");

        PageObject.commitDeal("UtilityBillsAgainstCash");
        String txn = PageObject.getTxn();
        System.out.println(txn);
    }

    @Test(groups = {"Inputter"})

    public void UtilityBillsAgainstAccount() throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Utility Bills");
        PageObject.menu_Link("Utility Bills Recieved Against Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgname = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:BILL.TYPE","1.5512");
        PageObject.click_Locator("fieldName:DEBIT.ACCT.NO");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1006593695");
        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","200145879");
        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE","20221230");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","5");

        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgname);
        PageObject.switchFrame(2);
        driver.findElement(By.xpath("//input[@id='fieldName:CONSUMER.NO:1']")).sendKeys("22000145");

        PageObject.commitDeal("UtilityBillsAgainstAccount");
        String txn = PageObject.getTxn();
        System.out.println(txn);
    }


    @Test(groups = {"Inputter"})

    public void MultiUtilityBillsAgainstAccount() throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Utility Bills");
        PageObject.menu_Link("Multi Utility Bills Recieved Against Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.img_Button("Expand Sub Value");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPES:1']")).sendKeys("1.5512");
        PageObject.click_Locator("fieldName:BILL.AMOUNT:1");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.AMOUNT:1']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPES:2']")).sendKeys("1.5512");
        PageObject.click_Locator("fieldName:BILL.AMOUNT:2");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.AMOUNT:2']")).sendKeys("2");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1006593695");
        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","6200021458");
        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE","20221230");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        driver.findElement(By.xpath("//input[@id='fieldName:CONSUMER.NO:1']")).sendKeys("2200014596");

        PageObject.commitDeal("MultiUtilityBillsAgainstAccount");
        String txn = PageObject.getTxn();
        System.out.println(txn);

    }
}
