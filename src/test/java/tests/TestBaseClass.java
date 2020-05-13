package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseClass {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    static String deviceName = "Samsung Galaxy S7";

    @BeforeMethod
    public void setup () throws IOException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung Galaxy S7");
        caps.setCapability("udid", "192.168.66.101:5555"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        caps.setCapability("appActivity","com.amazon.mShop.splashscreen.StartupActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}