package Test.Scripts.IBG.CAO.CAOD;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JointAccountCreation extends BaseClass {


    @Test(groups = {"CaoInputterIBG"},dataProvider = "inputterData1")
    public void JointAccCreation_FCY_Current(Map<String, String> testData) {
//
        PageObject.menu_Dropdown("IBG Account Open ");//test
        PageObject.menu_Dropdown("Foriegn Currency Account Open ");
        PageObject.childmenu_Link("Current Account  ",3);
        String homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:CUSTOMER",testData.get("Cid"));
        PageObject.textinput_Locator("fieldName:CURRENCY",testData.get("Currency"));
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY",testData.get("CategoryProduct"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",testData.get("Acc name"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",testData.get("Acc name2"));
        PageObject.textinput_Locator("fieldName:AOR",testData.get("SignOffData"));
        PageObject.radiobutton_Locator("radio:tab1:BIO.VERISYS",Integer.parseInt(testData.get("BioVersion")));
        PageObject.textinput_Locator("fieldName:SBP.COMPANY",testData.get("sbpCompany"));
        PageObject.textinput_Locator("fieldName:SBP.SECTOR.ID",testData.get("sbpSector"));
        PageObject.textinput_Locator("fieldName:SBP.SSECTOR.ID",testData.get("sbpSubSector"));
        PageObject.textinput_Locator("fieldName:SBP.SEGMENT.ID",testData.get("sbpSegment"));
        //PageObject.textinput_Locator("fieldName:SBP.SSEGMENT.ID",testData.get("sbpSubSegment"));
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",testData.get("Jholder"));
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",testData.get("RelationCode"));
        PageObject.form_Tab("kyc Details");
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose"));
//        PageObject.textinput_Locator("",testData.get("Purpose"));
        PageObject.textinput_Locator("fieldName:KYC.NO.TRANS",testData.get("ExpectedNumOfTxn"));//30
        PageObject.radiobutton_Locator("radio:tab2:UNSCLISTST",Integer.parseInt(testData.get("AC Screen list")));
        PageObject.select_Locator("fieldName:KYC.ATO",testData.get("TurnoverA"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.RG",testData.get("TurnoverM"));
        PageObject.textinput_Locator("fieldName:NO.TRANS.DR",testData.get("debitTxnNum"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.DR",testData.get("TurnoverDebitMonth"));
        //Txn:
        try {
            PageObject.commitDeal("IbgCAO_JointAccCreation_FCY_CurrentAccountTxn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test(groups = {"CaoInputter"},dataProvider = "inputterData2")
    public void JointAccCreation_FCY_Saving(Map<String, String> testData) {
//
        PageObject.menu_Dropdown("IBG Account Open ");//test
        PageObject.menu_Dropdown("Foriegn Currency Account Open ");
        driver.findElement(By.xpath("(//*[text()='Saving Account  '])[2]")).click();
        String homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:CUSTOMER",testData.get("Cid"));
        PageObject.textinput_Locator("fieldName:CURRENCY",testData.get("Currency"));
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY",testData.get("CategoryProduct"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",testData.get("Acc name"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",testData.get("Acc name2"));
        PageObject.textinput_Locator("fieldName:AOR",testData.get("SignOffData"));
        PageObject.radiobutton_Locator("radio:tab1:BIO.VERISYS",Integer.parseInt(testData.get("BioVersion")));
        PageObject.textinput_Locator("fieldName:SBP.COMPANY",testData.get("sbpCompany"));
        PageObject.textinput_Locator("fieldName:SBP.SECTOR.ID",testData.get("sbpSector"));
        PageObject.textinput_Locator("fieldName:SBP.SSECTOR.ID",testData.get("sbpSubSector"));
        PageObject.textinput_Locator("fieldName:SBP.SEGMENT.ID",testData.get("sbpSegment"));
        //PageObject.textinput_Locator("fieldName:SBP.SSEGMENT.ID",testData.get("sbpSubSegment"));
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",testData.get("Jholder"));
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",testData.get("RelationCode"));
        PageObject.form_Tab("kyc Details");
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose"));
//        PageObject.textinput_Locator("",testData.get("Purpose"));
        PageObject.textinput_Locator("fieldName:KYC.NO.TRANS",testData.get("ExpectedNumOfTxn"));//30
        PageObject.radiobutton_Locator("radio:tab2:UNSCLISTST",Integer.parseInt(testData.get("AC Screen list")));
        PageObject.select_Locator("fieldName:KYC.ATO",testData.get("TurnoverA"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.RG",testData.get("TurnoverM"));
        PageObject.textinput_Locator("fieldName:NO.TRANS.DR",testData.get("debitTxnNum"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.DR",testData.get("TurnoverDebitMonth"));
        //Txn:
        try {
            PageObject.commitDeal("IbgCAO_JointAccCreation_FCY_SavingAccountTxn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(groups={"CaoAuthorizerIbg"},dataProvider = "authData3")
    public void authAccCreationFCY_Current(Map<String, String> testData){
        //
        PageObject.menu_Dropdown("IBG Account Authorization ");
        PageObject.childmenu_Link("List Of Unauthorised A/Cs  ",2);
        String homePage = PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(0);
        PageObject.form_Tab("Authorization of Account");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("VER A @ID");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
        //
    }

    @Test(groups={"CaoInputter2Auth"},dataProvider = "authDataSaving")
    public void authAccCreationFCY_Saving(Map<String, String> testData){
        //
        PageObject.menu_Dropdown("IBG Account Authorization ");
        PageObject.menu_Link("List Of Unauthorised A/Cs  ");
        String homePage = PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(0);
        PageObject.form_Tab("Authorization of Account");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("VER A @ID");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
        //
    }

    @Test(groups={"CaoInputter"},dataProvider = "FCYSavingAccAmendmentData")
    public void FCYSavingAccAmendment(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("IBG Account Open ");
        PageObject.menu_Dropdown("Foriegn Currency Account Open ");
        PageObject.menu_Link("Saving Account  ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("transactionId",testData.get("Account Num"));
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose of Bank Account"));
        PageObject.commitDeal("LCSavingAccAmendmentTxn");

    }


    //Onwards Done by Abdul Moeed

    @Test(groups={"CaoInputter"},dataProvider = "LCSavingAccountInputter")
    public void LCSavingAccountInputter(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Conventional Account Open");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Saving Account - Royal Profit  ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("Return to application screen");
        Alert alert = driver.switchTo().alert();
        alert.accept();

        PageObject.textinput_Locator("transactionId",testData.get("ID"));
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose of Bank Account"));
        PageObject.commitDeal("LCSavingAccountInputter");
        //PageObject.img_Button("Commit the deal");

    }

    @Test(groups={"CaoInputter"},dataProvider = "LCCurrentInputter")
    public void LCCurrentInputter(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Conventional Account Open");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Saving Account - Royal Profit  ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("Return to application screen");
        Alert alert = driver.switchTo().alert();
        alert.accept();

        PageObject.textinput_Locator("transactionId",testData.get("ID"));
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("ID"));
        PageObject.commitDeal("LCCurrentAccountInputter");
        //PageObject.img_Button("Commit the deal");

    }

    @Test(groups={"CaoAuthorizer4"},dataProvider = "LCSavingAccountAuthorizer")
    public void LCSavingAccountAuthorizer(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Conv Account Authorization ");
        //PageObject. childmenu_Link("List Of Unauthorised A/Cs  ",6);
        driver.findElement(By.xpath("//*[@id=\'pane_\']/ul[5]/li/ul/li/a")).click();
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("VER A @ID");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");

    }

    @Test(groups={"CaoAuthorizer4"},dataProvider = "LCCurrentAuthorizer")
    public void LCCurrentAuthorizer(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Conv Account Authorization ");
        //PageObject. childmenu_Link("List Of Unauthorised A/Cs  ",6);
        driver.findElement(By.xpath("//*[@id=\'pane_\']/ul[5]/li/ul/li/a")).click();
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("VER A @ID");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");

    }


    @DataProvider(name = "FCYCurrentAccAmendmentData")
    public Object[][] FCYCurrentAccAmendment() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IbgCAO_JointAccCreation_FCY_CurrentAccountTxn.xlsx";
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

    @DataProvider(name = "FCYSavingAccAmendmentData")
    public Object[][] FCYSavingAccAmendment() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\IbgCAO_JointAccCreation_FCY_SavingAccountTxn.xlsx";
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


    @DataProvider(name = "inputterData2")
    public Object[][] JointAccCreation_LCYData_Saving() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("FCY Saving"); // Assuming data is in the first sheet
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

    @DataProvider(name = "inputterData1")
    public Object[][] JointAccCreation_FCYData_Current() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("FCY current"); // Assuming data is in the first sheet
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

    @DataProvider(name = "authData3")
    public Object[][] AuthData3() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IbgCAO_JointAccCreation_FCY_CurrentAccountTxn.xlsx";
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


    @DataProvider(name = "authDataSaving")
    public Object[][] AuthDataSaving() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\IbgCAO_JointAccCreation_FCY_SavingAccountTxn.xlsx";
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


    @DataProvider(name = "LCCurrentInputter")
    public Object[][] LCCurrentInputter() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("LCCurrentInputter"); // Assuming data is in the first sheet
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

    @DataProvider(name = "LCSavingAccountInputter")
    public Object[][] LCSavingAccountInputter() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("LCSavingAccountInputter"); // Assuming data is in the first sheet
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
    @DataProvider(name = "LCSavingAccountAuthorizer")
    public Object[][] LCSavingAccountAuthorizer() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\LCSavingAccountInputter.xlsx";
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

    @DataProvider(name = "LCCurrentAuthorizer")
    public Object[][] LCCurrentAuthorizer() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\LCCurrentAccountInputter.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("LCCurrentAuthorizer"); // Assuming data is in the first sheet
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
