package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FundsTransfer extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_Ft.xlsx";

    @Test(groups = {"IBGInputter"},dataProvider = "excelDatafTGeneral")
    public void fTGeneral(Map<String, String> testData) throws IOException {

        String CustomerTypeString = testData.get("CustomerType");

        String HomePage2 = driver.getWindowHandle();
        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Account Transfer");
        PageObject.menu_Link("Account to Account Transfer ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");


        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",testData.get("debit"));
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(HomePage2);
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT",testData.get("amount"));


        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO",testData.get("credit"));
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(HomePage2);
        PageObject.parentFrame();
        PageObject.switchFrame(2);

        if (CustomerTypeString=="1")
            PageObject.radiobutton_Locator("radio:mainTab:AML.TYP.CUST",1);

        else{
            PageObject.radiobutton_Locator("radio:mainTab:AML.TYP.CUST",2);
            PageObject.textarea_Locator("fieldName:NAME.COND.TXN",testData.get("Name"));
            PageObject.textinput_Locator("fieldName:ID.TYPE",testData.get("ID type"));
            PageObject.textinput_Locator("fieldName:ID.NUMBER",testData.get("ID Num"));
            PageObject.textinput_Locator("fieldName:ID.VAL.DT",testData.get("Exp Date"));

        }

        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE",Integer.parseInt(testData.get("CommisionCode")));

        if ( (Integer.parseInt(testData.get("chequeNum"))) !=0)
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER",testData.get("chequeNum"));

        PageObject.textinput_Locator("fieldName:DEBIT.VALUE.DATE",testData.get("date"));
        PageObject.textinput_Locator("fieldName:CREDIT.VALUE.DATE",testData.get("date"));
        PageObject.textinput_Locator("fieldName:DEBIT.THEIR.REF",testData.get("Narrative"));
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF",testData.get("CdNarrative"));
        PageObject.textinput_Locator("fieldName:PAYMENT.DETAILS:1",testData.get("Details"));


        PageObject.commitDeal("IBG_FundsTransferGeneral");
    }

    @Test(groups = {"IBGInputter"},dataProvider = "excelDataForOnlineFt")
    public void fTOnline(Map<String, String> testData) throws IOException {

        String HomePage2 = driver.getWindowHandle();
        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Account Transfer");
        PageObject.menu_Link("Account to Account Transfer- Online ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");


        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",testData.get("debit"));
        PageObject.click_Locator("fieldName:CREDIT.AMOUNT");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(HomePage2);
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT",testData.get("amount"));
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER",testData.get("chequeNum"));
        ///PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","123456789");

        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO",testData.get("credit"));
        PageObject.click_Locator("fieldName:CREDIT.AMOUNT");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(HomePage2);
        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.radiobutton_Locator("radio:mainTab:AML.TYP.CUST",1);
        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE",1);
        PageObject.textinput_Locator("fieldName:DEBIT.VALUE.DATE",testData.get("date"));
        PageObject.textinput_Locator("fieldName:CREDIT.VALUE.DATE",testData.get("date"));
/*

        PageObject.textarea_Locator("fieldName:NAME.COND.TXN","Customer");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","4220797762483");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT","21221231");
*/
        PageObject.commitDeal("IBG_FundsTransferOnline");
    }

    @Test(groups = {"IBGAuthorizer"},dataProvider = "excelDataAuthfTGeneral")
    public void authfTGeneral(Map<String, String> testData) throws IOException  {

        PageObject.menu_Dropdown("Payments/Zakat");
        PageObject.menu_Dropdown("Funds Transfer");

        PageObject.menu_Link("Account to Account Transfer ");

        String HomePage2 = driver.getWindowHandle();
        PageObject.switchToChildWindow();

        //Got the value from DataProvider file
        PageObject.textinput_Locator("transactionId",testData.get("Transaction Number"));
        PageObject.img_Button("Perform an action on the contract");
        PageObject.img_Button("Authorises a deal");
        WebElement theMsg = driver.findElement(By.xpath("(//td[@class='message'])[1]"));
        String Transaction = theMsg.getText();
        Assert.assertTrue(Transaction.contains("Deal slip printed"),"Deal slip not printed !");

    }


    @Test(groups = {"IBGAuthorizer"},dataProvider = "excelDataAuthfTOnline")
    public void authfTOnline(Map<String, String> testData) throws IOException  {

        PageObject.menu_Dropdown("Payments/Zakat");
        PageObject.menu_Dropdown("Funds Transfer");

        PageObject.menu_Link("Account to Account Transfer- Online ");

        String HomePage2 = driver.getWindowHandle();
        PageObject.switchToChildWindow();

        //Got the value from DataProvider file
        PageObject.textinput_Locator("transactionId",testData.get("Transaction Number"));
        PageObject.img_Button("Perform an action on the contract");
        PageObject.img_Button("Authorises a deal");
        WebElement theMsg = driver.findElement(By.xpath("(//td[@class='message'])[1]"));
        String Transaction = theMsg.getText();
        Assert.assertTrue(Transaction.contains("Deal slip printed"),"Deal slip not printed !");

    }

    @DataProvider(name = "excelDataAuthfTOnline")
    public Object[][] readExcelData4() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_FundsTransferOnline.xlsx";
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

    @DataProvider(name = "excelDataAuthfTGeneral")
    public Object[][] readExcelData3() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_FundsTransferGeneral.xlsx";
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


    @DataProvider(name = "excelDatafTGeneral")
    public Object[][] readExcelData2() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("General"); // Assuming data is in the first sheet
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

    @DataProvider(name = "excelDataForOnlineFt")
    public Object[][] readExcelData() throws IOException {
        // String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\FtGeneral.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("FtOnline"); // ftOnlineSheet
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
