package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BankersChequeIssuance_IBG extends BaseClass {

    String DebitAcc = "";

    @Test(groups = {"inputterIBG"},dataProvider = "BankersCheqSingleIssuanceAccountHolder")
    public void BankersCheqSingleIssuanceAccountHolder (Map<String, String> testData) throws IOException, InterruptedException {

        this.DebitAcc = testData.get("DEBIT.ACCT.NO");
        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu", 1);
        PageObject.childmenu_Link("Banker Cheque Single Issuance- Account Holder ", 1);


        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", testData.get("CREDIT.AMOUNT"));//6
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", testData.get("DEBIT.ACCT.NO"));
        PageObject.click_Locator("fieldName:BEN.CUSTOMER:1");//1
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", testData.get("BEN.CUSTOMER"));//Waqas Nadeem Khan
        PageObject.form_Tab("Due Delligence");
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1", testData.get("DD.ADDRESS"));//123 Building
        PageObject.textinput_Locator("fieldName:ID.TYPE", testData.get("ID.TYPE"));//ID-N
        PageObject.textinput_Locator("fieldName:ID.NUMBER", testData.get("ID.NUMBER"));//4222222222222
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1", testData.get("CONTACT.NO"));//03333333333
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");
        PageObject.form_Tab("Issue Instrument (Local Currency)");
        PageObject.commitDeal("BankersCheqSingleIssuanceAccountHolder");
        PageObject.switchToChildWindow();
    }



    String FILE_PATH = "";
    @DataProvider(name = "BankersCheqSingleIssuanceAccountHolder")
    public Object[][] dataMethod() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BC_Conv.xlsx";
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
    @Test(groups = {"authorizerIBG"})
    public void BankersCheqSingleIssuanceAccountHolderAuth() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Instrument SingleAuthorization ", 1);
        PageObject.childmenu_Link("Authorize Banker Chq Single-Act Holder", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:2:1:1",DebitAcc);
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "BankersCheqSingleIssuanceAccountHolderAuth")
    public Object[][] dataMethod1() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\BankersCheqSingleIssuanceAccountHolder.xlsx";
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

    @Test(groups = {"inputterIBG"},dataProvider = "BankerChequeSingleIssuanceWalkinCust")
    public void BankerChequeSingleIssuanceWalkinCust(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu", 1);
        PageObject.childmenu_Link("Banker Cheque Single Issuance- Walk-in Cust ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", testData.get("CREDIT.AMOUNT"));//14
        PageObject.click_Locator("fieldName:INST.NUMBER");
        PageObject.textinput_Locator("fieldName:INST.NUMBER", testData.get("INST.NUMBER"));//TT23004508781055
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", testData.get("BEN.CUSTOMER:1"));//Waqas Nadeem Khan
        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1", testData.get("ORDERING.CUST:1"));//Waqass
        PageObject.form_Tab("Due Delligence");
        PageObject.textinput_Locator("fieldName:APP.ADDRESS:1", testData.get("APP.ADDRESS:1"));//123 Building
        PageObject.textinput_Locator("fieldName:APP.ID.TYPE", testData.get("APP.ID.TYPE"));//ID-N
        PageObject.textinput_Locator("fieldName:CNIC.NO", testData.get("CNIC.NO"));//4222222222222
        PageObject.textinput_Locator("fieldName:APP.CONTACT.NO", testData.get("APP.CONTACT.NO"));//03333333333
        PageObject.textinput_Locator("fieldName:APP.MOTHER.NAME", testData.get("APP.MOTHER.NAME"));//Mother
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1", testData.get("DD.ADDRESS:1"));//123 Building
        PageObject.textinput_Locator("fieldName:ID.TYPE", testData.get("ID.TYPE"));//ID-N
        PageObject.textinput_Locator("fieldName:ID.NUMBER", testData.get("ID.NUMBER"));//4222222222221
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1", testData.get("CONTACT.NO:1"));//03333333331
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");
        PageObject.form_Tab("Issue Instrument (Local Currency)");
        PageObject.commitDeal("BankerChequeSingleIssuanceWalkinCust");
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "BankerChequeSingleIssuanceWalkinCust")
    public Object[][] dataMethod9() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
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

    @Test(groups = {"Authorizer"})
    public void BankerChequeSingleIssuanceWalkinCustAuth() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Instrument SingleAuthorization ", 1);
        PageObject.childmenu_Link("Authorize Banker Chq Single-Walkin Customer ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","111");
        PageObject.textinput_Locator("value:2:1:1","BC");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void BankerChequeSingleIssuanceWalkinCustAuthDelete() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Instrument SingleAuthorization ", 1);
        PageObject.childmenu_Link("Authorize Banker Chq Single-Walkin Customer ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:3:1:1","100");
        PageObject.textinput_Locator("value:2:1:1","BC");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void AuthorizeCollectionBankerChqCustMulti() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Instrument Bulk Authorization ", 1);
        PageObject.childmenu_Link("Authorize Collection Banker Chq -Cust (Multi)", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:2:1:1","1006948260");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"inputterIBG"},dataProvider = "BankerChequeSingleIssuanceVendorPayment")
    public void BankerChequeSingleIssuanceVendorPayment(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu", 1);
        PageObject.childmenu_Link("Banker Cheque Single Issuance- Vendor Payment ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", testData.get("BEN.CUSTOMER:1"));//Waqas Nadeem Khan
        PageObject.form_Tab("Due Delligence");
        PageObject.textinput_Locator("fieldName:APP.ADDRESS:1", testData.get("APP.ADDRESS:1"));//123 Building
        PageObject.textinput_Locator("fieldName:CNIC.NO", testData.get("CNIC.NO"));//4222222222222
        PageObject.textinput_Locator("fieldName:APP.CONTACT.NO", testData.get("APP.CONTACT.NO"));//03333333333
        PageObject.textinput_Locator("fieldName:APP.MOTHER.NAME", testData.get("APP.MOTHER.NAME"));//Mother
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1", testData.get("DD.ADDRESS:1"));//123 Building
        PageObject.textinput_Locator("fieldName:ID.TYPE", testData.get("ID.TYPE"));//ID-N
        PageObject.textinput_Locator("fieldName:ID.NUMBER", testData.get("ID.NUMBER"));//4222222222221
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1", testData.get("CONTACT.NO:1"));//03333333331
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");
        PageObject.form_Tab("Issue Instrument (Local Currency)");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", testData.get("CREDIT.AMOUNT"));//6
        PageObject.commitDeal("BankerChequeSingleIssuanceVendorPayment");
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "BankerChequeSingleIssuanceVendorPayment")
    public Object[][] dataMethod2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
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

    @Test(groups = {"inputterIBG"},dataProvider = "FundTrfCreditVendorPaytActSingleBulk")
    public void FundTrfCreditVendorPaytActSingleBulk(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu", 1);
        PageObject.childmenu_Link("Fund Trf Credit- Vendor Payt Act Single/ Bulk ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", testData.get("DEBIT.ACCT.NO"));//PKR159795505
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", testData.get("BEN.CUSTOMER:1"));//Waqas
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT", testData.get("DEBIT.AMOUNT"));//14
        PageObject.textinput_Locator("fieldName:ORDERING.BANK:1", testData.get("ORDERING.BANK:1"));//BAL
        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1", testData.get("ORDERING.CUST:1"));//Waqass
        PageObject.textinput_Locator("fieldName:DEBIT.CURRENCY", testData.get("DEBIT.CURRENCY"));//PKR
        PageObject.commitDeal("FundTrfCreditVendorPaytActSingleBulk");
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "FundTrfCreditVendorPaytActSingleBulk")
    public Object[][] dataMethod3() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(3); // Assuming data is in the first sheet
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

    @Test(groups = {"inputterIBG"},dataProvider = "CollectBankerChqAmtAcHolderBulkStep1")
    public void CollectBankerChqAmtAcHolderBulkStep1 (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq  Bulk Issuance Menu A\\c Holder", 1);
        PageObject.childmenu_Link("Collect Banker Chq Amt A/c Holder Bulk-Step-1 ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", testData.get("DEBIT.ACCT.NO"));//1007652804
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", testData.get("BEN.CUSTOMER:1"));//Waqas
        PageObject.textinput_Locator("fieldName:NO.OF.INST", testData.get("NO.OF.INST"));//2
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", testData.get("CREDIT.AMOUNT"));//14
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.img_Button("Commit the deal");
        PageObject.commitDeal("CollectBankerChqAmtAcHolderBulkStep1");
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "CollectBankerChqAmtAcHolderBulkStep1")
    public Object[][] dataMethod4() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(4); // Assuming data is in the first sheet
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

    @Test(groups = {"inputterIBG"},dataProvider = "IssuanceBankerChqAcHolderBulkStep2")
    public void IssuanceBankerChqAcHolderBulkStep2 (Map<String, String> testData) throws InterruptedException, IOException  {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq  Bulk Issuance Menu A\\c Holder", 1);
        PageObject.menu_Link("Issuance Banker Chq- A/c Holder Bulk- Step-2 ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:2:1:1",testData.get("value:2:1:1"));
        PageObject.find_Button();
        Thread.sleep(2000);

    }

    @DataProvider(name = "IssuanceBankerChqAcHolderBulkStep2")
    public Object[][] dataMethod5() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(5); // Assuming data is in the first sheet
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

    @Test(groups = {"inputterIBG"},dataProvider = "IssuanceBankerChqAcHolderBulkStep2")
    public void CollectBankerChqWCustSingleBulkStep1 (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Walkin Cust", 1);
        PageObject.childmenu_Link("Collect Banker Chq W/Cust-Single/Bulk- Step-1 ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", testData.get("AMOUNT.LOCAL.1:1"));//10
        PageObject.switchToChildWindow();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:NO.OF.INST", testData.get("NO.OF.INST"));//2
        PageObject.switchToChildWindow();
        PageObject.switchFrame(2);
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchToChildWindow();
        PageObject.switchFrame(2);
        PageObject.commitDeal("CollectBankerChqWCustSingleBulkStep1");
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "CollectBankerChqWCustSingleBulkStep1")
    public Object[][] dataMethod6() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(6); // Assuming data is in the first sheet
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
    @Test(groups = {"inputterIBG"},dataProvider = "IssuanceBankerChqWalkingCustBulkStep2")
    public void IssuanceBankerChqWalkingCustBulkStep2 (Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Walkin Cust", 1);
        PageObject.menu_Link("Issuance Banker Chq Walking Cust Bulk- Step-2 ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

    }

    @DataProvider(name = "IssuanceBankerChqWalkingCustBulkStep2")
    public Object[][] dataMethod7() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(7); // Assuming data is in the first sheet
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

    @Test(groups = {"inputterIBG"},dataProvider = "CollectBankerChqAmtVendorBulkStep1")
    public void CollectBankerChqAmtVendorBulkStep1 (Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Vendor Paymt", 1);
        PageObject.childmenu_Link("Collect Banker Chq Amt - Vendor Bulk- Step-1 ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:NO.OF.INST",testData.get("NO.OF.INST"));//2
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", testData.get("BEN.CUSTOMER:1"));//Waqas
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", testData.get("CREDIT.AMOUNT"));//14
        PageObject.textinput_Locator("fieldName:ORDERING.BANK:1", testData.get("ORDERING.BANK:1"));//BAL
        PageObject.commitDeal("CollectBankerChqAmtVendorBulkStep1");
        PageObject.switchToChildWindow();

    }

    @DataProvider(name = "CollectBankerChqAmtVendorBulkStep1")
    public Object[][] dataMethod8() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(8); // Assuming data is in the first sheet
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

    @Test(groups = {"inputterIBG"},dataProvider = "IssuanceofBankerChqVendorBulkStep2")
    public void IssuanceofBankerChqVendorBulkStep2 (Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Vendor Paymt", 1);
        PageObject.menu_Link("Issuance of Banker Chq - Vendor Bulk- Step-2 ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

    }

    @DataProvider(name = "IssuanceofBankerChqVendorBulkStep2")
    public Object[][] dataMetho10() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BankersChequeIssuance_IBG.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(9); // Assuming data is in the first sheet
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