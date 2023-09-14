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

public class UtilityBills extends BaseClass {

  @Test(groups = {"Inputter"})

    public void UtilityBillsAgainstAccount() throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Utility Bills");
        PageObject.menu_Link("Utility Bills Recieved Against Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgname = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:BILL.TYPE","1.0031");
        PageObject.click_Locator("fieldName:DEBIT.ACCT.NO");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1006593695");
        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","200145879");
        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE","20221230");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","5");

        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgname);
        PageObject.switchFrame(2);
        driver.findElement(By.xpath("//input[@id='fieldName:CONSUMER.NO:1']")).sendKeys("22000145");

        PageObject.commitDeal("UtilityBillsAgainstAccount");
        String txn = PageObject.getTxn();
        System.out.println(txn);
//        driver.close();
    }


    @Test(groups = {"Inputter"})

    public void MultiUtilityBillsAgainstAccount() throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Utility Bills");
        PageObject.menu_Link("Multi Utility Bills Recieved Against Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.img_Button("Expand Sub Value");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPES:1']")).sendKeys("1.0155");
        PageObject.click_Locator("fieldName:BILL.AMOUNT:1");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.AMOUNT:1']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPES:2']")).sendKeys("1.0155");
        PageObject.click_Locator("fieldName:BILL.AMOUNT:2");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.AMOUNT:2']")).sendKeys("2");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1006593695");
        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","6200021458");
        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE","20221230");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        driver.findElement(By.xpath("//input[@id='fieldName:CONSUMER.NO:1']")).sendKeys("2200014596");

        PageObject.commitDeal("MultiUtilityBillsAgainstAccount");
        String txn = PageObject.getTxn();
        System.out.println(txn);
        driver.close();

    }

    @Test(groups = {"Inputter"})

    public void UtilityBillsAgainstCash() throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Utility Bills");
        PageObject.menu_Link("Utility Bills Recieved Against Cash ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        driver.findElement(By.xpath("//input[@id='fieldName:BILL.TYPE:1']")).sendKeys("1.0155");
        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1","10");
        PageObject.click_Locator("fieldName:CONSUMER.NO");
        PageObject.textinput_Locator("fieldName:CONSUMER.NO","522012488");
        PageObject.click_Locator("fieldName:DEN.AMT:8");
        PageObject.textinput_Locator("fieldName:DEN.AMT:8","1");

        PageObject.textinput_Locator("fieldName:DEN.AMT:1","");

        PageObject.commitDeal("UtilityBillsAgainstCash");
        String txn = PageObject.getTxn();
        System.out.println(txn);
        driver.close();
    }

  /*  @Test(groups = {"Authorizer"}, dataProvider = "excelData")
    public void UtilityBillsAgainstCashAuthorize(Map<String, String> testData) throws IOException,InterruptedException {

        PageObject.menu_Dropdown("Branch Manager Menu");
        PageObject.menu_Dropdown("Core Retail");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Utility Bills");
        PageObject.menu_Link("Unauthorised List -Utility Bills ");


        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(1);
        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        driver.findElement(By.xpath("//a[contains(text(),'Authorise')]"));
    }



       @Test(groups = {"Inputter"})
         public void CollectionUtilityBillsReport() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Utility Bills");
        PageObject.menu_Link("Collection Scroll Utility Bills Report ");
        PageObject.switchToChildWindow();

        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).clear();
        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).sendKeys("1.0031");
        PageObject.find_Button();
        driver.close();
    }


    @DataProvider(name = "excelData")
    public Object[][] readExcelData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\UtilityBillsAgainstAccount.xlsx";

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
    } */
}


