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

public class BankersChequeEncashment_IBG extends BaseClass {

    @Test(groups = {"SS328565505"},dataProvider = "BC_EncashmentIBG")
    public void BankersChequeEncashmentInwardRemittance (Map<String, String> testData) throws IOException, InterruptedException  {


        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Encashment",1);
        PageObject.childmenu_Link("Bankers Cheque Encashment- Inward Remittance ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        Thread.sleep(5000);
        PageObject.click_Locator("fieldName:CREDIT.THEIR.REF");
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF",testData.get("CREDIT.THEIR.REF")); //2
        PageObject.click_Locator("fieldName:CREDIT.ACCT.NO");
        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO",testData.get("CREDIT.ACCT.NO"));
        PageObject.commitDeal("BankersChequeEncashment_IBG");
    }

    String FILE_PATH = "";
    @DataProvider(name = "BC_EncashmentIBG")
    public Object[][] dataMethod() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\BC_EncashmentIBG.xlsx";
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
}
