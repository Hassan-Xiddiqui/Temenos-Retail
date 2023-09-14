package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class chequeBookManagement extends BaseClass {

    public static String Txn="";
    public static String chq="CD.1007306919.0000004";

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\chequeBookManagement.xlsx";
    @Test(groups = {"Inputter"}, dataProvider = "Issuance")
    public void Issuance(Map<String, String> testData) throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Request For Issuance to CBU ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId",chq); //CD.1007306919.0000004
        PageObject.img_Button("Edit a contract");

        String Deal = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(Deal);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:ORDERING.DATE",testData.get("ORDERING.DATE"));
        PageObject.select_Locator("fieldName:ISSUED.AGAINST","REQUISTION EXISTING A/C");
        PageObject.select_Locator("fieldName:NO.CHQ.ISSUED","25");
        PageObject.textinput_Locator("fieldName:LAST.SERIAL",testData.get("LAST.SERIAL"));
        PageObject.textarea_Locator("fieldName:NOTES",testData.get("NOTES"));
        PageObject.radiobutton_Locator("radio:tab1:WAIVE.CHARGES",1);

        PageObject.commitDeal("chequeBookIssued");

    }

    @DataProvider(name = "Issuance")
    public Object[][] readExcelData1() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Issuance"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        //rowCount-=2;
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


    @Test(groups = {"Inputter"}, dataProvider = "Received")
    public void Received(Map<String, String> testData) throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Received From CPU ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);
        Thread.sleep(5000);
        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1")); //SB.1008612104.0000001
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Received Cheque Book");

        PageObject.parentFrame();
        PageObject.switchFrame(1);
        Thread.sleep(5000);
        PageObject.textinput_Locator("fieldName:CHQ.NO.STARTS",testData.get("CHQ.NO.STARTS"));
        PageObject.textarea_Locator("fieldName:NOTES",testData.get("NOTES"));
        PageObject.radiobutton_Locator("radio:tab1:WAIVE.CHARGES",1);

        PageObject.commitDeal("chequeBookReceived");
        Txn = PageObject.getTxn();

    }

    @DataProvider(name = "Received")
    public Object[][] readExcelData2() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Received"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        //rowCount-=2;
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

    @Test(groups = {"Authorizer"})
    public void Received_Authorization() throws InterruptedException, IOException {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");
        PageObject.menu_Link("Authorization Received From CPU ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",Txn);
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorize");
        PageObject.authorizeDeal();

    }


    @Test(groups = {"Inputter"}, dataProvider = "DeliveredTo3rdParty")
    public void DeliveredTo3rdParty(Map<String, String> testData) throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Delivered to Third Party ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1")); //SB.1008604638.0000001
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Delivered to third Party");

        PageObject.textinput_Locator("fieldName:DELIV.TO.CUS",testData.get("DELIV.TO.CUS"));
        PageObject.textinput_Locator("fieldName:CNIC.CUS",testData.get("CNIC.CUS"));
        PageObject.textarea_Locator("fieldName:NOTES",testData.get("NOTES"));

        PageObject.commitDeal("chequeBookDelivered");
        Txn = PageObject.getTxn();


    }

    @DataProvider(name = "DeliveredTo3rdParty")
    public Object[][] readExcelData3() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("DeliveredTo3rdParty"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        //rowCount-=2;
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

    @Test(groups = {"Authorizer"})
    public void DeliveredTo3rdParty_Authorization() throws InterruptedException, IOException {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");
        PageObject.menu_Link("Authorization of Third Party Delivery ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",Txn);
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorize");

        Thread.sleep(5000);

        //frame not found issue!
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        PageObject.authorizeDeal();

    }


    @Test(groups = {"Inputter"}, dataProvider = "Activation")
    public void Activation(Map<String, String> testData) throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Activation ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

            //PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1")); //CD.1008203610.0000001
        PageObject.find_Button();
        driver.manage().window().maximize();
        PageObject.form_Link("Activate Cheque Book");

        PageObject.parentFrame();
        PageObject.switchFrame(1);

        PageObject.select_Locator("fieldName:ISSUED.AGAINST","REQUISTION EXISTING A/C");
        //PageObject.textinput_Locator("fieldName:CHQ.NO.START",testData.get("CHQ.NO.START")); //34314526
        PageObject.textarea_Locator("fieldName:NOTES",testData.get("NOTES"));

        PageObject.commitDeal("chequeBookActivated");
        Txn = PageObject.getTxn();

    }
    @DataProvider(name = "Activation")
    public Object[][] readExcelData4() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Activation"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        //rowCount-=2;
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

    @Test(groups = {"Authorizer"})
    public void ActivationAuth() throws InterruptedException, IOException {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");
        PageObject.menu_Link("Authorization of Cheque Book Activation ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",Txn);
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorize");

        Thread.sleep(5000);

//        PageObject.parentFrame();
//        PageObject.switchFrame(1);
        PageObject.authorizeDeal();

    }







//        @Test(groups = {"Inputter"})
    public void overrideTC() throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Request For Issuance to CBU ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId",chq); //CD.1007306919.0000004
        PageObject.img_Button("Edit a contract");

        String Deal = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(Deal);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:ORDERING.DATE","20221124");
        PageObject.select_Locator("fieldName:ISSUED.AGAINST","FORM B");
        PageObject.select_Locator("fieldName:NO.CHQ.ISSUED","25");
        PageObject.textinput_Locator("fieldName:LAST.SERIAL","34314526");
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK ISSUED");
        PageObject.radiobutton_Locator("radio:tab1:WAIVE.CHARGES",1);

        PageObject.commitDeal("chequeBookIssued");
    }




}
