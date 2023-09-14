package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LockerSurrender extends BaseClass {

    String SurrTxn;
    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\LockerSurrender.xlsx";

    @Test(groups = {"Inputter"}, dataProvider = "excelDataLockerSurrender")

    public void LockerSurrender(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Locker Surrender");


        PageObject.menu_Link("Locker Surrender ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1"));
        PageObject.find_Button();

        PageObject.form_Link("Surrender Version");

        PageObject.textinput_Locator("fieldName:BRK.REASON:1", testData.get("BRK.REASON:1"));

        String menu1 = PageObject.switchToChildWindow();

        PageObject.img_Button("Commit the deal");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        SurrTxn = PageObject.getTxn();
        System.out.println(SurrTxn);

    }

    @DataProvider(name = "excelDataLockerSurrender")
    public Object[][] readExcelData1() throws IOException {

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

    public static void saveAccNumToFile(String accNumber) throws IOException {

        String TxnNum = accNumber ;
        System.out.println("Acc Number is: "+TxnNum);

        File file = new File(System.getProperty("user.dir") + "\\Data\\LockerSurrender.xlsx");
        XSSFWorkbook workbook;
        Row row;
        Cell cell;
        int rowNum = 0;

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            rowNum = sheet.getLastRowNum() + 1; // Start writing from the next row
        } else {
            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellValue("Acc Number");
        }

        Sheet sheet = workbook.getSheetAt(0);
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue(TxnNum);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

    }
    @Test(groups = {"Authorizer"})

    public void lockerSurrender_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Locker- Authorizer Menu");
        PageObject.menu_Dropdown("Locker Surrender");
        PageObject.menu_Link("Locker Surrender - Authorization ");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.parentFrame();
        PageObject.switchFrame(1);

//        PageObject.find_Button();

//        String menu2 = PageObject.switchToChildWindow();


        PageObject.form_Link("Authorize");

        String menu2 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");

        String menu3 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");

        SurrTxn = PageObject.getTxn();
        System.out.println(SurrTxn);

    }

    @DataProvider(name = "LockerSurrenderData")
    public Object[][] LockerSurrenderData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\LockerSurrenderData.xlsx";
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
