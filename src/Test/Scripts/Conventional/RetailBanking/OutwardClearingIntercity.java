package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class OutwardClearingIntercity extends BaseClass {

    String intercityTxn;
    @Test(groups = {"Inputter"})

    public void outwardClearingIntercity() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Clearing Menu");
        PageObject.childmenu_Dropdown("Customer Services",3);
        PageObject.menu_Dropdown("Clearing");
        PageObject.menu_Dropdown("Clearing NIFT/ SBP/ NBP");
        PageObject.menu_Dropdown("Outward Clearing ");
        PageObject.menu_Dropdown("Outward Clearing - Lodgment");
        PageObject.menu_Link("Intercity Clearing ");


        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:CUSTOMER.ACCT","1003114045");
        PageObject.click_Locator("fieldName:NO.OF.CHQ");
        PageObject.textinput_Locator("fieldName:NO.OF.CHQ","1");
        PageObject.click_Locator("fieldName:CHEQUE.NO:1");
        PageObject.textinput_Locator("fieldName:CHEQUE.NO:1","1234");
        PageObject.textinput_Locator("fieldName:AMOUNT:1","2000");
        PageObject.textinput_Locator("fieldName:BANKS:1","001");
        PageObject.textinput_Locator("fieldName:BRANCHES:1","001.1002");

//        PageObject.textinput_Locator("fieldName:DEPT.SLIP.NO","");
//        PageObject.textinput_Locator("fieldName:NARRATION","");

        PageObject.img_Button("Commit the deal");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("Commit the deal");

    }

}
