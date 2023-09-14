
package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Customers extends BaseClass {

    public static String Txn;

    private static int count = 11;

    public static String SECTOR;
    public static String TC;

    public static File  file;



    @Test (groups = {"Inputter"}, dataProvider = "indCustomer")
    public void individualCustomer(Map<String, String> column) throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        PageObject.menu_Link("Individual/Sole/Proprietorship/Minor ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        String crpType = column.get("CRP_TYPE") ;
        TC = column.get("TC");
        PageObject.textinput_Locator("fieldName:CRP.TYPE",crpType);
        PageObject.click_Locator("fieldName:ID.NUMBER:1");
        if ( (crpType.equalsIgnoreCase("9")) || (crpType.equalsIgnoreCase("1")) || (crpType.equalsIgnoreCase("5")) || (crpType.equalsIgnoreCase("6")) ){
            System.out.println("condition no1 true !");
            PageObject.textinput_Locator("fieldName:SRC.FUNDS",column.get("fieldName:SRC.FUNDS"));
//            Thread.sleep(5000);
        }

        //if crp type == 6, then fieldName:SRC.FUNDS must have this value: '801', TARGET:80, SPB industry2:60000001200, fieldName:INCM.LEVELSRC should be empty, Txn: 17704641
        //if crp type == 9, then fieldName:SRC.FUNDS must have this value: '802', TARGET:38, SPB industry2:60000001100, SoleProperTierName must be empty , fieldName:INCM.LEVELSRC should be empty, Txn: 17704648


        //if crp type == 5, then fieldName:SRC.FUNDS must have this value: '802', TARGET:39, SPB industry2:60000000700, SoleProperTierName must be empty , fieldName:INCM.LEVELSRC should be empty, fieldName:CREDIT.TURNOVER:1 must be '1041' ,  Txn: 17704667

        //if crp type == 10, superseedingfactor must be equal to 'Not Applicable', TARGET:8, SPB industry1:41960000000, SPB industry2:41960000000, fieldName:INCM.LEVELSRC should be empty, Txn: 17704649

        //if crp type == 3, TARGET:76, SPB industry2:60000001200, fieldName:INCM.LEVELSRC should be empty, Txn: 17704642

        //if crp type == 7, TARGET:85, SPB industry2:60000000600, fieldName:INCM.LEVELSRC should be empty, Txn: 17704645

        //if crp type == 2, TARGET:16, SPB industry2:60000000600, fieldName:INCM.LEVELSRC should be empty, Txn: 17704646

        //if crp type == 8, remove solePropertierName, Txn: 17704647

        PageObject.click_Locator("fieldName:TARGET");


        PageObject.textinput_Locator("fieldName:TARGET",column.get("TARGET"));
        //driver.findElement(By.xpath("//input[@id='fieldName:TARGET']")).sendKeys(column.get("TARGET"));
        PageObject.click_Locator("fieldName:ID.NUMBER:1");

        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY",column.get("SBP.INDUSTRY"));
        PageObject.textinput_Locator("fieldName:ID.NUMBER:1",column.get("ID_NUMBER"));
        PageObject.click_Locator("fieldName:ID.VAL.DT:1");

        //PageObject.textinput_Locator("fieldName:ID.VAL.DT:1",column.get("ID.VAL.DT:1"));
        PageObject.radiobutton_Locator("radio:mainTab:CUS.PEP",2);

//        PageObject.textinput_Locator("fieldName:SECTOR",column.get("SECTOR"));
//        SECTOR = column.get("SECTOR");
//        PageObject.select_Locator("fieldName:CUST.SEGMENT",column.get("CUST_SEGMENT"));
//        PageObject.radiobutton_Locator("radio:mainTab:SME.TYPE",1);
//        PageObject.textinput_Locator("fieldName:ID.TYPE:1",column.get("ID_TYPE"));
//        String ID_TYPE= column.get("ID_TYPE");
//        if (ID_TYPE.equalsIgnoreCase("ID-SPR")) {
//            PageObject.textinput_Locator("fieldName:ID.NUMBER:1","EB344078" + PageObject.idNumber());
//        }
//        else  {
//            PageObject.textinput_Locator("fieldName:ID.NUMBER:1","42344078" + PageObject.idNumber());
//        }
        PageObject.click_Locator("fieldName:ID.VAL.DT:1");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT:1",column.get("ID_VAL_DT"));
        PageObject.textinput_Locator("fieldName:NAME.1:1",column.get("NAME_1"));
        PageObject.textinput_Locator("fieldName:NAME.2:1","MUHAMMAD");
        PageObject.textinput_Locator("fieldName:SOLE.NAME",column.get("SOLE_NAME"));
        PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM",column.get("MB_FATH_HUS_NAM"));
        PageObject.select_Locator("fieldName:A.ADDRESS.TYPE",column.get("ADDRESS_TYPE"));
        PageObject.textarea_Locator("fieldName:ADD.H",column.get("ADD_H"));
        PageObject.textinput_Locator("fieldName:STREET:1",column.get("STREET"));

        PageObject.textinput_Locator("fieldName:TOWN.COUNTRY:1",column.get("TOWN_COUNTRY"));

        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT",column.get("SBP_IND_PARENT"));
        PageObject.click_Locator("fieldName:TOWN.COUNTRY:1");

//        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY",column.get("SBP_INDUSTRY"));
//        PageObject.textinput_Locator("fieldName:TARGET",column.get("TARGET"));
//        PageObject.textinput_Locator("fieldName:NATIONALITY",column.get("NATIONALITY"));
//        PageObject.textinput_Locator("fieldName:RESIDENCE",column.get("RESIDENCE"));
        PageObject.textinput_Locator("fieldName:DATE.OF.BIRT.LC",column.get("DATE_OF_BIRT_LC"));
        PageObject.textinput_Locator("fieldName:BIRTH.INCORP.DATE",column.get("BIRTH_INCORP_DATE"));
        PageObject.select_Locator("fieldName:ASAN.ACCOUNT",column.get("ASAN_ACCOUNT"));
        PageObject.select_Locator("fieldName:BAF.PREM.CUST",column.get("BAF_PREM_CUST"));
        PageObject.select_Locator("fieldName:BAF.PRM.THRSHLD",column.get("BAF_PRM_THRSHLD"));
        PageObject.select_Locator("fieldName:IBG.PREM.CUST",column.get("IBG_PREM_CUST"));
        PageObject.select_Locator("fieldName:IBG.PRM.THRSHLD",column.get("IBG_PRM_THRSHLD"));
        PageObject.textinput_Locator("fieldName:VISA.NO",column.get("VISA_NO"));
        PageObject.textinput_Locator("fieldName:EXP.DATE",column.get("EXP_DATE"));
        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);

        // CRP
//        PageObject.textinput_Locator("fieldName:CRP.TYPE",column.get("CRP_TYPE"));
        PageObject.click_Locator("fieldName:CUS.CATEG:1");
        if ( (crpType.equalsIgnoreCase("8")) || (crpType.equalsIgnoreCase("4")) ) {
            System.out.println("condition no2 true !");
            PageObject.textinput_Locator("fieldName:INCM.LEVELSRC", column.get("INCM_LEVELSRC"));

        }

        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1",column.get("CRP.CHANNEL:1"));
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1",column.get("CUS_CATEG"));
        Accounts.PD = column.get("CUS_CATEG");
        //Accounts.customerPD.add(column.get("CUS_CATEG"));
//        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1",column.get("CRP_CHANNEL"));
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1",column.get("EXP_GEO_INT"));
        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1",column.get("EXP_GEO_LOCAL"));
        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:1",column.get("CREDIT_TURNOVER"));
        PageObject.select_Locator("fieldName:SEDING.FACTS:1",column.get("SEDING_FACTS"));
        PageObject.textarea_Locator("fieldName:FURTHER.DETAILS",column.get("SEDING_SCORE"));
//        Thread.sleep(10000);

        //Extra
//        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT",column.get("SBP_IND_PARENT"));
//        PageObject.click_Locator("fieldName:TARGET");
//        PageObject.textinput_Locator("fieldName:ID.TYPE:1",column.get("ID_TYPE"));
//        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY",column.get("SBP_INDUSTRY"));
//        PageObject.click_Locator("fieldName:TARGET");
//        PageObject.textinput_Locator("fieldName:TARGET",column.get("TARGET"));
//        PageObject.click_Locator("fieldName:ID.VAL.DT:1");
//        PageObject.textinput_Locator("fieldName:ID.VAL.DT:1",column.get("ID_VAL_DT"));
////        PageObject.textinput_Locator("fieldName:DELIVERY.WDRAW:1",column.get("ID_VAL_DT"));
//
        PageObject.textinput_Locator("fieldName:DELIVERY.WDRAW:1",column.get("DELIVERY.WDRAW"));


//
//        // CP
//        PageObject.form_Tab("Contact Person");
//        PageObject.textinput_Locator("fieldName:CP.NAME:1",column.get("CP_NAME"));
//        PageObject.textinput_Locator("fieldName:CP.TITLE:1",column.get("CP_TITLE"));
//        PageObject.textinput_Locator("fieldName:CP.ADD:1",column.get("CP_ADD"));
//        PageObject.textinput_Locator("fieldName:CP.ADD2:1",column.get("CP_ADD2"));
//        PageObject.textinput_Locator("fieldName:CP.PH.OFF:1",column.get("CP_PH_OFF"));
//        PageObject.textinput_Locator("fieldName:CP.FAX.NO:1",column.get("CP_FAX_NO"));
//        PageObject.textinput_Locator("fieldName:CP.CELL.NO:1",column.get("CP_CELL_NO"));
//        PageObject.textinput_Locator("fieldName:CP.PH.RES:1",column.get("CP_PH_RES"));
//        PageObject.textinput_Locator("fieldName:CP.EMAIL:1",column.get("CP_EMAIL"));
//
        commitDeal();
        txnValidate();
        saveToDS("Individual Customers");
        saveToDS("UnAuth_Customers");
//        Accounts.customerTxn.add(PageObject.getTxn());
        //saveToDS("Accounts");

    }

    //******************** Corporate Customer **************************//

    @Test  (groups = {"Inputter"}, dataProvider = "corpCustomer")
    public void corporateCustomer(Map<String, String> column) throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        PageObject.menu_Link("Corporate Customers ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        TC = column.get("TC");

//        PageObject.textinput_Locator("fieldName:SECTOR",column.get("SECTOR"));
//        SECTOR = column.get("SECTOR");
//        PageObject.select_Locator("fieldName:CUST.SEGMENT",column.get("CUST_SEGMENT"));
//        PageObject.radiobutton_Locator("radio:mainTab:SME.TYPE",1);
//        PageObject.textinput_Locator("fieldName:ID.TYPE:1",column.get("ID_TYPE"));
//        PageObject.textinput_Locator("fieldName:ID.NUMBER:1","42309978" + PageObject.idNumber());
//        PageObject.click_Locator("fieldName:ID.VAL.DT:1");

        PageObject.textinput_Locator("fieldName:CRP.TYPE",column.get("CRP_TYPE"));

        //PageObject.textinput_Locator("fieldName:TARGET",column.get("TARGET"));

//        PageObject.textarea_Locator("fieldName:TEXT:1","");

        PageObject.click_Locator("fieldName:NAME.1:1");
        PageObject.textinput_Locator("fieldName:TARGET",column.get("TARGET"));
        PageObject.click_Locator("fieldName:NAME.1:1");
        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT",column.get("SBP_IND_PARENT"));
        PageObject.click_Locator("fieldName:SBP.INDUSTRY");
        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY",column.get("SBP_INDUSTRY"));
//        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);
        PageObject.click_Locator("fieldName:NAME.1:1");

//        driver.findElement(By.xpath("//*[@id=\"radio:mainTab:CUS.PEP\"]")).click();
//        PageObject.click_Locator("fieldName:NAME.1:1");
        PageObject.radiobutton_Locator("radio:mainTab:CUS.PEP",2);

        //        PageObject.textinput_Locator("fieldName:SECTOR",column.get("SECTOR"));
//        SECTOR = column.get("SECTOR");
//        PageObject.select_Locator("fieldName:CUST.SEGMENT",column.get("CUST_SEGMENT"));
//        PageObject.radiobutton_Locator("radio:mainTab:SME.TYPE",1);
//        PageObject.textinput_Locator("fieldName:ID.TYPE:1",column.get("ID_TYPE"));
//        String ID_TYPE= column.get("ID_TYPE");
//        if (ID_TYPE.equalsIgnoreCase("ID-SPR")) {
//            PageObject.textinput_Locator("fieldName:ID.NUMBER:1","EB344078" + PageObject.idNumber());
//        }
//        else  {
//            PageObject.textinput_Locator("fieldName:ID.NUMBER:1","42344078" + PageObject.idNumber());
//        }

        PageObject.textinput_Locator("fieldName:ID.TYPE:1",column.get("ID_TYPE"));
        PageObject.click_Locator("fieldName:NAME.1:1");
        PageObject.textinput_Locator("fieldName:ID.NUMBER:1",column.get("ID_NUMBER"));
        PageObject.click_Locator("fieldName:NAME.1:1");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT:1",column.get("ID_VAL_DT"));

        //add the fields...



//        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);

        PageObject.textinput_Locator("fieldName:NAME.1:1",column.get("NAME_1"));
        PageObject.textinput_Locator("fieldName:NAME.2:1","COMPANY");
//        PageObject.textinput_Locator("fieldName:SOLE.NAME","SOLE_NAME");
//        PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM","MB_FATH_HUS_NAM");
        PageObject.select_Locator("fieldName:A.ADDRESS.TYPE",column.get("ADDRESS_TYPE"));
        PageObject.textarea_Locator("fieldName:ADD.H",column.get("ADD_H"));
        PageObject.textinput_Locator("fieldName:STREET:1",column.get("STREET"));
        PageObject.textinput_Locator("fieldName:TOWN.COUNTRY:1",column.get("TOWN_COUNTRY"));
//        PageObject.click_Locator("fieldName:SBP.IND.PARENT");
        PageObject.radiobutton_Locator("radio:mainTab:CUS.PEP",1);

        PageObject.textinput_Locator("fieldName:NATIONALITY",column.get("NATIONALITY"));
        PageObject.textinput_Locator("fieldName:RESIDENCE",column.get("RESIDENCE"));
        PageObject.textinput_Locator("fieldName:BIRTH.INCORP.DATE",column.get("BIRTH_INCORP_DATE"));
        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);


//        PageObject.select_Locator("fieldName:ASAN.ACCOUNT",column.get("ASAN_ACCOUNT"));
//        PageObject.select_Locator("fieldName:BAF.PREM.CUST",column.get("BAF_PREM_CUST"));
//        PageObject.select_Locator("fieldName:BAF.PRM.THRSHLD",column.get("BAF_PRM_THRSHLD"));
//        PageObject.select_Locator("fieldName:IBG.PREM.CUST",column.get("IBG_PREM_CUST"));
//        PageObject.select_Locator("fieldName:IBG.PRM.THRSHLD",column.get("IBG_PRM_THRSHLD"));
//        PageObject.textinput_Locator("fieldName:VISA.NO",column.get("VISA_NO"));
//        PageObject.textinput_Locator("fieldName:EXP.DATE",column.get("EXP_DATE"));
//        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);

        // CRP
        //PageObject.textinput_Locator("fieldName:CRP.TYPE",column.get("CRP_TYPE"));
        //PageObject.textinput_Locator("fieldName:INCM.LEVELSRC",column.get("INCM_LEVELSRC"));
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1",column.get("CUS_CATEG"));
        Accounts.PD = column.get("CUS_CATEG");
//        Accounts.customerPD.add(column.get("CUS_CATEG"));
        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1",column.get("CRP_CHANNEL"));
        PageObject.textinput_Locator("fieldName:DELIVERY.WDRAW:1",column.get("DELIVERY.WDRAW"));
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1",column.get("EXP_GEO_INT"));
        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1",column.get("EXP_GEO_LOCAL"));
        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:1",column.get("CREDIT_TURNOVER"));
        PageObject.select_Locator("fieldName:SEDING.FACTS:1",column.get("SEDING_FACTS"));
        PageObject.textarea_Locator("fieldName:FURTHER.DETAILS",column.get("SEDING_SCORE"));

        // CP
        PageObject.form_Tab("Contact Person");
        PageObject.textinput_Locator("fieldName:CP.NAME:1",column.get("CP_NAME"));
        PageObject.textinput_Locator("fieldName:CP.TITLE:1",column.get("CP_TITLE"));
        PageObject.textinput_Locator("fieldName:CP.ADD:1",column.get("CP_ADD"));
        PageObject.textinput_Locator("fieldName:CP.ADD2:1",column.get("CP_ADD2"));
        PageObject.textinput_Locator("fieldName:CP.PH.OFF:1",column.get("CP_PH_OFF"));
        PageObject.textinput_Locator("fieldName:CP.FAX.NO:1",column.get("CP_FAX_NO"));
        PageObject.textinput_Locator("fieldName:CP.CELL.NO:1",column.get("CP_CELL_NO"));
        PageObject.textinput_Locator("fieldName:CP.PH.RES:1",column.get("CP_PH_RES"));
        PageObject.textinput_Locator("fieldName:CP.EMAIL:1",column.get("CP_EMAIL"));

        // PARTNER
        PageObject.form_Tab("Director/Partner/Trustees/Office Bearer");

        PageObject.textinput_Locator("fieldName:NAME:1",column.get("NAME"));
        PageObject.textinput_Locator("fieldName:P.ID.TYPE:1",column.get("P_ID_TYPE"));
        PageObject.textinput_Locator("fieldName:ID.NO:1","47893978" + PageObject.idNumber());
        PageObject.textinput_Locator("fieldName:FATER.HUSBAND:1",column.get("FATER_HUSBAND"));
        PageObject.textinput_Locator("fieldName:RES.ADD:1",column.get("RES_ADD"));
        PageObject.textinput_Locator("fieldName:P.PHNO.OFF:1",column.get("P_PHNO_OFF"));
        PageObject.textinput_Locator("fieldName:CELLULAR.NO:1",column.get("CELLULAR_NO"));
        PageObject.textinput_Locator("fieldName:PH.NO.RES:1",column.get("PH_NO_RES"));
        PageObject.textinput_Locator("fieldName:P.ID.VALIDITY:1",column.get("P_ID_VALIDITY"));
        PageObject.textinput_Locator("fieldName:CUS.NATN:1",column.get("CUS_NATN"));
        PageObject.textinput_Locator("fieldName:CUS.DOB:1",column.get("CUS_DOB"));
        PageObject.textinput_Locator("fieldName:CUS.BIRTH.PLACE:1",column.get("CUS_BIRTH_PLACE"));
       /* PageObject.textinput_Locator("fieldName:P.CITY:1","");
        PageObject.textinput_Locator("fieldName:P.PROVINCE:1","");
        PageObject.textinput_Locator("fieldName:P.CUST.GENDER:1","");
*/

        PageObject.img_Button("Validate a deal");

//        PageObject.img_Button("Validate a deal");
//
        commitDeal();
        txnValidate();
        saveToDS("Corporate Customers");
        saveToDS("UnAuth_Customers");
        //Accounts.customerTxn.add(PageObject.getTxn());
    }




    @Test  (groups = {"Authorizer"}, dataProvider = "auth")
    public void customerAuthorization(Map<String, String> column) throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Authorization");
        PageObject.menu_Dropdown("Authorization of CIF & ACCOUNT");
        PageObject.menu_Dropdown("Authorization of Customer");
        PageObject.menu_Link("Authorization of CIF- Branch Level ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("value:1:1:1",column.get("Customer_ID"));
        Customers.Txn = column.get("Customer_ID");

        TC = column.get("TC");
        Accounts.PD = column.get("PD");

        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorise a Customer");
        PageObject.authorizeDeal();
        txnValidate();

        saveToDS("CUSTOMERS");
    }



//                                 <<<      DATA PROVIDER      >>>

    @DataProvider(name = "indCustomer")
    public Object[][] indCustomer() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\DevopsTC_customerIndividual.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        rowCount=count;
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

    @DataProvider(name = "corpCustomer")
    public Object[][] corpCustomer() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\DevopsTC_customerCorporate.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        rowCount=count;
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

    @DataProvider(name = "auth")
    public Object[][] auth() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\UnAuth_Customers.xlsx";
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







    // Commit Deal For Inputter
    public static void commitDeal () throws IOException {
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Validate a deal']")).click();
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Commit the deal']")).click();
        if (driver.getPageSource().contains("Txn Complete:")){
            txnValidate();
        }else {
            try {
                WebElement acpOverride = driver.findElement(By.xpath("//tr/td/a[text()='Accept Overrides']"));
                acpOverride.click();
                txnValidate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static void txnValidate() throws IOException {
        WebElement Txn = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'Txn Complete:')]"));
        Assert.assertTrue(Txn.isDisplayed(),"Transaction Un-Successful");
        String Transaction = Txn.getText();
        String[] first = Transaction.split(":");
        String[] second = first[1].split(" ");
        Customers.Txn = second[1];
        System.out.println("Customer Number is: "+Customers.Txn);

    }

    public static void saveToDS(String testCaseName) throws IOException {

        if (testCaseName.equalsIgnoreCase("Accounts")){
            file = new File(System.getProperty("user.dir") + "\\Excel Data\\" +testCaseName+ ".xlsx");
            System.out.println("writting to file of accounts");
        }

        else {
            file = new File(System.getProperty("user.dir") + "\\Data\\" +testCaseName+ ".xlsx");
            System.out.println("writting to file of customers");
        }
        XSSFWorkbook workbook;
        Row row;
        Cell cell;
        int rowNum = 0;

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            rowNum = sheet.getLastRowNum() + 1; // Start writing from the next row
        } else {
            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellValue("TC");
            cell = row.createCell(1);
            cell.setCellValue("Customer_ID");
            cell = row.createCell(2);
            cell.setCellValue("PD");

        }

        Sheet sheet = workbook.getSheetAt(0);
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue(Customers.TC);
        cell = row.createCell(1);
        cell.setCellValue(Customers.Txn);
        cell = row.createCell(2);
        cell.setCellValue(Accounts.PD);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

    }
}
