package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settingsObj.DriverTypes;
import settingsObj.Settings;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;


/**
 * Created by Dima on 7/29/2018.
 */
public class Driver {
    private WebDriver webDriver;

    public void setWebDriver(DriverTypes driverType) {
        switch (driverType) {

            case Chrome:
                System.setProperty("webdriver.chrome.driver", Paths.get("src\\main", "resources", "chromedriver.exe").toString());
                webDriver = new ChromeDriver();
                implicitDelay(webDriver, Settings.implicitWait);

                break;
            case FireFox:
                webDriver = new FirefoxDriver();
                implicitDelay(webDriver,Settings.implicitWait);

                break;
            case IE:
                webDriver = new InternetExplorerDriver();
                break;
            default:
                webDriver = null;
        }

    }
    private void implicitDelay(WebDriver webDriver,int delay){
        webDriver.manage().timeouts().implicitlyWait(delay, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(Settings.loadingTime, TimeUnit.SECONDS);

    }


    public boolean waitElementToBeVisible(String webElementXpath,int timeOut){
        WebDriverWait wait = new WebDriverWait(getWebDriver(),timeOut);
        try {
            wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.xpath(webElementXpath))));
            return true;
        }catch (Exception e){
            System.out.println("Not present: "+webElementXpath);
            return false;
        }
    }

    public void waitToBeClickable(By by, int time){
        WebDriverWait wait = new WebDriverWait(getWebDriver(),time);
        wait.until(ExpectedConditions.elementToBeClickable(by));


    }

    public void waitElementToBeActive(String webElementXpath,int timeOut){
        WebDriverWait wait = new WebDriverWait(getWebDriver(),timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementXpath)));
    }

    public void waitElementToBecomeInvisible(String webElementXpath, int timeOut){
        WebDriverWait wait = new WebDriverWait(getWebDriver(),timeOut);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(webElementXpath)));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }


}
