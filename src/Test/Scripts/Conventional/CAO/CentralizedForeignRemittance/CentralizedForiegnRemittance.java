package Test.Scripts.Conventional.CAO.CentralizedForeignRemittance;

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


public class CentralizedForiegnRemittance extends BaseClass {

    @Test(groups = {"CfrInputter"},dataProvider = "CFRNostroInputter")
    public void CFRNostroInputter(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Centralized Foreign Remittance Menu");
        PageObject.menu_Dropdown("Outward Remittance");
        PageObject.menu_Link("FTT Direct(MT202) ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:CREDIT.CURRENCY",testData.get("FTTCurrency"));
        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO",testData.get("NostroAccount"));
        PageObject.click_Locator("fieldName:CREDIT.AMOUNT");
        // Closing newly opened window !
        String form = PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(form);

        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT",testData.get("FTTAmount"));
        PageObject.textinput_Locator("fieldName:CREDIT.VALUE.DATE",testData.get("ValueDate"));
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",testData.get("DebitAccount"));
        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        // Closing newly opened window !
        form = PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(form);
        //
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER",testData.get("ChequeNumber"));
        PageObject.textinput_Locator("fieldName:DEBIT.THEIR.REF",testData.get("DebitNarrative"));

//        PageObject.textinput_Locator("fieldName:TREASURY.RATE",testData.get("TREASURY.RATE"));
//        PageObject.textinput_Locator("fieldName:CUST.RATE",testData.get("CUST.RATE"));

        PageObject.textinput_Locator("fieldName:BEN.BANK:1",testData.get("Beneficiary"));

//        PageObject.textinput_Locator("fieldName:BEN.ACCT.NO",testData.get("BEN.ACCT.NO"));
//        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1",testData.get("ORDERING.CUST"));
//        fieldName:COMMISSION.TYPE:1
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1",testData.get("CommissionType"));

//        PageObject.textarea_Locator("fieldName:COMMISSION.AMT:1",testData.get("COMMISSION.AMT:1"));
//        PageObject.select_Locator("fieldName:COMMISSION.FOR:1","");
//        PageObject.radiobutton_Locator("radio:tab1:RATE.FIXING.IND",1);
//        PageObject.select_Locator("fieldName:RELATED.MSG:1","");
//        PageObject.textarea_Locator("fieldName:TIME.IND:1:1",testData.get("TIME.IND:1:1"));
//        PageObject.textarea_Locator("fieldName:SBP.RET.CODE",testData.get("SBP.RET.CODE"));
//        PageObject.textarea_Locator("fieldName:PAYMENT.DETAILS:1",testData.get("PAYMENT.DETAILS:1"));

        PageObject.textinput_Locator("fieldName:SWIFT.BIC",testData.get("BICCODE"));

//        PageObject.textarea_Locator("fieldName:A.REMARKS",testData.get("A.REMARKS"));

//        PageObject.form_Tab("MT 202 Details");
//
//        PageObject.textarea_Locator("fieldName:REC.CORR.BANK:1",testData.get("REC.CORR.BANK:1"));
//        PageObject.textarea_Locator("fieldName:REC.CORR.BANK.ACC",testData.get("REC.CORR.BANK.ACC"));
//        PageObject.textarea_Locator("fieldName:INTERMED.BANK:1",testData.get("INTERMED.BANK:1"));
//        PageObject.textarea_Locator("fieldName:INTERMED.BANK.ACC",testData.get("INTERMED.BANK.ACC"));
//        PageObject.textarea_Locator("fieldName:ACCT.WITH.BANK.ACC",testData.get("ACCT.WITH.BANK.ACC"));
//        PageObject.textarea_Locator("fieldName:BEN.ACCT.NO",testData.get("BEN.ACCT.NO"));
//        PageObject.textarea_Locator("fieldName:PYMT.NARRATION:1",testData.get("PYMT.NARRATION:1"));

//        PageObject.form_Tab("Due Diligence Form");
//
//        PageObject.textarea_Locator("fieldName:DD.ADDRESS:1",testData.get("DD.ADDRESS:1"));
//        PageObject.textarea_Locator("fieldName:PURP.REMITT:1",testData.get("PURP.REMITT:1"));
//        PageObject.textarea_Locator("fieldName:REL.BENEFICIARY",testData.get("REL.BENEFICIARY"));

        PageObject.commitDeal("CFRNastoInputter");

    }

    @Test(groups = {"CfrInputter"},dataProvider = "CFRVostroInputter")
            public void CFRVostroInputter(Map<String, String> testData) throws IOException{
        PageObject.menu_Dropdown("Centralized Foreign Remittance Menu");
        PageObject.menu_Dropdown("Inward Remittance");
        PageObject.childmenu_Link("Inward Remittance thru",1);
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",testData.get("DebitAccount"));
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT",testData.get("DebitAmount"));
        PageObject.textinput_Locator("fieldName:DEBIT.VALUE.DATE",testData.get("DebitValueDate"));
        PageObject.textinput_Locator("fieldName:DEBIT.THEIR.REF",testData.get("DebitNarrative"));
        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO",testData.get("CreditAccount"));
        PageObject.click_Locator("fieldName:CREDIT.VALUE.DATE");
        PageObject.textinput_Locator("fieldName:CREDIT.VALUE.DATE",testData.get("CreditValueDate"));
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF",testData.get("CreditNarrative"));

//        PageObject.textarea_Locator("fieldName:BK.TO.BK.INFO:1",testData.get("BK.TO.BK.INFO:1"));
//        PageObject.textarea_Locator("fieldName:ORDERING.CUST:1",testData.get("ORDERING.CUST:1"));
//        PageObject.textarea_Locator("fieldName:PAYMENT.DETAILS:1",testData.get("PAYMENT.DETAILS:1"));
//        PageObject.textarea_Locator("fieldName:COMMISSION.TYPE:1",testData.get("COMMISSION.TYPE:1"));
//        PageObject.textarea_Locator("fieldName:COMMISSION.AMT:1",testData.get("COMMISSION.AMT:1"));
//        PageObject.textarea_Locator("fieldName:SBP.RET.CODE",testData.get("SBP.RET.CODE"));
//        PageObject.textarea_Locator("fieldName:PURPOSE:1",testData.get("PURPOSE:1"));

//        PageObject.form_Tab("Due Diligence Form");
//
//        PageObject.textinput_Locator("fieldName:CX.USER.NAME",testData.get("CX.USER.NAME"));
//        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1",testData.get("DD.ADDRESS"));
//        PageObject.textinput_Locator("fieldName:DD.CNIC.NO",testData.get("DD.CNIC.NO"));
//        PageObject.textinput_Locator("fieldName:CONTACT.NO:1",testData.get("CONTACT.NO"));
//        PageObject.textinput_Locator("fieldName:LINE.OF.BUSS.OC:1",testData.get("LINE.OF.BUSS.OC"));
//        PageObject.textinput_Locator("fieldName:PURP.REMITT:1",testData.get("PURP.REMITT"));
//        PageObject.textinput_Locator("fieldName:NAME.REMIT",testData.get("NAME.REMIT"));
//        PageObject.textinput_Locator("fieldName:REL.BENEFICIARY",testData.get("REL.BENEFICIARY"));

        PageObject.commitDeal("CFRVostroInputter");

    }
    @Test(groups = {"CaoAuthorizer"},dataProvider = "CFRNostroAuth")
    public void CFRNostroAuth(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Centralized Foreign Remittance Menu ( AUTH )");
        PageObject.menu_Dropdown("Outward Remittance");
        PageObject.menu_Link("FTT Direct(MT202) ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("transactionId",testData.get("Transaction Number"));
        PageObject.img_Button("Perform an action on the contract");
        PageObject.img_Button("Authorises a deal");

    }

    @Test(groups = {"CaoAuthorizer"},dataProvider = "CFRVostroAuth")
    public void CFRVostroAuth(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Centralized Foreign Remittance Menu ( AUTH )");
        PageObject.menu_Dropdown("Inward Remittance");
        //PageObject.childmenu_Dropdown("Inward Remittance thru",1);
        driver.findElement(By.xpath("//*[@id=\'pane_\']/ul[2]/li/ul/li[5]/ul/li[1]/a")).click();
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("transactionId",testData.get("Transaction Number"));
        PageObject.img_Button("Perform an action on the contract");
        PageObject.img_Button("Authorises a deal");

    }



    @DataProvider(name = "CFRNostroInputter")
    public Object[][] readExcelData1() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\CentralizedForiegnRemittance.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("CFRNostroInputter"); // Assuming data is in the first sheet
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

    @DataProvider(name = "CFRVostroInputter")
    public Object[][] readExcelData2() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\CentralizedForiegnRemittance.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("CFRVostroInputter"); // Assuming data is in the first sheet
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

    @DataProvider(name = "CFRNostroAuth")
    public Object[][] readExcelData3() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\CFRNastoInputter.xlsx";
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

    @DataProvider(name = "CFRVostroAuth")
    public Object[][] readExcelData4() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\CFRVostroInputter.xlsx";
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
