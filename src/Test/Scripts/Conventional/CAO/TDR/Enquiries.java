package Test.Scripts.Conventional.CAO.TDR;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Enquiries extends BaseClass {

    String Txn;
//    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\PrematureEncashmentForAllProducts.xlsx";

    @Test(groups = {"InputterTDR"})

    public void Enquiries() throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Enquiries ");
        PageObject.menu_Link("List of Mahana Aamdan Deposits ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();
        Thread.sleep(2000);

        driver.close();
        PageObject.switchToParentWindow(homePage);

        PageObject.switchFrame(1);

        PageObject.childmenu_Link("TDR Interest Accrual Enquiry",1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();
        Thread.sleep(2000);

        driver.close();
        PageObject.switchToParentWindow(homePage);

        PageObject.switchFrame(1);

        PageObject.childmenu_Link("TDR Interest Accrual Enquiry",2);

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();
        Thread.sleep(2000);

        driver.close();
        PageObject.switchToParentWindow(homePage);

        PageObject.switchFrame(1);

        PageObject.childmenu_Link("10 percent WHT Enquiry on TDR Interest ",1);

        String menu3 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();
        Thread.sleep(2000);

        driver.close();
        PageObject.switchToParentWindow(homePage);

        PageObject.switchFrame(1);

        PageObject.childmenu_Link("c Balance",1);

        String menu4 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();
        Thread.sleep(2000);

        driver.close();
        PageObject.switchToParentWindow(homePage);

        PageObject.switchFrame(1);

        PageObject.menu_Link("List Of Outstanding Term Deposits ");

        String menu5 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();
        Thread.sleep(2000);

        driver.close();
        PageObject.switchToParentWindow(homePage);
    }
}