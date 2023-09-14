package Test.Scripts.IBG.CAO.CentralizedRemittanceProcessing;

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

public class CentralizeForeignRemittance extends BaseClass {
    //IBG_CfrInputter
    @Test(groups = "IBG_CfrInputter", dataProvider = "CentralizeForeignRemittance")
    public void CentralizeForeignRemittance(Map<String, String> testData) throws InterruptedException, IOException {

        //VARIABLE FOR EXCEL DATA STORAGE
        String DebitAccount = testData.get("DebitAccount");
        String CreditAccount = testData.get("CreditAccount");
        String ChequeNumber = testData.get("ChequeNumber");
        String Amount = testData.get("Amount");
        String CustomerTypeString = testData.get("CustomerType");
        int CustomerType = Integer.parseInt(CustomerTypeString);
        String CustomerName = testData.get("CustomerName");
        String CnicType = testData.get("CnicType");
        String CnicValidity = testData.get("CnicValidity");
        String CustomerCnic = testData.get("CustomerCnic");
        String Remarks = testData.get("Remarks");
        String DateOfBirth = testData.get("DateOfBirth");
        String FatherName = testData.get("FatherName");

//        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centralized Foreign Remittance Menu");
        PageObject.menu_Link("Account to Account Transfer ");

        String NewDealPage = PageObject.switchToChildWindow();

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",DebitAccount);
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");

        String DebitAccountDetails = PageObject.switchToChildWindow();
        this.driver.close();
        PageObject.switchToParentWindow(DebitAccountDetails);

        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT",Amount);
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER",ChequeNumber);
        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO",CreditAccount);
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");

        String CreditAccountDetails = PageObject.switchToChildWindow();
        this.driver.close();
        PageObject.switchToParentWindow(CreditAccountDetails);

        PageObject.radiobutton_Locator("radio:mainTab:AML.TYP.CUST", CustomerType);
        if (CustomerTypeString.equalsIgnoreCase("2")) {

            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);

            String newPage = PageObject.switchToChildWindow();
            PageObject.switchFrame(2);
//            refreshWindow(2);
            String childPage = PageObject.switchToChildWindow();
            PageObject.switchFrame(2);

            PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
        }



        PageObject.commitDeal("IbgCentralizeForeignRemittance");
    }

    @DataProvider(name = "CentralizeForeignRemittance")
    public Object[][] readExcelData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\CFR_AccountToAccount.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("CFR_Ibg"); // Assuming data is in the first sheet
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

    //IBG_CfrAuthorizer
    @Test(groups = "IBG_CfrAuthorizer", dataProvider = "CentralizeForeignRemittance_Authorization")
    public void CentralizeForeignRemittance_Authorization(Map<String, String> testData) throws InterruptedException, IOException {

        //VARIABLE FOR EXCEL DATA STORAGE
        String TxnNumber = testData.get("Transaction Number");

//        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centralized Foreign Remittance Menu ( AUTH )");
        PageObject.menu_Link("Account to Account Transfer ");

        String ChildPage1 = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId", TxnNumber);
        PageObject.img_Button("Perform an action on the contract");
//        Thread.sleep(3000);
        PageObject.authorizeDeal();

    }

    @DataProvider(name = "CentralizeForeignRemittance_Authorization")
    public Object[][] readExcelData_A() throws IOException {
        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\IbgCentralizeForeignRemittance.xlsx";
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

    /*_______________________________________________________________________________________________________________________________*/

    //IBG_CfrInputter
    @Test(groups = "IBG_CfrInputter", dataProvider = "CentralizeForeignRemittanceReversal")
    public void CentralizeForeignRemittanceReversal(Map<String, String> testData) throws InterruptedException, IOException {

        //VARIABLE FOR EXCEL DATA STORAGE
        String TransactionNumber = testData.get("Transaction Number");

//        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centralized Foreign Remittance Menu");
        PageObject.menu_Link("Funds Transfer General ");

        String NewDealPage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId",TransactionNumber);

        PageObject.img_Button("Perform an action on the contract");

        PageObject.img_Button("Reverses a deal from the live file");

    }

    @DataProvider(name = "CentralizeForeignRemittanceReversal")
    public Object[][] readExcelData1() throws IOException {
        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\IbgCentralizeForeignRemittance.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("CFR_Ibg"); // Assuming data is in the first sheet
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

    //IBG_CfrAuthorizer
    @Test(groups = "IBG_CfrAuthorizer", dataProvider = "CentralizeForeignRemittance_Authorization")
    public void CentralizeForeignRemittanceReversal_Authorization(Map<String, String> testData) throws InterruptedException, IOException {

        //VARIABLE FOR EXCEL DATA STORAGE
        String TxnNumber = testData.get("Transaction Number");

//        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centralized Foreign Remittance Menu ( AUTH )");
        PageObject.menu_Link("Remittance Reversal Auth  ");

        String ChildPage1 = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId", TxnNumber);
        PageObject.img_Button("Perform an action on the contract");
//        Thread.sleep(3000);
        PageObject.authorizeDeal();

    }

    @DataProvider(name = "CentralizeForeignRemittanceReversal_Authorization")
    public Object[][] readExcelData_1A() throws IOException {
        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\CentralizeForeignRemittance.xlsx";
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
