package Test.Scripts.IBG.CAO.CAOD;

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

public class CustomerCreation extends BaseClass {

    public static String txn;

    //@Test(groups = {"CaoInputterIBG"}, dataProvider = "customerCreation" )
    @Test(groups = {"CaoInputterIBG"}, dataProvider = "customerCreation" )
    public void customerCreation(Map<String, String> testData) throws IOException {

    String CustomerSegment = testData.get("CustomerSegment");
    String EntityType = testData.get("EntityType");
    String SourceOfFunds = testData.get("SourceOfFunds");
    String Occupation = testData.get("Occupation");
    int PEPCustomer = Integer.parseInt(testData.get("PEPCustomer"));
    String SBPIndustryParent = testData.get("SBPIndustryParent");
    String SBPIndustry = testData.get("SBPIndustry");
    String CustomerType = testData.get("CustomerType");
    String CnicType = testData.get("CnicType");
    String CnicNumber = testData.get("CnicNumber");
    String CustomerMnemonic = testData.get("CustomerMnemonic");
    String Nationality = testData.get("Nationality");
    String CountryResidence = testData.get("CountryResidence");
    String CountryBirth = testData.get("CountryBirth");
    String ProductType = testData.get("ProductType");
    String DepositChannel = testData.get("DepositChannel");
    String WithdrawChannel = testData.get("WithdrawChannel");
    String GeographicCountry = testData.get("GeographicCountry");
    String GeographicCity = testData.get("GeographicCity");
    String MonthlyCredit = testData.get("MonthlyCredit");


    PageObject.menu_Dropdown("Alfalah Customer Information at CAO");
    PageObject.menu_Dropdown("Customer Opening");
    PageObject.menu_Link("Individual/Sole/Proprietorship/Minor  ");

    //   PageObject.select_Locator("fieldName:CUST.SEGMENT","MASS");
    PageObject.switchToChildWindow();
    PageObject.select_Locator("fieldName:CUST.SEGMENT",CustomerSegment);
    PageObject.textinput_Locator("fieldName:CRP.TYPE",EntityType);
    PageObject.click_Locator("fieldName:SRC.FUNDS");
    PageObject.textinput_Locator("fieldName:SRC.FUNDS",SourceOfFunds);

    PageObject.click_Locator("fieldName:TEXT:1");

    PageObject.textinput_Locator("fieldName:TEXT:1","Testing");
    PageObject.click_Locator("fieldName:TARGET");
    PageObject.textinput_Locator("fieldName:TARGET",Occupation);

    PageObject.radiobutton_Locator("radio:mainTab:CUS.PEP",2);
    PageObject.radiobutton_Locator("radio:mainTab:CUS.PEP",PEPCustomer);
    PageObject.textinput_Locator("fieldName:SBP.IND.PARENT",SBPIndustryParent);
    PageObject.click_Locator("fieldName:SBP.INDUSTRY");
    PageObject.textinput_Locator("fieldName:SBP.INDUSTRY",SBPIndustry);
    PageObject.textinput_Locator("fieldName:ID.TYPE:1",CnicType);
    PageObject.textinput_Locator("fieldName:ID.NUMBER:1", CnicNumber);
    PageObject.click_Locator("fieldName:ID.VAL.DT:1");
    PageObject.textinput_Locator("fieldName:ID.VAL.DT:1", "20400101");
    PageObject.click_Locator("fieldName:MNEMONIC");
    PageObject.textinput_Locator("fieldName:MNEMONIC",CustomerMnemonic);
    PageObject.textinput_Locator("fieldName:NAME.1:1","SomeTestingUser");
    //        PageObject.textinput_Locator("fieldName:NAME.2:1","");
    //PageObject.textinput_Locator("fieldName:SHORT.NAME:1","Mrs. ABC");
    //        PageObject.select_Locator("fieldName:A.ADDRESS.TYPE","PERMANENT");

    PageObject.textarea_Locator("fieldName:ADD.H","SomeTestingAddress");
    PageObject.textinput_Locator("fieldName:STREET:1","SomeTestingStreet");

    PageObject.click_Locator("fieldName:DATE.OF.BIRT.LC");
    PageObject.textinput_Locator("fieldName:NATIONALITY",Nationality);
    PageObject.textinput_Locator("fieldName:RESIDENCE",CountryResidence);


    PageObject.textinput_Locator("fieldName:DATE.OF.BIRT.LC","19800101");
    PageObject.textinput_Locator("fieldName:ACCOUNT.OFFICER","1099511041");
    PageObject.textinput_Locator("fieldName:FATCA.BIRTH.CON", CountryBirth);
    PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM","SomeFather");

    PageObject.click_Locator("fieldName:CUS.CATEG:1");
    PageObject.textinput_Locator("fieldName:CUS.CATEG:1",ProductType);
    PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1", DepositChannel);
    PageObject.textinput_Locator("fieldName:DELIVERY.WDRAW:1",WithdrawChannel);
    PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1",GeographicCountry);
    PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1",GeographicCity);
    PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:1", MonthlyCredit);
    PageObject.select_Locator("fieldName:SEDING.FACTS:1","Not Applicable");
    PageObject.textarea_Locator("fieldName:FURTHER.DETAILS","Testing");

    PageObject.commitDeal("IbgCaoCustomerCreation");

    }

    @DataProvider(name = "customerCreation")
    public Object[][] readExcelData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\IbgCaoCustomerCreation.xlsx";
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




    //CaoAuthorizer5
    @Test(groups = {"CaoAuthorizerIbg"}, dataProvider = "customerCreation_Authorization" )
    public void customerCreation_Authorization(Map<String, String> testData) throws IOException {

        String TransactionNumber = testData.get("Transaction Number");

        PageObject.menu_Dropdown("Authorization of Customer at CAO");
        PageObject.menu_Link("Authorise a Customer  ");

        PageObject.switchToChildWindow();
        PageObject.switchFrame(0);
        PageObject.form_Tab("Authorization of Customers");

        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",TransactionNumber);
        PageObject.find_Button();

        PageObject.form_Link("Authorize");

        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);

        PageObject.authorizeDeal();

    }

    @DataProvider(name = "customerCreation_Authorization")
    public Object[][] customerCreation_Authorization() throws IOException {
        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\IbgCaoCustomerCreation.xlsx";
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

    /*__________________________________________________________________________________________________*/

    //CaoInputterIBG
    @Test(groups = {"CaoInputterIBG"}, dataProvider = "corporateCustomerCreation" )
    public void corporateCustomerCreation(Map<String, String> testData) throws IOException {

        String EntityType = testData.get("EntityType");
        String Occupation = testData.get("Occupation");
        int PEPCustomer = Integer.parseInt(testData.get("PEPCustomer"));
        String SBPIndustryParent = testData.get("SBPIndustryParent");
        String SBPIndustry = testData.get("SBPIndustry");
        String CnicType = testData.get("CnicType");
        String CnicNumber = testData.get("CnicNumber");
        String CustomerMnemonic = testData.get("CustomerMnemonic");
        String Nationality = testData.get("Nationality");
        String CountryResidence = testData.get("CountryResidence");
        String CountryBirth = testData.get("CountryBirth");
        String ProductType = testData.get("ProductType");
        String DepositChannel = testData.get("DepositChannel");
        String WithdrawChannel = testData.get("WithdrawChannel");
        String GeographicCountry = testData.get("GeographicCountry");
        String GeographicCity = testData.get("GeographicCity");
        String MonthlyCredit = testData.get("MonthlyCredit");


        PageObject.menu_Dropdown("Alfalah Customer Information at CAO");
        PageObject.menu_Dropdown("Customer Opening");
        PageObject.menu_Link("Corporate Customers  ");

        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:CRP.TYPE",EntityType);

        PageObject.click_Locator("fieldName:TEXT:1");
        PageObject.click_Locator("fieldName:TARGET");
        PageObject.textinput_Locator("fieldName:TARGET",Occupation);

        PageObject.radiobutton_Locator("radio:mainTab:CUS.PEP",2);
        PageObject.radiobutton_Locator("radio:mainTab:CUS.PEP",PEPCustomer);
        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT",SBPIndustryParent);
        PageObject.click_Locator("fieldName:SBP.INDUSTRY");
        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY",SBPIndustry);
        PageObject.textinput_Locator("fieldName:ID.TYPE:1",CnicType);
        PageObject.textinput_Locator("fieldName:ID.NUMBER:1", CnicNumber);
        PageObject.click_Locator("fieldName:ID.VAL.DT:1");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT:1", "20400101");
        PageObject.click_Locator("fieldName:MNEMONIC");
        PageObject.textinput_Locator("fieldName:MNEMONIC",CustomerMnemonic);
        PageObject.textinput_Locator("fieldName:NAME.1:1","SomeTestingUser");
        //        PageObject.textinput_Locator("fieldName:NAME.2:1","");
        //PageObject.textinput_Locator("fieldName:SHORT.NAME:1","Mrs. ABC");
        //        PageObject.select_Locator("fieldName:A.ADDRESS.TYPE","PERMANENT");

        PageObject.textarea_Locator("fieldName:ADD.H","SomeTestingAddress");
        PageObject.textinput_Locator("fieldName:STREET:1","SomeTestingStreet");

        PageObject.click_Locator("fieldName:BIRTH.INCORP.DATE");
        PageObject.textinput_Locator("fieldName:NATIONALITY",Nationality);
        PageObject.textinput_Locator("fieldName:RESIDENCE",CountryResidence);


        PageObject.textinput_Locator("fieldName:BIRTH.INCORP.DATE","19800101");
        PageObject.textinput_Locator("fieldName:ACCOUNT.OFFICER","1099511041");
        PageObject.textinput_Locator("fieldName:FATCA.BIRTH.CON", CountryBirth);
        PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM","SomeFather");

        PageObject.click_Locator("fieldName:CUS.CATEG:1");
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1",ProductType);
        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1", DepositChannel);
        PageObject.textinput_Locator("fieldName:DELIVERY.WDRAW:1",WithdrawChannel);
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1",GeographicCountry);
        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1",GeographicCity);
        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:1", MonthlyCredit);
        PageObject.select_Locator("fieldName:SEDING.FACTS:1","Not Applicable");
        PageObject.textarea_Locator("fieldName:FURTHER.DETAILS","Testing");

        PageObject.commitDeal("IbgCorporateCustomerCreation");

    }

    @DataProvider(name = "corporateCustomerCreation")
    public Object[][] readExcelData_2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\IbgCorporateCustomerCreation.xlsx";
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


    //CaoAuthorizer5
    @Test(groups = {"CaoAuthorizerIbg"}, dataProvider = "corporateCustomerCreation_Authorization" )
    public void corporateCustomerCreation_Authorization(Map<String, String> testData) throws IOException {

        String TransactionNumber = testData.get("Transaction Number");

        PageObject.menu_Dropdown("Authorization of Customer at CAO");
        PageObject.menu_Link("Authorise a Customer  ");

        PageObject.switchToChildWindow();
        PageObject.switchFrame(0);
        PageObject.form_Tab("Authorization of Customers");

        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",TransactionNumber);
        PageObject.find_Button();

        PageObject.form_Link("Authorize");

        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);

        PageObject.authorizeDeal();

    }

    @DataProvider(name = "corporateCustomerCreation_Authorization")
    public Object[][] readExcelData_2A() throws IOException {
        String FILE_PATH = System.getProperty("user.dir") + "\\Data\\IbgCorporateCustomerCreation.xlsx";
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

    @Test(groups = {"CaoInputter"}, dataProvider = "customerUpdation" )
    public void customerUpdation(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Alfalah Customer Information at CAO");
        PageObject.menu_Dropdown("Customer Opening");
        PageObject.menu_Link("Individual/Sole/Proprietorship/Minor  ");

        //   PageObject.select_Locator("fieldName:CUST.SEGMENT","MASS");
        String homePage=PageObject.switchToChildWindow();
        PageObject.img_Button("Return to application screen");
        PageObject.textinput_Locator("transactionId",testData.get("txn"));
        //PageObject.commitDeal("CaoCustomerUpdation");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM",testData.get("FatherName"));
        PageObject.textinput_Locator("fieldName:CUST.OFF.PHONE:1",testData.get("cellPhone"));
        PageObject.commitDeal("CaoUpdatingCustomer");
    }

}
