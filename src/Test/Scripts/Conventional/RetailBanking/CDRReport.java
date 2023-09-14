package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDRReport extends BaseClass {

    @Test( groups = {"Inputter"})

    public void CDRReportEnquiry() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Report");

        String HomePage2 = driver.getWindowHandle();
        PageObject.menu_Link("List of Call Deposit Receipt Instrument ");

        PageObject.switchToChildWindow();

        PageObject.find_Button();

        Thread.sleep(3000);

        PageObject.maximizeWindow();


    }
}
