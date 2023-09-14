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

public class CDR_Inward_Incity_IBG extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\ CDRInwardClearingInCity.xlsx";

    @Test(groups = {"IBGInputter"}, dataProvider = "excelDataCDRInwardClearingInCity")

    public void CDRInwardIncityIBG(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Inward Clearing");
        PageObject.menu_Link("Inward Clearing - Instruments Incity City ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CL.NO.MV", testData.get("CL.NO.MV"));
        PageObject.click_Locator("fieldName:CL.CHEQUE.NO:1");

        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1", testData.get("CL.CHEQUE.NO:1"));

        PageObject.click_Locator("fieldName:BANK.SORT.CODE:1");

        String HomePage2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1", testData.get("BANK.SORT.CODE:1"));

        //PageObject.commitDeal("CDRInwardInterCityCase");
    }

    @DataProvider(name = "excelDataCDRInwardClearingInCity")
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

    public void  CCDRInwardIncity_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("IBG - Manager Operation Menu");

        PageObject.menu_Dropdown("Core Retail Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Inward Clg Authorization");

        PageObject.menu_Link("Authorization of Inward Clearing Incity City ");

        PageObject.find_Button();

        PageObject.form_Link("Authorize Transaction");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");
    }

    @DataProvider(name = "CDRInwardClearingInCity")
    public Object[][]  CDRInwardClearingInCityinputData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CDRInwardClearingInCity.xlsx";
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
