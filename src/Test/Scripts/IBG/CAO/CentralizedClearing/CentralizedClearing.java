package Test.Scripts.IBG.CAO.CentralizedClearing;

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

public class CentralizedClearing extends BaseClass {

    //CaoInputterCentralized
    @Test(groups = {"CaoInputterIBG"},dataProvider = "CCSameDayInputter")
    public void CCSameDayInputter(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Inward Sameday Image Based Clearing- Input");
        PageObject.menu_Dropdown("Inward Clearing - Instrument Manual");
       // PageObject.menu_Link("Inward Clearing Sameday- Banker's Cheque ");
        driver.findElement(By.xpath("//*[@id=\'pane_\']/ul[9]/li/ul/li[4]/ul/li[2]/a")).click();
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1",testData.get("InstNo"));
        PageObject.click_Locator("fieldName:BANK.SORT.CODE:1");
        String form = PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(form);
        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1",testData.get("BankCode"));
        PageObject.textinput_Locator("fieldName:CL.RET.CODE:1",testData.get("ReturnCode"));
        PageObject.commitDeal("IbgCCSameDayInputter");

    }


    //CaoAuthorizerCentralized
    @Test(groups = {"CaoAuthorizerIbg"},dataProvider = "CCSameDayAuth")
    public void CCSameDayAuth(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Inward Sameday Image Based Clearing- Auth");
        PageObject.menu_Dropdown("Authorization of Inward Clearing Instrument");
        driver.findElement(By.xpath("//*[@id=\'pane_\']/ul[13]/li/ul/li[7]/ul/li[2]/a")).click();
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        //driver.findElement(By.xpath("//*[@id=\'enqsel\']/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/div/table/tbody/tr/td/a")).click();
    }


    //CaoInputterCentralized
    @Test(groups = {"CaoInputterIBG"},dataProvider = "CCNormalDayInputter")
    public void CCNormalDayInputter(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Inward Normal Image Based Clearing- Input");
        PageObject.menu_Dropdown("Inward Normal Clearing - Instrument Manual");
        PageObject.childmenu_Link("Inward Clearing Normal- Banker",2);
//        driver.findElement(By.xpath("//*[@id=\'pane_\']/ul[10]/li/ul/li[4]/ul/li[2]/a")).click();
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1",testData.get("InstNo"));
        PageObject.click_Locator("fieldName:BANK.SORT.CODE:1");
        String form = PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(form);
        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1",testData.get("BankCode"));
        PageObject.textinput_Locator("fieldName:CL.RET.CODE:1",testData.get("ReturnCode"));
        PageObject.commitDeal("IbgCCNormalDayInputter");

    }

    //CaoAuthorizerCentralized
    @Test(groups = {"CaoAuthorizerIbg"},dataProvider = "CCSameDayAuth")
    public void CCNormalDayAuth(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown("Inward Sameday Image Based Clearing- Auth");
        PageObject.menu_Dropdown("Authorization of Inward Clearing Instrument");
        driver.findElement(By.xpath("//*[@id=\'pane_\']/ul[13]/li/ul/li[7]/ul/li[2]/a")).click();
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        //driver.findElement(By.xpath("//*[@id=\'enqsel\']/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/div/table/tbody/tr/td/a")).click();
    }
    @DataProvider(name = "CCSameDayInputter")
    public Object[][] readExcelData1() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\CentralizedClearing.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("CCSameDayInputter"); // Assuming data is in the first sheet
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

    @DataProvider(name = "CCSameDayAuth")
    public Object[][] readExcelData2() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\IbgCCSameDayInputter.xlsx";
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

    @DataProvider(name = "CCNormalDayInputter")
    public Object[][] readExcelData3() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\CentralizedClearing.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);//IbgCCNormalDayInputter
        Sheet sheet = workbook.getSheet("CCNormalDayInputter"); // Assuming data is in the first sheet
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
    @DataProvider(name = "CCNormalDayAuth")
    public Object[][] readExcelData4() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\IbgCCNormalDayInputter.xlsx";
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
