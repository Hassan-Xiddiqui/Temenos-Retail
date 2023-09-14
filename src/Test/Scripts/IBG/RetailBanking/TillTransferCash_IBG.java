package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TillTransferCash_IBG extends BaseClass {

    String vaulttoTillTxn;
    String lcyTxn;
    String fcyTxn;
    String tillToVaultTxn;
    String tillToATMTxn;
    String atmToTillTxn;

    @Test(groups = {"IBGInputter"})
    public void vaultToTill_IBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.childmenu_Link("Vault To Till ",2);

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CURRENCY.1", "PKR");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");
//        PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", "10");

        PageObject.commitDeal("Vault To Till");
        vaulttoTillTxn = PageObject.getTxn();
    }

    @Test(groups = {"IBGInputter"})
    public void lcyTillTransfer_IBG() throws IOException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.childmenu_Link("LCY Till Transfer ",2);

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", "1005");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");

        PageObject.commitDeal("LCY Till Transfer");
        lcyTxn = PageObject.getTxn();
    }

    @Test(groups = {"IBGInputter"})
    public void fcyTillTransfer_IBG() throws IOException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.menu_Link("FCY Till Transfer ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", "1005");
        PageObject.textinput_Locator("fieldName:CURRENCY.1", "USD");
        PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", "1");

        PageObject.commitDeal("FCY Till Transfer");
        fcyTxn = PageObject.getTxn();
    }

    @Test(groups = {"IBGInputter"})
    public void tillToVault_IBG() throws IOException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
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

        PageObject.commitDeal("Till To Vault");
        tillToVaultTxn = PageObject.getTxn();
    }

    @Test(groups = {"IBGInputter"})
    public void tillToATM_IBG() throws IOException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.menu_Link("Till to ATM ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

//        PageObject.textinput_Locator("fieldName:TELLER.ID.2", "USD");
        PageObject.textinput_Locator("fieldName:TELLER.ID.1", "7600");
        PageObject.click_Locator("fieldName:TELLER.ID.2");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");

        PageObject.commitDeal("Till To ATM");
        tillToATMTxn = PageObject.getTxn();
    }

    @Test(groups = {"IBGInputter"})
    public void atmToTill_IBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Till Transfer (CASH)");
        PageObject.menu_Link("ATM to Till ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:TELLER.ID.2", "7600");
//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", "1005");
        Thread.sleep(8000);
        PageObject.click_Locator("fieldName:TELLER.ID.1");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");


        PageObject.commitDeal("Till To ATM");
        atmToTillTxn = PageObject.getTxn();
    }



}
