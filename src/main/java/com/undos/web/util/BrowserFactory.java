package com.undos.web.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    private static BrowserFactory browserFactory = null;
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public static synchronized BrowserFactory getInstance() {
        if (browserFactory == null) {
            browserFactory = new BrowserFactory();
        }
        return browserFactory;
    }

    public WebDriver openBrowser(String Browser) {
        WebDriver driver;
        switch (Browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Unsupported Webdriver:" + Browser);
        }

        driver.manage().window().maximize();
        webDriver.set(driver);
        return driver;
    }

    public void closebrowser()
    {
        if(webDriver.get()!= null)
        {
            webDriver.get().close();
            webDriver.get().quit();
            webDriver.remove();
        }
    }


}
