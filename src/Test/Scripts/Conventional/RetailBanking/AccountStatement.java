package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountStatement extends BaseClass {

    @Test(groups = {"Inputter"})
    public void todayBalance(){

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.childmenu_Dropdown("Balance Enquiry" , 1);
        PageObject.childmenu_Link("A/c Balance ",1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1" , "1006989401");
        PageObject.find_Button();


    }

    @Test(groups = {"Inputter"})
    public void accountBalance(){

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.childmenu_Dropdown("Balance Enquiry" , 1);
        PageObject.childmenu_Link("Account Balance Information    ",1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1" , "1006989401");
        PageObject.find_Button();
    }

    @Test(groups = {"Inputter"})
    public void accountStatement() throws IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.childmenu_Dropdown("Account Statement Printing" , 1);
//        PageObject.childmenu_Dropdown("Account Statement Print " , 1);
        driver.findElement(By.xpath("(//a[text()='Account Statement Print '])[1]")).click();
        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId" , "1007609217");
        PageObject.img_Button("Edit a contract");

        PageObject.textinput_Locator("fieldName:FROM.DATE" , "20221201");
        PageObject.textinput_Locator("fieldName:TO.DATE" , "20221230");
        PageObject.radiobutton_Locator("radio:mainTab:WAIVE.CHARGES" , 1);
        PageObject.select_Locator("fieldName:REASON" , "IMPORTANT ASSET");

        PageObject.commitDeal("Account Statement");
    }

    @Test(groups = {"Inputter"})
    public void accountUtilityBill(){

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.childmenu_Dropdown("Account Statement" , 1);
//      PageObject.childmenu_Dropdown("Account Statement- Utility Bill Accounts " , 1);
        driver.findElement(By.xpath("(//a[text()='Account Statement- Utility Bill Accounts '])[1]")).click();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

//        PageObject.textinput_Locator("value:1:1:1" , "20221201");
        PageObject.textinput_Locator("value:2:1:1" , "1007609217");
        PageObject.find_Button();

//        PageObject.textarea_Locator("fieldName:FROM.DATE","");
//        PageObject.textarea_Locator("fieldName:TO.DATE","");
//        PageObject.radiobutton_Locator("radio:mainTab:WAIVE.CHARGES",2);
//        PageObject.select_Locator("fieldName:REASON","");

    }

    @Test(groups = {"Inputter"})
    public void onlineStatement(){

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.childmenu_Dropdown("Account Statement" , 1);
//        PageObject.childmenu_Dropdown("Online Statement " , 1);
        driver.findElement(By.xpath("(//a[text()='Online Statement '])[1]")).click();
        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1" , "20221201");
        PageObject.textinput_Locator("value:2:1:1" , "1007609217");
        PageObject.find_Button();
    }

}
