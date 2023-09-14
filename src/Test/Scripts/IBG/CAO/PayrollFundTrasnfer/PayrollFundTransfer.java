package Test.Scripts.IBG.CAO.PayrollFundTrasnfer;

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

public class PayrollFundTransfer extends BaseClass {

    //CaoInputter2
    @Test(groups = {"CaoInputterIBG"},dataProvider = "PayrollFundTransfer")
    public void PayrollFundTransfer(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Funds Transfer Menu");
        PageObject.menu_Link("Funds Transfer ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",testData.get("DebitAccount"));
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT",testData.get("Amount"));
        PageObject.click_Locator("fieldName:DEBIT.VALUE.DATE");
        PageObject.textinput_Locator("fieldName:DEBIT.VALUE.DATE",testData.get("DebitValueDate"));
        PageObject.textinput_Locator("fieldName:DEBIT.THEIR.REF",testData.get("DebitNarrative"));
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER",testData.get("ChequeNumber"));
        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO",testData.get("CreditAccount"));
        PageObject.click_Locator("fieldName:CREDIT.VALUE.DATE");
        PageObject.textinput_Locator("fieldName:CREDIT.VALUE.DATE",testData.get("CreditValueDate"));
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF",testData.get("CreditNarrative"));
//        PageObject.textinput_Locator("fieldName:TREASURY.RATE","12");
        PageObject.click_Locator("radio:tab1:AML.TYP.CUST");
        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST",1);
        PageObject.textarea_Locator("fieldName:NAME.COND.TXN",testData.get("TXN"));
        PageObject.textinput_Locator("fieldName:CNIC.NO",testData.get("CNIC"));

        //asdasd
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1",testData.get("CommisionType"));
        //PageObject.textinput_Locator("fieldName:COMMISSION.AMT:1","1");
//        PageObject.img_Button("Validate a deal");
//        PageObject.img_Button("Commit the deal");

        PageObject.commitDeal("IbgPayrollFT");
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


//CaoAuthorizer2
    @Test(groups = {"CaoAuthorizerIbg"},dataProvider = "PayrollFundTransferAuth")
    public void PayrollFundTransferAuth(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Funds Transfer Authorization");
        PageObject.menu_Link("Funds Transfer Authorization ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("ID"));
        PageObject.click_Locator("defaultButton");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.form_Link("Authorize Transaction");


    }


    @DataProvider(name = "PayrollFundTransfer")
    public Object[][] readExcelData1() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\PayrollFundTransfer.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PayrollFundTransfer"); // Assuming data is in the first sheet
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
    public Object[][] readExcelData2() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\OrderInputterMenu.xlsx";
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

    @DataProvider(name = "PayrollFundTransferAuth")
    public Object[][] readExcelData3() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\PayrollFundTransfer.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PayrollFundTransferAuth"); // Assuming data is in the first sheet
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

