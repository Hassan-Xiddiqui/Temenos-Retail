package Test.Scripts.Conventional.CAO.TDR;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RemoveRolloverofMahanaAamdanPlus1Year extends BaseClass {

    String Txn;
//    String FILE_PATH1 = System.getProperty("user.dir") + "\\Data\\RemoveRolloverofDeposits.xlsx";

    @Test(groups = {"InputterTDR"})

    public void RemoveRolloverofMahanaAamdanPlus1Year() throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Remove Rollover ");
        PageObject.menu_Link("Remove Rollover of Mahana Aamdan Plus 1 Year ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

//        PageObject.childmenu_Link("Remove Rollover",1);
        driver.findElement(By.xpath("//*[@id=\"r1\"]/td[9]/a")).click();
        PageObject.click_Locator("CheckBox:fieldName:REMOVE.ROLLOVER");

        Thread.sleep(2000);
//        PageObject.textinput_Locator("fieldName:CUST.REMARKS:1","Testing");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();


        PageObject.commitDeal("RemoveRolloverofMahanaAamdanPlus1Year");

//        PageObject.authorizeByTxn(testData.get("Transaction Number"));





        Txn = PageObject.getTxn();
        System.out.println(Txn);

    }

    //    @DataProvider(name = "excelDataRemoveRolloverofDeposits")
//    public Object[][] readExcelData1() throws IOException {
//
//        FileInputStream fis = new FileInputStream(FILE_PATH1);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
    public static void saveAccNumToFile(String accNumber) throws IOException {

        String Txn = accNumber ;
        System.out.println("Acc Number is: "+Txn);

        File file = new File(System.getProperty("user.dir") + "\\Data\\RemoveRolloverofMahanaAamdanPlus1Year.xlsx");
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
        cell.setCellValue(Txn);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

    }

    String FILE_PATH2 = System.getProperty("user.dir") + "\\Data\\RemoveRolloverofMahanaAamdanPlus1Year.xlsx";

    @Test(groups = {"AuthorizerTDR"}, dataProvider = "DataRemoveRolloverofMahanaAamdanPlus1Year")

    public void RemoveRolloverofMahanaAamdanPlus1YearAuth(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR");
        PageObject.menu_Dropdown("Print Deal Slip");
        PageObject.menu_Link("Print TDR Reciept Rollover ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

// MM2300400089
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();


        PageObject.childmenu_Link("View Deal Slip",1);
        PageObject.authorizeByTxn(testData.get("Transaction Number"));

        PageObject.img_Button("Authorises a deal");
    }

    @DataProvider(name = "DataRemoveRolloverofMahanaAamdanPlus1Year")
    public Object[][] readExcelData2() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH2);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
//        rowCount-=2;
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
