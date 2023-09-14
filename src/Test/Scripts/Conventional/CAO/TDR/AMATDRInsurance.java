package Test.Scripts.Conventional.CAO.TDR;

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

public class AMATDRInsurance extends BaseClass {

    @Test(groups = {"InputterTDR"},dataProvider = "InsuranceEnquiryMahanaAmadan")
    public void InputterTDRInputterTDR(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("AMA TDR Insurance");
        PageObject.menu_Link("Insurance Enquiry - Mahana Amadan ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("value:1:1:1",testData.get("ID"));
        PageObject.find_Button();

    }

    @DataProvider(name = "InsuranceEnquiryMahanaAmadan")
    public Object[][] readExcelData1() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\AMATDRInsurance.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("InsuranceEnquiryMahanaAmadan"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        rowCount =2;
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
