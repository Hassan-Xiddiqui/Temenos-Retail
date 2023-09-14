//package Test.Scripts.IBG;
//
//import POM.PageObject;
//import Test.General.BaseClass;
//import lombok.ToString;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
////import static Test.General.ExtraMethods.*;
////import static Test.General.ExtraMethods.changeFrame;
//
//
//public class TellerCashIBG extends BaseClass{
//
//    String dateTodayGlobal = "20221231";
//
//    @Test(groups = "IBGInputter" , dataProvider = "cashDepoOnlineLCY")
//    public void cashDepoOnlineLCY(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String DepositAmount = testData.get("DepositAmount");
//        String DepositSlip = testData.get("DepositSlip");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY cash deposit - LCY A/c Online ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
////        PageObject.textinput_Locator("fieldName:ACCOUNT.1:1", "1000321229");
//        PageObject.textinput_Locator("fieldName:ACCOUNT.1:1", AccountNumber);
//        refreshWindow(2);
////        changeFrame(2);
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "1000");
////        changeFrame(2);
//        refreshWindow(2);
//
//        PageObject.textinput_Locator("fieldName:CASH.DSLIPNO", "1000001");
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        PageObject.textinput_Locator("fieldName:CX.ACCOUNT",  AccountNumber);
//        refreshWindow(2);
//        PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//        PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//        PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//
//        PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//        String newPage = PageObject.switchToChildWindow();
//        PageObject.switchFrame(2);
//
//        refreshWindow(2);
//
//        PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//        PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//        PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        commitDeal("IBG_cashDepoOnlineLCY");
//    }
//
//    @DataProvider(name = "cashDepoOnlineLCY")
//    public Object[][] readExcelData() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_cashDepoOnlineLCY.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "cashDepoOnlineLcy_Authorization")
//    public void cashDepoOnlineLcy_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY cash deposit - LCY A/c Online ");
//
//        String ChildPage1 = PageObject.switchToChildWindow();
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        Thread.sleep(3000);
//
//        int handleCount = driver.getWindowHandles().size();
//        String handleIds = driver.getWindowHandles().toString();
//        System.out.println(handleCount);
//        System.out.println(handleIds);
//        if (handleCount == 3) {
//            System.out.println("IN IF CONDITION");
//            String ChildPage2 = PageObject.switchToChildWindow();
//            driver.close();
//            PageObject.switchToParentWindow(homePage);
//            PageObject.switchToChildWindow();
//            System.out.println("in childPage1");
//            Thread.sleep(3000);
//        }
//        PageObject.maximizeWindow();
//        PageObject.authorizeDeal();
//        Thread.sleep(3000);
//        if (handleCount == 3) {
//            System.out.println("IN SECOND IF");
//            String ChildPage3 = PageObject.switchToChildWindow();
//            driver.close();
//            Thread.sleep(3000);
//            PageObject.switchToParentWindow(homePage);
//            PageObject.switchToChildWindow();
//            System.out.println("in childPage1");
//        }
//
//    }
//
//    @DataProvider(name = "cashDepoOnlineLcy_Authorization")
//    public Object[][] readExcelData_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_cashDepoOnlineLCY.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "IBGInputter" , dataProvider = "cashDepoWithinBranchLCY")
//    public void cashDepoWithinBranchLCY(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String DepositAmount = testData.get("DepositAmount");
//        String DepositSlip = testData.get("DepositSlip");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY cash deposit LCY A/c-(Within Branch) ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//        PageObject.textinput_Locator("fieldName:ACCOUNT.2", AccountNumber);
//
//        refreshWindow(2);
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", DepositAmount);
//
//        refreshWindow(2);
//
//        PageObject.textinput_Locator("fieldName:CASH.DSLIPNO", DepositSlip);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//        PageObject.commitDeal("IBG_cashDepoWithinBranchLCY");
//
//    }
//
//    @DataProvider(name = "cashDepoWithinBranchLCY")
//    public Object[][] readExcelData2() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_cashDepoWithinBranchLCY.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "cashDepoWithinBranchLCY_Authorization")
//    public void cashDepoWithinBranchLCY_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY cash deposit LCY A/c-(Within Branch) ");
//        homePage = PageObject.switchToChildWindow();
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        AssertionScreenshot("cashDepoWithinBranchLCY_Authorization");
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.img_Button("Authorises a deal");
//
//        int handlesCount = driver.getWindowHandles().size();
//        if (handlesCount == 3) {
//            String childPage = PageObject.switchToChildWindow();
//            driver.close();
//            PageObject.switchToParentWindow(childPage);
//        }
//
//    }
//
//    @DataProvider(name = "cashDepoWithinBranchLCY_Authorization")
//    public Object[][] readExcelData2_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_cashDepoWithinBranchLCY.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "LCYCashWithdrawalOnline")
//    public void LCYCashWithdrawalOnline(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String WithdrawAmount = testData.get("WithdrawAmount");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//        String ChequeNumber = testData.get("ChequeNumber");
//        String DateToday = dateTodayGlobal;
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - LCY A/c- Online ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE", DateToday);
//        refreshWindow(2);
//        PageObject.textinput_Locator("fieldName:ACCOUNT.1:1", AccountNumber);
//        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
//
//        String newPage = PageObject.switchToChildWindow();
//        driver.close();
//
//        PageObject.switchToParentWindow(newPage);
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", WithdrawAmount);
//        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER:1", ChequeNumber);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//
//        //page refresh here
//
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage2 = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//        PageObject.commitDeal("IBG_LCYCashWithdrawalOnline");
//
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalOnline")
//    public Object[][] readExcelData3() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_LCYCashWithdrawalOnline.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "LCYCashWithdrawalOnline_Authorization")
//    public void LCYCashWithdrawalOnline_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - LCY A/c- Online ");
//
//        homePage = PageObject.switchToChildWindow();
//        PageObject.maximizeWindow();
//        PageObject.textinput_Locator("transactionId", TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
////        refreshWindow(2);
//        PageObject.img_Button("Authorises a deal");
//
//        String childPage = PageObject.switchToChildWindow();
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalOnline_Authorization")
//    public Object[][] readExcelData3_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_LCYCashWithdrawalOnline.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "LCYCashWithdrawalWithinBranch")
//    public void LCYCashWithdrawalWithinBranch(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String WithdrawAmount = testData.get("WithdrawAmount");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//        String ChequeNumber = testData.get("ChequeNumber");
//        String DateToday = dateTodayGlobal;
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - LCY A/c-(Within Branch) ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:ACCOUNT.2",AccountNumber);
//        PageObject.click_Locator("fieldName:A.CHEQUE.DATE");
//
//        String newPage = PageObject.switchToChildWindow();
//        driver.close();
//
//        PageObject.switchToParentWindow(newPage);
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE", DateToday);
//        refreshWindow(2);
//        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1",WithdrawAmount);
//        refreshWindow(2);
//        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER:1", ChequeNumber);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage2 = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//        PageObject.commitDeal("IBG_LCYCashWithdrawalWithinBranch");
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalWithinBranch")
//    public Object[][] readExcelData4() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_LCYCashWithdrawalWithinBranch.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "LCYCashWithdrawalWithinBranch_Authorization")
//    public void LCYCashWithdrawalWithinBranch_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - LCY A/c-(Within Branch) ");
//
//        homePage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId", TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.img_Button("Authorises a deal");
//
//        int handlesCount = driver.getWindowHandles().size();
//        if (handlesCount == 3) {
//            String childPage = PageObject.switchToChildWindow();
//            driver.close();
//            PageObject.switchToParentWindow(childPage);
//        }
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalWithinBranch_Authorization")
//    public Object[][] readExcelData4_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_LCYCashWithdrawalWithinBranch.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "IBGInputter" , dataProvider = "LCYCashWithdrawalFCYAccFCYCheque")
//    public void LCYCashWithdrawalFCYAccFCYCheque(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String WithdrawAmount = testData.get("WithdrawAmount");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//        String ChequeNumber = testData.get("ChequeNumber");
//        String DateToday = dateTodayGlobal;
//        String WithdrawCurrency = testData.get("WithdrawCurrency");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - FCY A/c (FCY Cheque) ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:ACCOUNT.2",AccountNumber);
//        PageObject.click_Locator("fieldName:A.CHEQUE.DATE");
//
//        String newPage = PageObject.switchToChildWindow();
//        driver.close();
//
//        PageObject.switchToParentWindow(newPage);
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE", DateToday);
//        PageObject.textinput_Locator("fieldName:CURRENCY.1", WithdrawCurrency);
//        PageObject.textinput_Locator("fieldName:CONSUMER.NO",WithdrawAmount);
//        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER:1", ChequeNumber);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        refreshWindow(2);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage2 = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//        PageObject.commitDeal("IBG_LCYCashWithdrawalFCYAccFCYCheque");
//
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalFCYAccFCYCheque")
//    public Object[][] readExcelData5() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_LCYCashWithdrawalFCYAccFCYCheque.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "LCYCashWithdrawalFCYAccFCYCheque_Authorization")
//    public void LCYCashWithdrawalFCYAccFCYCheque_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - FCY A/c (FCY Cheque) ");
//
//        homePage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId", TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//
//        PageObject.img_Button("Authorises a deal");
//
//        String childPage = PageObject.switchToChildWindow();
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalFCYAccFCYCheque_Authorization")
//    public Object[][] readExcelData5_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_LCYCashWithdrawalFCYAccFCYCheque.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "FCYCashDeposit")
//    public void FCYCashDeposit(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String DepositAmount = testData.get("DepositAmount");
//        String DepositSlip = testData.get("DepositSlip");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//        String DepositedCurrency = testData.get("DepositedCurrency");
//
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("FCY Cash deposit ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:ACCOUNT.2", AccountNumber);
//
//        PageObject.textinput_Locator("fieldName:CURRENCY.1",DepositedCurrency);
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", DepositAmount);
//
//        refreshWindow(2);
//
//        PageObject.textinput_Locator("fieldName:CASH.DSLIPNO", DepositSlip);
//
//        PageObject.click_Locator("radio:tab1:AML.TYP.CUST");
//        refreshWindow(2);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage2 = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:REASON", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//
//        else
//        {
//            PageObject.textinput_Locator("fieldName:REASON","Testing");
//        }
//
//
//        PageObject.commitDeal("FCYCashDeposit");
//    }
//
//    @DataProvider(name = "FCYCashDeposit")
//    public Object[][] readExcelData6() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_FCYCashDeposit.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "TellerTransactionsDoneToday")
//    public void TellerTransactionsDoneToday(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerID = testData.get("TellerID");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.childmenu_Dropdown("Enquiries",5);
//        PageObject.menu_Link("Teller Transactions done Today ");
//
////        PageObject.switchToChildWindow();
//        String childPage = PageObject.switchToChildWindow();
//
////        PageObject.switchFrame(0);
//
//        PageObject.textinput_Locator("value:1:1:1",TellerID);
//        PageObject.find_Button();
//
//        PageObject.maximizeWindow();
//        AssertionScreenshot("TellerTransactionsDoneToday");
//
//        Thread.sleep(5000);
//
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//
//    }
//
//    @DataProvider(name = "TellerTransactionsDoneToday")
//    public Object[][] readExcelData7() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TellerTransactionsDoneToday.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "FCYCashDeposit_Authorization")
//    public void FCYCashDeposit_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("FCY Cash deposit ");
//
//        homePage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId", TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//
//        PageObject.img_Button("Authorises a deal");
//
//        String childPage = PageObject.switchToChildWindow();
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//
//    }
//
//    @DataProvider(name = "FCYCashDeposit_Authorization")
//    public Object[][] readExcelData6_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_FCYCashDeposit.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "IBGInputter" , dataProvider = "TellerCreditTransactionsDoneToday")
//    public void TellerCreditTransactionsDoneToday(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerID = testData.get("TellerID");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.childmenu_Dropdown("Enquiries",3);
//        PageObject.menu_Link("Teller Credit Transactions done Today ");
//
////        PageObject.switchToChildWindow();
//        String childPage = PageObject.switchToChildWindow();
//
////        PageObject.switchFrame(0);
//
//        PageObject.textinput_Locator("value:1:1:1",TellerID);
//        PageObject.find_Button();
//        Thread.sleep(5000);
//
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//    }
//
//    @DataProvider(name = "TellerCreditTransactionsDoneToday")
//    public Object[][] readExcelData8() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_TellerCreditTransactionsDoneToday.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "IBGInputter" , dataProvider = "TellerDebitTransactionsDoneToday")
//    public void TellerDebitTransactionsDoneToday(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerID = testData.get("TellerID");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.childmenu_Dropdown("Enquiries",3);
//        PageObject.menu_Link("Teller Debit Transactions done Today ");
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("value:1:1:1",TellerID);
//        PageObject.find_Button();
//        Thread.sleep(5000);
//
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//    }
//
//    @DataProvider(name = "TellerDebitTransactionsDoneToday")
//    public Object[][] readExcelData9() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_TellerDebitTransactionsDoneToday.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "IBGInputter", dataProvider = "DenominationSetupCash")
//    public void DenominationSetupCash(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String CurrencyType = testData.get("CurrencyType");
//        int amountPKR = 0;
//        double amountUSD = 0;
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Denomination Setup & Transaction");
//        PageObject.menu_Link("Denomination Transaction ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("transactionId", CurrencyType);
//        PageObject.img_Button("Edit a contract");
//
//        refreshWindow(2);
//
//
//        if (CurrencyType.equalsIgnoreCase("PKR")) {
//            for (int number = 0; number <= 6; number++) {
////                PageObject.img_Button("Expand Multi Value");
//                driver.findElement(By.xpath("(//tr/td/a/img[@alt='Expand Multi Value'])[1]")).click();
//            }
//
//            PageObject.textinput_Locator("fieldName:DENOM:1", "PKR10");
//            PageObject.textinput_Locator("fieldName:DENOM:2", "PKR20");
//            PageObject.textinput_Locator("fieldName:DENOM:3", "PKR50");
//            PageObject.textinput_Locator("fieldName:DENOM:4", "PKR75");
//            PageObject.textinput_Locator("fieldName:DENOM:5", "PKR100");
//            PageObject.textinput_Locator("fieldName:DENOM:6", "PKR500");
//            PageObject.textinput_Locator("fieldName:DENOM:7", "PKR1000");
//            PageObject.textinput_Locator("fieldName:DENOM:8", "PKR5000");
//
//            for (int number = 0; number <= 1; number++) {
////            PageObject.img_Button("Expand Multi Value");
//                driver.findElement(By.xpath("(//tr/td/a/img[@alt='Expand Multi Value'])[last()]")).click();
//            }
//
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "PKR01");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:2", "PKR02");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:3", "PKR05");
//
//            for (int number = 1; number <= 8; number++) {
//                PageObject.textinput_Locator("fieldName:QUANTITY:" + number, Integer.toString(0));
//            }
//
//            for (int number = 1; number <= 3; number++) {
//                PageObject.textinput_Locator("fieldName:QUANT.COIN:" + number, Integer.toString(0));
//            }
//
//            driver.findElement(By.xpath("//tr/td/a/img[@alt='Validate a deal']")).click();
//            WebElement AmountExceed = driver.findElement(By.xpath("//table/tbody/tr/td/span[contains(text(),'Amount exceeds')]"));
//            String Transaction = AmountExceed.getText();
//            String[] first = Transaction.split("-");
////            String[] second = first[1].split(" ");
//            String denominationAmount = first[1];
//            amountPKR = Integer.parseInt(denominationAmount);
//
//            int[] notes = new int[]{5000, 1000, 500, 100, 75, 50, 20, 10, 5, 2, 1};
//            int[] noteCounter = new int[11];
//
//            // count notes using Greedy approach
//            for (int i = 0; i < 11; i++) {
//                if (amountPKR >= notes[i]) {
//                    noteCounter[i] = amountPKR / notes[i];
//                    amountPKR = amountPKR % notes[i];
//                }
//            }
//
//            // Print notes
//            int note = 8;
//            int coin = 3;
//            for (int i = 0; i < 11; i++) {
//                if (noteCounter[i] != 0) {
////                    System.out.println(notes[i] + " : " + noteCounter[i]);
//
//                    String noteCount = Integer.toString(noteCounter[i]);
//                    if (note > 0) {
//                        PageObject.textinput_Locator("fieldName:QUANTITY:" + note, noteCount);
//                        note--;
//                    } else {
//                        PageObject.textinput_Locator("fieldName:QUANT.COIN:" + coin, noteCount);
//                        coin--;
//                    }
//
//                } else {
//                    System.out.println(notes[i] + " : " + noteCounter[i]);
//
//                    String noteCount = Integer.toString(noteCounter[i]);
//                    if (note > 0) {
//                        PageObject.textinput_Locator("fieldName:QUANTITY:" + note, noteCount);
//                        note--;
//                    } else {
//                        PageObject.textinput_Locator("fieldName:QUANT.COIN:" + coin, noteCount);
//                        coin--;
//                    }
//                }
//            }
//
//            AssertionScreenshot("IBG_DenominationSetupCash");
//
//            PageObject.commitDeal("IBG_DenominationSetupCash");
//
//        }
//        else if (CurrencyType.equalsIgnoreCase("USD")) {
//            for (int number = 0; number <= 5; number++) {
////                PageObject.img_Button("Expand Multi Value");
//                driver.findElement(By.xpath("(//tr/td/a/img[@alt='Expand Multi Value'])[1]")).click();
//            }
//
//            PageObject.textinput_Locator("fieldName:DENOM:1", "USD1");
//            PageObject.textinput_Locator("fieldName:DENOM:2", "USD2");
//            PageObject.textinput_Locator("fieldName:DENOM:3", "USD5");
//            PageObject.textinput_Locator("fieldName:DENOM:4", "USD10");
//            PageObject.textinput_Locator("fieldName:DENOM:5", "USD20");
//            PageObject.textinput_Locator("fieldName:DENOM:6", "USD50");
//            PageObject.textinput_Locator("fieldName:DENOM:7", "USD100");
//
//            for (int number = 0; number <= 5; number++) {
////            PageObject.img_Button("Expand Multi Value");
//                driver.findElement(By.xpath("(//tr/td/a/img[@alt='Expand Multi Value'])[last()]")).click();
//            }
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "USD");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:2", "USD1");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:3", "USD10");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:4", "USD2");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:5", "USD25");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:6", "USD5");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:7", "USD50");
//
//            for (int number = 1; number <= 7; number++) {
//                PageObject.textinput_Locator("fieldName:QUANTITY:" + number, Integer.toString(0));
//            }
//
//            for (int number = 1; number <= 7; number++) {
//                PageObject.textinput_Locator("fieldName:QUANT.COIN:" + number, Integer.toString(0));
//            }
//
//            driver.findElement(By.xpath("//tr/td/a/img[@alt='Validate a deal']")).click();
//            WebElement AmountExceed = driver.findElement(By.xpath("//table/tbody/tr/td/span[contains(text(),'Amount exceeds')]"));
//            String Transaction = AmountExceed.getText();
//            String[] first = Transaction.split("-");
////            String[] second = first[1].split(" ");
//            String denominationAmount = first[1];
//            amountUSD = Integer.parseInt(denominationAmount);
//
//            double[] notes = new double[]{100, 50, 20, 10, 5, 2, 1, .50, 0.05, 0.25, 0.02, 0.10, 0.01, 1};
//            int[] noteCounter = new int[14];
//
//            // count notes using Greedy approach
//            for (int i = 0; i < 14; i++) {
//                if (amountUSD >= notes[i]) {
//                    double noteCountDoubleValue = amountUSD / notes[i];
//                    noteCounter[i] = (int)noteCountDoubleValue;
//                    amountUSD = amountUSD % notes[i];
//                }
//            }
//
//            // Print notes
//            int note = 7;
//            int coin = 7;
//            for (int i = 0; i < 14; i++) {
//                if (noteCounter[i] != 0) {
////                    System.out.println(notes[i] + " : " + noteCounter[i]);
//
//                    String noteCount = Integer.toString(noteCounter[i]);
//                    if (note > 0) {
//                        PageObject.textinput_Locator("fieldName:QUANTITY:" + note, noteCount);
//                        note--;
//                    } else {
//                        PageObject.textinput_Locator("fieldName:QUANT.COIN:" + coin, noteCount);
//                        coin--;
//                    }
//
//                } else {
//                    System.out.println(notes[i] + " : " + noteCounter[i]);
//
//                    String noteCount = Integer.toString(noteCounter[i]);
//                    if (note > 0) {
//                        PageObject.textinput_Locator("fieldName:QUANTITY:" + note, noteCount);
//                        note--;
//                    } else {
//                        PageObject.textinput_Locator("fieldName:QUANT.COIN:" + coin, noteCount);
//                        coin--;
//                    }
//                }
//            }
//
//            AssertionScreenshot("DenominationSetupCash");
//
//            PageObject.commitDeal("DenominationSetupCash");
//
//        }
//
//    }
//
//    @DataProvider(name = "DenominationSetupCash")
//    public Object[][] readExcelData11() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_DenominationSetupCash.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "DenominationSetupCash_Authorization")
//    public void DenominationSetupCash_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Denomination Setup");
//        PageObject.menu_Link("Authorise of Denomination Transaction ");
//
//        String childPage = PageObject.switchToChildWindow();
//
////        PageObject.parentFrame();
////        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("value:1:1:1", TxnNumber);
//        PageObject.find_Button();
//
//        driver.findElement(By.xpath("//tr/td/a[text()='Authorise Transaction']")).click();
//
//        PageObject.img_Button("Authorises a deal");
//
////        String childPage2 = PageObject.switchToChildWindow();
////        driver.close();
//    }
//
//    @DataProvider(name = "DenominationSetupCash_Authorization")
//    public Object[][] readExcelData11_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_DenominationSetupCash.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "IBGInputter" , dataProvider = "DenominationSetupPrizeBond")
//    public void DenominationSetupPrizeBond(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String CurrencyType = testData.get("CurrencyType");
//        String PB100 = testData.get("PB100");
//        String PB1500 = testData.get("PB1500");
//        String PB15000 = testData.get("PB15000");
//        String PB200 = testData.get("PB200");
//        String PB25000 = testData.get("PB25000");
//        String PB40000 = testData.get("PB40000");
//        String PB750 = testData.get("PB750");
//        String PB7500 = testData.get("PB7500");
//
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.menu_Link("Prize Bond Denomination ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("transactionId","PB");
//        PageObject.img_Button("Edit a contract");
//
//        refreshWindow(2);
//
//        for (int number = 0; number <= 6; number++) {
//            PageObject.img_Button("Expand Multi Value");
//        }
//
//        PageObject.textinput_Locator("fieldName:DENOM:1", "PB100");
//        PageObject.textinput_Locator("fieldName:DENOM:2", "PB1500");
//        PageObject.textinput_Locator("fieldName:DENOM:3", "PB15000");
//        PageObject.textinput_Locator("fieldName:DENOM:4", "PB200");
//        PageObject.textinput_Locator("fieldName:DENOM:5", "PB25000");
//        PageObject.textinput_Locator("fieldName:DENOM:6", "PB40000");
//        PageObject.textinput_Locator("fieldName:DENOM:7", "PB750");
//        PageObject.textinput_Locator("fieldName:DENOM:8", "PB7500");
//
//        PageObject.textinput_Locator("fieldName:QUANTITY:1", PB100);
//        PageObject.textinput_Locator("fieldName:QUANTITY:2", PB1500);
//        PageObject.textinput_Locator("fieldName:QUANTITY:3", PB15000);
//        PageObject.textinput_Locator("fieldName:QUANTITY:4", PB200);
//        PageObject.textinput_Locator("fieldName:QUANTITY:5", PB25000);
//        PageObject.textinput_Locator("fieldName:QUANTITY:6", PB40000);
//        PageObject.textinput_Locator("fieldName:QUANTITY:7", PB750);
//        PageObject.textinput_Locator("fieldName:QUANTITY:8", PB7500);
//
//
//        PageObject.commitDeal("DenominationSetupPrizeBond");
//    }
//    @DataProvider(name = "DenominationSetupPrizeBond")
//    public Object[][] readExcelData12() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_DenominationSetupPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "DenominationSetupPrizeBond_Authorization")
//    public void DenominationSetupPrizeBond_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.menu_Link("Prize Bond Denomination Authorization  ");
//
//        String childPage = PageObject.switchToChildWindow();
//
////        PageObject.parentFrame();
////        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("value:1:1:1", TxnNumber);
//        PageObject.find_Button();
//
////        driver.findElement(By.xpath("//tr/td/a[text()='Authorise Transaction']")).click();
//
//        PageObject.img_Button("Authorises a deal");
//
////        String childPage2 = PageObject.switchToChildWindow();
////        driver.close();
//    }
//
//    @DataProvider(name = "DenominationSetupPrizeBond_Authorization")
//    public Object[][] readExcelData12_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_DenominationSetupPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "IBGInputter" , dataProvider = "UtilityBillsReceivedAgainstCash")
//    public void UtilityBillsReceivedAgainstCash(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String Amount = testData.get("Amount");
//        String ConsumerNumber = testData.get("ConsumerNumber");
//
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Utility Bills");
//        PageObject.menu_Link("Utility Bills Recieved Against Cash ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        //img dropdown
//        driver.findElement(By.xpath("//tr/td/a/img[@class='dropdown_button dropdown_button_TELLER dropdown_button_TELLER_PKUTILITYBILL']")).click();
//        //seleting an option from dropdown
//        driver.findElement(By.xpath("//tr/td[contains(text(),'KWSB')]")).click();
////        refreshWindow(2);
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//
////        PageObject.textinput_Locator("fieldName:CONSUMER.NO", "");
//
//        PageObject.commitDeal("UtilityBillsReceivedAgainstCash");
//    }
//
//    @DataProvider(name = "UtilityBillsReceivedAgainstCash")
//    public Object[][] readExcelData13() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_UtilityBillsReceivedAgainstCash.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "BalanceBookPKR")
//    public void BalanceBookPKR(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String tellerID = testData.get("TellerID");
//
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.childmenu_Dropdown("Enquiries",3);
//        PageObject.menu_Link("Cash Balance Book(PKR)  ");
//
////        PageObject.parentFrame();
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("value:1:1:1",tellerID);
//        PageObject.find_Button();
//        PageObject.maximizeWindow();
//        AssertionScreenshot("BalanceBookPKR");
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//    }
//
//    @DataProvider(name = "BalanceBookPKR")
//    public Object[][] readExcelData14() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_BalanceBookPKR.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    /*__________________________________________________________________________*/
//
//    @Test(groups = "IBGInputter" , dataProvider = "BankerChequeWalkinCustomerTT")
//    public void BankerChequeWalkinCustomerTT(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String Amount = testData.get("Amount");
//        String NoOfInstruments = testData.get("NoOfInstruments");
//        String Purpose = testData.get("Purpose");
//
//        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
//        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')])[1]")).click();
//        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,'Cheque Issuance')])[1]")).click();
//        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,'Cheq Bulk Issuance Menu Walkin Cust')])[1]")).click();
//        PageObject.menu_Link("Collect Banker Chq W/Cust-Single/Bulk- Step-1 ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//        PageObject.click_Locator("fieldName:NO.OF.INST");
//        refreshWindow(2);
//
//        PageObject.textinput_Locator("fieldName:NO.OF.INST", NoOfInstruments);
//        PageObject.click_Locator("fieldName:NARRATIVE.2:1");
//
//        refreshWindow(2);
//
//        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE",Purpose);
//
//       PageObject.commitDeal("IBG_BankerChequeWalkinCustomerTT");
//    }
//
//    @DataProvider(name = "BankerChequeWalkinCustomerTT")
//    public Object[][] readExcelData15() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_BankerChequeWalkinCustomerTT.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "IBGInputter" , dataProvider = "BankerChequeWalkinCustomerFT")
//    public void BankerChequeWalkinCustomerFT(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
////        String Amount = testData.get("Amount");
//        String TT = testData.get("Transaction Number");
//        /*String Beneficiary = testData.get("Beneficiary");
//        String Applicant = testData.get("Applicant");*/
//
//        /*String ApplicantAddress = testData.get("ApplicantAddress");
//        String ApplicantID = testData.get("ApplicantID");
//        String ApplicantCnic = testData.get("ApplicantCnic");
//        String ApplicantContact = testData.get("ApplicantContact");
//        String ApplicantMotherName = testData.get("ApplicantMotherName");
//        String BeneficiaryAddress = testData.get("BeneficiaryAddress");
//        String BeneficiaryID = testData.get("BeneficiaryID");
//        String BeneficiaryCnic = testData.get("BeneficiaryCnic");
//        String BeneficiaryContact = testData.get("BeneficiaryContact");
////        String ChequePurpose = testData.get("ChequePurpose");
//        String ChequePurpose = "Rental Payment";*/
//
//        String Amount = "50000";
//        String Beneficiary = "SOMEONE BENEFICIARY";
//        String Applicant = "SOME APPLICANT";
//        String ApplicantAddress = "SOME ADDRESS";
//        String ApplicantID = "ID-N";
//        String ApplicantCnic = "9850000000001";
//        String ApplicantContact = "03698523658";
//        String ApplicantMotherName = "SOME MOTHER";
//        String BeneficiaryAddress = "SOME ADDRESS";
//        String BeneficiaryID = "ID-N";
//        String BeneficiaryCnic = "9850000000002";
//        String BeneficiaryContact = "03658963257";
////        String ChequePurpose = testData.get("ChequePurpose");
//        String ChequePurpose = "Rental Payment";
//
//
//        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
//        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')])[1]")).click();
//        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,'Cheque Issuance')])[1]")).click();
//        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,'Cheq Single Issuance Menu')])[1]")).click();
//        PageObject.menu_Link("Banker Cheque Single Issuance- Walk-in Cust ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", Amount);
//        PageObject.textinput_Locator("fieldName:INST.NUMBER", TT);
//        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", Beneficiary);
//        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1", Applicant);
//
//        PageObject.form_Tab("Due Delligence");
//
//        PageObject.textinput_Locator("fieldName:APP.ADDRESS:1", ApplicantAddress);
//        PageObject.textinput_Locator("fieldName:APP.ID.TYPE", ApplicantID);
//        PageObject.textinput_Locator("fieldName:CNIC.NO", ApplicantCnic);
//        PageObject.textinput_Locator("fieldName:APP.CONTACT.NO", ApplicantContact);
//        PageObject.textinput_Locator("fieldName:APP.MOTHER.NAME", ApplicantMotherName);
//        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1", BeneficiaryAddress);
//        PageObject.textinput_Locator("fieldName:ID.TYPE", BeneficiaryID);
//        PageObject.textinput_Locator("fieldName:ID.NUMBER", BeneficiaryCnic);
//        PageObject.textinput_Locator("fieldName:CONTACT.NO:1", BeneficiaryContact);
//        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE",ChequePurpose);
//
//        PageObject.commitDeal("IBG_BankerChequeWalkinCustomerFT");
//    }
//
//    @DataProvider(name = "BankerChequeWalkinCustomerFT")
//    public Object[][] readExcelData16() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_BankerChequeWalkinCustomerTT.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "IBGInputter" , dataProvider = "PrizeBondSell")
//    public void PrizeBondSell(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String Amount = testData.get("Amount");
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerName = testData.get("CustomerName");
//        String IdType = testData.get("IdType");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicNumber = testData.get("CnicNumber");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.menu_Link("Prize Bond - Sell ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//        PageObject.click_Locator("fieldName:CX.ACCOUNT");
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", 2);
//        PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//        PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", IdType);
//        PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//        PageObject.textinput_Locator("fieldName:CNIC.NO", CnicNumber);
//
//        PageObject.commitDeal("IBG_PrizeBondSell");
//    }
//
//    @DataProvider(name = "PrizeBondSell")
//    public Object[][] readExcelData17() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_PrizeBondSell.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "PrizeBondSell_Authorization")
//    public void PrizeBondSell_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.menu_Link("Prize Bond - Sell ");
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "PrizeBondSell_Authorization")
//    public Object[][] readExcelData17_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_PrizeBondSell.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "IBGInputter" , dataProvider = "PrizeBondBuy")
//    public void PrizeBondBuy(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String Amount = testData.get("Amount");
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerName = testData.get("CustomerName");
//        String IdType = testData.get("IdType");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicNumber = testData.get("CnicNumber");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.menu_Link("Prize Bond - Buy ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//        PageObject.click_Locator("fieldName:CX.ACCOUNT");
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", 2);
//        PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//        PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", IdType);
//        PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//        PageObject.textinput_Locator("fieldName:CNIC.NO", CnicNumber);
//
//        PageObject.commitDeal("IBG_PrizeBondBuy");
//    }
//
//    @DataProvider(name = "PrizeBondBuy")
//    public Object[][] readExcelData18() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_PrizeBondBuy.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "PrizeBondBuy_Authorization")
//    public void PrizeBondBuy_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.menu_Link("Prize Bond - Buy ");
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "PrizeBondBuy_Authorization")
//    public Object[][] readExcelData18_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_PrizeBondBuy.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "LCYTillTransferPrizeBond")
//    public void LCYTillTransferPrizeBond(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerId = testData.get("TellerId");
//        String Amount = testData.get("Amount");
//        String Narrative = testData.get("Narrative");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.childmenu_Link("LCY Till Transfer ",1);
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", TellerId);
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//        PageObject.click_Locator("fieldName:NARRATIVE.1:1:1");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1", Narrative);
//
//        PageObject.commitDeal("IBG_LCYTillTransferPrizeBond");
//    }
//
//    @DataProvider(name = "LCYTillTransferPrizeBond")
//    public Object[][] readExcelData19() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_LCYTillTransferPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "LCYTillTransferPrizeBond_Authorization")
//    public void LCYTillTransferPrizeBond_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.childmenu_Link("LCY Till Transfer ",2);
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "LCYTillTransferPrizeBond_Authorization")
//    public Object[][] readExcelData19_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_LCYTillTransferPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "TillToVaultTransferPrizeBond")
//    public void TillToVaultTransferPrizeBond(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerId = testData.get("TellerId");
//        String Amount = testData.get("Amount");
//        String Narrative = testData.get("Narrative");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.childmenu_Link("Till to Vault ",1);
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//        PageObject.img_Button("New Deal");
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//        PageObject.click_Locator("fieldName:NARRATIVE.1:1:1");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1", Narrative);
//
//        PageObject.commitDeal("IBG_TillToVaultTransferPrizeBond");
//    }
//
//    @DataProvider(name = "TillToVaultTransferPrizeBond")
//    public Object[][] readExcelData20() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_TillToVaultTransferPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "TillToVaultTransferPrizeBond_Authorization")
//    public void TillToVaultTransferPrizeBond_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.childmenu_Link("Till to Vault ",3);
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "TillToVaultTransferPrizeBond_Authorization")
//    public Object[][] readExcelData20_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_TillToVaultTransferPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "VaultToTillTransferPrizeBond")
//    public void VaultToTillTransferPrizeBond(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerId = testData.get("TellerId");
//        String Amount = testData.get("Amount");
//        String Narrative = testData.get("Narrative");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.childmenu_Link("Vault To Till ",1);
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//        PageObject.img_Button("New Deal");
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//        PageObject.click_Locator("fieldName:NARRATIVE.1:1:1");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1", Narrative);
//
//        PageObject.commitDeal("IBG_VaultToTillTransferPrizeBond");
//    }
//
//    @DataProvider(name = "VaultToTillTransferPrizeBond")
//    public Object[][] readExcelData21() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_VaultToTillTransferPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "VaultToTillTransferPrizeBond_Authorization")
//    public void VaultToTillTransferPrizeBond_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.childmenu_Link("Vault To Till ",2);
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "VaultToTillTransferPrizeBond_Authorization")
//    public Object[][] readExcelData21_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_VaultToTillTransferPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "LCYTillTransfer")
//    public void LCYTillTransfer(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerId = testData.get("TellerId");
//        String Amount = testData.get("Amount");
//        String Narrative = testData.get("Narrative");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("LCY Till Transfer ",2);
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", TellerId);
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//        PageObject.click_Locator("fieldName:NARRATIVE.1:1:1");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1", Narrative);
//
//        PageObject.commitDeal("IBG_LCYTillTransfer");
//    }
//
//    @DataProvider(name = "LCYTillTransfer")
//    public Object[][] readExcelData22() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_LCYTillTransfer.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "LCYTillTransfer_Authorization")
//    public void LCYTillTransfer_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("LCY Till Transfer ",1);
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "LCYTillTransfer_Authorization")
//    public Object[][] readExcelData22_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_LCYTillTransfer.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "FCYTillTransfer")
//    public void FCYTillTransfer(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerId = testData.get("TellerId");
//        String Amount = testData.get("Amount");
//        String Currency = testData.get("Currency");
//        String Narrative = testData.get("Narrative");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("FCY Till Transfer ",1);
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", TellerId);
//        PageObject.textinput_Locator("fieldName:CURRENCY.1", Currency);
//        PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", Amount);
//        PageObject.click_Locator("fieldName:NARRATIVE.1:1:1");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1", Narrative);
//
//        PageObject.commitDeal("IBG_FCYTillTransfer");
//    }
//
//    @DataProvider(name = "FCYTillTransfer")
//    public Object[][] readExcelData23() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_FCYTillTransfer.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "FCYTillTransfer_Authorization")
//    public void FCYTillTransfer_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("FCY Till Transfer ",1);
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "FCYTillTransfer_Authorization")
//    public Object[][] readExcelData23_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_FCYTillTransfer.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "TillToVault")
//    public void TillToVault(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerId = testData.get("TellerId");
//        String LCYAmount = testData.get("LCYAmount");
//        String FCYAmount = testData.get("FCYAmount");
//        String Currency = testData.get("Currency");
//        String Narrative = testData.get("Narrative");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("Till to Vault ",2);
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:CURRENCY.1", Currency);
//        if (Currency.equalsIgnoreCase("PKR")) {
//            PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", LCYAmount);
//        }
//        else {
//            PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", FCYAmount);
//        }
//        PageObject.click_Locator("fieldName:NARRATIVE.1:1:1");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1", Narrative);
//
//        PageObject.commitDeal("IBG_TillToVault");
//    }
//
//    @DataProvider(name = "TillToVault")
//    public Object[][] readExcelData24() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_TillToVault.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "TillToVault_Authorization")
//    public void TillToVault_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("Till to Vault ",1);
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "TillToVault_Authorization")
//    public Object[][] readExcelData24_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_TillToVault.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "VaultToTill")
//    public void VaultToTill(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerId = testData.get("TellerId");
//        String LCYAmount = testData.get("LCYAmount");
//        String FCYAmount = testData.get("FCYAmount");
//        String Currency = testData.get("Currency");
//        String Narrative = testData.get("Narrative");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("Vault To Till ",2);
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:CURRENCY.1", Currency);
//        if (Currency.equalsIgnoreCase("PKR")) {
//            PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", LCYAmount);
//        }
//        else {
//            PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", FCYAmount);
//        }
//        PageObject.click_Locator("fieldName:NARRATIVE.1:1:1");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1", Narrative);
//
//        PageObject.commitDeal("IBG_VaultToTill");
//    }
//
//    @DataProvider(name = "VaultToTill")
//    public Object[][] readExcelData25() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_VaultToTill.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "VaultToTill_Authorization")
//    public void VaultToTill_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("Vault To Till ",1);
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "VaultToTill_Authorization")
//    public Object[][] readExcelData25_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_VaultToTill.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "TillToATM")
//    public void TillToATM(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerId = testData.get("TellerId");
//        String AtmTill = testData.get("AtmTill");
//        String Amount = testData.get("Amount");
//        String Narrative = testData.get("Narrative");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("Till to ATM ",1);
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:TELLER.ID.2", TellerId);
//        PageObject.click_Locator("fieldName:TELLER.ID.1");
//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", AtmTill);
//        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//        PageObject.click_Locator("fieldName:NARRATIVE.1:1:1");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1", Narrative);
//
//        PageObject.commitDeal("IBG_TillToATM");
//    }
//
//    @DataProvider(name = "TillToATM")
//    public Object[][] readExcelData26() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_TillToATM.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "TillToATM_Authorization")
//    public void TillToATM_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("Till to ATM ",1);
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "TillToATM_Authorization")
//    public Object[][] readExcelData26_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_TillToATM.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//
//
//    @Test(groups = "IBGInputter" , dataProvider = "AtmToTill")
//    public void AtmToTill(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerId = testData.get("TellerId");
//        String AtmTill = testData.get("AtmTill");
//        String Amount = testData.get("Amount");
//        String Narrative = testData.get("Narrative");
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("ATM to Till ",1);
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:TELLER.ID.2", AtmTill);
//        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
//        PageObject.textinput_Locator("fieldName:TELLER.ID.1", TellerId);
//        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", Amount);
//        PageObject.click_Locator("fieldName:NARRATIVE.1:1:1");
//        PageObject.textinput_Locator("fieldName:NARRATIVE.1:1:1", Narrative);
//
//        PageObject.commitDeal("IBG_TillToATM");
//    }
//
//    @DataProvider(name = "AtmToTill")
//    public Object[][] readExcelData27() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_AtmToTill.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//    @Test(groups = "Authorizer" , dataProvider = "AtmToTill_Authorization")
//    public void AtmToTill_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Till Transfer (CASH)");
//        PageObject.childmenu_Link("ATM to till ",1);
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.authorizeDeal();
//    }
//
//    @DataProvider(name = "AtmToTill_Authorization")
//    public Object[][] readExcelData27_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IBG_TillToATM.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//    @Test(groups = "Inputter" , dataProvider = "TillCashPositionTeller")
//    public void TillCashPositionTeller(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String tellerID = testData.get("TellerID");
//
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.childmenu_Dropdown("Enquiries",3);
//        PageObject.menu_Link("Till Cash Position - Teller ");
//
////        PageObject.parentFrame();
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("value:1:1:1",tellerID);
//        PageObject.find_Button();
//        PageObject.maximizeWindow();
//        AssertionScreenshot("TillCashPositionTeller");
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//    }
//
//    @DataProvider(name = "TillCashPositionTeller")
//    public Object[][] readExcelData28() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_TillCashPositionTeller.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//    @Test(groups = "Inputter" , dataProvider = "TillCashPositionVaultTill")
//    public void TillCashPositionVaultTill(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String tellerID = testData.get("TellerID");
//
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.childmenu_Dropdown("Enquiries",3);
//        PageObject.menu_Link("Till Cash Position - VAULT Till ");
//
////        PageObject.parentFrame();
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("value:1:1:1",tellerID);
//        PageObject.find_Button();
//        PageObject.maximizeWindow();
//        AssertionScreenshot("TillCashPositionVaultTill");
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//    }
//
//    @DataProvider(name = "TillCashPositionVaultTill")
//    public Object[][] readExcelData29() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_TillCashPositionVaultTill.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//
//
//    @Test(groups = "Inputter" , dataProvider = "TillCashPositionVaultTillPkr")
//    public void TillCashPositionVaultTillPkr(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String tellerID = testData.get("TellerID");
//
//
//        PageObject.menu_Dropdown("Teller Menu - Universal Teller -IBG");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.childmenu_Dropdown("Enquiries",3);
//        PageObject.menu_Link("Till Cash Position - VAULT Till EQ PKR ");
//
////        PageObject.parentFrame();
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("value:1:1:1",tellerID);
//        PageObject.find_Button();
//        PageObject.maximizeWindow();
//        AssertionScreenshot("TillCashPositionVaultTillPkr");
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//    }
//
//    @DataProvider(name = "TillCashPositionVaultTillPkr")
//    public Object[][] readExcelData30() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IBG_TillCashPositionVaultTillPkr.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
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
//
//
//}
