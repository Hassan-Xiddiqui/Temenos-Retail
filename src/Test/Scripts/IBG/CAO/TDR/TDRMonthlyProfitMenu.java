package Test.Scripts.IBG.CAO.TDR;

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

public class TDRMonthlyProfitMenu extends BaseClass {

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "TDRIssuanceMaturityLCY_IBG")
    public void TDRIssuanceMaturityLCY_IBG (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Term Deposit Issuance LCY ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", "11871120");//11871120
        PageObject.click_Locator("fieldName:CATEGORY");
        //PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", "11745297");
        PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", "T1YA");
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", "100000");
        PageObject.form_Tab(" Settlement / Charges Details");
        PageObject.textinput_Locator("fieldName:DRAWDOWN.ACCOUNT",testData.get("DRAWDOWN.ACCOUNT"));
        PageObject.click_Locator("fieldName:PRIN.LIQ.ACCT");
        PageObject.textinput_Locator("fieldName:PRIN.LIQ.ACCT",testData.get("PRIN.LIQ.ACCT"));
        PageObject.textinput_Locator("fieldName:INT.LIQ.ACCT",testData.get("INT.LIQ.ACCT"));
        PageObject.commitDeal("TDRIssuanceMaturityLCY_IBG");

    }

    @DataProvider(name = "TDRIssuanceMaturityLCY_IBG")
    public Object[][] dataMethod() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\TDRMonthlyProfitMenu.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("TDRIssuanceMaturityLCY_IBG"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "TDRIssuanceMaturityFCY_IBG")
    public void TDRIssuanceMaturityFCY_IBG (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Term Deposit Issuance FCY ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", testData.get("CUSTOMER.ID"));
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", testData.get("JOINT.CUSTOMER"));
        PageObject.textinput_Locator("fieldName:CATEGORY", testData.get("CATEGORY"));
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", testData.get("REST.PERIOD.LD"));
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", testData.get("AMOUNT:1") );
        PageObject.form_Tab(" Settlement / Charges Details");
        PageObject.textinput_Locator("fieldName:DRAWDOWN.ACCOUNT",testData.get("DRAWDOWN.ACCOUNT"));
        PageObject.click_Locator("fieldName:PRIN.LIQ.ACCT");
        PageObject.textinput_Locator("fieldName:PRIN.LIQ.ACCT",testData.get("PRIN.LIQ.ACCT"));
        PageObject.textinput_Locator("fieldName:INT.LIQ.ACCT",testData.get("INT.LIQ.ACCT"));
        PageObject.commitDeal("TDRIssuanceMaturityFCY_IBG");

    }
    @DataProvider(name = "TDRIssuanceMaturityFCY_IBG")
    public Object[][] dataMethod1() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\TDRMonthlyProfitMenu.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("TDRIssuanceMaturityFCY_IBG"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "TDRBackDatedMaturityLCY_IBG")
    public void TDRBackDatedMaturityLCY_IBG (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Back Dated Term Deposit LCY  ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", testData.get("CUSTOMER.ID"));//12105488
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", testData.get("JOINT.CUSTOMER"));//11745297
        PageObject.textinput_Locator("fieldName:VALUE.DATE", testData.get("VALUE.DATE"));//20230103
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY", testData.get("CATEGORY"));//21022
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", testData.get("REST.PERIOD.LD"));//DF1YMTA
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", testData.get("AMOUNT:1"));//100
        PageObject.form_Tab(" Settlement / Charges Details");
        PageObject.textinput_Locator("fieldName:DRAWDOWN.ACCOUNT",testData.get("DRAWDOWN.ACCOUNT"));
        PageObject.click_Locator("fieldName:PRIN.LIQ.ACCT");
        PageObject.textinput_Locator("fieldName:PRIN.LIQ.ACCT",testData.get("PRIN.LIQ.ACCT"));
        PageObject.textinput_Locator("fieldName:INT.LIQ.ACCT",testData.get("INT.LIQ.ACCT"));
        PageObject.commitDeal("TDRBackDatedMaturityFCY_IBG");


    }

    @DataProvider(name = "TDRBackDatedMaturityLCY_IBG")
    public Object[][] dataMethod2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\TDRMonthlyProfitMenu.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("TDRBackDatedMaturityLCY_IBG"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "TDRBackDatedMaturityFCY_IBG")
        public void TDRBackDatedMaturityFCY_IBG (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Back Dated Term Deposit LCY  ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", testData.get("CUSTOMER.ID"));//12105488
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", testData.get("JOINT.CUSTOMER"));//11745297
            PageObject.textinput_Locator("fieldName:VALUE.DATE", testData.get("VALUE.DATE"));//20230103
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY", testData.get("CATEGORY"));//21022
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", testData.get("REST.PERIOD.LD"));//DF1YMTA
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", testData.get("AMOUNT:1"));//100
        PageObject.form_Tab(" Settlement / Charges Details");
        PageObject.textinput_Locator("fieldName:DRAWDOWN.ACCOUNT",testData.get("DRAWDOWN.ACCOUNT"));
        PageObject.click_Locator("fieldName:PRIN.LIQ.ACCT");
        PageObject.textinput_Locator("fieldName:PRIN.LIQ.ACCT",testData.get("PRIN.LIQ.ACCT"));
        PageObject.textinput_Locator("fieldName:INT.LIQ.ACCT",testData.get("INT.LIQ.ACCT"));
        PageObject.commitDeal("TDRBackDatedMaturityFCY_IBG");


    }

    @DataProvider(name = "TDRBackDatedMaturityFCY_IBG")
    public Object[][] dataMethod3() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\TDRMonthlyProfitMenu.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("TDRBackDatedMaturityFCY_IBG"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "TDRAmendmentPreMaturity")
    public void TDRAmendmentPreMaturity (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Term Deposit Amendment/Pre-Maturity ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1"));
        PageObject.find_Button();
        PageObject.form_Link("Amend");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        Thread.sleep(4000);
        PageObject.commitDeal("TDRAmendmentPreMaturity");
        PageObject.switchToChildWindow();
        Thread.sleep(4000);
        PageObject.switchToParentWindow(menu);
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "TDRAmendmentPreMaturity")
    public Object[][] dataMethod4() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\TDRMonthlyProfitMenu.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("TDRAmendmentPreMaturity"); // Assuming data is in the first sheet
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
