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

public class CDR_Issuance extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\CDRIssuanceinput.xlsx";
    @Test( groups = {"Inputter"}, dataProvider = "excelDataCDRIssuanceinput")

    public void CDRIssuanceinput(Map<String, String> testData) throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");
        PageObject.menu_Link("Call Deposit Receipt- Single Issuance ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",testData.get("DEBIT.ACCT.NO"));
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1",testData.get("BEN.CUSTOMER:1"));
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT",testData.get("CREDIT.AMOUNT"));
        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE" , 4);

        PageObject.textarea_Locator("fieldName:CHEQUE.NUMBER",testData.get("CHEQUE.NUMBER"));
        PageObject.textarea_Locator("fieldName:ORDERING.CUST:1",testData.get("ORDERING.CUST:1"));
        PageObject.textarea_Locator("fieldName:PAYMENT.DETAILS:1",testData.get("PAYMENT.DETAILS:1"));
        PageObject.textarea_Locator("fieldName:COMMISSION.TYPE:1",testData.get("COMMISSION.TYPE:1"));
        PageObject.textarea_Locator("fieldName:COMMISSION.AMT:1",testData.get("COMMISSION.AMT:1"));
        //PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","WAIVE");

        PageObject.form_Tab("Due Delligence");

        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1",testData.get("DD.ADDRESS:1"));
        PageObject.textinput_Locator("fieldName:ID.TYPE",testData.get("ID.TYPE"));
        PageObject.textinput_Locator("fieldName:ID.NUMBER",testData.get("ID.NUMBER"));
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1",testData.get("CONTACT.NO:1"));
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE", testData.get("INS.ISS.PURPOSE"));

//        PageObject.textarea_Locator("fieldName:PURPOSE:1",testData.get("PURPOSE:1"));

        PageObject.commitDeal("CDRIssuanceinput");


    }
    @DataProvider(name = "excelDataCDRIssuanceinput")
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

    public void CDRIssuance_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Instrument Authorization");

        PageObject.menu_Link("Authorization of Single CDR Issuance ");

        //String menu1 = PageObject.switchToChildWindow();

        PageObject.find_Button();

        PageObject.form_Link("Authorize Transaction");

        String menu2 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");

    }

    @DataProvider(name = " CDRIssuanceinput")
    public Object[][]  CDRIssuanceinputData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CDRIssuanceinput.xlsx";
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

