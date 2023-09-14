package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDRChangeStatus extends BaseClass {

    @Test(groups = {"Inputter"})

    //Data related issue, transaction couldn't perform properly

    public void CDRChngStatus() throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services", 2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance");


        String HomePage2 = driver.getWindowHandle();

        PageObject.menu_Link("Change Status of Instrument ");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1","CDR.LDA0610547");

        PageObject.find_Button();

        PageObject.maximizeWindow();

       //INCOMPLETE DUE TO SYSTEM ISSUE

        Thread.sleep(2000);
        PageObject.form_Link("Change Status");

        Thread.sleep(2000);

        //PageObject.commitDeal("CDRChngStatus");
    }

       @Test(groups = {"Authorizer"})

       public void CDRChangeStatus_Auth() throws IOException, InterruptedException {

           PageObject.menu_Dropdown("Manager Operation Menu");
           PageObject.menu_Dropdown("Core Retail Menu");

           PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");
           PageObject.menu_Dropdown("Call Deposit Receipt Maintenance Authorize");

           PageObject.menu_Link("Authorisation Change Status of Instrument ");

           String menu1 = PageObject.switchToChildWindow();

           PageObject.find_Button();

           PageObject.form_Link("Authorize Transaction");

           String menu2 = PageObject.switchToChildWindow();
           PageObject.img_Button("Authorises a deal");


       }
}
