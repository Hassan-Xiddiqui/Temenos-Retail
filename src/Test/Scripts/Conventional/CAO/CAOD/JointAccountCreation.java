package Test.Scripts.Conventional.CAO.CAOD;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JointAccountCreation extends BaseClass {

        @Test(groups = {"CaoInputter"}, dataProvider = "inputterData")
    public void JointAccCreation_LCY_Current(Map<String, String> testData) {

        PageObject.menu_Dropdown("Conventional Account Open");//test
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Current Account  ");
        String homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:CUSTOMER",testData.get("Cid"));
        PageObject.textinput_Locator("fieldName:CATEGORY",testData.get("CategoryProduct"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",testData.get("Acc name"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",testData.get("Acc name2"));
        PageObject.textinput_Locator("fieldName:AOR",testData.get("SignOffData"));
        PageObject.textinput_Locator("fieldName:SBP.COMPANY",testData.get("sbpCompany"));
        PageObject.textinput_Locator("fieldName:SBP.SECTOR.ID",testData.get("sbpSector"));
        PageObject.textinput_Locator("fieldName:SBP.SSECTOR.ID",testData.get("sbpSubSector"));
        PageObject.textinput_Locator("fieldName:SBP.SEGMENT.ID",testData.get("sbpSegment"));
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",testData.get("Jholder"));
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",testData.get("RelationCode"));

//            PageObject.click_Locator("fieldName:SBP.SSEGMENT.ID");
//            PageObject.click_Locator("fieldName:SBP.CATEGORY.ID");
//            PageObject.click_Locator("fieldName:SBP.SCAT.ID");
//            PageObject.click_Locator("fieldName:OTHER.OFFICER:1");
//            PageObject.radiobutton_Locator("radio:tab1:CHARGES.EXEMPT",2);
//            PageObject.radiobutton_Locator("radio:tab1:CUST.TAX.EXEMPT",2);
//            PageObject.radiobutton_Locator("radio:tab1:CASH.TAX.EXEMPT",2);
//            PageObject.click_Locator("fieldName:ACCT.OPR.INST.2:1");
//            PageObject.click_Locator("fieldName:JOINT.NOTES:1:1");

//        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose"));
//        PageObject.textinput_Locator("",testData.get("Purpose"));
            PageObject.form_Tab("kyc Details");
        PageObject.textinput_Locator("fieldName:KYC.NO.TRANS",testData.get("ExpectedNumOfTxn"));//30
        PageObject.radiobutton_Locator("radio:tab2:UNSCLISTST",1);
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose"));
        PageObject.select_Locator("fieldName:KYC.ATO",testData.get("TurnoverA"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.RG",testData.get("TurnoverM"));
        PageObject.textinput_Locator("fieldName:NO.TRANS.DR",testData.get("debitTxnNum"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.DR",testData.get("TurnoverDebitMonth"));

//            PageObject.click_Locator("fieldName:EX.TOVER.DR.OTH");
//            PageObject.click_Locator("fieldName:ATOGTM");
//            PageObject.click_Locator("fieldName:EXP.MONTH.TOVER");
//            PageObject.radiobutton_Locator("radio:tab2:KYC.CO.ATO",1);
//            PageObject.click_Locator("fieldName:SFUNDOTH");
//            PageObject.radiobutton_Locator("radio:tab2:KYC.REASON.HIGH",1);
//            PageObject.radiobutton_Locator("radio:tab2:MON.TOVER.CRG",1);
//            PageObject.click_Locator("fieldName:MON.TOVER.CORP");
//            PageObject.select_Locator("fieldName:SOURCEFUNDS","");
//            PageObject.click_Locator("fieldName:TOT.FIN.AMT");

//            PageObject.form_Tab("Mandatee Info");
//
//            PageObject.select_Locator("radio:tab3:FATCA.MANDATE","");
//            PageObject.click_Locator("fieldName:MANDATEE.NAME:1");
//            PageObject.click_Locator("fieldName:KIN.ID.TYPE:1");
//            PageObject.click_Locator("fieldName:MANDATEE.NIC:1");
//            PageObject.click_Locator("fieldName:MAND.OCCUPATION:1");
//            PageObject.click_Locator("fieldName:MAND.RELATION:1");
//            PageObject.click_Locator("fieldName:INCOME.SOURCE:1");
//            PageObject.click_Locator("fieldName:MONTHLY.INCOME:1");
//            PageObject.click_Locator("fieldName:FATH.HUS.NAME:1");
//            PageObject.click_Locator("fieldName:CUS.NATN:1");
//            PageObject.click_Locator("fieldName:CUS.DOB:1");
//            PageObject.click_Locator("fieldName:CUS.BIRTH.PLACE:1");
//            PageObject.click_Locator("fieldName:MAN.VAL.DATE:1");
//            PageObject.click_Locator("fieldName:FAT.MANDT.ADDR:1");
//
//            PageObject.form_Tab("PREMIER.DEBITCARD");
//
//            PageObject.select_Locator("fieldName:BAF.PRM.IMD","");
//            PageObject.click_Locator("fieldName:BAF.PRM.CRDNAME");
//            PageObject.radiobutton_Locator("radio:tab4:BAF.PRM.FMEMBR",1);
//            PageObject.click_Locator("fieldName:BAF.PRM.PEN");
//            PageObject.click_Locator("fieldName:BAF.PRM.DATETME");

        //Txn:1008213906
        try {
            PageObject.commitDeal("CAO_JointAccCreation_LCYTxn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(groups={"CaoInputter2Auth"},dataProvider = "authData")
    public void authAccCreationLCY(Map<String, String> testData){
        //
        PageObject.menu_Dropdown("Conv Account Authorization ");
        PageObject.menu_Link("List Of Unauthorised A/Cs  ");
        String homePage = PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(0);
        PageObject.form_Tab("Authorization of Account");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("VER A @ID");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
        //
    }


    @Test(groups = {"CaoInputter"},dataProvider = "inputterData2")
    public void JointAccCreation_LCY_Saving(Map<String, String> testData) {
//
        PageObject.menu_Dropdown("Conventional Account Open");//test
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Account - PLS Saving  ");
        String homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:CUSTOMER",testData.get("Cid"));
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY",testData.get("CategoryProduct"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",testData.get("Acc name"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",testData.get("Acc name2"));
        PageObject.textinput_Locator("fieldName:AOR",testData.get("SignOffData"));
        PageObject.textinput_Locator("fieldName:SBP.COMPANY",testData.get("sbpCompany"));
        PageObject.textinput_Locator("fieldName:SBP.SECTOR.ID",testData.get("sbpSector"));
        PageObject.textinput_Locator("fieldName:SBP.SSECTOR.ID",testData.get("sbpSubSector"));
        PageObject.textinput_Locator("fieldName:SBP.SEGMENT.ID",testData.get("sbpSegment"));
        PageObject.click_Locator("fieldName:SBP.SSEGMENT.ID");
        PageObject.textinput_Locator("fieldName:SBP.SSEGMENT.ID",testData.get("sbpSubSector"));
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",testData.get("Jholder"));

//            PageObject.click_Locator("fieldName:SBP.SSEGMENT.ID");
//            PageObject.click_Locator("fieldName:SBP.CATEGORY.ID");
//            PageObject.click_Locator("fieldName:SBP.SCAT.ID");
//            PageObject.click_Locator("fieldName:OTHER.OFFICER:1");
//            PageObject.radiobutton_Locator("radio:mainTab:ZAKAT.EXEMPT",2);
//            PageObject.radiobutton_Locator("radio:mainTab:CHARGES.EXEMPT",2);
//            PageObject.radiobutton_Locator("radio:mainTab:CASH.TAX.EXEMPT",2);
//            PageObject.click_Locator("fieldName:ACCT.OPR.INST.2:1");
//            PageObject.click_Locator("fieldName:JOINT.NOTES:1:1");


        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",testData.get("RelationCode"));
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose"));
//        PageObject.textinput_Locator("",testData.get("Purpose"));


//        PageObject.radiobutton_Locator("radio:tab1:UNSCLISTST",1);
//        PageObject.click_Locator("fieldName:PURPOSE");
        PageObject.textinput_Locator("fieldName:KYC.NO.TRANS",testData.get("ExpectedNumOfTxn"));//30
        PageObject.radiobutton_Locator("radio:tab1:UNSCLISTST",Integer.parseInt(testData.get("AC Screen list")));
        PageObject.select_Locator("fieldName:KYC.ATO",testData.get("TurnoverA"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.RG",testData.get("TurnoverM"));
        PageObject.textinput_Locator("fieldName:NO.TRANS.DR",testData.get("debitTxnNum"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.DR",testData.get("TurnoverDebitMonth"));

//        PageObject.click_Locator("fieldName:EX.TOVER.DR.OTH");
//        PageObject.click_Locator("fieldName:ATOGTM");
//        PageObject.click_Locator("fieldName:EXP.MONTH.TOVER");
//        PageObject.radiobutton_Locator("radio:tab2:KYC.CO.ATO",1);
//        PageObject.click_Locator("fieldName:SFUNDOTH");
//        PageObject.radiobutton_Locator("radio:tab2:KYC.REASON.HIGH",1);
//        PageObject.radiobutton_Locator("radio:tab2:MON.TOVER.CRG",1);
//        PageObject.click_Locator("fieldName:MON.TOVER.CORP");
//        PageObject.select_Locator("fieldName:SOURCEFUNDS","");
//        PageObject.click_Locator("fieldName:TOT.FIN.AMT");


//        PageObject.form_Tab("Mandatee Info");
//
//        PageObject.select_Locator("radio:tab3:FATCA.MANDATE","");
//        PageObject.click_Locator("fieldName:MANDATEE.NAME:1");
//        PageObject.click_Locator("fieldName:KIN.ID.TYPE:1");
//        PageObject.click_Locator("fieldName:MANDATEE.NIC:1");
//        PageObject.click_Locator("fieldName:MAND.OCCUPATION:1");
//        PageObject.click_Locator("fieldName:MAND.RELATION:1");
//        PageObject.click_Locator("fieldName:INCOME.SOURCE:1");
//        PageObject.click_Locator("fieldName:MONTHLY.INCOME:1");
//        PageObject.click_Locator("fieldName:FATH.HUS.NAME:1");
//        PageObject.click_Locator("fieldName:CUS.NATN:1");
//        PageObject.click_Locator("fieldName:CUS.DOB:1");
//        PageObject.click_Locator("fieldName:CUS.BIRTH.PLACE:1");
//        PageObject.click_Locator("fieldName:MAN.VAL.DATE:1");
//        PageObject.click_Locator("fieldName:FAT.MANDT.ADDR:1");
//
//        PageObject.form_Tab("PREMIER.DEBITCARD");
//
//        PageObject.select_Locator("fieldName:BAF.PRM.IMD","");
//        PageObject.click_Locator("fieldName:BAF.PRM.CRDNAME");
//        PageObject.radiobutton_Locator("radio:tab4:BAF.PRM.FMEMBR",1);
//        PageObject.click_Locator("fieldName:BAF.PRM.PEN");
//        PageObject.click_Locator("fieldName:BAF.PRM.DATETME");
        //Txn:1008213906
        try {
            PageObject.commitDeal("CAO_JointAccCreation_LCY_SavingAccountTxn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test(groups={"CaoInputter2Auth"},dataProvider = "authData2")
    public void authAccCreationLCY_Saving(Map<String, String> testData){
        //
        PageObject.menu_Dropdown("Conv Account Authorization ");
        PageObject.menu_Link("List Of Unauthorised A/Cs  ");
        String homePage = PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(0);
        PageObject.form_Tab("Authorization of Account");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("VER A @ID");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
        //
    }

    @Test(groups = {"CaoInputter"},dataProvider = "inputterData3")
    public void JointAccCreation_FCY_Current(Map<String, String> testData) throws IOException  {
//
        PageObject.menu_Dropdown("Conventional Account Open");//test
        PageObject.menu_Dropdown("Foriegn Currency Account Open");
        driver.findElement(By.xpath("(//*[text()='Current Account  '])[2]")).click();
        String homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:CUSTOMER",testData.get("Cid"));
        PageObject.textinput_Locator("fieldName:CURRENCY",testData.get("Currency"));
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY",testData.get("CategoryProduct"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",testData.get("Acc name"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",testData.get("Acc name2"));
        PageObject.textinput_Locator("fieldName:AOR",testData.get("SignOffData"));
        PageObject.radiobutton_Locator("radio:tab1:BIO.VERISYS",Integer.parseInt(testData.get("BioVersion")));
        PageObject.textinput_Locator("fieldName:SBP.COMPANY",testData.get("sbpCompany"));
        PageObject.textinput_Locator("fieldName:SBP.SECTOR.ID",testData.get("sbpSector"));
        PageObject.textinput_Locator("fieldName:SBP.SSECTOR.ID",testData.get("sbpSubSector"));
        PageObject.textinput_Locator("fieldName:SBP.SEGMENT.ID",testData.get("sbpSegment"));
        //PageObject.textinput_Locator("fieldName:SBP.SSEGMENT.ID",testData.get("sbpSubSegment"));
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",testData.get("Jholder"));
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",testData.get("RelationCode"));

//        PageObject.click_Locator("fieldName:SBP.SSEGMENT.ID");
//        PageObject.click_Locator("fieldName:SBP.CATEGORY.ID");
//        PageObject.click_Locator("fieldName:SBP.SCAT.ID");
//        PageObject.click_Locator("fieldName:OTHER.OFFICER:1");
//        PageObject.radiobutton_Locator("radio:tab1:CHARGES.EXEMPT",2);
//        PageObject.radiobutton_Locator("radio:tab1:CUST.TAX.EXEMPT",2);
//        PageObject.radiobutton_Locator("radio:tab1:BS.ONLINE",2);
//        PageObject.select_Locator("fieldName:AUTH.SIG.FUND.P","");
//        PageObject.click_Locator("fieldName:ACC.OTH.FLAG:1");
//        PageObject.click_Locator("fieldName:JOINT.NOTES:1:1");
//        PageObject.click_Locator("\"fieldName:CUSTOMER\"");

        PageObject.form_Tab("kyc Details");
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose"));
//        PageObject.textinput_Locator("",testData.get("Purpose"));
        PageObject.textinput_Locator("fieldName:KYC.NO.TRANS",testData.get("ExpectedNumOfTxn"));//30
        PageObject.radiobutton_Locator("radio:tab2:UNSCLISTST",Integer.parseInt(testData.get("AC Screen list")));
        PageObject.select_Locator("fieldName:KYC.ATO",testData.get("TurnoverA"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.RG",testData.get("TurnoverM"));
        PageObject.textinput_Locator("fieldName:NO.TRANS.DR",testData.get("debitTxnNum"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.DR",testData.get("TurnoverDebitMonth"));

        PageObject.click_Locator("fieldName:EX.TOVER.DR.OTH");
        PageObject.click_Locator("fieldName:ATOGTM");
        PageObject.click_Locator("fieldName:EXP.MONTH.TOVER");
        PageObject.radiobutton_Locator("radio:tab2:KYC.CO.ATO",1);
        PageObject.click_Locator("fieldName:SFUNDOTH");
        PageObject.radiobutton_Locator("radio:tab2:KYC.REASON.HIGH",1);
        PageObject.radiobutton_Locator("radio:tab2:MON.TOVER.CRG",1);
        PageObject.click_Locator("fieldName:MON.TOVER.CORP");
        PageObject.select_Locator("fieldName:SOURCEFUNDS","");
        PageObject.click_Locator("fieldName:TOT.FIN.AMT");


//        PageObject.form_Tab("Mandatee Info");
//
//        PageObject.radiobutton_Locator("radio:tab3:FATCA.MANDATE",1);
//        PageObject.click_Locator("fieldName:MANDATEE.NAME:1");
//        PageObject.click_Locator("fieldName:KIN.ID.TYPE:1");
//        PageObject.click_Locator("fieldName:MANDATEE.NIC:1");
//        PageObject.click_Locator("fieldName:MAND.OCCUPATION:1");
//        PageObject.click_Locator("fieldName:MAND.RELATION:1");
//        PageObject.click_Locator("fieldName:INCOME.SOURCE:1");
//        PageObject.click_Locator("fieldName:MONTHLY.INCOME:1");
//        PageObject.click_Locator("fieldName:FATH.HUS.NAME:1");
//        PageObject.click_Locator("fieldName:CUS.NATN:1");
//        PageObject.click_Locator("fieldName:CUS.DOB:1");
//        PageObject.click_Locator("fieldName:CUS.BIRTH.PLACE:1");
//        PageObject.click_Locator("fieldName:MAN.VAL.DATE:1");
//        PageObject.click_Locator("fieldName:FAT.MANDT.ADDR:1");
//
//        PageObject.form_Tab("Clean Marking");
//
//        PageObject.click_Locator("fieldName:POSTING.RESTRICT:1");
//        PageObject.click_Locator("fieldName:REASON");
//        PageObject.select_Locator("fieldName:NO.CHQ.ISSUED","");

        PageObject.commitDeal("CAO_JointAccCreation_FCY_CurrentAccountTxn");
        //Txn:
//        try {
//            PageObject.commitDeal("CAO_JointAccCreation_FCY_CurrentAccountTxn");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }


    @Test(groups={"CaoAuthorizer1"},dataProvider = "authData3")
        public void authAccCreationFCY_Current(Map<String, String> testData){
        //
        PageObject.menu_Dropdown("Conv Account Authorization ");
        PageObject.menu_Link("List Of Unauthorised A/Cs  ");
        String homePage = PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(0);
        PageObject.form_Tab("Authorization of Account");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("VER A @ID");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
        //
    }

    @Test(groups = {"CaoInputter"},dataProvider = "inputterData4")
    public void JointAccCreation_FCY_Saving(Map<String, String> testData){

        PageObject.menu_Dropdown("Conventional Account Open");
        PageObject.menu_Dropdown("Foriegn Currency Account Open");
        PageObject.childmenu_Link("Saving Account  ",1);
//        driver.findElement(By.xpath("(//*[text()='Saving Account  ']'])[1]")).click();
        String homePage = PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.textinput_Locator("fieldName:CUSTOMER",testData.get("Cid"));
        PageObject.textinput_Locator("fieldName:CURRENCY",testData.get("Currency"));
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY",testData.get("CategoryProduct"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",testData.get("Acc name"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",testData.get("Acc name2"));
        PageObject.textinput_Locator("fieldName:AOR",testData.get("SignOffData"));
        PageObject.radiobutton_Locator("radio:tab1:BIO.VERISYS",Integer.parseInt(testData.get("BioVersion")));
        PageObject.textinput_Locator("fieldName:SBP.COMPANY",testData.get("sbpCompany"));
        PageObject.textinput_Locator("fieldName:SBP.SECTOR.ID",testData.get("sbpSector"));
        PageObject.textinput_Locator("fieldName:SBP.SSECTOR.ID",testData.get("sbpSubSector"));
        PageObject.textinput_Locator("fieldName:SBP.SEGMENT.ID",testData.get("sbpSegment"));
        //PageObject.textinput_Locator("fieldName:SBP.SSEGMENT.ID",testData.get("sbpSubSegment"));
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",testData.get("Jholder"));
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",testData.get("RelationCode"));

//        PageObject.click_Locator("fieldName:SBP.SSEGMENT.ID");
//        PageObject.click_Locator("fieldName:SBP.CATEGORY.ID");
//        PageObject.click_Locator("fieldName:SBP.SCAT.ID");
//        PageObject.click_Locator("fieldName:OTHER.OFFICER:1");
//        PageObject.radiobutton_Locator("radio:tab1:CHARGES.EXEMPT",2);
//        PageObject.radiobutton_Locator("radio:tab1:CUST.TAX.EXEMPT",2);
//        PageObject.radiobutton_Locator("radio:tab1:BS.ONLINE",2);
//        PageObject.select_Locator("fieldName:AUTH.SIG.FUND.P","");
//        PageObject.click_Locator("fieldName:ACC.OTH.FLAG:1");
//        PageObject.click_Locator("fieldName:JOINT.NOTES:1:1");


        PageObject.form_Tab("kyc Details");
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose"));
//        PageObject.textinput_Locator("",testData.get("Purpose"));
        PageObject.textinput_Locator("fieldName:KYC.NO.TRANS",testData.get("ExpectedNumOfTxn"));//30
        PageObject.radiobutton_Locator("radio:tab2:UNSCLISTST",Integer.parseInt(testData.get("AC Screen list")));
        PageObject.select_Locator("fieldName:KYC.ATO",testData.get("TurnoverA"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.RG",testData.get("TurnoverM"));
        PageObject.textinput_Locator("fieldName:NO.TRANS.DR",testData.get("debitTxnNum"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.DR",testData.get("TurnoverDebitMonth"));

//        PageObject.form_Tab("Mandatee Info");
//
//        PageObject.radiobutton_Locator("radio:tab3:FATCA.MANDATE",1);
//        PageObject.click_Locator("fieldName:MANDATEE.NAME:1");
//        PageObject.click_Locator("fieldName:KIN.ID.TYPE:1");
//        PageObject.click_Locator("fieldName:MANDATEE.NIC:1");
//        PageObject.click_Locator("fieldName:MAND.OCCUPATION:1");
//        PageObject.click_Locator("fieldName:MAND.RELATION:1");
//        PageObject.click_Locator("fieldName:INCOME.SOURCE:1");
//        PageObject.click_Locator("fieldName:MONTHLY.INCOME:1");
//        PageObject.click_Locator("fieldName:FATH.HUS.NAME:1");
//        PageObject.click_Locator("fieldName:CUS.NATN:1");
//        PageObject.click_Locator("fieldName:CUS.DOB:1");
//        PageObject.click_Locator("fieldName:CUS.BIRTH.PLACE:1");
//        PageObject.click_Locator("fieldName:MAN.VAL.DATE:1");
//        PageObject.click_Locator("fieldName:FAT.MANDT.ADDR:1");
//
//        PageObject.form_Tab("Clean Marking");
//
//        PageObject.click_Locator("fieldName:POSTING.RESTRICT:1");
//        PageObject.click_Locator("fieldName:REASON");
//        PageObject.select_Locator("fieldName:NO.CHQ.ISSUED","");

        try {
            PageObject.commitDeal("JointAccCreation_FCY_Saving");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test(groups={"CaoInputter"},dataProvider = "LCCurrentAccAmendmentData")
    public void LCCurrentAccAmendment(Map<String, String> testData) throws IOException {

        PageObject.menu_Dropdown("Conventional Account Open");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Current Account  ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("Return to application screen");
        driver.switchTo().alert().accept();
        PageObject.textinput_Locator("transactionId",testData.get("ID"));
        PageObject.img_Button("Edit a contract");

//        PageObject.click_Locator("fieldName:CUSTOMER");
//        PageObject.click_Locator("fieldName:CATEGORY");
//            PageObject.click_Locator("fieldName:ACCOUNT.TITLE.1:1");
//                PageObject.click_Locator("fieldName:ACCOUNT.TITLE.2:1");
//        PageObject.click_Locator("fieldName:AOR");
//            PageObject.click_Locator("fieldName:SBP.COMPANY");
//        PageObject.click_Locator("fieldName:SBP.SECTOR.ID");
//        PageObject.click_Locator("fieldName:SBP.SSECTOR.ID");
//        PageObject.click_Locator("fieldName:SBP.SEGMENT.ID");
//        PageObject.click_Locator("fieldName:SBP.SSEGMENT.ID");
//        PageObject.click_Locator("fieldName:SBP.CATEGORY.ID");
//        PageObject.click_Locator("fieldName:SBP.SCAT.ID");
//        PageObject.click_Locator("fieldName:ACCOUNT.OFFICER");
//        PageObject.click_Locator("fieldName:OTHER.OFFICER:1");
//        PageObject.radiobutton_Locator("radio:mainTab:ZAKAT.EXEMPT",1);
//        PageObject.select_Locator("fieldName:FIQAH","");
//        PageObject.radiobutton_Locator("radio:mainTab:CHARGES.EXEMPT",2);
//        PageObject.radiobutton_Locator("radio:mainTab:CASH.TAX.EXEMPT",2);
//        PageObject.click_Locator("fieldName:ACCT.OPR.INST.2:1");
//        PageObject.radiobutton_Locator("radio:mainTab:BS.ONLINE",1);
//        PageObject.radiobutton_Locator("radio:mainTab:NTN.FILER",1);
//        PageObject.radiobutton_Locator("radio:mainTab:BAF.ONL.WAIVE",3);
//        PageObject.click_Locator("fieldName:JOINT.HOLDER:1");
//        PageObject.click_Locator("fieldName:RELATION.CODE:1");
//        PageObject.click_Locator("fieldName:JOINT.NOTES:1:1");

        PageObject.form_Tab("kyc Details");
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose of Bank Account"));
//        PageObject.click_Locator("fieldName:PURPOSE");
//            PageObject.click_Locator("fieldName:KYC.NO.TRANS");
//        PageObject.click_Locator("fieldName:NO.TRANS.DR");
//        PageObject.select_Locator("fieldName:MONTH.TOVER.DR","Below 1M");
//        PageObject.click_Locator("fieldName:EX.TOVER.DR.OTH");
//
//        PageObject.select_Locator("fieldName:KYC.ATO","");
//        PageObject.click_Locator("fieldName:ATOGTM");
//        PageObject.click_Locator("fieldName:MONTH.TOVER.RG");
//        PageObject.click_Locator("fieldName:EXP.MONTH.TOVER");
//
//        PageObject.radiobutton_Locator("radio:tab1:KYC.CO.ATO",1);
//        PageObject.click_Locator("fieldName:SFUNDOTH");
//        PageObject.radiobutton_Locator("radio:tab1:KYC.REASON.HIGH",1);
//        PageObject.radiobutton_Locator("radio:tab1:MON.TOVER.CRG",1);
//        PageObject.click_Locator("fieldName:MON.TOVER.CORP");
//        PageObject.click_Locator("fieldName:SOURCEFUNDS");
//        PageObject.click_Locator("fieldName:TOT.FIN.AMT");
//
//        PageObject.form_Tab("Mandatee Info");
//
//        PageObject.radiobutton_Locator("radio:tab2:FATCA.MANDATE",1);
//        PageObject.click_Locator("fieldName:MANDATEE.NAME:1");
//        PageObject.click_Locator("fieldName:KIN.ID.TYPE:1");
//        PageObject.click_Locator("fieldName:MANDATEE.NIC:1");
//        PageObject.click_Locator("fieldName:MAND.OCCUPATION:1");
//        PageObject.click_Locator("fieldName:MAND.RELATION:1");
//        PageObject.click_Locator("fieldName:INCOME.SOURCE:1");
//        PageObject.click_Locator("fieldName:MONTHLY.INCOME:1");
//        PageObject.click_Locator("fieldName:FATH.HUS.NAME:1");
//        PageObject.click_Locator("fieldName:CUS.NATN:1");
//        PageObject.click_Locator("fieldName:CUS.DOB:1");
//        PageObject.click_Locator("fieldName:CUS.BIRTH.PLACE:1");
//        PageObject.click_Locator("fieldName:MAN.VAL.DATE:1");
//        PageObject.click_Locator("fieldName:FAT.MANDT.ADDR:1");
//
//        PageObject.form_Tab("PREMIER.DEBITCARD");
//
//        PageObject.select_Locator("fieldName:BAF.PRM.IMD","");
//        PageObject.click_Locator("fieldName:BAF.PRM.CRDNAME");
//        PageObject.radiobutton_Locator("radio:tab3:BAF.PRM.FMEMBR",1);
//        PageObject.click_Locator("fieldName:BAF.PRM.PEN");
//        PageObject.click_Locator("fieldName:BAF.PRM.DATETME");
//
        PageObject.commitDeal("LCCurrentAccAmendmentTxn");

    }

    @Test(groups={"CaoInputter"},dataProvider = "LCSavingAccAmendmentData")
        public void LCSavingAccAmendment(Map<String, String> testData) throws IOException {
//1008617134
        PageObject.menu_Dropdown("Conventional Account Open");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Saving Account - Royal Profit  ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("Return to application screen");
        driver.switchTo().alert().accept();
        PageObject.textinput_Locator("transactionId",testData.get("ID"));
        PageObject.img_Button("Edit a contract");
//        PageObject.click_Locator("fieldName:CUSTOMER");
//        PageObject.click_Locator("fieldName:ACCOUNT.TITLE.1:1");
//        PageObject.click_Locator("fieldName:ACCOUNT.TITLE.2:1");
//        PageObject.click_Locator("fieldName:AOR");
//        PageObject.click_Locator("fieldName:SBP.COMPANY");
//        PageObject.click_Locator("fieldName:SBP.SECTOR.ID");
//        PageObject.click_Locator("fieldName:SBP.SSECTOR.ID");
//        PageObject.click_Locator("fieldName:SBP.SEGMENT.ID");
//        PageObject.click_Locator("fieldName:SBP.SSEGMENT.ID");
//        PageObject.click_Locator("fieldName:SBP.CATEGORY.ID");
//        PageObject.click_Locator("fieldName:SBP.SCAT.ID");
//        PageObject.click_Locator("fieldName:ACCOUNT.OFFICER");
//        PageObject.click_Locator("fieldName:OTHER.OFFICER:1");
//        PageObject.radiobutton_Locator("radio:mainTab:ZAKAT.EXEMPT",1);
//        PageObject.select_Locator("fieldName:FIQAH","");
//        PageObject.radiobutton_Locator("radio:mainTab:CHARGES.EXEMPT",2);
//        PageObject.radiobutton_Locator("radio:mainTab:CASH.TAX.EXEMPT",2);
//        PageObject.click_Locator("fieldName:ACCT.OPR.INST.2:1");
//        PageObject.radiobutton_Locator("radio:mainTab:BS.ONLINE",1);
//        PageObject.radiobutton_Locator("radio:mainTab:NTN.FILER",1);
//        PageObject.radiobutton_Locator("radio:mainTab:BAF.ONL.WAIVE",3);
//        PageObject.click_Locator("fieldName:JOINT.HOLDER:1");
//        PageObject.click_Locator("fieldName:RELATION.CODE:1");
//        PageObject.click_Locator("fieldName:JOINT.NOTES:1:1");

        PageObject.form_Tab("kyc Details");
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose of Bank Account"));
//        PageObject.click_Locator("fieldName:PURPOSE");
//        PageObject.click_Locator("fieldName:KYC.NO.TRANS");
//        PageObject.click_Locator("fieldName:NO.TRANS.DR");
//        PageObject.select_Locator("fieldName:MONTH.TOVER.DR","Below 1M");
//        PageObject.click_Locator("fieldName:EX.TOVER.DR.OTH");
//
//        PageObject.select_Locator("fieldName:KYC.ATO","");
//        PageObject.click_Locator("fieldName:ATOGTM");
//        PageObject.click_Locator("fieldName:MONTH.TOVER.RG");
//        PageObject.click_Locator("fieldName:EXP.MONTH.TOVER");
//
//        PageObject.radiobutton_Locator("radio:tab1:KYC.CO.ATO",1);
//        PageObject.click_Locator("fieldName:SFUNDOTH");
//        PageObject.radiobutton_Locator("radio:tab1:KYC.REASON.HIGH",1);
//        PageObject.radiobutton_Locator("radio:tab1:MON.TOVER.CRG",1);
//        PageObject.click_Locator("fieldName:MON.TOVER.CORP");
//        PageObject.click_Locator("fieldName:SOURCEFUNDS");
//        PageObject.click_Locator("fieldName:TOT.FIN.AMT");
//
//        PageObject.form_Tab("Mandatee Info");
//
//        PageObject.radiobutton_Locator("radio:tab2:FATCA.MANDATE",1);
//        PageObject.click_Locator("fieldName:MANDATEE.NAME:1");
//        PageObject.click_Locator("fieldName:KIN.ID.TYPE:1");
//        PageObject.click_Locator("fieldName:MANDATEE.NIC:1");
//        PageObject.click_Locator("fieldName:MAND.OCCUPATION:1");
//        PageObject.click_Locator("fieldName:MAND.RELATION:1");
//        PageObject.click_Locator("fieldName:INCOME.SOURCE:1");
//        PageObject.click_Locator("fieldName:MONTHLY.INCOME:1");
//        PageObject.click_Locator("fieldName:FATH.HUS.NAME:1");
//        PageObject.click_Locator("fieldName:CUS.NATN:1");
//        PageObject.click_Locator("fieldName:CUS.DOB:1");
//        PageObject.click_Locator("fieldName:CUS.BIRTH.PLACE:1");
//        PageObject.click_Locator("fieldName:MAN.VAL.DATE:1");
//        PageObject.click_Locator("fieldName:FAT.MANDT.ADDR:1");
//
//        PageObject.form_Tab("PREMIER.DEBITCARD");
//
//        PageObject.select_Locator("fieldName:BAF.PRM.IMD","");
//        PageObject.click_Locator("fieldName:BAF.PRM.CRDNAME");
//        PageObject.radiobutton_Locator("radio:tab3:BAF.PRM.FMEMBR",1);
//        PageObject.click_Locator("fieldName:BAF.PRM.PEN");
//        PageObject.click_Locator("fieldName:BAF.PRM.DATETME");

        PageObject.commitDeal("LCSavingAccAmendmentTxn");

    }



    @DataProvider(name = "LCCurrentAccAmendmentData")
    public Object[][] LCCurrentAccAmendment() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("LCCurrentInputter"); // Assuming data is in the first sheet
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

    @DataProvider(name = "LCSavingAccAmendmentData")
    public Object[][] LCSavingAccAmendment() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("LCSavingAccountInputter"); // Assuming data is in the first sheet
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

    @DataProvider(name = "inputterData")
    public Object[][]   JointAccCreation_LCYData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
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

    @DataProvider(name = "inputterData2")
    public Object[][] JointAccCreation_LCYData_Saving() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(1); // Assuming data is in the first sheet
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

    @DataProvider(name = "inputterData3")
    public Object[][] JointAccCreation_FCYData_Current() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(2); // Assuming data is in the first sheet
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



    @DataProvider(name = "inputterData4")
    public Object[][] JointAccCreation_FCYData_Saving() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(3); // Assuming data is in the first sheet
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

    @DataProvider(name = "authData")
    public Object[][] AuthData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CAO_JointAccCreation_LCYTxn.xlsx";
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

    @DataProvider(name = "authData2")
    public Object[][] AuthData2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CAO_JointAccCreation_LCY_SavingAccountTxn.xlsx";
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

    @DataProvider(name = "authData3")
    public Object[][] AuthData3() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CAO_JointAccCreation_FCY_CurrentAccountTxn.xlsx";
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
