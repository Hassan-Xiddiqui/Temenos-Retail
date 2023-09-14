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

public class BankersChequeReport_IBG extends BaseClass {

    @Test(groups = {"inputterIBG"},dataProvider = "BankersChequeReport")
    public void BankersChequeReport(Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Report",1);
        PageObject.childmenu_Link("Cheque Instrument  ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1"));//20230104
        PageObject.find_Button();

    }

    String FILE_PATH = "";
    @DataProvider(name = "BankersChequeReport")
    public Object[][] dataMethod() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeReport_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
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

    @Test(groups = {"authorizerIBG"},dataProvider = "ListOfBankersChequeInstrument")
    public void ListOfBankersChequeInstrument (Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Report", 1);
        PageObject.childmenu_Link("Cheque Instrument  ", 1);
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1        "));
        PageObject.find_Button();

    }

    @DataProvider(name = "ListOfBankersChequeInstrument")
    public Object[][] dataMethod1() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeReport_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
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

}
