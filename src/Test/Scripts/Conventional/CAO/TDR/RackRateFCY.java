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

public class RackRateFCY extends BaseClass {

    String Txn;
    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\RackRateFCY.xlsx";

    @Test(groups = {"InputterTDR"}, dataProvider = "excelDataRackRateFCY")

    public void RackRateFCY(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Term Deposits - Rack Rate");
        PageObject.menu_Link("Create Term Deposits FCY  ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

//        PageObject.img_Button("New Deal");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", testData.get("CUSTOMER.ID"));

        PageObject.click_Locator("fieldName:CURRENCY");

        String menu2 = PageObject.switchToChildWindow();
        driver.close();

//        String menu2 = PageObject.switchToChildWindow();

        PageObject.switchToParentWindow(menu1);

        PageObject.textinput_Locator("fieldName:CURRENCY",testData.get("CURRENCY"));
        PageObject.textinput_Locator("fieldName:FTD.TYPE",testData.get("FTD.TYPE"));
        PageObject.click_Locator("fieldName:PRINCIPAL");
        PageObject.textinput_Locator("fieldName:PRINCIPAL",testData.get("PRINCIPAL"));

//        PageObject.select_Locator("fieldName:PROFIT.PAY.TERM","");
//        PageObject.click_Locator("fieldName:INTEND.DATE");
//        PageObject.click_Locator("fieldName:CUST.REMARKS:1");
//        PageObject.click_Locator("fieldName:TAX.INTEREST.TYPE:1");

//        PageObject.form_Tab("Settlemnt / Charge Details");
//
//        PageObject.click_Locator("fieldName:DRAWDOWN.ACCOUNT");
//        PageObject.click_Locator("fieldName:PRIN.LIQ.ACCT");
//        PageObject.click_Locator("fieldName:INT.LIQ.ACCT");
//        PageObject.click_Locator("fieldName:CHRG.LIQ.ACCT");

        PageObject.form_Tab("Rollover Info");
        PageObject.radiobutton_Locator("radio:tab3:AUTO.ROLLOVER",Integer.parseInt(testData.get("AUTO.ROLLOVER")));

//        PageObject.click_Locator("fieldName:FINAL.MATURITY");
//        PageObject.click_Locator("fieldName:EXP.DATE");

        PageObject.commitDeal("RackRateFCY");

//        PageObject.authorizeByTxn(testData.get("Transaction Number"));





        Txn = PageObject.getTxn();
        System.out.println(Txn);

    }

    @DataProvider(name = "excelDataRackRateFCY")
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

        String Txn = accNumber ;
        System.out.println("Acc Number is: "+Txn);

        File file = new File(System.getProperty("user.dir") + "\\Data\\RackRateFCY.xlsx");
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

    String FILE_PATH2 = System.getProperty("user.dir") + "\\Data\\RackRateFCY.xlsx";

    @Test(groups = {"AuthorizerTDR"}, dataProvider = "DataRackRateFCY")

    public void RackRateFCYAuth(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR");
        PageObject.childmenu_Dropdown("Authorization Of TDR",1);
        PageObject.menu_Link("Authorization of Rack Rate & ODD TDR ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();


        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();


        PageObject.authorizeByTxn(testData.get("Transaction Number"));

        PageObject.img_Button("Authorises a deal");
    }

    @DataProvider(name = "DataRackRateFCY")
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
