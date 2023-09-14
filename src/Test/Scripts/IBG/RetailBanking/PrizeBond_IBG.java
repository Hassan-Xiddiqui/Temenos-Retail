package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PrizeBond_IBG extends BaseClass {

    public class PrizeBond extends BaseClass {
        String lcyTxn;
        String tillToVaultTxn;
        String vaultToTillTxn;
        String sellTxn;
        String buyTxn;

        @Test(groups = {"IBGInputter"})
        public void lcyTillTransfer_IBG() throws IOException {

            PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
            PageObject.menu_Dropdown("Teller");
            PageObject.menu_Dropdown("Teller Menu");
            PageObject.menu_Dropdown("Prize Bond Menu");
            PageObject.childmenu_Link("LCY Till Transfer ",1);

            PageObject.parentFrame();
            PageObject.switchFrame(2);

            PageObject.img_Button("New Deal");

            PageObject.textinput_Locator("fieldName:TELLER.ID.1", "1005");
            PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");

            PageObject.commitDeal("LCY Till Transfer PB");
            lcyTxn = PageObject.getTxn();
        }

        @Test(groups = {"IBGInputter"})
        public void tillToVault_IBG() throws IOException {

            PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
            PageObject.menu_Dropdown("Teller");
            PageObject.menu_Dropdown("Teller Menu");
            PageObject.menu_Dropdown("Prize Bond Menu");
            PageObject.menu_Link("Till to Vault ");

            PageObject.parentFrame();
            PageObject.switchFrame(2);

            PageObject.img_Button("New Deal");

            PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");
            PageObject.commitDeal("Till To Vault PB");
            tillToVaultTxn = PageObject.getTxn();

        }

        @Test(groups = {"IBGInputter"})
        public void vaultToTill_IBG() throws IOException {

            PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
            PageObject.menu_Dropdown("Teller");
            PageObject.menu_Dropdown("Teller Menu");
            PageObject.menu_Dropdown("Prize Bond Menu");
            PageObject.menu_Link("Vault To Till ");

            PageObject.parentFrame();
            PageObject.switchFrame(2);

            PageObject.img_Button("New Deal");

            PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");
            PageObject.commitDeal("Vault To Till PB");
            vaultToTillTxn = PageObject.getTxn();

        }

        @Test(groups = {"IBGInputter"})
        public void sellBond_IBG() {

            PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
            PageObject.menu_Dropdown("Teller");
            PageObject.menu_Dropdown("Teller Menu");
            PageObject.menu_Dropdown("Prize Bond Menu");
            PageObject.menu_Link("Prize Bond - Sell ");

            PageObject.parentFrame();
            PageObject.switchFrame(2);

            PageObject.img_Button("New Deal");

        }

        @Test(groups = {"IBGInputter"})
        public void buyBond_IBG() {

            PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
            PageObject.menu_Dropdown("Teller");
            PageObject.menu_Dropdown("Teller Menu");
            PageObject.menu_Dropdown("Prize Bond Menu");
            PageObject.menu_Link("Prize Bond - Buy ");

            PageObject.parentFrame();
            PageObject.switchFrame(2);

            PageObject.img_Button("New Deal");

        }


    }
}
