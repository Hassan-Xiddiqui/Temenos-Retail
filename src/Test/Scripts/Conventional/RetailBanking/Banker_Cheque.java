package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import zmq.ZError;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Banker_Cheque extends BaseClass{

    public static String debitAccount="";



 // SI = Single Issuence

    @Test(groups = {"Inputter"},dataProvider = "SIAccontHolderData")
    public void SIAccontHolder(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque- Inputter Menu\")])[1]")).click();
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque Issuance\")])[1]")).click();
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheq Single Issuance Menu\")])[1]")).click();
        PageObject.menu_Link("Banker Cheque Single Issuance- Account Holder ");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT",testData.get("CREDIT.AMOUNT"));
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",testData.get("DEBIT.ACCT.NO"));
        debitAccount = testData.get("DEBIT.ACCT.NO");
        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        String form = PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(form);
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER",testData.get("CHEQUE.NUMBER"));
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1",testData.get("BEN.CUSTOMER"));
        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1",testData.get("ORDERING.CUST"));

        PageObject.textarea_Locator("fieldName:ORDERING.BANK:1",testData.get(""));
        PageObject.radiobutton_Locator("radio:tab1:COMMISSION.CODE",3);

        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1",testData.get("COMMISSION.TYPE"));

//        PageObject.textarea_Locator("fieldName:COMMISSION.AMT:1",testData.get("COMMISSION.AMT:1"));
//        PageObject.textarea_Locator("fieldName:CUST.RATE",testData.get("CUST.RATE"));

        PageObject.form_Tab("Due Delligence");

        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1",testData.get("DD.ADDRESS"));
        PageObject.textinput_Locator("fieldName:ID.TYPE",testData.get("ID.TYPE"));
        PageObject.textinput_Locator("fieldName:ID.NUMBER",testData.get("ID.NUMBER"));
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1",testData.get("CONTACT.NO"));
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Donation/Charity");
        PageObject.textinput_Locator("fieldName:PURPOSE:1",testData.get("PURPOSE"));


        PageObject.img_Button("Validate a deal");
        PageObject.commitDeal("SIAccontHolder");


    }

    @Test(groups = {"authorizer"})
    public void SIAccontHolderAuth() throws IOException{

        PageObject.menu_Dropdown("Manager Operation Menu"); //
        PageObject.menu_Dropdown("Core Retail Menu");
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque- Authorizer Menu\")])[1]")).click();
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheq Instrument SingleAuthorization \")])")).click();
        PageObject.menu_Link("Authorize Banker Chq Single-Act Holder ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(0);
        PageObject.img_Button("Selection Screen");
        PageObject.click_Locator("value:2:1:1");
        PageObject.textinput_Locator("value:2:1:1",debitAccount);
        PageObject.find_Button();
        driver.switchTo().parentFrame();
        PageObject.switchFrame(0);
        PageObject.formindex_Link("Authorise a Transaction",1);


    }

    @Test(groups = {"Inputter"},dataProvider = "WalkInCusStp1")
    public void WalkInCusStp1(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque- Inputter Menu\")])[1]")).click();
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque Issuance\")])[1]")).click();
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheq Single Issuance Menu\")])[1]")).click();
        driver.findElement(By.xpath("//ul/li/span/img[contains(@alt,\"Banker's Cheq Bulk Issuance Menu Walkin Cust\")][1]")).click();
        PageObject.menu_Link("Collect Banker Chq W/Cust-Single/Bulk- Step-1 ");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1",testData.get("AMOUNT.LOCAL"));
        PageObject.textinput_Locator("fieldName:NO.OF.INST",testData.get("NO.OF.INST"));

//        PageObject.textarea_Locator("fieldName:NARRATIVE.2:1",testData.get("NARRATIVE.2:1"));

        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Custom Duty/Import Duty");

//        PageObject.textarea_Locator("fieldName:PURPOSE",testData.get("PURPOSE"));
//        PageObject.textarea_Locator("fieldName:DEN.AMT:1",testData.get("DEN.AMT:1"));
//        String Trans = PageObject.commitDeal("WalkInCusStp1");

        Thread.sleep(9000);


        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);


        PageObject.menu_Link("Banker Cheque Single Issuance- Walk-in Cust ");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");
//        PageObject.textinput_Locator("fieldName:INST.NUMBER",Trans);
        PageObject.img_Button("Validate a deal");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1",testData.get("BEN.CUSTOMER"));
        WebElement element = driver.findElement(By.xpath("//span[@id='disabled_DEBIT.ACCT.NO']"));
        String debitAcc = element.getText();
        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1",testData.get("ORDERING.CUST"));

        PageObject.textarea_Locator("fieldName:PAYMENT.DETAILS:1",testData.get("PAYMENT.DETAILS:1"));

        PageObject.form_Tab("Due Delligence");

        PageObject.textinput_Locator("fieldName:APP.ADDRESS:1",testData.get("APP.ADDRESS"));
        PageObject.textinput_Locator("fieldName:APP.ID.TYPE",testData.get("APP.ID.TYPE"));
        PageObject.textinput_Locator("fieldName:CNIC.NO",testData.get("CNIC.NO"));
        PageObject.textinput_Locator("fieldName:APP.CONTACT.NO",testData.get("APP.CONTACT.NO"));
        PageObject.textinput_Locator("fieldName:APP.MOTHER.NAME",testData.get("MOTHER.NAME"));
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1",testData.get("DD.ADDRESS:1"));
        PageObject.textinput_Locator("fieldName:ID.TYPE",testData.get("ID.TYPE"));
        PageObject.textinput_Locator("fieldName:ID.NUMBER",testData.get("ID.NUMBER"));
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1",testData.get("CONTACT.NO:1"));
        PageObject.img_Button("Validate a deal");
        PageObject.commitDeal("WalkInCusStp2");

    }

    @Test(groups = {"authorizer"},dataProvider = "WalkInAuth")
    public void WalkInAuth(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Manager Operation Menu"); //
        PageObject.menu_Dropdown("Core Retail Menu");
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque- Authorizer Menu\")])[1]")).click();
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheq Instrument SingleAuthorization \")])")).click();
        PageObject.menu_Link("Authorize Banker Chq Single-Walkin Customer ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        //Thread.sleep(5000);
        PageObject.textinput_Locator("value:1:1:1","PKR159800031");
        PageObject.textinput_Locator("value:2:1:1","");
        PageObject.find_Button();
        PageObject.formindex_Link("Authorise a Transaction",1);
        Thread.sleep(5000);
        PageObject.authorizeDeal();



    }

    @Test(groups = {"Inputter"})
    public void Encashment () throws IOException{


        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque- Inputter Menu\")])[1]")).click();
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque Encashment\")])")).click();
        PageObject.menu_Link("Bankers Cheque Encashment- Inward Remittance ");

    }

    @Test(groups = {"authorizer"})
    public void BankerChequeReport () throws IOException{

        PageObject.menu_Dropdown("Manager Operation Menu"); //
        PageObject.menu_Dropdown("Core Retail Menu");
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque- Authorizer Menu\")])[1]")).click();
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque Report\")])")).click();
        PageObject.childmenu_Link("Cheque Instrument  ",1);
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.find_Button();

    }

// before execute this script you should change the Print locatoin
//    step-1 : Login with user XXX
//            step-2 : Click on tools at the top
//            Step-3 : Click on My Profile
//            Step-4 : Click on Amend preferences
//            step - 5 : Change the print locatoin to local
    @Test(groups = {"authorizer"},dataProvider = "DealSlip")
    public void DealSlip (Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Manager Operation Menu"); //
        PageObject.menu_Dropdown("Core Retail Menu");
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheque- Authorizer Menu\")])[1]")).click();
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,\"Banker's Cheq Instrument SingleAuthorization \")])")).click();
        PageObject.menu_Link("Authorize Banker Chq Single-Act Holder ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(0);
        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:2:1:1",testData.get("value:1:1:1"));
        PageObject.find_Button();
        PageObject.formindex_Link("Authorise a Transaction",3);
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.authorizeDeal();

    }


    String FILE_PATH = "";


    @DataProvider(name = "SIAccontHolderData")
    public Object[][] dataMethod() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BC_Conv.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
//        rowCount=6;
        System.out.println("Row found:  "+rowCount);
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Col found:  "+colCount);
        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap

        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
            Row row = sheet.getRow(i);
            Map<String, String> map = new HashMap<String, String>();
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String value = formatter.formatCellValue(cell);
                System.out.println("the value:  "+value);
                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
            }
            data[i - 1][0] = map;
        }

        workbook.close();
        fis.close();
        return data;
    }

    @DataProvider(name = "WalkInCusStp1")
    public Object[][] dataMethod1() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BC_Conv.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(1); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
//        rowCount=6;
        System.out.println("Row found:  "+rowCount);
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Col found:  "+colCount);
        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap

        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
            Row row = sheet.getRow(i);
            Map<String, String> map = new HashMap<String, String>();
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String value = formatter.formatCellValue(cell);
                System.out.println("the value:  "+value);
                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
            }
            data[i - 1][0] = map;
        }

        workbook.close();
        fis.close();
        return data;
    }

    @DataProvider(name = "WalkInAuth")
    public Object[][] dataMethod2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BC_Conv.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(2); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
//        rowCount=6;
        System.out.println("Row found:  "+rowCount);
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Col found:  "+colCount);
        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap

        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
            Row row = sheet.getRow(i);
            Map<String, String> map = new HashMap<String, String>();
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String value = formatter.formatCellValue(cell);
                System.out.println("the value:  "+value);
                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
            }
            data[i - 1][0] = map;
        }

        workbook.close();
        fis.close();
        return data;
    }

    @DataProvider(name = "DealSlip")
    public Object[][] dataMethod3() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BC_Conv.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(3); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
//        rowCount=6;
        System.out.println("Row found:  "+rowCount);
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Col found:  "+colCount);
        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap

        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
            Row row = sheet.getRow(i);
            Map<String, String> map = new HashMap<String, String>();
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String value = formatter.formatCellValue(cell);
                System.out.println("the value:  "+value);
                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
            }
            data[i - 1][0] = map;
        }

        workbook.close();
        fis.close();
        return data;
    }



}
