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

public class AlfalahSpecialRateTDR_IBG extends BaseClass {

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "AlfalahIslamicSpecialRateTDR")
    public void AlfalahIslamicSpecialRateTDR  (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Alfalah Islamic Special Rate TDR", 1);
        PageObject.childmenu_Link("Alfalah Islamic Special Rate TDR ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", testData.get("CUSTOMER.ID"));//12105488
        //PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.click_Locator("fieldName:JOINT.CUSTOMER");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", testData.get("JOINT.CUSTOMER"));//11745297
        //PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", testData.get("REST.PERIOD.LD"));//DFOMTDA
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", testData.get("AMOUNT:1"));//100
        PageObject.img_Button("Validate a deal");
        //PageObject.commitDeal("AlfalahIslamicSpecialRateTDR");

    }

    @DataProvider(name = "AlfalahIslamicSpecialRateTDR")
    public Object[][] dataMethod() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\AlfalahSpecialRateTDR_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("AlfalahIslamicSpecialRateTDR"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "AlfalahIslamicSpRateTDRMonthlyProfit")
    public void AlfalahIslamicSpRateTDRMonthlyProfit  (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Alfalah Islamic Special Rate TDR", 1);
        PageObject.childmenu_Link("Alfalah Islamic Sp Rate TDR (Monthly Profit) ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", testData.get("CUSTOMER.ID"));//12105488
        //PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.click_Locator("fieldName:JOINT.CUSTOMER");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", testData.get("JOINT.CUSTOMER"));//11745297
        //PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        //PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", "DFOMTDA");//TDR12SM
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", testData.get("AMOUNT:1"));//1M
        PageObject.img_Button("Validate a deal");
        PageObject.textinput_Locator("fieldName:VALUE.DATE",testData.get("VALUE.DATE"));//20230702
        PageObject.textinput_Locator("fieldName:INTEREST.RATE:1",testData.get("INTEREST.RATE:1"));//1000
        PageObject.form_Tab(" Settlement / Charges Details");
        PageObject.textinput_Locator("fieldName:DRAWDOWN.ACCOUNT",testData.get("DRAWDOWN.ACCOUNT"));
        PageObject.click_Locator("fieldName:PRIN.LIQ.ACCT");
        PageObject.textinput_Locator("fieldName:PRIN.LIQ.ACCT",testData.get("PRIN.LIQ.ACCT"));
        PageObject.textinput_Locator("fieldName:INT.LIQ.ACCT",testData.get("INT.LIQ.ACCT"));
        //PageObject.img_Button("Validate a deal");
        PageObject.commitDeal("AlfalahIslamicSpRateTDRMonthlyProfit");

    }

    @DataProvider(name = "AlfalahIslamicSpRateTDRMonthlyProfit")
    public Object[][] dataMethod1() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\AlfalahSpecialRateTDR_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("IslamicSpRateTDRMonthly"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "DealslipforspecialTDR")
        public void DealslipforspecialTDR    (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Alfalah Islamic Special Rate TDR", 1);
        PageObject.childmenu_Link("Deal slip for special TDR ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", testData.get("CUSTOMER.ID"));//12105488
        PageObject.click_Locator("fieldName:JOINT.CUSTOMER");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", testData.get("JOINT.CUSTOMER"));//11745297
        //  PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", testData.get("REST.PERIOD.LD"));//21022
//        Thread.sleep(5000);
        PageObject.click_Locator("fieldName:REST.PERIOD.LD");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", testData.get("REST.PERIOD.LD"));//TDR12SM
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", testData.get("AMOUNT:1"));//100
        PageObject.textinput_Locator("fieldName:INTEREST.RATE:1",testData.get("INTEREST.RATE:1"));
        PageObject.form_Tab(" Settlement / Charges Details");
        PageObject.textinput_Locator("fieldName:DRAWDOWN.ACCOUNT",testData.get("DRAWDOWN.ACCOUNT"));
        PageObject.click_Locator("fieldName:PRIN.LIQ.ACCT");
        PageObject.textinput_Locator("fieldName:PRIN.LIQ.ACCT",testData.get("PRIN.LIQ.ACCT"));
        PageObject.textinput_Locator("fieldName:INT.LIQ.ACCT",testData.get("INT.LIQ.ACCT"));
        //PageObject.img_Button("Validate a deal");
        PageObject.commitDeal("DealslipforspecialTDR");

    }

    @DataProvider(name = "DealslipforspecialTDR")
    public Object[][] dataMethod2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\AlfalahSpecialRateTDR_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("DealslipforspecialTDR"); // Assuming data is in the first sheet
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
