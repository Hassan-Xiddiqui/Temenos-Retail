package Test.Scripts.IBG.RetailBanking;

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

public class PostRestrictionMarking_IBG extends BaseClass {

    String txn;

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\postRestrictionMarking_IBG.xlsx";

    @Test(groups = {"IBGInputter"}, dataProvider = "excelDatapostRestrictionMarking_IBG")
    public void postRestrictionMarking_IBG(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu- IBG");

        PageObject.menu_Dropdown("Account Maintenance");

        PageObject.menu_Link("Posting Restrict Marking ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.parentFrame();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1")); //1007891257
        PageObject.find_Button();

        PageObject.parentFrame();
        PageObject.switchFrame(0);

        PageObject.form_Link("Set/Remove Posting Restrict");

        PageObject.parentFrame();
        PageObject.switchFrame(1);

        PageObject.textinput_Locator("fieldName:POSTING.RESTRICT:1",testData.get("POSTING.RESTRICT:1"));
        PageObject.textinput_Locator("fieldName:POST.RESTR:1",testData.get("POST.RESTR:1"));
        PageObject.textinput_Locator("fieldName:POSTING.DATE:1",testData.get("POSTING.DATE:1"));  //Date should be current date of the system
        PageObject.select_Locator("fieldName:POSTING.REASON:1",testData.get("POSTING.REASON:1")); //Account Blocked By Court OR Blocked by CD - SS Unit

        PageObject.commitDeal("Posting Restrict Marking ");
        txn = PageObject.getTxn();
        System.out.println(txn);
    }

    public static void saveAccNumToFile(String accNumber) throws IOException {

        String TxnNum = accNumber ;
        System.out.println("Acc Number is: "+TxnNum);

        File file = new File(System.getProperty("user.dir") + "\\Data\\PostRestrictionMarking.xlsx");
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
    @DataProvider(name = "excelDatapostRestrictionMarking_IBG")
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


    @Test(groups = {"IBGAuthorizer"})

    public void postRestrictionMarking_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("ACCOUNT");
        PageObject.menu_Dropdown("Account Maintenance ");
        PageObject.menu_Link("Authorisation of Posting Restriction- Marking ");

        String menu1 = PageObject.switchToChildWindow();


        PageObject.find_Button();

//        String menu2 = PageObject.switchToChildWindow();


        PageObject.form_Link("Authorise the Account");

        String menu2 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");

        txn = PageObject.getTxn();
        System.out.println(txn);

    }

    @DataProvider(name = "PostRestrictionMarkingData")
    public Object[][] PostRestrictionMarkingData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\PostRestrictionMarkingData.xlsx";
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
