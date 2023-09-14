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

public class chequeBookManagement extends BaseClass {

    public static String Txn="";
    public static String chq="CD.5000001475";

    @Test(groups = {"IBGInputter"})
    public void Issuance() throws  IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu- IBG");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Request For Issuance to CBU ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId",chq); //CD.5000001475  CD.5000720713.0000014
        PageObject.img_Button("Edit a contract");

        String Deal = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(Deal);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:ORDERING.DATE","20221231");
        PageObject.select_Locator("fieldName:ISSUED.AGAINST","REQUISTION EXISTING A/C");
        PageObject.select_Locator("fieldName:NO.CHQ.ISSUED","25");
        PageObject.textinput_Locator("fieldName:LAST.SERIAL","34314526");
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK ISSUED");
        PageObject.radiobutton_Locator("radio:tab1:WAIVE.CHARGES",1);

        PageObject.commitDeal("chequeBook(IBG)");


    }


    @Test(groups = {"IBGInputter"}, dataProvider = "chq")
    public void Received(Map<String, String> column) throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu- IBG");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Received From CPU ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",column.get("Transaction Number"));
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Received Cheque Book");

        PageObject.parentFrame();
        PageObject.switchFrame(1);

        PageObject.textinput_Locator("fieldName:CHQ.NO.STARTS","34563486");
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK RECEIVED");
        PageObject.radiobutton_Locator("radio:tab1:WAIVE.CHARGES",1);

        Customers.commitDeal();
//        PageObject.commitDeal("chequeBook(IBG)");


    }


    @Test(groups = {"IbgAuthorizer"}, dataProvider = "chq")
    public void Received_Authorization(Map<String, String> column)  {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");
        PageObject.menu_Link("Authorization Received From CPU ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",column.get("Transaction Number"));
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorize");
        PageObject.authorizeDeal();

    }


    @Test(groups = {"IBGInputter"}, dataProvider = "chq")
    public void DeliveredTo3rdParty(Map<String, String> column) throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu- IBG");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Delivered to Third Party ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("value:1:1:1", column.get("Transaction Number"));
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Delivered to third Party");

        PageObject.textinput_Locator("fieldName:DELIV.TO.CUS","AFFAN");
        PageObject.textinput_Locator("fieldName:CNIC.CUS","4098674826453");
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK DELIVERED");

        Customers.commitDeal();
//        PageObject.commitDeal("chequeBookDelivered");
//        Txn = PageObject.getTxn();


    }

    @Test(groups = {"IbgAuthorizer"}, dataProvider = "chq")
    public void DeliveredTo3rdParty_Authorization(Map<String, String> column) throws InterruptedException{


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");
        PageObject.menu_Link("Authorization of Third Party Delivery ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",column.get("Transaction Number"));
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorize");

        Thread.sleep(5000);

        //frame not found issue!
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        PageObject.authorizeDeal();

    }


    @Test(groups = {"IBGInputter"}, dataProvider = "chq")
    public void Activation(Map<String, String> column) throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu- IBG");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Activation ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",column.get("Transaction Number"));
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Activate Cheque Book");

        PageObject.parentFrame();
        PageObject.switchFrame(1);

        PageObject.select_Locator("fieldName:ISSUED.AGAINST","REQUISTION EXISTING A/C");
        PageObject.textinput_Locator("fieldName:CHQ.NO.START","34563486"); //34314526
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK ISSUED");

        Customers.commitDeal();
//        PageObject.commitDeal("chequeBookActivated");
//        Txn = PageObject.getTxn();

    }

    @Test(groups = {"IbgAuthorizer"}, dataProvider = "chq")
    public void ActivationAuth(Map<String, String> column) throws InterruptedException {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");
        PageObject.menu_Link("Authorization of Cheque Book Activation ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",column.get("Transaction Number"));
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorize");

        Thread.sleep(5000);

//        PageObject.parentFrame();
//        PageObject.switchFrame(1);
        PageObject.authorizeDeal();

    }

    @DataProvider(name = "chq")
    public Object[][] auth() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\chequeBook(IBG).xlsx";
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