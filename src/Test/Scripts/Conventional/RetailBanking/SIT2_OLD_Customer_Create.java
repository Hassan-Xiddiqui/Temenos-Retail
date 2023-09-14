package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;

public class SIT2_OLD_Customer_Create extends BaseClass {

    public static String txn;

    @Test(groups = {"IBGInputter"})
    public void CC() {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
    }

    @Test(groups = {"Inputter"} , dataProvider = "excelData")
    public void customerCreation(Map<String, String> excelData) throws IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        //driver.findElement(By.xpath("(//ul/li/span/img[@alt='Alfalah Customer Information'])[2]")).click();
        PageObject.menu_Link("Individual/Sole/Proprietorship/Minor ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:SECTOR",excelData.get("SECTOR"));
        PageObject.textinput_Locator("fieldName:ID.TYPE:1",excelData.get("ID-TYPE"));
        PageObject.textinput_Locator("fieldName:ID.NUMBER:1",excelData.get("ID-NO"));
        PageObject.click_Locator("fieldName:ID.VAL.DT:1");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT:1",excelData.get("VALID-DATE"));
        PageObject.textinput_Locator("fieldName:NAME.1:1",excelData.get("NAME"));
        PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM",excelData.get("FATHER-NAME"));
        PageObject.textinput_Locator("fieldName:STREET:1",excelData.get("STREET"));
        PageObject.textinput_Locator("fieldName:TOWN.COUNTRY:1",excelData.get("COUNTRY"));
        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT",excelData.get("SBP-IND-PR"));
        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY",excelData.get("SBP-IND"));
        PageObject.textinput_Locator("fieldName:TARGET",excelData.get("TARGET"));
        PageObject.textinput_Locator("fieldName:NATIONALITY",excelData.get("NATIONALITY"));
        PageObject.textinput_Locator("fieldName:RESIDENCE",excelData.get("RESIDENCE"));
        PageObject.textinput_Locator("fieldName:DATE.OF.BIRT.LC",excelData.get("DOB"));

        PageObject.textinput_Locator("fieldName:CRP.TYPE","1");
        PageObject.textinput_Locator("fieldName:INCM.LEVELSRC","102");
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1","1001");
        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1","9");
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1","PK");
        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1","1");
        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:1","402");
        PageObject.select_Locator("fieldName:SEDING.FACTS:1","Not Applicable");

//        PageObject.textarea_Locator("fieldName:FURTHER.DETAILS","");

//        PageObject.switchFrame("Contact Person");
//
//        PageObject.textinput_Locator("fieldName:CP.NAME:1","CP.NAME");
//        PageObject.textinput_Locator("fieldName:CP.TITLE:1","CP.TITLE"  );
//        PageObject.textinput_Locator("fieldName:CP.ADD:1",testData.get("CP.ADD"));
//        PageObject.textinput_Locator("fieldName:CP.ADD2:1",testData.get("CP.ADD2"));
//        PageObject.textinput_Locator("fieldName:CP.PH.OFF:1",testData.get("CP.PH.OFF"));
//        PageObject.textinput_Locator("fieldName:CP.FAX.NO:1",testData.get("CP.FAX.NO"));
//        PageObject.textinput_Locator("fieldName:CP.CELL.NO:1",testData.get("CP.CELL.NO"));
//        PageObject.textinput_Locator("fieldName:CP.PH.RES:1",testData.get("CP.PH.RES"));
//        PageObject.textinput_Locator("fieldName:CP.EMAIL:1",testData.get("CP.EMAIL"));

        PageObject.commitDeal("Customer Create");
        txn = PageObject.getTxn();
        System.out.println(txn);
    }

    @DataProvider(name = "excelData")
    public Object[][] readExcelData() throws IOException {

        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\\\";

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
