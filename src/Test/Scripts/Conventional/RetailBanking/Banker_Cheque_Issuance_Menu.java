package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class Banker_Cheque_Issuance_Menu extends BaseClass{



    @Test(groups = {"Inputter"})

    public void Banker_Cheque_Account_Holder() throws IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu",1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.childmenu_Dropdown("Cheque Issuance",1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu",1);
        PageObject.menu_Link("Banker Cheque Single Issuance- Account Holder ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","100");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1007902119");
        PageObject.click_Locator("fieldName:ORDERING.CUST:1");
        String menu1 = PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","82755198");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","Arshad Test");

//        PageObject.textarea_Locator("fieldName:ORDERING.CUST:1","");
//        PageObject.textarea_Locator("fieldName:PAYMENT.DETAILS:1","");
//        PageObject.textarea_Locator("fieldName:ORDERING.BANK:1","");
//        PageObject.radiobutton_Locator("radio:tab1:COMMISSION.CODE",3);
//        PageObject.textarea_Locator("fieldName:COMMISSION.TYPE:1","");
//        PageObject.textarea_Locator("fieldName:COMMISSION.AMT:1","");
//        PageObject.textarea_Locator("fieldName:CUST.RATE","");

        PageObject.form_Tab("Due Delligence");
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1","Test 123 street");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","3214569874125");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1","03332233665");
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Donation/Charity");

//        PageObject.textarea_Locator("fieldName:PURPOSE:1","");

        PageObject.commitDeal("Banker Cheque");
        driver.close();
    }

    @Test(groups = {"Authorizer"})
    public void Banker_Cheque_Account_Holder_Auth() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu" , 1);
        PageObject.childmenu_Dropdown("Cheq Instrument SingleAuthorization " , 1);
        PageObject.menu_Link("Authorize Banker Chq Single-Act Holder ");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:2:1:1","1007902119");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        PageObject.authorizeDeal();
        Thread.sleep(4000);
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(menu1);

    }

    @Test(groups = {"Inputter"})
        public void Banker_Cheque_Walking_Customer() throws IOException

    {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu",1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.childmenu_Dropdown("Cheque Issuance",1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu",1);
        PageObject.menu_Link("Banker Cheque Single Issuance- Walk-in Cust ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","100");

//        PageObject.textarea_Locator("fieldName:INST.NUMBER","");

        //PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1006948260");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","Ahmed Test");
        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1","Akber Test");

//        PageObject.textarea_Locator("fieldName:PAYMENT.DETAILS:1","");

        PageObject.form_Tab("Due Delligence");
        PageObject.textinput_Locator("fieldName:APP.ADDRESS:1","Test 123 Street");
        PageObject.textinput_Locator("fieldName:APP.ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:CNIC.NO","1234569874126");
        PageObject.textinput_Locator("fieldName:APP.CONTACT.NO","03332233665");
        PageObject.textinput_Locator("fieldName:APP.MOTHER.NAME","Mother");
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1","Test 123 Street");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","3214569874563");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1","03138855662");


        //PageObject.textinput_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");
//        PageObject.textarea_Locator("fieldName:PURPOSE:1","");
        //PageObject.txnValidate("Banker Cheque");
        PageObject.commitDeal("Banker Cheque");
        driver.close();

    }
    @Test(groups = {"Inputter"})
    public void Banker_Cheque_Vendor_Payment() throws IOException

    {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu",1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.childmenu_Dropdown("Cheque Issuance",1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu",1);
        PageObject.menu_Link("Banker Cheque Single Issuance- Walk-in Cust ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","100");
//        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1006948260");

        PageObject.textarea_Locator("fieldName:INST.NUMBER","");

        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","");
        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1","");

        PageObject.textarea_Locator("fieldName:PAYMENT.DETAILS:1","");

        PageObject.form_Tab("Due Delligence");
        PageObject.textinput_Locator("fieldName:APP.ADDRESS:1","");
        PageObject.textinput_Locator("fieldName:APP.ID.TYPE","");
        PageObject.textinput_Locator("fieldName:CNIC.NO","");
        PageObject.textinput_Locator("fieldName:APP.CONTACT.NO","");
        PageObject.textinput_Locator("fieldName:APP.MOTHER.NAME","");
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1","");
        PageObject.textinput_Locator("fieldName:ID.TYPE","");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1","");
        PageObject.textinput_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");

//        PageObject.textarea_Locator("fieldName:PURPOSE:1","");

        PageObject.txnValidate("Banker Cheque");
        PageObject.commitDeal("Banker Cheque");
        driver.close();

    }
    @Test(groups = {"Inputter"})
    public void Fund_Trf_Credit_Vendor_Payt_Act_Single_Bulk() throws IOException
    {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu",1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.childmenu_Dropdown("Cheque Issuance",1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu",1);
        PageObject.menu_Link("Fund Trf Credit- Vendor Payt Act Single/ Bulk ");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","");
        PageObject.textinput_Locator("fieldName:DEBIT.CURRENCY","PKR");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","");
        PageObject.textinput_Locator("fieldName:DEBIT.VALUE.DATE","");
        PageObject.textinput_Locator("fieldName:DEBIT.THEIR.REF","");
//        PageObject.textarea_Locator("fieldName:ORDERING.CUST:1","");
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF","");
        PageObject.textinput_Locator("fieldName:ORDERING.BANK:1","");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","");
        PageObject.txnValidate("Banker Cheque");
        PageObject.commitDeal("Banker Cheque");
    }


    @Test(groups = {"Inputter"})
    public void Banker_Cheque_Bulk_Account_Holder() throws IOException
    {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu",1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.childmenu_Dropdown("Cheque Issuance",1);
        PageObject.childmenu_Dropdown("Cheq  Bulk Issuance Menu",1);
        PageObject.menu_Link("Collect Banker Chq Amt A/c Holder Bulk-Step-1");
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","");
        PageObject.textarea_Locator("fieldName:CHEQUE.NUMBER","");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","");
        PageObject.textinput_Locator("fieldName:ORDERING.BANK:1","");
        PageObject.textinput_Locator("fieldName:NO.OF.INST","");
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","");
        PageObject.textinput_Locator("fieldName:COMMISSION.AMT:1","");
        PageObject.txnValidate("");
        PageObject.commitDeal("");
    }
    @Test(groups = {"Inputter"})
    public void Banker_Cheque_Bulk_Account_Holder_Step2() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services", 2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq  Bulk Issuance Menu", 1);
        PageObject.menu_Link("Collect Banker Chq Amt A/c Holder Bulk-Step-2");
    }

    @Test(groups = {"Inputter"})
    public void Banker_Cheque_Bulk_Walkin_Customer() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services", 2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Walkin Cust", 1);
        PageObject.menu_Link("Collect Banker Chq W/Cust-Single/Bulk- Step-1");
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1","");
        PageObject.textinput_Locator("fieldName:NO.OF.INST","");

//        PageObject.textarea_Locator("fieldName:NARRATIVE.2:1","");

        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");

//        PageObject.textarea_Locator("fieldName:PURPOSE","");
//        PageObject.textarea_Locator("fieldName:DEN.AMT:1","");
    }

    @Test(groups = {"Inputter"})
    public void Banker_Cheque_Bulk_Account_Vendor_Payment() throws IOException
    {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services", 2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Vendor Paymt", 1);
        PageObject.menu_Link("Collect Banker Chq Amt - Vendor Bulk- Step-1");
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","");
        PageObject.textinput_Locator("fieldName:ORDERING.BANK:1","");
        PageObject.textinput_Locator("fieldName:NO.OF.INST","");
        PageObject.txnValidate("");
        PageObject.commitDeal("");
    }


    @Test(groups = {"Inputter"})
    public void Banker_Cheque_Bulk_Account_Vendor_Payment_Step2() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services", 2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Vendor Paymt", 1);
        PageObject.menu_Link("Collect Banker Chq Amt - Vendor Bulk- Step-2");
    }


}
