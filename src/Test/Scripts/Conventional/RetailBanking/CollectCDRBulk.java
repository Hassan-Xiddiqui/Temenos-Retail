package Test.Scripts.Conventional.RetailBanking;

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

public class CollectCDRBulk extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\CDRCollectBulk.xlsx";

    @Test( groups = {"Inputter"},  dataProvider = "excelDataCDRCollectBulk")

    public void CDRBulkIssuance(Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");
        PageObject.menu_Link("Collect CDR Amount A/c Holder Bulk-Step-1 ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", testData.get("CREDIT.AMOUNT"));
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", testData.get("DEBIT.ACCT.NO"));

        PageObject.click_Locator("fieldName:NO.OF.INST");

        String HomePage2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);

//        PageObject.textarea_Locator("fieldName:CHEQUE.NUMBER",testData.get("CHEQUE.NUMBER"));
//        PageObject.textarea_Locator("fieldName:ORDERING.BANK:1",testData.get("ORDERING.BANK:1"));

        PageObject.textinput_Locator("fieldName:NO.OF.INST", testData.get("NO.OF.INST"));
        PageObject.radiobutton_Locator("radio:tab1:COMMISSION.CODE" , 3 );
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1", testData.get("COMMISSION.TYPE:1"));
        PageObject.textinput_Locator("fieldName:COMMISSION.AMT:1", testData.get("COMMISSION.AMT:1"));

        //PageObject.commitDeal("CDRBulkIssuance");

    }

    @DataProvider(name = "excelDataCDRCollectBulk")
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

    public void CDRBulkIssuance_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Manager Operation Menu");

        PageObject.menu_Dropdown("Core Retail Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Instrument Authorization");

        PageObject.menu_Link("Authorization Bulk CDR Instrument ");

        PageObject.find_Button();

        PageObject.form_Link("Authorize Transaction");

        String menu2 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");


    }

    @DataProvider(name = "CDRCollectBulk")
    public Object[][]  CDRCollectBulkinputData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CDRCollectBulk.xlsx";
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
