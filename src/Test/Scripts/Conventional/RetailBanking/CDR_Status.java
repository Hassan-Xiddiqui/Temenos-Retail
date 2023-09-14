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

public class CDR_Status extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\CDRStatus.xlsx";

    @Test(groups = {"Inputter"}, dataProvider = "excelDataCDRStatus")

    public void CDRStatusStop(Map<String, String> testData) throws InterruptedException, IOException {

        //Data related issue, transaction couldn't perform properly

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services", 2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance");


        String HomePage2 = driver.getWindowHandle();

        PageObject.menu_Link("Change Status of Instrument ");

        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1", testData.get("value:1:1:1"));

        PageObject.find_Button();

        PageObject.maximizeWindow();

        PageObject.form_Link("Change Status");

        Thread.sleep(2000);

        PageObject.img_Button("Commit the deal");


}

    @DataProvider(name = "excelDataCDRStatus")
    public Object[][] readExcelData1() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        //rowCount-=2;
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

    @Test(groups = {"Authorizer"})

    public void CDRStatusStop_Auth() throws IOException, InterruptedException {
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");


        PageObject.childmenu_Link("Call Deposit Receipt- Authorizer Menu",0);
        PageObject.childmenu_Link("Call Deposit Receipt Maintenance Authorize",0);

        PageObject.menu_Link("Authorisation Change Status of Instrument ");


        String menu1 = PageObject.switchToChildWindow();

        PageObject.find_Button();

        PageObject.form_Link("Authorize Transaction");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");



    }

}
