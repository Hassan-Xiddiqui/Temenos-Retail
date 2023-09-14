package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDR_Report_IBG extends BaseClass {

    @Test(groups = {"IBGInputter"})

    public void CDRReportIBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
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
