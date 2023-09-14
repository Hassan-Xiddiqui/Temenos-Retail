package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static Test.Scripts.IBG.RetailBanking.Customers.commitDeal;

public class kycOfAccount extends BaseClass {

    String ibgHomePage;
    String menu1;

    @Test(groups = {"caoInputter"}, dataProvider = "TestData")
    public void KYC(Map<String, String> column) throws InterruptedException, IOException {

        PageObject.switchFrame(1);

//        PageObject.main_menu("Tools");
        PageObject.menu_Dropdown("My Companies");
        PageObject.menu_Link("BANK ALFALAH LTD - IBG ");

        ibgHomePage = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.menu_Dropdown("Assign Branches ");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId", column.get("CAOUSER.002"));
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:ASSIGN.BRANCH:1", column.get("1556111040"));
        commitDeal();
        driver.close();

        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Define Current Branch ");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId", column.get("CAOUSER.002"));
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:ASSIGN.BRANCH:1", column.get("1556111040"));
        commitDeal();
        driver.close();

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CENTRALIZED ACCOUNT PROCESSOR");
        PageObject.menu_Dropdown("CORE/RETAIL MAIN MENU");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("ACCOUNT");
        PageObject.menu_Dropdown("Amendment Account ");
        PageObject.menu_Link("Amendment Account ");

//        menu1 = PageObject.switchToChildWindow();
//        PageObject.maximizeWindow();
//
//        PageObject.textinput_Locator("value:1:1:1",column.get("Customer_ID"));
//        PageObject.click_Locator("defaultButton");
//
//        PageObject.form_Link("Amend Indivial/Sole/Minor Customer");
//
//        // CRP Details
//        PageObject.form_Tab("Customer's Risk Profiling Details");
//
//        PageObject.imgchild_Button("Expand Sub Value" , 2);
//        PageObject.textinput_Locator("fieldName:CUS.CATEG:2","1001");
//        PageObject.imgchild_Button("Expand Sub Value" , 4);
//        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:2","9");
//        PageObject.imgchild_Button("Expand Sub Value" , 6);
//        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:2","PK");
//        PageObject.imgchild_Button("Expand Sub Value" , 8);
//        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:2","1");
//        PageObject.imgchild_Button("Expand Sub Value" , 10);
//        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:2","402");
//        PageObject.imgchild_Button("Expand Sub Value" , 12);
//        PageObject.select_Locator("fieldName:SEDING.FACTS:2","Not Applicable");
//
//        commitDeal();
//
//        PageObject.select_Locator("fieldName:OCCUPATION","Business");
//        PageObject.textinput_Locator("fieldName:NAME.OF.BUS","EVENT MANAGEMENT");
//        PageObject.textinput_Locator("fieldName:NAT.OF.BUS","EVENT MANAGEMENT");
//        PageObject.textinput_Locator("fieldName:STAT.OWNER","EVENT MANAGEMENT");
//        PageObject.textinput_Locator("fieldName:NAME.OF.EMP","ALI REHMAN");
//        PageObject.textinput_Locator("fieldName:CS.POS","CEO");
//        PageObject.textinput_Locator("fieldName:CS.EMP.SINCE","1995");
//        PageObject.radiobutton_Locator("radio:mainTab:STATUS",1);
//
//        PageObject.textinput_Locator("fieldName:CURRENT.SALARY","");
//        PageObject.textinput_Locator("fieldName:OTHER.INCOME","");
//        PageObject.textinput_Locator("fieldName:OTHER.FUNDS","");
//        PageObject.textinput_Locator("fieldName:PER.PROP.INMNT","");
//        PageObject.textinput_Locator("fieldName:CS.ANNUM.TO","");
//        PageObject.textinput_Locator("fieldName:SOURCE.OF.INCOME","");
//        PageObject.radiobutton_Locator("radio:mainTab:REL.POILITICAL",1);
//        PageObject.textinput_Locator("fieldName:POLITICAL.FIGURE","");
//        PageObject.radiobutton_Locator("radio:mainTab:PFAMAPPROVAL",1);
//        PageObject.radiobutton_Locator("radio:mainTab:HRAMAPPROVAL",1);
//        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);
//        PageObject.textinput_Locator("fieldName:CUST.COMMENTS:1","NEW CUSTOMER");
//        PageObject.textinput_Locator("fieldName:EXP.COUNT.PARTY:1","ISLAMABAD");
//
//
//        commit2();
//        Customers.txnValidate();
//        Customers.saveToDS("ECRP");
    }
    }