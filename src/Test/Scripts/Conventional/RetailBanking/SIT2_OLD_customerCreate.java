
package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class SIT2_OLD_customerCreate extends BaseClass {

    public static String Txn;
    public static String Txn2;

    @Test (groups = {"Inputter"})
    public void individualCustomer() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        //driver.findElement(By.xpath("(//ul/li/span/img[@alt='Alfalah Customer Information'])[2]")).click();
        PageObject.menu_Link("Individual/Sole/Proprietorship/Minor ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:SECTOR","1000");
        PageObject.select_Locator("fieldName:CUST.SEGMENT","MASS");
        PageObject.radiobutton_Locator("radio:mainTab:SME.TYPE",1);
        PageObject.textinput_Locator("fieldName:ID.TYPE:1","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER:1","42344078" + PageObject.idNumber());
        PageObject.click_Locator("fieldName:ID.VAL.DT:1");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT:1","07 AUG 2041");
        PageObject.textinput_Locator("fieldName:NAME.1:1","CUSTOMER01");
        PageObject.textinput_Locator("fieldName:NAME.2:1","CUSTOMER01");
        PageObject.textinput_Locator("fieldName:SOLE.NAME","CUSTOMER01");
        PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM","FATHER01");
        PageObject.select_Locator("fieldName:A.ADDRESS.TYPE","OFFICE");
        PageObject.textarea_Locator("fieldName:ADD.H","address");
        PageObject.textinput_Locator("fieldName:STREET:1","KARACHI");
        PageObject.textinput_Locator("fieldName:TOWN.COUNTRY:1","KARACHI PARKISTAN");
        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT","60000000000");
        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY","60000000800");
        PageObject.textinput_Locator("fieldName:TARGET","64");
        PageObject.textinput_Locator("fieldName:NATIONALITY","PK");
        PageObject.textinput_Locator("fieldName:RESIDENCE","PK");
        PageObject.textinput_Locator("fieldName:DATE.OF.BIRT.LC","25 JUL 1998");
        PageObject.textinput_Locator("fieldName:BIRTH.INCORP.DATE","");
        PageObject.select_Locator("fieldName:ASAN.ACCOUNT","");
        PageObject.select_Locator("fieldName:BAF.PREM.CUST","");
        PageObject.select_Locator("fieldName:BAF.PRM.THRSHLD","");
        PageObject.select_Locator("fieldName:IBG.PREM.CUST","");
        PageObject.select_Locator("fieldName:IBG.PRM.THRSHLD","");
        PageObject.textinput_Locator("fieldName:VISA.NO","");
        PageObject.textinput_Locator("fieldName:EXP.DATE","");
        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);

        // CRP
        PageObject.textinput_Locator("fieldName:CRP.TYPE","1");
        PageObject.textinput_Locator("fieldName:INCM.LEVELSRC","102");
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1","1001");
        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1","9");
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1","PK");
        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1","1");
        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:1","402");
        PageObject.select_Locator("fieldName:SEDING.FACTS:1","Not Applicable");
        PageObject.textarea_Locator("fieldName:FURTHER.DETAILS","further details....");

        // CP
        PageObject.form_Tab("Contact Person");
        PageObject.textinput_Locator("fieldName:CP.NAME:1","MUHAMMAD");
        PageObject.textinput_Locator("fieldName:CP.ADD:1","ADDRESSS");
        PageObject.textinput_Locator("fieldName:CP.ADD2:1","ADDRESS222");
        PageObject.textinput_Locator("fieldName:CP.PH.OFF:1","033576768686");
        PageObject.textinput_Locator("fieldName:CP.FAX.NO:1","76868");
        PageObject.textinput_Locator("fieldName:CP.CELL.NO:1","033565767");
        PageObject.textinput_Locator("fieldName:CP.PH.RES:1","HOUSE NO 1 C");
        PageObject.textinput_Locator("fieldName:CP.EMAIL:1","SDVGDJAS@GMAIL.COM");

        PageObject.commitDeal("Customers");
        Txn = PageObject.getTxn();

    }


    @Test  (groups = {"Inputter"})
    public void corporateCustomer() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        PageObject.menu_Link("Corporate Customers ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:SECTOR","1110");
        PageObject.select_Locator("fieldName:CUST.SEGMENT","");
        PageObject.radiobutton_Locator("radio:mainTab:SME.TYPE",1);
        PageObject.textinput_Locator("fieldName:ID.TYPE:1","ID-R");
        PageObject.textinput_Locator("fieldName:ID.NUMBER:1","42309978" + PageObject.idNumber());
        PageObject.click_Locator("fieldName:ID.VAL.DT:1");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT:1","07 AUG 2041");
        PageObject.textinput_Locator("fieldName:NAME.1:1","CUSTOMER01");
        PageObject.textinput_Locator("fieldName:NAME.2:1","CUSTOMER01");
//        PageObject.textinput_Locator("fieldName:SOLE.NAME","CUSTOMER01");
//        PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM","FATHER01");
        PageObject.select_Locator("fieldName:A.ADDRESS.TYPE","OFFICE");
        PageObject.textarea_Locator("fieldName:ADD.H","");
        PageObject.textinput_Locator("fieldName:STREET:1","KARACHI");
        PageObject.textinput_Locator("fieldName:TOWN.COUNTRY:1","KARACHI PARKISTAN");
        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT","42282000000");
        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY","42282000000");
        PageObject.textinput_Locator("fieldName:TARGET","9");
        PageObject.textinput_Locator("fieldName:NATIONALITY","PK");
        PageObject.textinput_Locator("fieldName:RESIDENCE","PK");
        PageObject.textinput_Locator("fieldName:BIRTH.INCORP.DATE","25 JUL 1998");
        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);

        // CRP
        PageObject.textinput_Locator("fieldName:CRP.TYPE","11");
        PageObject.textinput_Locator("fieldName:INCM.LEVELSRC","124");
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1","6003");
        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1","9");
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1","PK");
        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1","1");
        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:1","432");
        PageObject.select_Locator("fieldName:SEDING.FACTS:1","Not Applicable");
        PageObject.textarea_Locator("fieldName:FURTHER.DETAILS","");

        // CP
        PageObject.form_Tab("Contact Person");
        PageObject.textinput_Locator("fieldName:CP.NAME:1","MUHAMMAD");
        PageObject.textinput_Locator("fieldName:CP.ADD:1","ADDRESSS");
        PageObject.textinput_Locator("fieldName:CP.ADD2:1","ADDRESS222");
        PageObject.textinput_Locator("fieldName:CP.PH.OFF:1","033576768686");
        PageObject.textinput_Locator("fieldName:CP.FAX.NO:1","76868");
        PageObject.textinput_Locator("fieldName:CP.CELL.NO:1","033565767");
        PageObject.textinput_Locator("fieldName:CP.PH.RES:1","HOUSE NO 1 C");
        PageObject.textinput_Locator("fieldName:CP.EMAIL:1","SDVGDJAS@GMAIL.COM");

        // PARTNER
        PageObject.form_Tab("Director/Partner/Trustees/Office Bearer");
        PageObject.textinput_Locator("fieldName:NAME:1","ASIF");
        PageObject.textinput_Locator("fieldName:P.ID.TYPE:1","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NO:1","47893978" + PageObject.idNumber());
        PageObject.textinput_Locator("fieldName:FATER.HUSBAND:1","UMER");
        PageObject.textinput_Locator("fieldName:RES.ADD:1","ADDRESSS");
        PageObject.textinput_Locator("fieldName:P.PHNO.OFF:1","033788689787");
        PageObject.textinput_Locator("fieldName:CELLULAR.NO:1","033878797907");
        PageObject.textinput_Locator("fieldName:PH.NO.RES:1","HOUSE NO 29C");
        PageObject.textinput_Locator("fieldName:P.ID.VALIDITY:1","07 AUG 2041");
        PageObject.textinput_Locator("fieldName:CUS.NATN:1","PK");
        PageObject.textinput_Locator("fieldName:CUS.DOB:1","25 JUL 1998");
        PageObject.textinput_Locator("fieldName:CUS.BIRTH.PLACE:1","KARACHI");
       /* PageObject.textinput_Locator("fieldName:P.CITY:1","");
        PageObject.textinput_Locator("fieldName:P.PROVINCE:1","");
        PageObject.textinput_Locator("fieldName:P.CUST.GENDER:1","");
*/
        PageObject.commitDeal("Customers");
        Txn2 = PageObject.getTxn();


    }
    @Test  (groups = {"Authorizer"})
    public void customerAuthorization() throws InterruptedException, IOException {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Authorization");
        PageObject.menu_Dropdown("Authorization of CIF & ACCOUNT");
        PageObject.menu_Dropdown("Authorization of Customer");
        PageObject.menu_Link("Authorization of CIF- Branch Level ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("value:1:1:1",Txn);
        Thread.sleep(5000);
        PageObject.click_Locator("defaultButton");
        Thread.sleep(5000);
        PageObject.form_Link("Authorise a Customer");
        Thread.sleep(5000);
        PageObject.authorizeDeal();

//        PageObject.commitDeal("Customers");
    }

    @Test  (groups = {"Authorizer"})
    public void customerAuthorization2() throws InterruptedException, IOException {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Authorization");
        PageObject.menu_Dropdown("Authorization of CIF & ACCOUNT");
        PageObject.menu_Dropdown("Authorization of Customer");
        PageObject.menu_Link("Authorization of CIF- Branch Level ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("value:1:1:1",Txn2);
        Thread.sleep(5000);
        PageObject.click_Locator("defaultButton");
        Thread.sleep(5000);
        PageObject.form_Link("Authorise a Customer");
        Thread.sleep(5000);
        PageObject.authorizeDeal();

//        PageObject.commitDeal("Customers");
    }

}
