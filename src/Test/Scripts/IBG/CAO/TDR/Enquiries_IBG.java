package Test.Scripts.IBG.CAO.TDR;

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

public class Enquiries_IBG extends BaseClass {

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "EnquiriesListOfTDR")
    public void EnquiriesListOfTDR (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("List of Outstanding Term Deposits ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1", testData.get("value:1:1:1"));//12267389
        PageObject.find_Button();

    }
    @DataProvider(name = "EnquiriesListOfTDR")
    public Object[][] dataMethod() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\Enquiries_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("EnquiriesListOfTDR"); // Assuming data is in the first sheet
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


    @Test(groups = {"InputterTDR_IBG"},dataProvider = "EnquiriesOtherLoanSchedulesFull")
    public void EnquiriesOtherLoanSchedulesFull(Map<String, String> testData) throws IOException, InterruptedException {

            PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
            PageObject.childmenu_Dropdown("Enquiries", 1);
            PageObject.childmenu_Link("Other Loan Schedules (Full) ", 1);

            String menu = PageObject.switchToChildWindow();
            PageObject.maximizeWindow();

                    PageObject.textinput_Locator("value:1:1:1", testData.get("value:1:1:1"));
            PageObject.find_Button();

        }

    @DataProvider(name = "EnquiriesOtherLoanSchedulesFull")
    public Object[][] dataMethod1() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\Enquiries_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("EnquiriesOtherLoanSchedulesFull"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "OtherLoansdisbursedtoday")
    public void OtherLoansdisbursedtoday (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Other Loans disbursed today ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.textinput_Locator("value:1:1:1", "");
        PageObject.textinput_Locator("value:2:1:1", testData.get("value:1:1:1"));//12201086

        PageObject.find_Button();

//        Boolean verify =  driver.findElement(By.xpath("(//table/tbody/tr/td/a[text()='View LD Contract'])[1]")).isDisplayed();
//
//        Assert.assertTrue(verify,"Enquiry not showing any result !");

        PageObject.formindex_Link("View LD Contract",1);

        //Apply assertion
//        String getTxn = "abc";
        String getTxn = driver.findElement(By.xpath("//tr/td/input[@id='transactionId']")).getAttribute("value");
        System.out.println(getTxn);

    }
    @DataProvider(name = "OtherLoansdisbursedtoday")
    public Object[][] dataMethod2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\Enquiries_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("OtherLoansdisbursedtoday"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"})
    public void InterestAccrualsOtherLoans  () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Interest Accruals (Other Loans) ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void RepaymentHistoryOtherLoans () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Repayment History (Other Loans) ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

//        PageObject.textinput_Locator("value:1:1:1", "LD1419712927");
//        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "LDNewDepositsReceivedToday")
    public void LDNewDepositsReceivedToday   (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("LD New Deposits Received Today ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.textinput_Locator("value:2:1:1",testData.get("value:1:1:1"));
            PageObject.textinput_Locator("value:1:1:1", testData.get("value:2:1:1"));
        PageObject.find_Button();
        PageObject.formindex_Link("View LD Contract",1);

    }

    @DataProvider(name = "LDNewDepositsReceivedToday")
    public Object[][] dataMethod3() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\Enquiries_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("LDNewDepositsReceivedToday"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"})
    public void TransactionSchedules   () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Transaction Schedules ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void TransactionSchedulesForward    () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Transaction Schedules Forward ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void AccountEntriesforGivendates      () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Account Entries for Given dates  ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void AccountStmt () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Account Stmt ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    }
