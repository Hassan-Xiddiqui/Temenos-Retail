package Test.Scripts.Conventional.CAO.TDR;

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

public class AmendmentTermDepositsSpecialRate extends BaseClass {

    String Txn;
    String FILE_PATH1 = System.getProperty("user.dir") + "\\Data\\SpecialRateLCY.xlsx";

    @Test(groups = {"InputterTDR"}, dataProvider = "excelDataAmendmentTermDepositsSpecialRate")

    public void AmendmentTermDepositsSpecialRate(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Amendment For Term Deposits - Rack & Special");
        PageObject.menu_Link("Amendment Term Deposits Special Rate ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("transactionId",testData.get("Transaction Number"));
        PageObject.img_Button("Edit a contract");

//        PageObject.click_Locator("fieldName:CUSTOMER.ID");
//        PageObject.click_Locator("fieldName:DEAL.DATE");
//        PageObject.click_Locator("fieldName:VALUE.DATE");
//        PageObject.click_Locator("fieldName:MATURITY.DATE");
//        PageObject.click_Locator("fieldName:INTEREST.RATE");
//        PageObject.click_Locator("fieldName:INTEND.DATE");
        PageObject.textinput_Locator("fieldName:CUST.REMARKS:1","Testing");
//        PageObject.click_Locator("fieldName:LIMIT.REFERENCE");
//        PageObject.click_Locator("fieldName:TAX.INTEREST.TYPE:1");
//        PageObject.click_Locator("fieldName:AUTO.ROLL.TERM");
//        PageObject.click_Locator("fieldName:ROLLOVER.INT.RATE");
//        PageObject.click_Locator("fieldName:FINAL.MATURITY");

        PageObject.form_Tab("Settlemnt / Charge Details");

        PageObject.click_Locator("fieldName:CHRG.LIQ.ACCT");


        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();


        PageObject.commitDeal("AmendmentTermDepositsSpecialRate");

        PageObject.authorizeByTxn(testData.get("Transaction Number"));





        Txn = PageObject.getTxn();
        System.out.println(Txn);

    }

    @DataProvider(name = "excelDataAmendmentTermDepositsSpecialRate")
    public Object[][] readExcelData1() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH1);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        rowCount=2;
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

        String Txn = accNumber ;
        System.out.println("Acc Number is: "+Txn);

        File file = new File(System.getProperty("user.dir") + "\\Data\\AmendmentTermDepositsSpecialRate.xlsx");
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

    String FILE_PATH2 = System.getProperty("user.dir") + "\\Data\\AmendmentTermDepositsSpecialRate.xlsx";

    @Test(groups = {"AuthorizerTDR"}, dataProvider = "DataAmendmentTermDepositsSpecialRate")

    public void AmendmentTermDepositsSpecialRateAuth(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR");
        PageObject.childmenu_Dropdown("Authorization Of TDR",1);
        PageObject.menu_Link("Authorisation of Special Rate Term Deposits  ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

// MM2300400089
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();


        PageObject.authorizeByTxn(testData.get("Transaction Number"));

        PageObject.img_Button("Authorises a deal");
    }

    @DataProvider(name = "DataAmendmentTermDepositsSpecialRate")
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
