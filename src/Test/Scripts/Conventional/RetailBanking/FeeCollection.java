package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FeeCollection extends BaseClass {

   @Test(groups = {"Inputter"})
    public void FeeCollection() throws IOException{

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Fee Collection - Against Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgname = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:INSTITUTE","5.0031");
        PageObject.click_Locator("fieldName:DEBIT.ACCT.NO");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1006593695");
        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","250202235");
        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE","20221220");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgname);
                PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","2");

//       PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","");
//       PageObject.textinput_Locator("fieldName:COMMISSION.AMT:1","");
//       PageObject.textinput_Locator("fieldName:VALUE:1","");

        PageObject.commitDeal("Fee Collection");
        String txn = PageObject.getTxn();
        System.out.println(txn);
        driver.close();
    }

    @Test(groups = {"Inputter"})
    public void MultiFeeCollection() throws IOException{

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Multi Fee Collection - Against Account  ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.img_Button("Expand Sub Value");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPES:1']")).sendKeys("5.0031");
        PageObject.click_Locator("fieldName:BILL.AMOUNT:1");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.AMOUNT:1']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPES:2']")).sendKeys("5.0031");
        PageObject.click_Locator("fieldName:BILL.AMOUNT:2");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.AMOUNT:2']")).sendKeys("2");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1006593695");
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);

        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","6200021458");
        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE","20221220");

//        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","");
//        PageObject.textinput_Locator("fieldName:COMMISSION.AMT:1","");
//        PageObject.textinput_Locator("fieldName:VALUE:1","");
        //PageObject.commitDeal("Multi Fee Collection");
        driver.close();
    }

    @Test(groups = {"Inputter"})
    public void FeeCollectionT24Branches() throws IOException {
        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Fee Collection - T24 Branches ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:INSTITUTE","14.0001");
        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1","20");
        PageObject.click_Locator("fieldName:VALUE:1");
        PageObject.textinput_Locator("fieldName:VALUE:1","Soban Khan");
        PageObject.textinput_Locator("fieldName:DEN.AMT:1","BC1004100148");
//        PageObject.textinput_Locator("fieldName:DEN.AMT:8","2");



        PageObject.commitDeal("Fee Collection T24 Branches");
        String txn = PageObject.getTxn();
        System.out.println(txn);
        driver.close();

    }


    @Test(groups = {"Inputter"})
    public void FeeCollectionReport() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Fee Collection Report ");
        PageObject.switchToChildWindow();

        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).clear();
        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).sendKeys("5.0031");
        PageObject.find_Button();
        driver.close();
     }

    @Test(groups = {"Inputter"})
    public void InstituteFeeCollectionReport() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Institute Fee Collection Report ");
        PageObject.switchToChildWindow();

        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).clear();
        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).sendKeys("5.0031");
        PageObject.find_Button();
        driver.close();
    }


 /*   @Test(groups = {"Authorizer"}, dataProvider = "excelData")
    public void FeeCollectionT24BranchesAuthorize(Map<String, String> testData) throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Branch Manager Menu");
        PageObject.menu_Dropdown("Core Retail");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Fee Collection");
        PageObject.menu_Link("Fee Collection - Unauthorised List ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(2);
        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        driver.findElement(By.xpath("//a[contains(text(),'Authorise')]"));
    }


    @DataProvider(name = "excelData")
    public Object[][] readExcelData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\Fee Collection T24 Branches.xlsx";

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
    }*/
}