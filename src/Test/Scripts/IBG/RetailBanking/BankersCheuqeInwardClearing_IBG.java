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

public class BankersCheuqeInwardClearing_IBG extends BaseClass {
    @Test(groups = {"SS328565505"},dataProvider = "InwardClearingNormalBankersCheque")
    public void InwardClearingNormalBankersCheque(Map<String, String> testData) throws IOException, InterruptedException    {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheuqe Inward Clearing", 1);
        PageObject.childmenu_Link("Inward Clearing Normal", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1", testData.get("CL.CHEQUE.NO:1"));//ISFK0012078
        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1", testData.get("BANK.SORT.CODE:1"));
        PageObject.textinput_Locator("fieldName:CL.NO.MV", testData.get("CL.NO.MV"));
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.commitDeal("InwardClearingNormalBankersCheque");

    }

    String FILE_PATH = "";
    @DataProvider(name = "InwardClearingNormalBankersCheque")
    public Object[][] dataMethod() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersCheuqeInwardClearing_IBG.xlsx";
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
    @Test(groups = {"MH214215505"},dataProvider = "AuthorizationofNormalClearingBC")
    public void AuthorizationofNormalClearingBC(Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Normal Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.click_Locator("value:1:1:1");
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("Authorise Transaction");

        //Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }
    @Test(groups = {"MH214215505"},dataProvider = "AuthorizationofNormalClearingBC")
    public void DeletionOfNormalClearingBC(Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Normal Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.click_Locator("value:1:1:1");
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("Authorise Transaction");

        //Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }
    @DataProvider(name = "AuthorizationofNormalClearingBC")
    public Object[][] dataMethod1() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\InwardClearingNormalBankersCheque.xlsx";
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

    @Test(groups = {"SS328565505"},dataProvider = "InwardClearingIntercityBankersCheque")
    public void InwardClearingIntercityBankersCheque(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheuqe Inward Clearing", 1);
        PageObject.childmenu_Link("Inward Clearing Intercity", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1", testData.get("CL.CHEQUE.NO:1"));//ISFK0012079
        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1", testData.get("BANK.SORT.CODE:1"));//001
        PageObject.textinput_Locator("fieldName:CL.NO.MV", testData.get("CL.NO.MV"));
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.commitDeal("InwardClearingIntercityBankersCheque");
    }

    @DataProvider(name = "InwardClearingIntercityBankersCheque")
    public Object[][] dataMethod3() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersCheuqeInwardClearing_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(1); // Assuming data is in the first sheet
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
    @Test(groups = {"MH214215505"},dataProvider = "AuthorizationOfIntercityClearingBC")
    public void AuthorizationOfIntercityClearingBC(Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Intercity Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }
    @DataProvider(name = "AuthorizationOfIntercityClearingBC")
    public Object[][] dataMethod4(Map<String, String> testData) throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\InwardClearingIntercityBankersCheque1.xlsx";
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

    @Test(groups = {"MH214215505"},dataProvider = "DeletionOfIntercityClearingBC")
    public void DeletionOfIntercityClearingBC(Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Normal Clearing- BC ", 1);
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("Delete a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Deletes a Deal");
        PageObject.switchToChildWindow();
        //driver.close();
//        PageObject.switchToParentWindow(menu1);
//        PageObject.switchToChildWindow();

    }
    @DataProvider(name = "DeletionOfIntercityClearingBC")
    public Object[][] dataMethod5(Map<String, String> testData) throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\InwardClearingIntercityBankersCheque1.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(1); // Assuming data is in the first sheet
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

    @Test(groups = {"SS328565505"},dataProvider = "InwardClearingSameDayBankersCheque")
    public void InwardClearingSameDayBankersCheque(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheuqe Inward Clearing", 1);
        PageObject.childmenu_Link("Inward Clearing Same Day", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1",testData.get("CL.CHEQUE.NO:1"));//ISFK0012076
        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1", testData.get("BANK.SORT.CODE:1"));//001
        PageObject.textinput_Locator("fieldName:CL.NO.MV", testData.get("CL.NO.MV"));//1
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.commitDeal("InwardClearingSameDayBankersCheque");

    }

    @DataProvider(name = "InwardClearingSameDayBankersCheque")
    public Object[][] dataMethod2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersCheuqeInwardClearing_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(2); // Assuming data is in the first sheet
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
    @Test(groups = {"MH214215505"},dataProvider = "SameDayClearingBC")
    public void AuthorizationOfSameDayClearingBC(Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Same Day Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();



        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("Authorise Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "SameDayClearingBC")
    public Object[][] dataMethod5() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\InwardClearingSameDayBankersCheque.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        rowCount=2;
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

    @Test(groups = {"MH214215505"},dataProvider = "DeletionOfSameDayClearingBC")
    public void DeletionOfSameDayClearingBC(Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Same Day Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("Delete Transaction");
    //        PageObject.parentFrame();
    //        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Deletes a Deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }
    @DataProvider(name = "DeletionOfSameDayClearingBC")
    public Object[][] dataMethod6() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\InwardClearingSameDayBankersCheque.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(1 ); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        //rowCount=3;
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
