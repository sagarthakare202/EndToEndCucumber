package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
    /** This method is to initialise the threadlocal driver on the basis of given driver
     * @param browser
     * @return this will return tldriver
     * **/

    public WebDriver init_driver(String browser) {
        System.out.println("Browser value is: " + browser);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().create();
            tldriver.set(new ChromeDriver());
        } else if (browser.equals("FF")) {
            WebDriver driver = WebDriverManager.firefoxdriver().create();
            tldriver.set(new FirefoxDriver());
        }
        else {
            System.out.println("Please pass the correct browser value");
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        return getDriver();
    }
    public static synchronized WebDriver getDriver(){
        return tldriver.get();
    }

}
