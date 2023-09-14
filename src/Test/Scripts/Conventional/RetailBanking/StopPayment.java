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

public class StopPayment extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\StopPayment.xlsx";

    @Test(groups = {"Inputter"},priority = 1,dataProvider = "excelDataStopPaymentChequeBook")
    public void stopPaymentChequeBook(Map<String, String> testData) throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Stop Payment of Cheque Book ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("transactionId",testData.get("TID"));

        PageObject.img_Button("Edit a contract");

        PageObject.textinput_Locator("fieldName:PAYM.STOP.TYPE:1",testData.get("Payment Stp Type"));
        PageObject.textinput_Locator("fieldName:CHEQUE.BOOK",testData.get("Cheque Book"));
        PageObject.textinput_Locator("fieldName:FIRST.CHEQUE.NO:1",testData.get("Cheque Num S"));
        PageObject.textinput_Locator("fieldName:LAST.CHEQUE.NO:1",testData.get("Cheque Num E"));
        PageObject.select_Locator("fieldName:WAIVE.CHARGE:1",testData.get("Waive"));
        PageObject.textinput_Locator("fieldName:BENEFICIARY:1",testData.get("Beneficiary"));
        PageObject.textinput_Locator("fieldName:LAST.CHEQUE.NO:1",testData.get("Remarks"));
        PageObject.textinput_Locator("fieldName:REMARKS:1:1",testData.get("REMARKS:1:1"));
//        PageObject.commitDeal("stopPaymentChequeBook");

        //2 times
//        String txn = PageObject.getTxn();
//        System.out.println("Txn is:  "+txn);


//        String txn = PageObject.getTxn();
//        System.out.println("Txn is:  "+txn);
    }
    //dependsOnMethods = {"stopPayment_Cheque","stopPayment_ChequeSeries"}
    //To make dependent on other methods
    @Test(groups = {"Inputter"}, priority = 3,dataProvider = "excelDataStopPaymentRevokeCheque")
    public void stopPaymentRevokeCheque(Map<String, String> testData) throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Revoke Stop Payment of Cheque ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("transactionId",testData.get("TID"));
        PageObject.img_Button("Edit a contract");

        PageObject.textinput_Locator("fieldName:MOD.PS.CHQ.NO:1",testData.get("Cheque Num"));
        PageObject.commitDeal("stopPayment_RevokeCheque");
        String txn = PageObject.getTxn();
        System.out.println("Txn is:  "+txn);
    }

    @Test(groups = {"Inputter"}, priority = 3,dataProvider = "excelDataStopPaymentCheque")
    public void stopPaymentOfCheque(Map<String, String> testData) throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Stop Payment of Cheque(s) ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("transactionId",testData.get("TID"));
        PageObject.img_Button("Edit a contract");

        PageObject.textinput_Locator("fieldName:PAYM.STOP.TYPE:1",testData.get("Payment Stp Type"));
        PageObject.textinput_Locator("fieldName:FIRST.CHEQUE.NO:1",testData.get("Cheque Num"));
        PageObject.textinput_Locator("fieldName:LAST.CHEQUE.NO:1",testData.get("Cheque Num"));

        PageObject.select_Locator("fieldName:WAIVE.CHARGE:1",testData.get("Waive"));

        PageObject.textinput_Locator("fieldName:BENEFICIARY:1",testData.get("BENEFICIARY:1"));
        PageObject.textinput_Locator("fieldName:REMARKS:1:1",testData.get("REMARKS:1:1"));

        PageObject.commitDeal("stopPaymentOfCheque");
        //2 times
        String txn = PageObject.getTxn();
        System.out.println("Txn is:  "+txn);
    }


    @Test(groups = {"Authorizer"},dataProvider = "excelDataAuthStopPayment")
    public void authStopPayment(Map<String, String> testData) throws IOException  {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");

        PageObject.menu_Link("Authorization for Payment Stop ");
        String HomePage2 = driver.getWindowHandle();
        PageObject.switchToChildWindow();

        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));

        PageObject.find_Button();
        PageObject.form_Link("Authorise the Payment Stop");
        PageObject.img_Button("Authorises a deal");
        //then logout
    }



    @DataProvider(name = "excelDataAuthStopPayment")
    public Object[][] readExcelData4() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\stopPaymentOfCheque.xlsx";
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

    @DataProvider(name = "excelDataStopPaymentCheque")
    public Object[][] readExcelData() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("stopPaymentCheque"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = (sheet.getRow(0).getPhysicalNumberOfCells());
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


    @DataProvider(name = "excelDataStopPaymentChequeBook")
    public Object[][] readExcelData2() throws IOException {
        //String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\FtGeneral.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("stopPaymentChequeBook"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = (sheet.getRow(0).getPhysicalNumberOfCells());
        //rowCount=2;
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


    @DataProvider(name = "excelDataStopPaymentRevokeCheque")
    public Object[][] readExcelData3() throws IOException {
       // String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\FtGeneral.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("stopPaymentRevokeCheque"); // Assuming data is in the first sheet
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
