package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StockManagement extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_StockManagement.xlsx";

    @Test(groups = {"IBGInputter"},dataProvider = "excelDataStocksReceived")
    public void stocksReceived(Map<String, String> testData) throws IOException {
        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Stock Management Menu");
        PageObject.menu_Dropdown("Stock Receive and Transfer");
        PageObject.menu_Link("Stock Recieve  ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:INSTRUMENT.TYPE:1",testData.get("CDR"));
        PageObject.textinput_Locator("fieldName:FROM.SERIAL.NUM:1",testData.get("Serial NumS"));
        PageObject.textinput_Locator("fieldName:TO.SERIAL.NUM:1",testData.get("Serial NumE"));
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT",testData.get("Amount"));
        PageObject.textinput_Locator("fieldName:INVOICE.NUMBER",testData.get("InvoiceNum"));

/*
        PageObject.textinput_Locator("fieldName:INSTRUMENT.TYPE:1","CDR");
        PageObject.textinput_Locator("fieldName:FROM.SERIAL.NUM:1","12351");
        PageObject.textinput_Locator("fieldName:TO.SERIAL.NUM:1","12355");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","951");
        PageObject.textinput_Locator("fieldName:INVOICE.NUMBER","4567796");
*/

        PageObject.commitDeal("IBG_StockManagement_StocksReceived");
        String txn = PageObject.getTxn();
        System.out.println(txn);

    }

    @Test(groups = {"IBGInputter"},dataProvider = "excelDataStocksTransferFromMStoWS")
    public void stocksTransferFromMStoWS(Map<String, String> testData) throws IOException {
        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Stock Management Menu");
        PageObject.menu_Dropdown("Stock Receive and Transfer");
        PageObject.menu_Link("Stock Transfer from MS to WS ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        //PageObject.textinput_Locator("transactionId","BC.123456");
        driver.findElement(By.xpath("(//input[@id='transactionId'])[2]")).sendKeys(testData.get("TID"));
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:FROM.SERIAL.NO:1",testData.get("Serial NumS"));
        PageObject.click_Locator("fieldName:TO.SERIAL.NO:1");
        PageObject.textinput_Locator("fieldName:TO.SERIAL.NO:1",testData.get("Serial NumE"));
        PageObject.textinput_Locator("fieldName:NARRATIVE:1",testData.get("Narrative"));
        PageObject.commitDeal("IBG_stocksTransfer");
        String txn = PageObject.getTxn();
        System.out.println(txn);
    }

    @Test(groups = {"IBGInputter"},dataProvider = "excelDataStocksTransferFromWStoMS")
    public void stocksTransferFromWStoMS(Map<String, String> testData) throws IOException {
        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Stock Management Menu");
        PageObject.menu_Dropdown("Stock Receive and Transfer");
        PageObject.menu_Link("Stock Transfer from WS to MS ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        //PageObject.textinput_Locator("transactionId","BC.123456");
        driver.findElement(By.xpath("(//input[@id='transactionId'])[2]")).sendKeys(testData.get("TID"));
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:FROM.SERIAL.NO:1",testData.get("Serial NumS"));
        PageObject.click_Locator("fieldName:TO.SERIAL.NO:1");
        PageObject.textinput_Locator("fieldName:TO.SERIAL.NO:1",testData.get("Serial NumE"));
        PageObject.textinput_Locator("fieldName:NARRATIVE:1",testData.get("Narrative"));
        PageObject.commitDeal("IBG_stocksTransfer");
        String txn = PageObject.getTxn();
        System.out.println(txn);
    }


    @Test(groups = {"IBGInputter"},dataProvider = "excelDataStocksEnquiryMainStock")
    public void stocksEnquiryMainStock(Map<String, String> testData) throws IOException {
        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Stock Management Menu");
        PageObject.menu_Dropdown("Enquiries of Stock");
        PageObject.menu_Link("Main Stock ");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1",testData.get("TID"));
        PageObject.find_Button();
    }

    @Test(groups = {"IBGInputter"},dataProvider = "excelDataStocksEnquiryWorkingStock")
    public void stocksEnquiryWorkingStock(Map<String, String> testData) throws IOException {
        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Stock Management Menu");
        PageObject.menu_Dropdown("Enquiries of Stock");
        PageObject.menu_Link("Working Stock ");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1",testData.get("TID"));
        PageObject.find_Button();
    }


    //Auth will be depended upon stocksReceived
    //Add parameter in @annotation of dependsUponMethod
    @Test(groups = {"IBGAuthorizer"},dataProvider = "excelDataAuthStocksReceived")
    public void authTheStocks(Map<String, String> testData) throws IOException  {

        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Authorisation of Stock");
        PageObject.menu_Link("Authorise/Delete Stock Records ");

        String HomePage2 = driver.getWindowHandle();
        PageObject.switchToChildWindow();
        //Got the value from DataProvider file
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("Authorise Transaction");
        PageObject.img_Button("Authorises a deal");
//        //then logout
    }

    //DependsOnMethods = {"stocksTransferFromMStoWS","stocksTransferFromWStoMS"}
    @Test(groups = {"IBGAuthorizer"},dataProvider = "excelDataAuthStocksTransfer")
    public void authTheStockTransfers(Map<String, String> testData) throws IOException  {

        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Authorisation of Stock");
        PageObject.menu_Link("Authorise/Delete Stock Transfer Records ");

        String HomePage2 = driver.getWindowHandle();
        PageObject.switchToChildWindow();

        //Got the value from DataProvider file
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();

        driver.findElement(By.xpath("//img[@alt='Select Drilldown']")).click();
        PageObject.img_Button("Authorises a deal");

        //Authorise click
        //then logout
    }



    @DataProvider(name = "excelDataAuthStocksTransfer")
    public Object[][] readExcelData8() throws IOException {

        FileInputStream fis = new FileInputStream("D:\\Selenium Workspace Functional Testing\\Retail Ops\\Data\\IBG_stocksTransfer.xlsx");
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

    @DataProvider(name = "excelDataAuthStocksReceived")
    public Object[][] readExcelData7() throws IOException {

        FileInputStream fis = new FileInputStream("D:\\Selenium Workspace Functional Testing\\Retail Ops\\Data\\IBG_StockManagement_StocksReceived.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("stocksReceivedData"); // Assuming data is in the first sheet
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

    @DataProvider(name = "excelDataStocksReceived")
    public Object[][] readExcelData2() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("stocksReceivedData"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        colCount -=3;
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

    @DataProvider(name = "excelDataStocksTransferFromMStoWS")
    public Object[][] readExcelData3() throws IOException {
        //String FILE_PATH = System.getProperty("user.dir")+"\\Data\\StockManagement_StocksReceived.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("stocksTransferFromMStoWS"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        colCount -=3;
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

    @DataProvider(name = "excelDataStocksTransferFromWStoMS")
    public Object[][] readExcelData9() throws IOException {
        //String FILE_PATH = System.getProperty("user.dir")+"\\Data\\StockManagement_StocksReceived.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("stocksTransferFromWStoMS"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        colCount -=3;
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


    @DataProvider(name = "excelDataStocksEnquiryMainStock")
    public Object[][] readExcelData5() throws IOException {
        //String FILE_PATH = System.getProperty("user.dir")+"\\Data\\StockManagement_StocksReceived.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("stocksEnquiryMainStock"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        colCount -=3;
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

    @DataProvider(name = "excelDataStocksEnquiryWorkingStock")
    public Object[][] readExcelData6() throws IOException {
      //  String FILE_PATH = System.getProperty("user.dir")+"\\Data\\StockManagement_StocksReceived.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("stocksEnquiryWorkingStock"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        colCount-=3;
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
