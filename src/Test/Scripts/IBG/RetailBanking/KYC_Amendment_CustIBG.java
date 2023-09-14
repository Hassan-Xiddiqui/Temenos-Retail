package Test.Scripts.IBG.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KYC_Amendment_CustIBG extends BaseClass {
    String txn;

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\kYC_Amendment_CustIBG.xlsx";
    String CusNumber="16992982";

    @Test(groups = {"IBGInputter"},dataProvider = "excelDataKYC_Amendment_CustIBG")

    public void KYC_Amendment_CustIBG(Map<String, String> testData) throws IOException, InterruptedException {



        PageObject.menu_Dropdown("Customer Relation Officer Menu- IBG");
        PageObject.menu_Dropdown("Alfalah Customer & Account Information-IBG ");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah KYC Information");
        PageObject.menu_Dropdown("Alfalah Customer KYC Information");

        PageObject.menu_Link("KYC Amendment Customer ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1", testData.get("value:1:1:1"));
        PageObject.find_Button();


        PageObject.form_Link("Input KYC");

        Thread.sleep(2000);

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.select_Locator("fieldName:OCCUPATION",testData.get("OCCUPATION"));  //Business or Salaried
        PageObject.textinput_Locator("fieldName:NAME.OF.BUS",testData.get("NAME.OF.BUS"));
        PageObject.textinput_Locator("fieldName:NAT.OF.BUS",testData.get("NAT.OF.BUS"));
        PageObject.textinput_Locator("fieldName:STAT.OWNER",testData.get("STAT.OWNER"));
        PageObject.textinput_Locator("fieldName:NAME.OF.EMP",testData.get("NAME.OF.EMP"));
        PageObject.textinput_Locator("fieldName:CS.POS",testData.get("CS.POS"));
        PageObject.textinput_Locator("fieldName:CS.EMP.SINCE",testData.get("CS.EMP.SINCE"));
        PageObject.radiobutton_Locator("radio:mainTab:STATUS",1);
        PageObject.textinput_Locator("fieldName:CURRENT.SALARY",testData.get("CURRENT.SALARY"));
        PageObject.textinput_Locator("fieldName:OTHER.INCOME",testData.get("OTHER.INCOME"));
        PageObject.textinput_Locator("fieldName:OTHER.FUNDS",testData.get("OTHER.FUNDS"));
        PageObject.textinput_Locator("fieldName:PER.PROP.INMNT",testData.get("PER.PROP.INMNT"));
        PageObject.textinput_Locator("fieldName:CS.ANNUM.TO",testData.get("CS.ANNUM.TO"));
        PageObject.textinput_Locator("fieldName:SOURCE.OF.INCOME",testData.get("SOURCE.OF.INCOME"));
        PageObject.radiobutton_Locator("radio:mainTab:REL.POILITICAL",1);
        PageObject.textinput_Locator("fieldName:POLITICAL.FIGURE",testData.get("POLITICAL.FIGURE"));
        PageObject.radiobutton_Locator("radio:mainTab:PFAMAPPROVAL",1);
        PageObject.textinput_Locator("fieldName:KYC.REVW.COMENT",testData.get("KYC.REVW.COMENT"));
        PageObject.radiobutton_Locator("radio:mainTab:HRAMAPPROVAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.BS.CNT.PHNO",1);
        PageObject.textinput_Locator("fieldName:CUST.COMMENTS:1",testData.get("CUST.COMMENTS:1"));
        PageObject.radiobutton_Locator("radio:mainTab:CH.FIN.STMT",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.EXP.GEO.LOCAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.EXP.GEO.INT",1);
        PageObject.textinput_Locator("fieldName:EXP.COUNT.PARTY:1",testData.get("EXP.COUNT.PARTY:1"));
        PageObject.radiobutton_Locator("radio:mainTab:CH.EXP.COUNT.PARTY",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.OCCUPATION",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.NAME.OF.BUS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.NAT.OF.BUS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.STAT.OWNER",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.NAME.OF.EMP",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.POS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.EMP.SINCE",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.STATUS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CURRENT.SALARY",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.COMMENTS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CUS.SATISFY",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.PER.PROP.INMNT",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.ANNUM.TO",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.SOURCE.OF.INCOME",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.REL.POILITICAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.POLITICAL.FIGURE",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.PFAMAPPROVAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.RISKLEVEL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.AMEND.DATE",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.KYC.REVW.COMENT",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.HRAMAPPROVAL",1);

        PageObject.commitDeal("IBG KYC_Amendment_Customer");

        txn = PageObject.getTxn();
        System.out.println(txn);
//        saveAccNumToFile(CusNumber);


    }
    public static void saveAccNumToFile(String accNumber) throws IOException {

        String TxnNum = accNumber ;
        System.out.println("Acc Number is: "+TxnNum);

        File file = new File(System.getProperty("user.dir") + "\\Data\\KYC_Amendment_Cust_IBG.xlsx");
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
            cell.setCellValue("Acc Number");
        }

        Sheet sheet = workbook.getSheetAt(0);
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue(TxnNum);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

    }

    @Test(groups = {"Authorizer"},dataProvider = "excelData")

    public void kyc_Amendment_Customer_Auth(Map<String, String> testData) throws IOException, InterruptedException {

//        PageObject.menu_Dropdown("Manager Operation Menu");
//        PageObject.menu_Dropdown("Core Retail Menu");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Authorization");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Authorization of KYC");
        PageObject.menu_Dropdown("Alfalah KYC Information Authorization");
        PageObject.menu_Dropdown("Authorization of Cusotmer KYC");
        PageObject.menu_Link("Authorization for Customer KYC- Branch Level ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",CusNumber);
        PageObject.find_Button();


        PageObject.form_Link("Authorise a KYC");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Authorises a deal");

        txn = PageObject.getTxn();
        System.out.println(txn);





    }

    @DataProvider(name = "excelDataKYC_Amendment_CustIBG")
    public Object[][] readExcelData1() throws IOException {

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
