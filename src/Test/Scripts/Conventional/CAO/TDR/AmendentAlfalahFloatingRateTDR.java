/*
package Test.Scripts.Conventional.CAO.TDR;

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
import java.util.HashMap;
import java.util.Map;

public class AmendentAlfalahFloatingRateTDR extends BaseClass {

    String Txn;

    @Test(groups = {"InputterTDR"})

    public void AmendentAlfalahFloatingRateTDR() throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Alfalah Floating Rate Term Deposits LCY");
        PageObject.menu_Link("Amendent Alfalah Floating Rate TDR ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.childmenu_Link("Amend Term Deposit",1);

        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD","TDRFRLCY1Z");

        PageObject.commitDeal("AmendentAlfalahFloatingRateTDR");



//        PageObject.authorizeByTxn(testData.get("Transaction Number"));





        Txn = PageObject.getTxn();
        System.out.println(Txn);

    }

    public static void saveAccNumToFile(String accNumber) throws IOException {

        String Txn = accNumber ;
        System.out.println("Acc Number is: "+Txn);

        File file = new File(System.getProperty("user.dir") + "\\Data\\AmendentAlfalahFloatingRateTDR.xlsx");
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
        cell.setCellValue(Txn);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

    }

//    String FILE_PATH2 = System.getProperty("user.dir") + "\\Data\\AmendentAlfalahFloatingRateTDR.xlsx";

    @Test(groups = {"AuthorizerTDR"})

    public void AmendentAlfalahFloatingRateTDRAuth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR");
        PageObject.menu_Dropdown("Alfalah Floating Rate TDR Authorizer");
        PageObject.menu_Link("Authorization- Alfalah Floating TDR Amendment ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);
        PageObject.find_Button();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Select Drilldown");

        PageObject.switchToChildWindow();
        PageObject.switchFrame(1);
//        PageObject.authorizeByTxn(testData.get("Transaction Number"));

        PageObject.img_Button("Authorises a deal");
    }


}
*/
