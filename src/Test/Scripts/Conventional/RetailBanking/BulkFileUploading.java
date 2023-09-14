package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.Test;
import java.io.IOException;

public class BulkFileUploading extends BaseClass {

    @Test(groups = {"Inputter"})

    public void BulkFileUpload() throws IOException,InterruptedException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services" , 2);
        PageObject.menu_Dropdown("Bulk File Uploading Inputter Menu");
        PageObject.menu_Link("Bulk File Uploading Input ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgname = driver.getWindowHandle();
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DESCRIPTION","TEST FILE");







    }
}
