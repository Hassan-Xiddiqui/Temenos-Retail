package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static Test.Scripts.Conventional.RetailBanking.Customers.*;

public class ECRP extends BaseClass  {

    static String incomeSourceLevel;

    @Test (groups = {"CaoInputterECRP"}, dataProvider = "TestData")
    public void ECRP(Map<String, String> column) throws InterruptedException, IOException {

        Customers.Txn = column.get("Customer_ID");
        TC = column.get("TC");
        Accounts.PD = column.get("PD");

        PageObject.menu_Dropdown("CENTRALIZED ACCOUNT PROCESSOR");
        PageObject.menu_Dropdown("CORE/RETAIL MAIN MENU");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Amendment of Customer");
        PageObject.menu_Link("Amendment of Live Customer  ");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",column.get("Customer_ID"));
        PageObject.click_Locator("defaultButton");

        PageObject.form_Link("Amend Indivial/Sole/Minor Customer");

        // CRP Details
        PageObject.form_Tab("Customer's Risk Profiling Details");

        PageObject.imgchild_Button("Expand Sub Value" , 2);
        PageObject.textinput_Locator("fieldName:CUS.CATEG:2","1001");
        PageObject.imgchild_Button("Expand Sub Value" , 4);
        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:2","9");
        PageObject.imgchild_Button("Expand Sub Value" , 6);
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:2","PK");
        PageObject.imgchild_Button("Expand Sub Value" , 8);
        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:2","1");
        PageObject.imgchild_Button("Expand Sub Value" , 10);
        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:2","402");
        PageObject.imgchild_Button("Expand Sub Value" , 12);
        PageObject.select_Locator("fieldName:SEDING.FACTS:2","Not Applicable");

        commitDeal();

        PageObject.select_Locator("fieldName:OCCUPATION","Business");
        PageObject.textinput_Locator("fieldName:NAME.OF.BUS","EVENT MANAGEMENT");
        PageObject.textinput_Locator("fieldName:NAT.OF.BUS","EVENT MANAGEMENT");
        PageObject.textinput_Locator("fieldName:STAT.OWNER","EVENT MANAGEMENT");
        PageObject.textinput_Locator("fieldName:NAME.OF.EMP","ALI REHMAN");
        PageObject.textinput_Locator("fieldName:CS.POS","CEO");
        PageObject.textinput_Locator("fieldName:CS.EMP.SINCE","1995");
        PageObject.radiobutton_Locator("radio:mainTab:STATUS",1);

        PageObject.textinput_Locator("fieldName:CURRENT.SALARY","");
        PageObject.textinput_Locator("fieldName:OTHER.INCOME","");
        PageObject.textinput_Locator("fieldName:OTHER.FUNDS","");
        PageObject.textinput_Locator("fieldName:PER.PROP.INMNT","");
        PageObject.textinput_Locator("fieldName:CS.ANNUM.TO","");
        PageObject.textinput_Locator("fieldName:SOURCE.OF.INCOME","");
        PageObject.radiobutton_Locator("radio:mainTab:REL.POILITICAL",1);
        PageObject.textinput_Locator("fieldName:POLITICAL.FIGURE","");
        PageObject.radiobutton_Locator("radio:mainTab:PFAMAPPROVAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:HRAMAPPROVAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);
        PageObject.textinput_Locator("fieldName:CUST.COMMENTS:1","NEW CUSTOMER");
        PageObject.textinput_Locator("fieldName:EXP.COUNT.PARTY:1","ISLAMABAD");


        commit2();
        Customers.txnValidate();
        Customers.saveToDS("ECRP");

    }

    @Test  (groups = {"Inputter"}, dataProvider = "TestData")
    public void ECRP_housewife (Map<String, String> column) throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        PageObject.menu_Link("Individual/Sole/Proprietorship/Minor ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        TC = column.get("TC");

//        PageObject.textinput_Locator("fieldName:CRP.TYPE",testData.get("CRP.TYPE"));
//        PageObject.textinput_Locator("fieldName:SRC.FUNDS",testData.get("SRC.FUNDS"));
//        PageObject.textinput_Locator("fieldName:TARGET",testData.get("TARGET"));
//        PageObject.textinput_Locator("fieldName:TEXT:1",testData.get("TEXT"));
//        PageObject.textinput_Locator("fieldName:CUS.PEP",testData.get("CUS.PEP"));
//        PageObject.textinput_Locator("radio:mainTab:CUS.PEP",testData.get("mainTab"));
//        PageObject.textinput_Locator("radio:mainTab:CUS.PEP",testData.get("mainTab"));
//        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT",testData.get("SBP.IND.PARENT"));
//        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY",testData.get("SBP.INDUSTRY"));

        PageObject.textinput_Locator("fieldName:SECTOR",column.get("SECTOR"));
        SECTOR = column.get("SECTOR");
        PageObject.select_Locator("fieldName:CUST.SEGMENT",column.get("CUST_SEGMENT"));
        PageObject.radiobutton_Locator("radio:mainTab:SME.TYPE",1);
        PageObject.textinput_Locator("fieldName:ID.TYPE:1",column.get("ID_TYPE"));
        String ID_TYPE= column.get("ID_TYPE");
        if (ID_TYPE.equalsIgnoreCase("ID-SPR")) {
            PageObject.textinput_Locator("fieldName:ID.NUMBER:1","EB344078" + PageObject.idNumber());
        }
        else  {
            PageObject.textinput_Locator("fieldName:ID.NUMBER:1","42344078" + PageObject.idNumber());
        }
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
        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY",column.get("SBP_INDUSTRY"));
        PageObject.textinput_Locator("fieldName:TARGET",column.get("TARGET"));
        PageObject.textinput_Locator("fieldName:NATIONALITY",column.get("NATIONALITY"));
        PageObject.textinput_Locator("fieldName:RESIDENCE",column.get("RESIDENCE"));
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
        PageObject.textinput_Locator("fieldName:CRP.TYPE",column.get("CRP_TYPE"));
        PageObject.textinput_Locator("fieldName:INCM.LEVELSRC",column.get("INCM_LEVELSRC"));

        String num = column.get("INCM_LEVELSRC");
        if (num.equalsIgnoreCase("101")) {
            incomeSourceLevel = "<100,000";
        }
        else if(num.equalsIgnoreCase("103")) {
            incomeSourceLevel = ">300,000";
        }
        else {
            incomeSourceLevel = "100,000 - 300,000";
        }

        PageObject.textarea_Locator("fieldName:INCM.LEVELSRC","");
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1",column.get("CUS_CATEG"));
        Accounts.PD = column.get("CUS_CATEG");
        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1",column.get("CRP_CHANNEL"));
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

        commitDeal();
        txnValidate();
        saveToDS("Individual Customers");
    }




//                                 <<<      DATA PROVIDER      >>>

    @DataProvider(name = "TestData")
    public Object[][] indCustomer() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\DevopsTC_customerIndividual.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        rowCount=2;
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
    }
    public static void txnValidate()  {

        if (incomeSourceLevel.equalsIgnoreCase("<100,000")) {
            WebElement Txn = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'MEDIUM')]"));
        }
        else if(incomeSourceLevel.equalsIgnoreCase(">300,000")) {
            WebElement Txn = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'HIGH')]"));
        }
        else {
            WebElement Txn = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'LOW')]"));

            Assert.assertTrue(Txn.isDisplayed(), "Transaction Un-Successful");
            Customers.Txn = Txn.getText();
            System.out.println("Transaction Number is: " + Customers.Txn);
        }
    }

    private static void commit2() {
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Commit the deal']")).click();
    }
}
