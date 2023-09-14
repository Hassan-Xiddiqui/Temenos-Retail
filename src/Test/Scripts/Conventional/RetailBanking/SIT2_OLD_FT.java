package Test.Scripts.Conventional.RetailBanking;

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

public class SIT2_OLD_FT extends BaseClass {

    @Test( groups = {"Inputter"} , dataProvider = "excelData")
    public void fundTransferOnline(Map<String , String> data) throws IOException {
        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Link("Account to Account Transfer- Online ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO",data.get("CRE-ACCOUNT"));
        PageObject.click_Locator("fieldName:CREDIT.AMOUNT");

//        String newPageCSO = driver.getWindowHandle();

        String newPage = PageObject.switchToChildWindow();
        driver.close();

        PageObject.switchToParentWindow(newPage);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT",data.get("VALUE"));
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",data.get("DEB-ACCOUNT"));
        PageObject.click_Locator("fieldName:CREDIT.AMOUNT");

        PageObject.switchToChildWindow();
        driver.close();

        PageObject.switchToParentWindow(newPage);
        PageObject.switchFrame(2);

        PageObject.radiobutton_Locator("radio:mainTab:AML.TYP.CUST",1);

        PageObject.commitDeal("Fund Transfer");
    }

    @DataProvider(name = "excelData")
    public Object[][] readExcelData() throws IOException {

        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\Book1.xlsx";

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
