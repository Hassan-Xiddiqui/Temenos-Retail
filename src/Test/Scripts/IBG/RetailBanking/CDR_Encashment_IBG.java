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

public class CDR_Encashment_IBG extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\ CDREncashmentinput.xlsx";

    @Test(groups = {"IBGInputter"}, dataProvider = "excelDataCDREncashmentinput")

    public void CDREncashmentIBG(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance");
        PageObject.menu_Link("Call Deposit Receipt Encashment (Within Bank) ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO", testData.get("CREDIT.ACCT.NO"));
        PageObject.click_Locator("fieldName:CREDIT.THEIR.REF");

        String HomePage2 = PageObject.switchToChildWindow();
        //PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF", testData.get("CREDIT.THEIR.REF"));

        //PageObject.commitDeal("CDREncashment");


    }

    @DataProvider(name = "excelDataCDREncashmentinput")
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

    public void  CDREncashment_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("IBG - Manager Operation Menu");

        PageObject.menu_Dropdown("Core Retail Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance Authorize");

        PageObject.menu_Link("Authorization Encashment CDR Instrument- FT ");

        String menu1 = PageObject.switchToChildWindow();

        PageObject.find_Button();

        PageObject.form_Link("Authorize Transaction");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");

    }

    @DataProvider(name = "CDREncashmentinput")
    public Object[][]  CDREncashmentinputinputData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CDREncashmentinput.xlsx";
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
