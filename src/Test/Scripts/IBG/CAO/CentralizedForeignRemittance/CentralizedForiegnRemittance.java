package Test.Scripts.IBG.CAO.CentralizedForeignRemittance;

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


public class CentralizedForiegnRemittance extends BaseClass {

    @Test(groups = {"CaoInputterIBG"},dataProvider = "CFRNostroInputter")
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
        PageObject.textinput_Locator("fieldName:BEN.BANK:1",testData.get("Beneficiary"));
//        fieldName:COMMISSION.TYPE:1
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1",testData.get("CommissionType"));

        PageObject.textinput_Locator("fieldName:SWIFT.BIC",testData.get("BICCODE"));
        PageObject.commitDeal("IbgCFRNastoInputter");

    }

    @Test(groups = {"CaoInputterIbg"},dataProvider = "CFRVostroInputter")
            public void CFRVostroInputter(Map<String, String> testData) throws IOException{
        PageObject.menu_Dropdown("Centralized Foreign Remittance Menu");
        PageObject.menu_Dropdown("Inward Remittance");
        PageObject.childmenu_Link("Inward Remittance thru",1);
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","");
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT",testData.get("DebitAmount"));
        PageObject.textinput_Locator("fieldName:DEBIT.VALUE.DATE",testData.get("DebitValueDate"));
        PageObject.textinput_Locator("fieldName:DEBIT.THEIR.REF",testData.get("DebitNarrative"));
        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO",testData.get("CreditAccount"));
        PageObject.click_Locator("fieldName:CREDIT.VALUE.DATE");
        PageObject.textinput_Locator("fieldName:CREDIT.VALUE.DATE",testData.get("CreditValueDate"));
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF",testData.get("CreditNarrative"));
       // PageObject.commitDeal("CFRVostroInputter");

    }


    @Test(groups = {"CaoAuthorizerIbg"},dataProvider = "CFRNostroAuth")
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

        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\IbgCFRNastoInputter.xlsx";
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
