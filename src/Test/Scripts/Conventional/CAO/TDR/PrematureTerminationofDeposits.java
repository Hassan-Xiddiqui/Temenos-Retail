package Test.Scripts.Conventional.CAO.TDR;

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

public class PrematureTerminationofDeposits extends BaseClass {

    @Test(groups = {"InputterTDR"},dataProvider = "PTDInputter")
    public void PTDInputter(Map<String, String> testData) throws IOException{

    PageObject.menu_Dropdown(" Centralized TDR ");
    PageObject.menu_Dropdown("Premature Termination of Deposits");
    PageObject.menu_Link("Premature Termination of Deposits ");
    PageObject.switchToChildWindow();
    driver.manage().window().maximize();
    PageObject.textinput_Locator("value:1:1:1",testData.get("Deal"));
    PageObject.find_Button();
    PageObject.form_Link("Early Terminate Deal");
        PageObject.switchToChildWindow();

//        PageObject.click_Locator("fieldName:INT.SCHEDULE");
//        PageObject.click_Locator("fieldName:OUR.REMARKS:1");

        PageObject.textinput_Locator("fieldName:CUST.REMARKS:1",testData.get("REMARKS:1"));
        PageObject.textinput_Locator("fieldName:INT.SCHEDULE",testData.get("INT.SCHEDULE"));

//        PageObject.form_Tab("Settlemnt / Charge Details");
//
//        PageObject.click_Locator("fieldName:DRAWDOWN.ACCOUNT");
//        PageObject.click_Locator("fieldName:PRIN.LIQ.ACCT");
//        PageObject.click_Locator("fieldName:INT.LIQ.ACCT");
//        PageObject.click_Locator("fieldName:CHRG.LIQ.ACCT");
//        PageObject.click_Locator("fieldName:CHARGE.CODE:1");
//        PageObject.click_Locator("fieldName:CHARGE.AMOUNT:1");
//
//        PageObject.form_Tab("Rollover Info");
//
//        PageObject.click_Locator("fieldName:ROLLOVER.DATE");
//        PageObject.click_Locator("fieldName:AUTO.ROLL.TERM");
//        PageObject.click_Locator("fieldName:ROLLOVER.INT.RATE");
//        PageObject.click_Locator("fieldName:FINAL.MATURITY");

        PageObject.commitDeal("PTDInputter");

    }


    @Test(groups = {"InputterTDR"},dataProvider = "PTDInputterSpecial")
    public void PTDInputterSpecial(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Premature Termination of Deposits");
        PageObject.menu_Link("Premature Termination for Deposit(Special RT) ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("Deal"));
        PageObject.find_Button();
        PageObject.form_Link("Early Terminate Deal");
        PageObject.switchToChildWindow();

//        PageObject.click_Locator("fieldName:PI.INT.KEY");
//        PageObject.click_Locator("fieldName:OUR.REMARKS:1");
        PageObject.textinput_Locator("fieldName:CUST.REMARKS:1",testData.get("REMARKS:1"));
        //PageObject.textinput_Locator("fieldName:INT.SCHEDULE",testData.get("INT.SCHEDULE"));

//        PageObject.form_Tab("Settlemnt / Charge Details");
//
//        PageObject.click_Locator("fieldName:DRAWDOWN.ACCOUNT");
//        PageObject.click_Locator("fieldName:PRIN.LIQ.ACCT");
//        PageObject.click_Locator("fieldName:INT.LIQ.ACCT");
//        PageObject.click_Locator("fieldName:CHRG.LIQ.ACCT");
//        PageObject.click_Locator("fieldName:CHARGE.CODE:1");
//        PageObject.click_Locator("fieldName:CHARGE.AMOUNT:1");
//
//        PageObject.form_Tab("Rollover Info");
//
//        PageObject.click_Locator("fieldName:ROLLOVER.DATE");
//        PageObject.click_Locator("fieldName:AUTO.ROLL.TERM");
//        PageObject.click_Locator("fieldName:ROLLOVER.INT.RATE");
//        PageObject.click_Locator("fieldName:FINAL.MATURITY");

        PageObject.commitDeal("PTDInputter");

    }

    @Test(groups = {"InputterTDR"},dataProvider = "PTDInputterMahanaAmdan")
    public void PTDInputterMahanaAmdan(Map<String, String> testData) throws IOException{
        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Premature Termination of Deposits");
        PageObject.menu_Link("Premature Termination of Mahana Amdan ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("ID"));
        PageObject.find_Button();


    }

    @Test(groups = {"InputterTDR"},dataProvider = "PTDInputterMahanaAmdan1Year")
    public void PTDInputterMahanaAmdan1Year(Map<String, String> testData) throws IOException{
        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Premature Termination of Deposits");
        PageObject.menu_Link("Premature Termination of Mahana Amdan ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.click_Locator("value:1:1:1");
        PageObject.textinput_Locator("value:1:1:1",testData.get("ID"));
        PageObject.find_Button();
    }

    @Test(groups = {"InputterTDR"},dataProvider = "PTDInputterMahanaAmdanNew")
    public void PTDInputterMahanaAmdanNew(Map<String, String> testData) throws IOException{
        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Premature Termination of Deposits");
        PageObject.menu_Link("Premature Termination of Mahana Amdan ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.click_Locator("value:1:1:1");
        PageObject.textinput_Locator("value:1:1:1",testData.get("ID"));
        PageObject.find_Button();
    }
    @Test(groups = {"AuthorizerTDR"},dataProvider = "PTDAuthorizer")
    public void PTDAuthorizer(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown(" Centralized TDR");
        PageObject.menu_Dropdown("Authorization of Premature Termination");
        PageObject.menu_Link("Authorization of Premature Termination ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("Customer"));
        PageObject.find_Button();
        PageObject.formindex_Link("Authorise Premature Deal",5);
        PageObject.authorizeDeal();


    }

    @DataProvider(name = "PTDInputter")
    public Object[][] readExcelData1() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\PrematureTerminationofDeposits.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PTDInputter"); // Assuming data is in the first sheet
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

    @DataProvider(name = "PTDInputterSpecial")
    public Object[][] readExcelData2() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\PrematureTerminationofDeposits.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PTDInputterSpecial"); // Assuming data is in the first sheet
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

    @DataProvider(name = "PTDInputterMahanaAmdan")
    public Object[][] readExcelData3() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\PrematureTerminationofDeposits.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PTDInputterMahanaAmdan"); // Assuming data is in the first sheet
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

    @DataProvider(name = "PTDInputterMahanaAmdan1Year")
    public Object[][] readExcelData4() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\PrematureTerminationofDeposits.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PTDInputterMahanaAmdan1Year"); // Assuming data is in the first sheet
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

    @DataProvider(name = "PTDInputterMahanaAmdanNew")
    public Object[][] readExcelData5() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\PrematureTerminationofDeposits.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PTDInputterMahanaAmdanNew"); // Assuming data is in the first sheet
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

    @DataProvider(name = "PTDAuthorizer")
    public Object[][] readExcelData6() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\PrematureTerminationofDeposits.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PTDAuthorizer"); // Assuming data is in the first sheet
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


