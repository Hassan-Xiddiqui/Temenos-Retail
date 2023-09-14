package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CDR_Dealslip extends BaseClass {

    @Test( groups = {"Inputter"})
    public void CDRDealSliptxn() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");

        PageObject.menu_Link("Call Deposit Receipt- Single Issuance ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1000264788");
        PageObject.click_Locator("fieldName:BEN.CUSTOMER:1");

        String HomePage2 = driver.getWindowHandle();
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(HomePage2);
        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","1000");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","SARA");

//        PageObject.textarea_Locator("fieldName:CHEQUE.NUMBER","");

        //PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE" , 4 );//(//input[@id='radio:mainTab:COMMISSION.CODE'])[4]
        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE" , 4 );

//        PageObject.textarea_Locator("fieldName:ORDERING.CUST:1","");
//        PageObject.textarea_Locator("fieldName:PAYMENT.DETAILS:1","");
//        PageObject.textarea_Locator("fieldName:COMMISSION.TYPE:1","");
//        PageObject.textarea_Locator("fieldName:COMMISSION.AMT:1","");


        //PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","WAIVE");


        PageObject.form_Tab("Due Delligence");

        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1","D1-SAT");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","4220190909123");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1","03332125612");
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE", "Business Investment");

        PageObject.textarea_Locator("fieldName:PURPOSE:1","");
//        PageObject.commitDeal("CDRDealSliptxn");



    }


    @Test(groups = {"Authorizer"},dataProvider = "excelDataAuthCDRDealSlip")
    public void authfTOnline(Map<String, String> testData) throws IOException {

        //Menu
       // PageObject.menu_Dropdown("Manager Operation Menu");
        //PageObject.menu_Dropdown("Core Retail Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Instrument Authorization");
        //PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");

        //PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");
        String HomePage2 = driver.getWindowHandle();
        PageObject.menu_Link("Authorization of Single CDR Issuance ");

//        PageObject.parentFrame();
        //PageObject.switchFrame(2);



        PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");

        PageObject.textinput_Locator("value:2:1:1", "DEBIT.ACCT.NO");

        PageObject.find_Button();

        PageObject.form_Link("Authorise a Transaction");

        //PageObject.textinput_Locator("transactionId", testData.get("Transaction Number"));

        //PageObject.img_Button("Authorises a deal");
        //once again open deal slip ..


    }

    @Test(groups = {"Inputter"},dataProvider = "excelDataAuthCDRDealSlip")
    public void viewCDRSlip(Map<String, String> testData) throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");

        PageObject.menu_Link("Call Deposit Receipt- Single Issuance ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId", testData.get("Transaction Number"));
        PageObject.img_Button("Perform an action on the contract");

        //PageObject.img_Button("Prints the deal slip");
        //
    }

    @DataProvider(name = "excelDataAuthCDRDealSlip")
    public Object[][] readExcelData4() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CDRDealSliptxn.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap

        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
            Row row = sheet.getRow(i);
            Map<String, String> map = new HashMap<String, String>();
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String value = formatter.formatCellValue(cell);
                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
            }
            data[i - 1][0] = map;
        }

        workbook.close();
        fis.close();
        return data;


    }


}
