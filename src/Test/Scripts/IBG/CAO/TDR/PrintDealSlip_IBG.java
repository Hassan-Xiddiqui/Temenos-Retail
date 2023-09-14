package Test.Scripts.IBG.CAO.TDR;

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

public class PrintDealSlip_IBG extends BaseClass {

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "PrintTDRReciept")
    public void PrintTDRReciept  (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Print IBG Deal Slip", 1);
        PageObject.childmenu_Link("Print TDR Reciept ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1", testData.get("value:1:1:1"));//LD1419712927
        PageObject.find_Button();
        PageObject.form_Link("View Deal Slip");

    }

    @DataProvider(name = "PrintTDRReciept")
    public Object[][] dataMethod() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\PrintDealSlip_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PrintTDRReciept"); // Assuming data is in the first sheet
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

    @Test(groups = {"InputterTDR_IBG"},dataProvider = "PrintTDRRecieptRollover")
    public void PrintTDRRecieptRollover   (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Print IBG Deal Slip", 1);
        PageObject.childmenu_Link("Print TDR Reciept Rollover ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();


        PageObject.textinput_Locator("value:1:1:1", testData.get("value:1:1:1"));//LD1419712927
        PageObject.find_Button();
        PageObject.form_Link("View Deal Slip");

    }

    @DataProvider(name = "PrintTDRRecieptRollover")
    public Object[][] dataMethod1() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\PrintDealSlip_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("PrintTDRRecieptRollover"); // Assuming data is in the first sheet
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
