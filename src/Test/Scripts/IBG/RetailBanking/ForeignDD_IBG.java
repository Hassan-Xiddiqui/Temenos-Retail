package Test.Scripts.IBG.RetailBanking;

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

public class ForeignDD_IBG extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\ ForeignDD.xlsx";

    @Test(groups = {"IBGInputter"}, dataProvider = "excelDataForeignDD")

    public void CDRForeignDDIBG(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Deposit/Payment/Zakat/FT");
        PageObject.menu_Dropdown("Foreign Currency Remittances");
        PageObject.menu_Dropdown("Outward Remittance");
        PageObject.menu_Link("Foreign Demand Draft (MT110) ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");


        PageObject.textinput_Locator("fieldName:CREDIT.CURRENCY", testData.get("CREDIT.CURRENCY"));
        PageObject.textinput_Locator("fieldName:INSTRUMENT.TYPE:1", testData.get("INSTRUMENT.TYPE:1"));
        Thread.sleep(3000);

        PageObject.click_Locator("fieldName:CREDIT.AMOUNT");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", testData.get("CREDIT.AMOUNT"));
        String HomePage2 = driver.getWindowHandle();
        PageObject.click_Locator("fieldName:DEBIT.ACCT.NO");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", testData.get("DEBIT.ACCT.NO"));
        PageObject.click_Locator("fieldName:DEBIT.ACCT.NO");


        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", testData.get("BEN.CUSTOMER:1"));

        PageObject.switchToChildWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);
        PageObject.radiobutton_Locator("radio:tab1:COMMISSION.CODE",4);

        PageObject.radiobutton_Locator("radio:tab1:REMITTANCE.TYPE",3);


        PageObject.form_Tab("MT110 Details");

        PageObject.select_Locator("fieldName:SEND.TO.PARTY:1", testData.get("SEND.TO.PARTY:1"));

        PageObject.textinput_Locator("fieldName:BK.TO.BK.OUT:1:1", testData.get("BK.TO.BK.OUT:1:1"));

        PageObject.commitDeal("ForeignDemandDraftInput");


    }

    @DataProvider(name = "excelDataForeignDD")
    public Object[][] readExcelData1() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        //rowCount-=2;
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


    @Test(groups = {"Authorizer"})

    public void ForeignDemandDraft_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("IBG - Manager Operation Menu");

        PageObject.menu_Dropdown("Core Retail Menu");

        PageObject.menu_Dropdown("Payments/Zakat");

        PageObject.menu_Dropdown("Funds Transfer");

        PageObject.menu_Dropdown("Foreign Currency Remittances");

        PageObject.menu_Dropdown("Outward Remittance");

        PageObject.menu_Link("Foreign Demand Draft (MT110) ");

        PageObject.parentFrame();

        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId","");

        PageObject.img_Button("Perform an action on the contract");

        // String menu2 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");

    }

    @DataProvider(name = "ForeignDD")
    public Object[][]  ForeignDDinputData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\ForeignDD.xlsx";
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
