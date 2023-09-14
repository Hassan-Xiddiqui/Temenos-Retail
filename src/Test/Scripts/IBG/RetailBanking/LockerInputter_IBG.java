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

public class LockerInputter_IBG extends BaseClass {

    String lockerTxn;
    String amendSingleTxn;
    String amendJointTxn;

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\assignLocker_IBG.xlsx";
    @Test(groups = {"IBGInputter"}, dataProvider = "excelDataassignLocker_IBG")

    public void assignLocker_IBG(Map<String, String> testData) throws IOException, InterruptedException {

        String AssignLocker = "13238663";

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Locker Inputter Meu");
//        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
//        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Assign Locker");


        PageObject.menu_Link("Assign Locker ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.form_Link("Joint");

        PageObject.textinput_Locator("fieldName:KEY",testData.get("KEY"));
        PageObject.textinput_Locator("fieldName:CUSTOMER",testData.get( AssignLocker));
        PageObject.click_Locator("fieldName:CUST.ACCT");

        Thread.sleep(2000);

        PageObject.textinput_Locator("fieldName:CUST.ACCT",testData.get("CUST.ACCT"));
        PageObject.textinput_Locator("fieldName:JOINT.CNO:1",testData.get("JOINT.CNO:1"));
        PageObject.select_Locator("fieldName:OPEARTING.INST",testData.get("OPEARTING.INST"));
        PageObject.textinput_Locator("fieldName:OPEARTING.NAME:1", testData.get("OPEARTING.NAME:1"));
        PageObject.radiobutton_Locator("radio:mainTab:CHARGES.WAIVE",2);
        PageObject.radiobutton_Locator("radio:mainTab:KEY.DEPOSIT",1);
        PageObject.radiobutton_Locator("radio:tab1:MANDATEE",2);


        PageObject.commitDeal("Assign Locker IBG");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        lockerTxn = PageObject.getTxn();
        System.out.println(lockerTxn);
        saveAccNumToFile(AssignLocker);

    }

    @DataProvider(name = "excelDataassignLocker_IBG")
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

        File file = new File(System.getProperty("user.dir") + "\\Data\\Assign Locker IBG.xlsx");
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
    @Test(groups = {"IBGAuthorizer"})

    public void assignLocker_AuthIBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Locker- Authorizer Menu");
        PageObject.menu_Dropdown("Assign Locker");
        PageObject.menu_Link("Assign Locker - Authorization ");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.parentFrame();
        PageObject.switchFrame(1);

        //table/tbody/tr/td/a[text()='Authorise Locker Assign Charges'][1]

        PageObject.formindex_Link("Authorise Locker Assign Charges",1);

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Authorises a deal");

        String menu3 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Authorises a deal");

        lockerTxn = PageObject.getTxn();
        System.out.println(lockerTxn);

    }

    @DataProvider(name = "excelDataassignLocker_IBGAuth")
    public Object[][] readExcelData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\Assign Locker IBG.xlsx";
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


    String FILE_PATH1 = System.getProperty("user.dir")+"\\Excel Data\\amendmentLockerSingleIBG.xlsx";
    @Test(groups = {"IBGInputter"}, dataProvider = "excelDataamendmentLockerSingleIBG")

    public void amendmentLockerSingleIBG(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
//        PageObject.menu_Dropdown("Remittance Menu");
//        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Meu");
        PageObject.menu_Dropdown("Locker Amendment");


        PageObject.menu_Link("Amendment of Locker Single ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1"));
        PageObject.find_Button();


        PageObject.form_Link("Amendment Version");

        PageObject.textinput_Locator("fieldName:KEY",testData.get("KEY"));
        PageObject.select_Locator("fieldName:STATUS",testData.get("STATUS"));
        PageObject.textinput_Locator("fieldName:CUST.ACCT",testData.get("CUST.ACCT")); //1000058935 5000077867
        PageObject.radiobutton_Locator("radio:tab1:CHARGES.WAIVE",1);
        PageObject.textinput_Locator("fieldName:BRK.REASON:1",testData.get("BRK.REASON:1"));

        PageObject.commitDeal("Amendment of Locker Single IBG");

        amendSingleTxn = PageObject.getTxn();
        System.out.println(amendSingleTxn);
//        saveAccNumToFile(amendmentLockerSingle);
    }
    @DataProvider(name = "excelDataamendmentLockerSingleIBG")
    public Object[][] readExcelData2() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH1);
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

    public static void saveAccNumToFile1(String accNumber) throws IOException {

        String TxnNum = accNumber ;
        System.out.println("Acc Number is: "+TxnNum);

        File file = new File(System.getProperty("user.dir") + "\\Data\\AmendmentLockerSingleIBG.xlsx");
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

    @Test(groups = {"IBGAuthorizer"})

    public void amendmentLocker_AuthIBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Locker- Authorizer Menu");
        PageObject.menu_Dropdown("Locker Amendment");
        PageObject.menu_Link("Locker Amendment- Authorization ");

        String menu1 = PageObject.switchToChildWindow();
        //PageObject.maximizeWindow();


        //table/tbody/tr/td/a[text()='Authorise Locker Assign Charges'][1]

//        PageObject.textinput_Locator("value:1:1:1","OR.0009.0031");
        PageObject.find_Button();

        String menu2 = PageObject.switchToChildWindow();
//        PageObject.maximizeWindow();

        PageObject.form_Link("Authorize");

        String menu3 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");

        lockerTxn = PageObject.getTxn();
        System.out.println(lockerTxn);

    }

    @DataProvider(name = "amendLockerSIBGData")
    public Object[][] amendLockerSIBGData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\AmendmentLockerSingleIBG.xlsx";
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


    String FILE_PATH2 = System.getProperty("user.dir")+"\\Excel Data\\amendmentLockerJointIBG.xlsx";
    @Test(groups = {"IBGInputter"}, dataProvider = "excelDataamendmentLockerJointIBG")

    public void amendmentLockerJointIBG(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
//        PageObject.menu_Dropdown("Remittance Menu");
//        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Meu");
        PageObject.menu_Dropdown("Locker Amendment");


        PageObject.menu_Link("Amendment of Locker Joint ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1"));
        PageObject.find_Button();


        PageObject.form_Link("Joint Amendment Version");


        PageObject.textinput_Locator("fieldName:KEY",testData.get("KEY"));
        PageObject.select_Locator("fieldName:STATUS",testData.get("STATUS"));
        PageObject.textinput_Locator("fieldName:CUST.ACCT",testData.get("CUST.ACCT"));
        PageObject.radiobutton_Locator("radio:tab1:CHARGES.WAIVE",1);
        PageObject.textinput_Locator("fieldName:BRK.REASON:1",testData.get("BRK.REASON:1"));

        PageObject.commitDeal("AmendmentLockerJointIBG");

        amendJointTxn = PageObject.getTxn();
        System.out.println(amendJointTxn);
    }

    @DataProvider(name = "excelDataamendmentLockerJointIBG")
    public Object[][] readExcelData3() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH2);
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

    public static void saveAccNumToFile2(String accNumber) throws IOException {

        String TxnNum = accNumber ;
        System.out.println("Acc Number is: "+TxnNum);

        File file = new File(System.getProperty("user.dir") + "\\Data\\AmendmentLockerJointIBG.xlsx");
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

    @Test(groups = {"IBGAuthorizer"})

    public void amendmentLockerJoint_AuthIBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Locker- Authorizer Menu");
        PageObject.menu_Dropdown("Locker Amendment");
        PageObject.menu_Link("Locker Amendment- Authorization ");

        String menu1 = PageObject.switchToChildWindow();
        //PageObject.maximizeWindow();


        //table/tbody/tr/td/a[text()='Authorise Locker Assign Charges'][1]

//        PageObject.textinput_Locator("value:1:1:1","OR.0001.0031");
        PageObject.find_Button();

        String menu2 = PageObject.switchToChildWindow();
//        PageObject.maximizeWindow();

        PageObject.form_Link("Authorize");

        String menu3 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");

        lockerTxn = PageObject.getTxn();
        System.out.println(lockerTxn);

    }

    @DataProvider(name = "amendLockerJIBGData")
    public Object[][] amendLockerJIBGData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\AmendmentLockerJointIBG.xlsx";
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
