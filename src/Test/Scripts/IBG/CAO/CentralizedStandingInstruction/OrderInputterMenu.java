package Test.Scripts.IBG.CAO.CentralizedStandingInstruction;

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

public class OrderInputterMenu extends BaseClass {

    public static String txn;
    String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\OrderInputterMenu.xlsx";


    //CaoInputter2
    @Test(groups = {"CaoInputterLogin4"},dataProvider = "StandingOrderINP")
    public void StandingOrderINP(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Standing Order- Inputter Menu");
        PageObject.menu_Link("Maintain Minumum Balance ");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId", testData.get("TransictionID"));
        PageObject.img_Button("Edit a contract");
        PageObject.click_Locator("fieldName:CURRENT.AMOUNT.BAL");
        PageObject.textinput_Locator("fieldName:CURRENT.AMOUNT.BAL", testData.get("Amount"));
        PageObject.textinput_Locator("fieldName:CURRENT.FREQUENCY", testData.get("Frequency"));//e0Y e0M e0W eBD e0F
        PageObject.textinput_Locator("fieldName:CPTY.ACCT.NO", testData.get("DebitAccount"));
        PageObject.textinput_Locator("fieldName:PAYMENT.DETAILS:1", testData.get("Payment"));
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1", testData.get("CommisionType"));
        PageObject.img_Button("Commit the deal");


    }

    //CaoAuthorizer
    @Test(groups = {"CaoStandingAuthorizer"},dataProvider = "StandingOrderAuth")
    public void StandingOrderAuth(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Standing Order-Authorizer Menu");
        PageObject.menu_Link("Maintain Minumum Balance ");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId", testData.get("TransictionID"));
        PageObject.img_Button("Edit a contract");
        PageObject.click_Locator("fieldName:CURRENT.AMOUNT.BAL");
        PageObject.textinput_Locator("fieldName:CURRENT.AMOUNT.BAL", testData.get("Amount"));
        PageObject.textinput_Locator("fieldName:CURRENT.FREQUENCY", testData.get("Frequency"));//e0Y e0M e0W eBD e0F
        PageObject.textinput_Locator("fieldName:CPTY.ACCT.NO", testData.get("DebitAccount"));
        PageObject.textinput_Locator("fieldName:PAYMENT.DETAILS:1", testData.get("Payment"));
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1", testData.get("CommisionType"));
//        PageObject.img_Button("Commit the deal");


    }

    //CaoAuthorizer
    @Test(groups = {"CaoAuthorizerIbg"},dataProvider = "UnauthorizedList")
    public void UnauthorizedList(Map<String, String> testData) {

        PageObject.menu_Dropdown("Standing Order-Authorizer Menu");
        PageObject.menu_Link("Unauthorise List of STO ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1", testData.get("ID"));
        PageObject.textinput_Locator("value:2:1:1", testData.get("RecordStatus"));
        PageObject.find_Button();


    }


    //CaoInputter2
    @Test(groups = {"CaoInputterIBG"},dataProvider = "STOReversed")
    public void STOReversed(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Standing Order- Inputter Menu");
        PageObject.menu_Dropdown("STO Enquiries");
        PageObject.menu_Link("Enquiry for STO Reversed ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1", testData.get("IdValue"));
        PageObject.find_Button();

    }

    //CaoInputter2
    @Test(groups = {"CaoInputterIBG"},dataProvider = "AccountBalanceInformation")
    public void AccountBalanceInformation(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Account Enquiries ");
        PageObject.menu_Link("Account Balance Information ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        //1007735360
        PageObject.textinput_Locator("value:1:1:1", testData.get("IdValue"));
        PageObject.find_Button();


    }


//CaoInputter2
    @Test(groups = {"CaoInputterIBG"}, dataProvider = "OnlineAccountInformation")
    public void OnlineAccountInformation(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Account Enquiries ");
        PageObject.menu_Link("Online Account Statement ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1", testData.get("BookingDate"));
        PageObject.textinput_Locator("value:2:1:1", testData.get("Account"));
        PageObject.find_Button();

    }

    @DataProvider(name = "StandingOrderINP")
    public Object[][] readExcelData1() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("StandingOrderINP"); // Assuming data is in the first sheet
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



    @DataProvider(name = "StandingOrderAuth")
    public Object[][] readExcelData2() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("StandingOrderAuth"); // Assuming data is in the first sheet
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


    @DataProvider(name = "UnauthorizedList")
    public Object[][] readExcelData3() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("UnauthorizedList"); // Assuming data is in the first sheet
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


    @DataProvider(name = "STOReversed")
    public Object[][] readExcelData4() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("STOReversed"); // Assuming data is in the first sheet
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

    @DataProvider(name = "AccountBalanceInformation")
    public Object[][] readExcelData5() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("AccountBalanceInformation"); // Assuming data is in the first sheet
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


    @DataProvider(name = "OnlineAccountInformation")
    public Object[][] readExcelData6() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("OnlineAccountInformation"); // Assuming data is in the first sheet
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


