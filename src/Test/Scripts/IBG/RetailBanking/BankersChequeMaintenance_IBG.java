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

public class BankersChequeMaintenance_IBG extends BaseClass {

    String FILE_PATH = "";

    @Test(groups = {"SS328565505"},dataProvider = "BankersChequeStaleInstrumentRevalidate")
    public void BankersChequeStaleInstrumentRevalidate (Map<String, String> testData) throws IOException, InterruptedException  {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Maintenance",1);
        PageObject.childmenu_Link("Cheque Stale Instrument Re-validate ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1"));//ISFK0001018
        PageObject.find_Button();

        PageObject.parentFrame();
        PageObject.form_Link("Active Instrument");
        PageObject.switchToChildWindow();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();
        PageObject.img_Button("Commit the deal");
    }

    @DataProvider(name = "BankersChequeStaleInstrumentRevalidate")
    public Object[][] dataMethod1() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeMaintenance_IBG.xlsx";
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

    @Test(groups = {"MH214215505"},dataProvider = "AuthorizationIssueStaleInstrument")
    public void AuthorizationIssueStaleInstrument (Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Authorization Issue Stale Instrument", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
//        PageObject.switchFrame(0);

//        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1"));
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
//        PageObject.parentFrame();
//        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "AuthorizationIssueStaleInstrument")
    public Object[][] dataMethod2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeMaintAuth_IBG.xlsx";
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
//----------------------------------------------------------------------------------------------------------------------
    @Test(groups = {"SS328565505"},dataProvider = "BankersChequeDuplicateIssuance")
    public void BankersChequeDuplicateIssuance (Map<String, String> testData) throws IOException, InterruptedException  {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Maintenance",1);
        PageObject.childmenu_Link("Cheque Duplicate Issuance ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1"));
        PageObject.find_Button();
        PageObject.form_Link("Duplicate Issue");
        PageObject.radiobutton_Locator("radio:tab1:CHARGE.EXEMPT",1);
        PageObject.commitDeal("BankersChequeDuplicateIssuance");
    }
    @DataProvider(name = "BankersChequeDuplicateIssuance")
    public Object[][] dataMetho3() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeMaintenance_IBG.xlsx";;
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

    @Test(groups = {"MH214215505"},dataProvider = "BankersChequeDuplicateIssuanceAuth")
    public void BankersChequeDuplicateIssuanceAuth(Map<String, String> testData) throws InterruptedException, IOException   {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Authorization of Duplicate ", 1);

        String menu1 = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        driver.switchTo().parentFrame();
//        PageObject.switchFrame(1);
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:1:1:1",testData.get("value:1:1:1"));
        Thread.sleep(5000);
        PageObject.find_Button();
        PageObject.form_Link("Authorise Duplicate BC Charges");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "BankersChequeDuplicateIssuanceAuth")
    public Object[][] dataMetho4() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeMaintAuth_IBG.xlsx";
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
//----------------------------------------------------------------------------------------------------------------------

    @Test(groups = {"SS328565505"},dataProvider = "BankersChequeCancellation")
    public void BankersChequeCancellation (Map<String, String> testData) throws IOException, InterruptedException   {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Maintenance",1);
        PageObject.childmenu_Link("Cheque Cancellation ", 1);
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF",testData.get("CREDIT.THEIR.REF"));//IKHI0004761
        PageObject.radiobutton_Locator("radio:tab1:COMMISSION.CODE",2);
       PageObject.commitDeal("BankersChequeCancellation");
//        PageObject.switchToChildWindow();
    }
    @DataProvider(name = "BankersChequeCancellation")
    public Object[][] dataMethod() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeMaintenance_IBG.xlsx";
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


    // This is for Authorization of Banker cheque cancellation.
     @Test(groups = {"Authorizer"})
    public void AuthorizationOfDuplicateBankersCheque () throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Authorization of Duplicate Banker", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Authorise Duplicate BC Charges");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }
    //----------------------------------------------------------------------------------------------------------------------
    @Test(groups = {"Authorizer"})
    public void DeleteIssueStaleInstrument () throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Authorization Issue Stale Instrument", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Delete a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Deletes a Deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void AuthorisationStopStatusofBankerCheque () throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Authorisation Stop Status of Banker Cheque", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
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

    @Test(groups = {"Authorizer"})
    public void AuthorizeTransfertoVendorPaymentAccount () throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Authorize Transfer to Vendor Payment Account", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        //PageObject.img_Button("Authorises a deal");
        //PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void DeleteTransfertoVendorPaymentAccount () throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Authorize Transfer to Vendor Payment Account", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Delete a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Deletes a Deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void AuthorisationBankersCheqCashTransaction () throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Cheq-Cash Transaction", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
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

    @Test(groups = {"Authorizer"})
    public void DeleteBankersCheqCashTransaction () throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Cheq-Cash Transaction", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Delete a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Deletes a Deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

}
