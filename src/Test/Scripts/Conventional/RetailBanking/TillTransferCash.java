package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TillTransferCash extends BaseClass {

    String vaulttoTillTxn;
    String lcyTxn;
    String fcyTxn;
    String tillToVaultTxn;
    String tillToATMTxn;
    String atmToTillTxn;

    @Test(groups = {"Inputter"})
    public void vaultToTill() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.menu_Link("Vault To Till ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CURRENCY.1", "PKR");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");

        PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1","");
        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1","");
//        PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", "10");

        PageObject.commitDeal("Vault To Till");
        vaulttoTillTxn = PageObject.getTxn();
    }

    @Test(groups = {"Inputter"})
    public void lcyTillTransfer() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.childmenu_Link("LCY Till Transfer ",2);

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", "1005");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");

//        PageObject.textinput_Locator("fieldName:TELLER.ID.1","");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1","");

        PageObject.commitDeal("LCY Till Transfer");
        lcyTxn = PageObject.getTxn();
    }

    @Test(groups = {"Inputter"})
    public void fcyTillTransfer() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.menu_Link("FCY Till Transfer ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", "1005");
        PageObject.textinput_Locator("fieldName:CURRENCY.1", "USD");
        PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", "10");

    //        PageObject.textinput_Locator("fieldName:TELLER.ID.1","");
    //        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1","");

        PageObject.commitDeal("FCY Till Transfer");
        fcyTxn = PageObject.getTxn();
    }

    @Test(groups = {"Inputter"})
    public void tillToVault() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.childmenu_Link("Till to Vault ",2);

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CURRENCY.1", "USD");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "");
        PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", "10");

//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1","");

        PageObject.commitDeal("Till To Vault");
        tillToVaultTxn = PageObject.getTxn();
    }

    @Test(groups = {"Inputter"})
    public void tillToATM() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.menu_Link("Till to ATM ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

//        PageObject.textinput_Locator("fieldName:TELLER.ID.2", "USD");
        PageObject.textinput_Locator("fieldName:TELLER.ID.1", "0975");
        PageObject.click_Locator("fieldName:TELLER.ID.2");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");

//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1","");

        PageObject.commitDeal("Till To ATM");
        tillToATMTxn = PageObject.getTxn();
    }

    @Test(groups = {"Inputter"})
    public void atmToTill() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.menu_Link("ATM to Till ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:TELLER.ID.2", "0975");
//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", "1005");
        Thread.sleep(8000);
        PageObject.click_Locator("fieldName:TELLER.ID.1");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");

//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1","");


        PageObject.commitDeal("Till To ATM");
        atmToTillTxn = PageObject.getTxn();
    }


}
