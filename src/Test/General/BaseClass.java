package Test.General;

import POM.PageObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Actions action;
    public static String homePage;

    // Configuration Property File
    public String getProperty(String key) throws IOException {
        //Reading configuration file from the path

        FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\Resources\\config.properties");
        Properties props = new Properties();
        props.load(reader);
        return props.getProperty(key);
    }

    // Configuration Of Chrome Driver
    public void chromeConfig() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\dependency\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        this.driver = new ChromeDriver(options);

        PageObject PageObject = new PageObject(driver);

        action = new Actions(driver);

        driver.get("https://172.24.128.50/R22UAT1/servlet/BrowserServlet");
//        driver.get("http://172.24.157.27:9080/R22SIT2/servlet/BrowserServlet");
        //driver.get("http://172.21.81.59:9080/R13UAT1/servlet/BrowserServlet");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    // Configuration Of Edge Driver
    public static void edgeConfig() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\dependency\\msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);

        driver = new EdgeDriver(options);

        PageObject PageObject = new PageObject(driver);

        action = new Actions(driver);

        driver.get("http://172.24.157.27:9080/R22SIT2/servlet/BrowserServlet");
        //driver.get("http://172.21.81.59:9080/R13UAT1/servlet/BrowserServlet");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    //    Screenshot Utility
    public String getScreenshot(String testCaseName) throws IOException {

        TakesScreenshot sc = (TakesScreenshot) driver;
        File path = sc.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\Reports\\" + testCaseName + " " + PageObject.idNumber() +".png");
//        File file = new File("C:\\Users\\xcelliti2\\IdeaProjects\\Retail Ops\\Reports\\" +testCaseName+ ".png");
        FileUtils.copyFile(path, file);
        return System.getProperty("user.dir") + "\\Reports\\" + testCaseName + " " + PageObject.idNumber() +".png";
    }

    public static String AssertionScreenshot(String testCaseName) throws IOException {

        Date date1 = new Date();
        SimpleDateFormat dft = new SimpleDateFormat("E yyyy.MM.dd HH:mm:ss");
        String replaceString=dft.format(date1).toString().replaceAll(":"," ");
        TakesScreenshot sc = (TakesScreenshot) driver;
        File path = sc.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\"+ testCaseName+ "\\" + testCaseName + replaceString +".png");
        FileUtils.copyFile(path, file);
        return System.getProperty("user.dir") + "\\"+ testCaseName+ "\\" + testCaseName + dft.format(date1) +".png";
    }

    @BeforeMethod(groups = {"InputterTDR"})

    public void InputterTDR() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
            PageObject.signIn("AK2366601", "");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","AK23666.01");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(2000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"AuthorizerTDR"})

    public void AuthorizerTDR() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("RB1965401", "");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","RB19654.01");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"InputterTDR_IBG"})

    public void InputterTDR_IBG() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
            PageObject.signIn("AK2366602", "QWer12345");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","AK23666.02");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","2550111030");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"AuthorizerTDR_IBG"})

    public void AuthorizerTDR_IBG() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
//        PageObject.signIn("RB1965401", "ADmin+258");
        PageObject.signIn("RB1965402", "QWer1234");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","RB19654.01");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }


    @BeforeMethod(groups = {"CfrInputter"})
    public void CfrInputter() throws InterruptedException {
        chromeConfig();
        PageObject.signIn("cfr01", "QWer1234");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","CFR.01");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1001911540");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
    }

    @BeforeMethod(groups = {"CfrAuthorizer"})
    public void CfrAuthorizer() throws InterruptedException {
        chromeConfig();
        PageObject.signIn("cfr02", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);


    }

    @BeforeMethod(groups = {"IBG_CfrInputter"})
    public void IBG_CfrInputter() throws InterruptedException {
        chromeConfig();
        PageObject.signIn("cfr03", "");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","CFR.03");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1001911540");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
    }

    @BeforeMethod(groups = {"IBG_CfrAuthorizer"})
    public void IBG_CfrAuthorizer() throws InterruptedException {
        chromeConfig();
        PageObject.signIn("cfr04", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);


    }

    @BeforeMethod(groups = {"Inputter"})
    public void inputterLogin() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("HN14336290", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CSO - Conventional");
        PageObject.menu_Link("CSO - Conventional ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }
//************************* Saperate before method () for each Cao class (transaction). ****************************** //
    @BeforeMethod(groups = {"inputterIBG"})
    public void inputterIBG() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("retail003", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CSO - IBG");
        PageObject.menu_Link("CSO - IBG ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"SS328565505"})
    public void SS328565505() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("SS328565505", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CSO - IBG");
        PageObject.menu_Link("CSO - IBG ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }
    @BeforeMethod(groups = {"authorizerIBG"})
    public void authorizerIBG() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("retailauth005", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("IBG - Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"MH214215505"})
    public void MH214215505() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("MH214215505", "QWer12345");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Branch Manager IBG ");
       // PageObject.menu_Dropdown("Core Retail Menu");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"authorizer"})
    public void authorizer() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("retailauth007", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);

//        PageObject.menu_Dropdown("CSO - Conventional");
//        PageObject.menu_Link("CSO - Conventional ");
//
//        homePage = PageObject.switchToChildWindow();
//
//        PageObject.maximizeWindow();
//        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"CaoInputter"})
    public void CaoInputterLogin2() {
//        edgeConfig();
        chromeConfig();
        //
        PageObject.signIn("AB2375501", "");
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","AB23755.01");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        PageObject.switchToParentWindow(homePage);
        PageObject.switchFrame(1);
    }

    @BeforeMethod(groups = {"CaoAuthorizer"})
    public void caoAuthorizerLogin() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("NK1988001", "123456");
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"CaoInputterIBG"})
    public void CaoInputterLoginIBG() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("caouser004", "QWer1234");
        PageObject.switchFrame(0);
        driver.findElement(By.xpath("//a[text()='Tools']")).click();
        String mainPage = PageObject.switchToChildWindow();
        driver.findElement(By.xpath("//img[@alt='My Companies']")).click();
        driver.findElement(By.xpath("//*[text()='BANK ALFALAH LTD - IBG ']")).click();
        PageObject.switchToChildWindow();
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        driver.findElement(By.xpath("//*[text()='Define Current Branch ']")).click();
        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","CAOUSER.004");
        PageObject.img_Button("Edit a contract");
//        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","100311100");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1556111040");
        driver.findElement(By.xpath("//input[@id='fieldName:CURRENT.BRANCH']")).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        PageObject.switchToParentWindow(homePage);
        PageObject.switchFrame(1);
    }

    @BeforeMethod(groups = {"CaoAuthorizerIbg"})
    public void CaoIbgAuthLogin() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("caoauth002", "QWer1234");
        PageObject.switchFrame(0);
        driver.findElement(By.xpath("//a[text()='Tools']")).click();
        String mainPage = PageObject.switchToChildWindow();
        driver.findElement(By.xpath("//img[@alt='My Companies']")).click();
        driver.findElement(By.xpath("//img[text()='BANK ALFALAH LTD - IBG ']")).click();
        PageObject.switchToChildWindow();
        PageObject.switchFrame(1);
    }


    @BeforeMethod(groups = {"IBGInputter"})
    public void inputterIbgLogin() {
        chromeConfig();

        PageObject.signIn("retail001", "QWer1234");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CSO - IBG");
        PageObject.menu_Link("CSO - IBG ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"IBGAuthorizer"})
    public void authIbgLogin() {
        chromeConfig();

        PageObject.signIn("retailauth001", "QWer1234");

        homePage = driver.getWindowHandle();

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("IBG - Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");
    }


    @BeforeMethod(groups = {"Authorizer"})
    public void authorizerLogin() {
        chromeConfig();

        PageObject.signIn("retailauth006", "QWer1234");

        homePage = driver.getWindowHandle();

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");

    }


//    @AfterMethod(groups = {"Authorizer" , "Inputter", "IBGInputter", "IBGAuthorizer"})
//    public void userLogout(){
//        this.driver.close();
//
//        PageObject.switchToParentWindow(homePage);
//
//        PageObject.switchFrame(0);
//
//        PageObject.signOff();
//
//        this.driver.close();
//    }


//    @BeforeMethod(groups = {"PowerUser"})
//    public void PowerUserLogin() {
//        chromeConfig();
//
//        PageObject.signIn("talha01", "QWer1234");
//
//        homePage = driver.getWindowHandle();
//
//        PageObject.switchFrame(0);
//
//        driver.findElement(By.xpath("//div/div/form[@id='commandLineForm']")).clear();
//        driver.findElement(By.xpath("//div/div/form[@id='commandLineForm']")).sendKeys("RECORD.LOCK");
////        PageObject.textinput_Locator("commandValue","RECORD.LOCK");
//        PageObject.click_Locator("Go");
//
//        PageObject.maximizeWindow();
//        PageObject.switchFrame(0);
//    }

}




