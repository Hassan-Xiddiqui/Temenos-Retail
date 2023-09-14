package POM;

import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Random;

public class PageObject extends BaseClass {

    public static WebDriver driver;
    public static Actions action;
    public static String parentWindow;

    public PageObject(WebDriver driver) {
        this.driver = driver;

    }

    //This method is to perform actions on Form Input Fields
    public static void textinput_Locator(String Id , String value) {

        driver.findElement(By.xpath("//tr/td/input[@id='"+Id+"']")).clear();
        driver.findElement(By.xpath("//tr/td/input[@id='"+Id+"']")).sendKeys(value);

    }

    //This method is to perform click on Form Input Fields
    public static void click_Locator (String Id) {

        driver.findElement(By.xpath("//tr/td/input[@id='"+Id+"']")).click();

    }

    //This method is to perform actions on Form Images
    public static void img_Button (String alt_Value) {
        driver.findElement(By.xpath("//tr/td/a/img[@alt='"+alt_Value+"']")).click();
    }

    public static void imgchild_Button (String alt_Value , Integer index) {
        driver.findElement(By.xpath("(//tr/td/a/img[@alt='"+alt_Value+"'])["+index+"]")).click();
    }


    public static void find_Button () {
        driver.findElement(By.xpath("//tr/td/a[@alt='Run Selection']")).click();
    }

    //This method is to perform action on Static Select Dropdowns
    public static void select_Locator (String Id , String value) {
        WebElement Dropdown = driver.findElement(By.xpath("//tr/td/select[@id='"+Id+"']"));
        Select static_Dropdown = new Select(Dropdown);
        static_Dropdown.selectByValue(value);
    }

    //This method is to perform SignIn action
    public static void signIn (String userName , String passWord) {
        driver.findElement(By.xpath("//input[@name='signOnName']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    //Switch Frame
    public static void switchFrame(int index){
        driver.switchTo().frame(index);
    }

    public static void refreshWindow(int indexNumber)
    {
        String childPage = PageObject.switchToChildWindow();
        PageObject.switchFrame(indexNumber);
    }

    public  static void uploadFile(String filePath,String frameID){

        WebElement fileFrame = driver.findElement(By.xpath("//iframe[@id='"+frameID+"']"));
        driver.switchTo().frame(fileFrame);
        driver.findElement(By.xpath("//input[@id='fileInput']")).sendKeys(filePath);
        driver.findElement(By.xpath("//img[@title='Upload']")).click();

    }

    public static void parentFrame(){
        driver.switchTo().parentFrame();
    }

    //This method is to perform actions on Form Textarea Fields
    public static void textarea_Locator (String Id , String value) {
        driver.findElement(By.xpath("//tr/td/textarea[@id='"+Id+"']")).clear();
        driver.findElement(By.xpath("//tr/td/textarea[@id='"+Id+"']")).sendKeys(value);
    }

    //This method is to perform actions on Form Radio Buttons
    public static void radiobutton_Locator(String Id , int index) {
        //tr/td/input/following-sibling::span[text()='Small']
        driver.findElement(By.xpath("(//tr/td/input[@id='"+Id+"'])["+index+"]")).click();
    }

    //This method is to perform actions on In-Form Tabs
    public static void form_Tab(String text_Value) {
        driver.findElement(By.xpath("//tr/td/a/span[text()='"+text_Value+"']")).click();
    }

//    //This method is to perform action of Accept Override
//    public static void acceptOverride() {
//        driver.findElement(By.xpath("//tr/td/a[text()='Accept Overrides']")).click();
//    }

    //This method is to Expand/Collapse Menu Items
    public static void menu_Dropdown(String alt_Value) {
        driver.findElement(By.xpath("//ul/li/span/img[@alt='"+alt_Value+"']")).click();
    }

    public static void childmenu_Dropdown(String alt_Value, Integer index) {
        driver.findElement(By.xpath("(//ul/li/span/img[contains(@alt,'"+alt_Value+"')])["+index+"]")).click();
    }

    //This method is to perform a click on Menu Links
    public static void menu_Link(String text_Value) {
        driver.findElement(By.xpath("//ul/li/a[text()='"+text_Value+"']")).click();
    }

    public static void authformLink(String text_Value) {
        driver.findElement(By.xpath("//tr/td/a/b[text()='"+text_Value+"']")).click();
    }

    public static void childmenu_Link(String text_Value , Integer index) {
        driver.findElement(By.xpath("(//ul/li/a[contains(text(),'"+text_Value+"')])["+index+"]")).click();
    }

//    public static void childmenuLink(String text_Value , Integer index) {
//        driver.findElement(By.xpath("(//tr/td/a[contains(text(),'"+text_Value+"')])["+index+"]")).click();
//    }

    public static void form_Link(String text_Value) {
        driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='"+text_Value+"']")).click();
    }

    public static void formindex_Link(String text_Value , Integer index) {
        driver.findElement(By.xpath("(//table/tbody/tr/td/a[text()='"+text_Value+"'])["+index+"]")).click();
    }

    public static void authorizeDeal () {
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Authorises a deal']")).click();
        if (driver.getPageSource().contains("Accept Overrides")){
            WebElement override = driver.findElement(By.xpath("//tr/td/a[text()='Accept Overrides']"));
            override.click();
        }
    }

    public static void authorizeByTxn(String txn){
        driver.findElement(By.xpath("//td[text()='"+txn+"']/following-sibling::td//a[text()='Authorises a deal']")).click();
    }


    //Generate Random Numbers

    public static int idNumber() {
        Random rand = new Random();
        int min = 10000;
        int max = 99999;

        int rand_value = rand.nextInt((max - min) + 1) + min;
        return rand_value;
    }

    public static String switchToChildWindow() {
        String homePage = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        return homePage;
    }

    public static String switchToParentWindow(String window){
        driver.switchTo().window(window);
        return window;
    }

    public static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public static String txnValidate(String testCaseName) throws IOException {
       WebElement Txn = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'Txn Complete:')]"));
       Assert.assertTrue(Txn.isDisplayed(),"Transaction Un-Successful");

       String Transaction = Txn.getText();
       String[] first = Transaction.split(":");
       String[] second = first[1].split(" ");
       String TxnNum = second[1];
       System.out.println("Transaction Number is: "+TxnNum);

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
            cell.setCellValue("Transaction Number");
        }

        Sheet sheet = workbook.getSheetAt(0);
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue(TxnNum);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

        return TxnNum;

    }

    // Commit Deal For Inputter
    public static String commitDeal (String testCaseName) throws IOException {
        String valueOfTxn="";
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Validate a deal']")).click();
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Commit the deal']")).click();
        if (driver.getPageSource().contains("Txn Complete:")){
            valueOfTxn=txnValidate(testCaseName);
        }else{
            try {
                WebElement acpOverride = driver.findElement(By.xpath("//tr/td/a[text()='Accept Overrides']"));
                AssertionScreenshot(testCaseName);
                acpOverride.click();
                valueOfTxn=txnValidate(testCaseName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        return valueOfTxn;
    }

    // Get Txn Number to pass further for Authorization
    public static String getTxn () {
        WebElement Txn = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'Txn Complete:')]"));
        String Transaction = Txn.getText();
        String[] first = Transaction.split(":");
        String[] second = first[1].split(" ");
        String TxnNum = second[1];
        return TxnNum;
    }



    //This method is for user SignOff
    public static void signOff() {
        driver.findElement(By.xpath("//tr/td/a[@alt='Sign off']")).click();
    }

    public static void tools() {
        driver.findElement(By.xpath("//tr/td/a[@alt='Tools']")).click();
    }

}
