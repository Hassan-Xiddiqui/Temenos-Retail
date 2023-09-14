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

public class MahanaAamdanDeposits3YearMigration extends BaseClass {

    @Test(groups = {"InputterTDR"},dataProvider = "MAD3YPremature")
            public void MAD3YPremature(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Mahana Aamdan Deposits 3 Year- Migration");
        PageObject.menu_Link("Mahana Aamdan Deposits 3 Years- Premature ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("fieldName:FTD.TYPE",testData.get("Product Category"));

//        PageObject.click_Locator("fieldName:PI.INT.KEY");
//        PageObject.click_Locator("fieldName:TOT.INTEREST.AMT");
//        PageObject.click_Locator("fieldName:TOT.INTEREST.AMT");
//        PageObject.click_Locator("fieldName:TAX.INTEREST.KEY:1");
//        PageObject.click_Locator("fieldName:INT.SCHEDULE");
//        PageObject.click_Locator("fieldName:OUR.REMARKS:1");

        PageObject.textinput_Locator("fieldName:CUST.REMARKS:1",testData.get("Remarks"));

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
//        PageObject.click_Locator("fieldName:AUTO.ROLL.TERM");
//        PageObject.click_Locator("fieldName:ROLLOVER.INT.RATE");
//        PageObject.click_Locator("fieldName:FINAL.MATURITY");

        PageObject.img_Button("Validate a deal");

    }

    @Test(groups = {"InputterTDR"},dataProvider = "MAD3YMigration")
    public void MAD3YMigration(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Mahana Aamdan Deposits 3 Year- Migration");
        PageObject.menu_Link("Mahana Aamdan Deposits 3 Years- Migration ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("fieldName:CUSTOMER.ID",testData.get("Customer"));
        PageObject.click_Locator("fieldName:PRINCIPAL");
        String form = PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(form);
        PageObject.textinput_Locator("fieldName:PRINCIPAL",testData.get("Principal"));

//        PageObject.click_Locator("fieldName:CUST.REMARKS:1");
//        PageObject.select_Locator("fieldName:FIQAH","");

        PageObject.img_Button("Validate a deal");

    }

    @Test(groups = {"AuthorizerTDR"})
    public void MAD3YPrematureAuth() throws IOException{

        PageObject.menu_Dropdown(" Centralized TDR");
        PageObject.menu_Dropdown("Mahana Aamdan Deposits 3 Year- Migration Auth");
        PageObject.menu_Link("Mahana Aamdan Deposits 3 Years- Premature ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();

    }

    @Test(groups = {"AuthorizerTDR"})
    public void MAD3YMigrationAuth() throws IOException{

        PageObject.menu_Dropdown(" Centralized TDR");
        PageObject.menu_Dropdown("Mahana Aamdan Deposits 3 Year- Migration Auth");
        PageObject.menu_Link("Mahana Aamdan Deposits 3 Years- Migration ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();

    }

    @DataProvider(name = "MAD3YPremature")
    public Object[][]   readExcelData1() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\MahanaAamdanDeposits3YearMigration.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("MAD3YPremature"); // Assuming data is in the first sheet
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

    @DataProvider(name = "MAD3YMigration")
    public Object[][] readExcelData2() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\MahanaAamdanDeposits3YearMigration.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("MAD3YMigration"); // Assuming data is in the first sheet
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
