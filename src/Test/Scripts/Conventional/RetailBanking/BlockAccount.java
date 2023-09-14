package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BlockAccount extends BaseClass {

    @Test(groups = {"Inputter"})
    public void blockAmount() throws IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.childmenu_Dropdown("Block Account" , 1);
        PageObject.childmenu_Link("Block Amount " , 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:ACCOUNT.NUMBER" , "");

//        PageObject.textarea_Locator("fieldName:DESCRIPTION","DESCRIPTION");

        PageObject.textinput_Locator("fieldName:FROM.DATE" , "");
        PageObject.textinput_Locator("fieldName:TO.DATE" , "");
        PageObject.textinput_Locator("fieldName:LOCKED.AMOUNT" , "");
        PageObject.textinput_Locator("fieldName:FREEZE" , "");
        PageObject.textinput_Locator("fieldName:REASON" , "");
        PageObject.textinput_Locator("fieldName:FRZ.REQ.BY" , "");

        PageObject.commitDeal("Block Ammount");
    }

    @Test(groups = {"Inputter"})
    public void releaseAmmount() throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.childmenu_Dropdown("Block Account" , 1);
        PageObject.childmenu_Link("Release Amount " , 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","ID");
        PageObject.textinput_Locator("value:3:1:1","Account");
        PageObject.find_Button();

        PageObject.formindex_Link("Release Amount",1);

        PageObject.commitDeal("Release Ammount");
    }

}
