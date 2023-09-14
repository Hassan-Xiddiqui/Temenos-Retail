package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Test.Scripts.Conventional.RetailBanking.Customers.*;

public class Accounts extends BaseClass {
//    Customers customer = new Customers();

    private static int count = 11;
    public static String PD,CUSTOMER;
    public static File  file;

    static int Customerindex = 0;
    static int PDindex = 0;

    public static ArrayList<String> customerTxn = new ArrayList<>();
    public static ArrayList<String> customerPD = new ArrayList<>();

    public static String ACCOUNT_TITLE_1,ACCOUNT_TITLE_2,OTHER_OFFICER,REFEREE,JOINT_HOLDER,RELATION_CODE,
            JOINT_NOTES,MULTI_ACCT,BAF_PRM_IMD,BAF_PRM_CRDNAME,BAF_PRM_PEN,BAF_PRM_DATETME,REMITTER_NAME,REMITTER_ID_NO,
            RELATIONSHIP_BE,REMITTER_RESID,REMITTER_ID_TYP,CURRENCY;
    public static String[] LCY_CURRENT_ACCOUNTS = { "1001", "1005", "1007", "1010", "1011", "1014", "1017", "1022",
                                                    "1030", "1031", "1034", "1035", "1037", "1038", "1142", "1143",
                                                    "1150", "1171", "1326" };
    //CurrentAcc,
    public static String[] LCY_SAVING_ACCOUNTS = { "6001", "6004", "6005", "6009", "6012", "6014", "6018", "6025" };
    public static String[] FCY_CURRENT_ACCOUNTS = { "1003", "1033", "1036", "1040", "1142", "1143" };
    public static String[] FCY_SAVING_ACCOUNTS = { "6003", "6019", "6030", "6035", "6039" };
    public static String[] KIDS_ACCOUNT = { "6020" };

    //		                         <<<<    CALLING DIFFERENT SCRIPTS    >>>>

    @Test (groups = {"Inputter"}, dataProvider = "condition")
    public void callAccountCreation(Map<String, String> column) throws InterruptedException, IOException {

//        Getting the data
        if (Customerindex==0)
        getTxnAndPD();

        //require from Customer Script !
//        CUSTOMER = column.get("Customer_ID");
//        Accounts.PD = column.get("CATEGORY");

//        System.out.println("the array size:  "+customerTxn.size());
//
        System.out.println("Customer is:  "+customerTxn+" and the Category:  "+customerPD);
//
        System.out.println("Before increment, Index of customer and PD: "+Customerindex +" "+PDindex);
        CUSTOMER = customerTxn.get(Customerindex++);
        Accounts.PD = customerPD.get(PDindex++);
        System.out.println("After increment, Index of customer and PD: "+Customerindex +" "+PDindex);

        TC = column.get("TC-Account Creation");

//        WebElement element = driver.findElement(By.xpath("//[@id='disabled_DEBIT.ACCT.NO']"));
//        String debitAcc = element.getText();


        CURRENCY = column.get("CURRENCY");
        ACCOUNT_TITLE_1 = column.get("ACCOUNT_TITLE_1");
        ACCOUNT_TITLE_2 = column.get("ACCOUNT_TITLE_2");
        OTHER_OFFICER = column.get("OTHER_OFFICER");
        REFEREE = column.get("REFEREE");
        JOINT_HOLDER = column.get("JOINT_HOLDER");
        RELATION_CODE = column.get("RELATION_CODE");
        JOINT_NOTES = column.get("JOINT_NOTES");
        MULTI_ACCT = column.get("MULTI_ACCT");
        REMITTER_NAME = column.get("REMITTER_NAME");
        REMITTER_ID_NO = column.get("REMITTER_ID_NO");
        RELATIONSHIP_BE = column.get("RELATIONSHIP_BE");
        REMITTER_RESID = column.get("REMITTER_RESID");
        REMITTER_ID_TYP = column.get("REMITTER_ID_TYP");

        for (String typeOfProduct : LCY_CURRENT_ACCOUNTS) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                lcyCurrentAccount();
            }
        }
        for (String typeOfProduct : LCY_SAVING_ACCOUNTS) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                lcySavingAccount();
            }
        }
        for (String typeOfProduct : FCY_CURRENT_ACCOUNTS) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                fcyCurrentAccount();
            }
        }
        for (String typeOfProduct : FCY_SAVING_ACCOUNTS) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                fcySavingAccount();
            }
        }
        for (String typeOfProduct : KIDS_ACCOUNT) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                lcyKidsAccount();
            }
        }

    }

    public static void saveToDS(String testCaseName, String txnOfAcc) throws IOException {

        file = new File(System.getProperty("user.dir") + "\\Excel Data\\" +testCaseName+ ".xlsx");
        System.out.println("writting to file of accounts");

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
            cell.setCellValue("Account Number");
        }

        Sheet sheet = workbook.getSheetAt(0);
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue(txnOfAcc);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

    }

    public void lcyCurrentAccount() throws InterruptedException, IOException {
//        System.out.println(customer.Txn);

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Current Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");


        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.textinput_Locator("fieldName:CATEGORY", PD);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);
        PageObject.textinput_Locator("fieldName:REFEREE",  REFEREE);

        PageObject.radiobutton_Locator("radio:tab1:BAF.PEN.ACCT", 1);

//        PageObject.click_Locator("fieldName:ACC.OTH.FLAG:1");
        //Non mandatory fields:

//        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
//        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
//        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);
//        PageObject.select_Locator("fieldName:MULTI.ACCT",  MULTI_ACCT);

        // TAB2
//        PageObject.form_Tab("PREMIER.DEBITCARD");
//
//        PageObject.select_Locator("fieldName:BAF.PRM.IMD", BAF_PRM_IMD);
//        PageObject.textinput_Locator("fieldName:BAF.PRM.CRDNAME", BAF_PRM_CRDNAME);
//        PageObject.radiobutton_Locator("radio:tab2:BAF.PRM.FMEMBR", 1);
//        PageObject.textinput_Locator("fieldName:BAF.PRM.PEN", BAF_PRM_PEN);
//        PageObject.textinput_Locator("fieldName:BAF.PRM.DATETME", BAF_PRM_DATETME);
//
//        // TAB3
//        PageObject.form_Tab("Alfalah Assan Remittance");
//
//        PageObject.textinput_Locator("fieldName:REMITTER.NAME:1", REMITTER_NAME);
//        PageObject.textinput_Locator("fieldName:REMITTER.ID.NO:1", REMITTER_ID_NO);
//        PageObject.textinput_Locator("fieldName:RELATIONSHIP.BE:1", RELATIONSHIP_BE);
//        PageObject.textinput_Locator("fieldName:REMITTER.RESID:1", REMITTER_RESID);
//        PageObject.textinput_Locator("fieldName:REMITTER.ID.TYP:1", REMITTER_ID_TYP);

        commitDeal();
        txnValidate();
        saveToDS2("LCY Current Accounts");
        saveToDS("unAuthAccounts",PageObject.getTxn());
    }

    public void lcySavingAccount() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Saving Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY", PD);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);
        PageObject.textinput_Locator("fieldName:REFEREE",  REFEREE);
        PageObject.radiobutton_Locator("radio:mainTab:BAF.PEN.ACCT", 1);

    //Non mandatory fields:

        /*
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);
        PageObject.select_Locator("fieldName:MULTI.ACCT",  MULTI_ACCT);


        // TAB2
        PageObject.form_Tab("PREMIER.DEBITCARD");

        PageObject.select_Locator("fieldName:BAF.PRM.IMD", BAF_PRM_IMD);
        PageObject.textinput_Locator("fieldName:BAF.PRM.CRDNAME", BAF_PRM_CRDNAME);
        PageObject.radiobutton_Locator("radio:tab1:BAF.PRM.FMEMBR", 1);
        PageObject.textinput_Locator("fieldName:BAF.PRM.PEN", BAF_PRM_PEN);
        PageObject.textinput_Locator("fieldName:BAF.PRM.DATETME", BAF_PRM_DATETME);


        // TAB3
        PageObject.form_Tab("Alfalah Assan Remittance");

        PageObject.textinput_Locator("fieldName:REMITTER.NAME:1", REMITTER_NAME);
        PageObject.textinput_Locator("fieldName:REMITTER.ID.NO:1", REMITTER_ID_NO);
        PageObject.textinput_Locator("fieldName:RELATIONSHIP.BE:1", RELATIONSHIP_BE);
        PageObject.textinput_Locator("fieldName:REMITTER.RESID:1", REMITTER_RESID);
        PageObject.textinput_Locator("fieldName:REMITTER.ID.TYP:1", REMITTER_ID_TYP);
*/
        commitDeal();
        txnValidate();
        saveToDS2("LCY Saving Accounts");
        saveToDS("unAuthAccounts",PageObject.getTxn());
    }

    public void lcyKidsAccount() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Alfalah SnaPack Kids Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.click_Locator("fieldName:ACCOUNT.TITLE.1:1");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);Thread.sleep(2000);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);Thread.sleep(2000);
        PageObject.click_Locator("fieldName:OTHER.OFFICER:1");
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);Thread.sleep(2000);
//      PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
//        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
//        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Commit the deal']")).click();
        try {
            WebElement acpOverride = driver.findElement(By.xpath("//tr/td/a[text()='Accept Overrides']"));
            acpOverride.click();
        } catch (Exception e) {
            System.out.println("No warnings !");
            Thread.sleep(6000);
            PageObject.click_Locator("fieldName:OTHER.OFFICER:1");
            PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);Thread.sleep(2000);
            commitDeal();
            saveToDS2("LCY Kids Accounts");
            saveToDS("unAuthAccounts",PageObject.getTxn());
        }


    }

    public void fcyCurrentAccount() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Foreign Currency Account Open");
//        PageObject.menu_Link("Current Account ");
        PageObject.childmenu_Link("Current Account ",2);

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.textinput_Locator("fieldName:CATEGORY", PD);
        PageObject.textinput_Locator("fieldName:CURRENCY", CURRENCY);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);
        PageObject.textinput_Locator("fieldName:REFEREE",  REFEREE);
//        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
//        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
//        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);

        commitDeal();
        txnValidate();
        saveToDS2("FCY Current Accounts");
        saveToDS("unAuthAccounts",PageObject.getTxn());
    }

    public void fcySavingAccount() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Foreign Currency Account Open");
//        PageObject.menu_Link("Saving Account ");
        PageObject.childmenu_Link("Saving Account ",2);
        //

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.textinput_Locator("fieldName:CATEGORY", PD);
        PageObject.textinput_Locator("fieldName:CURRENCY", CURRENCY);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);

//        PageObject.click_Locator("fieldName:MULTI.ACCT");

        PageObject.textinput_Locator("fieldName:REFEREE",  REFEREE);
//        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
//        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
//        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);

        commitDeal();
        txnValidate();
        saveToDS2("FCY Saving Accounts");
        saveToDS("unAuthAccounts",PageObject.getTxn());
    }


    @Test (groups = {"Authorizer"}, dataProvider = "auth")
    public void accountAuthorization(Map<String, String> column) throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Authorization");
        PageObject.menu_Dropdown("Authorization of CIF & ACCOUNT");
        PageObject.menu_Dropdown("Authorization of Account");
        PageObject.menu_Link("Authorization for Account- Branch Level ");


        homePage = PageObject.switchToChildWindow();

//        PageObject.textinput_Locator("value:1:1:1",variableName);
        PageObject.textinput_Locator("value:1:1:1",column.get("Account Number"));
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorise");
        PageObject.authorizeDeal();

    }





    public void getTxnAndPD() throws IOException {



        String excelFilePath = System.getProperty("user.dir")+"\\Data\\UnAuth_Customers.xlsx";

        try (FileInputStream inputStream = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read from the first sheet

            int columnIdIndex = -1;
            int pdIndex = -1;

            // Find the column indexes for "Column_ID" and "PD"
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                String cellValue = cell.getStringCellValue();
                if (cellValue.equalsIgnoreCase("Customer_ID")) {
                    columnIdIndex = cell.getColumnIndex();
                } else if (cellValue.equalsIgnoreCase("PD")) {
                    pdIndex = cell.getColumnIndex();
                }
            }

            if (columnIdIndex == -1 || pdIndex == -1) {
                System.out.println("Columns not found in the Excel sheet.");
                return;
            }

            // Read data from the specified columns
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                String Customer_ID = row.getCell(columnIdIndex).getStringCellValue();
                String pd = row.getCell(pdIndex).getStringCellValue();
                System.out.println("Customer_ID: " + Customer_ID + ", PD: " + pd);
                customerTxn.add(Customer_ID);
                customerPD.add(pd);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("the result:  ");

                System.out.println("the array size:  "+customerTxn.size());
        for (int i=0;i<customerTxn.size();i++){
            System.out.println("the customer is:    "+customerTxn.get(i)+" and pd: "+customerPD.get(i));
        }

    }


//                                 <<<      DATA PROVIDER      >>>

    @DataProvider(name = "condition")
    public Object[][] indCustomer() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\Accounts.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        rowCount=count
        ;
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
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\unAuthAccounts.xlsx";
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





    public static void saveToDS2(String testCaseName) throws IOException {
        File file = new File(System.getProperty("user.dir") + "\\Data\\" +testCaseName+ ".xlsx");
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
            cell.setCellValue("Account_ID");
            cell = row.createCell(2);
            cell.setCellValue("Customer_ID");
            cell = row.createCell(3);
            cell.setCellValue("PD");

        }

        Sheet sheet = workbook.getSheetAt(0);
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue(Customers.TC);
        cell = row.createCell(1);
        cell.setCellValue(Customers.Txn);
        cell = row.createCell(2);
        cell.setCellValue(CUSTOMER);
        cell = row.createCell(3);
        cell.setCellValue(Accounts.PD);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

    }

}