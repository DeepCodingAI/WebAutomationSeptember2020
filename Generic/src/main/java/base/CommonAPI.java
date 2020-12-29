package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public String browserStackUserName = "your_user_name";
    public String browserStackAccessKey = "Your_Access_Key";
    public String sauceLabsUserName = "";
    public String sauceLabsAccessKey = "";

    public static WebDriver driver = null;

    @Parameters({"useCloudEnv","envName","os","os_version","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(String useCloudEnv,String envName,String os,
                      String os_version, String browserName, String browserVersion,String url) throws MalformedURLException {
        if(useCloudEnv.equalsIgnoreCase("true")){
            getCloudDriver(envName,os,os_version,browserName,browserVersion);
        }else if(useCloudEnv.equalsIgnoreCase("false")){
            getLocalDriver(os,browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();

    }

    public WebDriver getLocalDriver(String OS, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
                driver = new ChromeDriver();
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }else if(browserName.equalsIgnoreCase("firefox")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver");
                driver = new FirefoxDriver();
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.gecko.driver", "./Generic/driver/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }else if(browserName.equalsIgnoreCase("ie")){
                System.setProperty("webdriver.ie.driver", "./Generic/driver/internetexplorerdriver.exe");
                driver = new InternetExplorerDriver();

        }else if(browserName.equalsIgnoreCase("safari")){
            System.setProperty("webdriver.safari.driver", "./Generic/driver/safaridriver");
            driver = new SafariDriver();
        }
        return driver;
    }

    public WebDriver getCloudDriver(String envName, String OS,String os_version,
                                    String browserName, String browserVersion) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browserVersion",browserVersion);
        cap.setCapability("os", OS);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Browserstack")){
            driver = new RemoteWebDriver(new URL("http://"+browserStackUserName+":"+browserStackAccessKey+
                    "@hub-cloud.browserstack.com/wd/hub"),cap);
        }else if(envName.equalsIgnoreCase("Saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + sauceLabsUserName + ":" + sauceLabsAccessKey +
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }

        return driver;
    }

    @AfterMethod
    public void cleanUp(){
        driver.close();
    }

    public static void navigateBack(){
        driver.navigate().back();
    }
    public void clickOnWebElement(String locator){
        try {
            driver.findElement(By.cssSelector(locator)).click();
        }catch (Exception ex1){
            try{
                driver.findElement(By.className(locator)).click();
            }catch (Exception ex2){
                try{
                    driver.findElement(By.id(locator)).click();
                }catch (Exception ex3){
                    driver.findElement(By.xpath(locator)).click();
                }
            }
        }
    }
    public void typeOnWebElement(String locator, String value){
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        }catch (Exception ex1){
            try{
                driver.findElement(By.className(locator)).sendKeys(value);
            }catch (Exception ex2){
                try{
                    driver.findElement(By.id(locator)).sendKeys(value);
                }catch (Exception ex3){
                    driver.findElement(By.xpath(locator)).sendKeys(value);
                }
            }
        }
    }
    public void typeOnWebElementNHitEnter(String locator, String value){
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        }catch (Exception ex1){
            try{
                driver.findElement(By.className(locator)).sendKeys(value, Keys.ENTER);
            }catch (Exception ex2){
                try{
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }catch (Exception ex3){
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }
    public void clearInputField(String locator){
        try {
            driver.findElement(By.cssSelector(locator)).clear();
        }catch (Exception ex1){
            try{
                driver.findElement(By.className(locator)).clear();
            }catch (Exception ex2){
                try{
                    driver.findElement(By.id(locator)).clear();
                }catch (Exception ex3){
                    driver.findElement(By.xpath(locator)).clear();
                }
            }
        }
    }

    public String getWebText(String locator){
        String text = "";
        try {
           text =  driver.findElement(By.cssSelector(locator)).getText();
        }catch (Exception ex1){
            try{
            text = driver.findElement(By.className(locator)).getText();
            }catch (Exception ex2){
                try{
                  text = driver.findElement(By.id(locator)).getText();
                }catch (Exception ex3){
                   text =  driver.findElement(By.xpath(locator)).getText();
                }
            }
        }
        return text;
    }
    public List<WebElement> getListOfWebElements(String locator){
        List<WebElement> elementList = driver.findElements(By.cssSelector(locator));
        return elementList;
    }
    public List<String> getListOfText(List<WebElement> elements){
        List<String> listOfText = new ArrayList<String>();
        for(WebElement element:elements){
            listOfText.add(element.getText());
        }
        return listOfText;
    }
    public List<String> getListOfText(String locator){
        List<WebElement> elementList = driver.findElements(By.cssSelector(locator));
        List<String> listOfText = new ArrayList<String>();
        for(WebElement element:elementList){
            listOfText.add(element.getText());
        }
        return listOfText;
    }
    public void printText(List<String> list){
        for(String st:list){
            System.out.println(st);
        }
    }

    public void sleepFor(int sec)throws InterruptedException{
        Thread.sleep(1000 * sec);
    }

    //Synchronization
    public static void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public static void waitUntilClickAble(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch(Exception ex){
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
    }

    public static void waitUntilVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitUntilSelectable(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
}
