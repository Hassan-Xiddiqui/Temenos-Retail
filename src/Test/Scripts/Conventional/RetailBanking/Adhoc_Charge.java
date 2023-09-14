package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Adhoc_Charge  extends BaseClass {

    @Test(groups = {"Inputter"})
    public void AdhocChargeFixedRate() throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("ACCOUNT");
        PageObject.childmenu_Dropdown("Adhoc Charge Request" , 2);
        PageObject.childmenu_Link("With delivery (FIXED RATE) " , 2);

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

//        PageObject.form_Tab("Delivery Dets");
//
//        PageObject.textarea_Locator("fieldName:MSG.SERIES","");
//        PageObject.textarea_Locator("fieldName:RELATED.REF","");
//        PageObject.radiobutton_Locator("radio:tab2:ORD.INST.TYPE",1);
//        PageObject.textarea_Locator("fieldName:ORDERING.INST:1","");
//        PageObject.radiobutton_Locator("radio:tab2:ACCT.WITH.TYPE",1);
//        PageObject.textarea_Locator("fieldName:ACCT.WITH.BANK:1","");
//        PageObject.textarea_Locator("fieldName:SENDER.DETAIL","");
//        PageObject.textarea_Locator("fieldName:SENDER.INFO:1","");
//        PageObject.textarea_Locator("fieldName:REMARKS:1","");

        PageObject.commitDeal("AdhocChargeFixedRate");
        String txn = PageObject.getTxn();
        System.out.println(txn);
        driver.close();
 }


    @Test(groups = {"Inputter"})
    public void AdhocChargeChangeableRate() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("ACCOUNT");
        PageObject.childmenu_Dropdown("Adhoc Charge Request", 2);
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

//        PageObject.form_Tab("Delivery Dets");
//
//        PageObject.textarea_Locator("fieldName:MSG.SERIES","");
//        PageObject.textarea_Locator("fieldName:RELATED.REF","");
//        PageObject.radiobutton_Locator("radio:tab2:ORD.INST.TYPE",1);
//        PageObject.textarea_Locator("fieldName:ORDERING.INST:1","");
//        PageObject.radiobutton_Locator("radio:tab2:ACCT.WITH.TYPE",1);
//        PageObject.textarea_Locator("fieldName:ACCT.WITH.BANK:1","");
//        PageObject.textarea_Locator("fieldName:SENDER.DETAIL","");
//        PageObject.textarea_Locator("fieldName:SENDER.INFO:1","");
//        PageObject.textarea_Locator("fieldName:REMARKS:1","");

        PageObject.commitDeal("AdhocChargeChangeableRate");
        String txn = PageObject.getTxn();
        System.out.println(txn);
        driver.close();
    }

    @Test(groups = {"Inputter"})
    public void ListAdhocChargeRequest() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.menu_Dropdown("Adhoc Charge Request");
        PageObject.menu_Link("List of ADHOC Charges ");
        PageObject.switchToChildWindow();
        PageObject.find_Button();
    }

}

