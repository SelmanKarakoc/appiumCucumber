package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AndroidDriver appiumDriver;
    private static AppiumDriver appleDriver;//ben yazdim


    static final String deviceName="Pixel";
    static final String platformName="Android";
    static final String platformVersion="10.0";
    static final String automationName="UiAutomator2";

    public static AndroidDriver getAndroidDriver()  {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
        if (appiumDriver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
            caps.setCapability("appPackage", "com.ailebutcem");
            caps.setCapability("appActivity", "com.ailebutcem.MainActivity");
            caps.setCapability(MobileCapabilityType.NO_RESET,false); // true uygulama sifirlanmiyor onceki adimlari muhafaza ediyor
            //false ise her test baslangicinda sifirliyor
            /*
            Bunlar Kiwi codlari:
            caps.setCapability("appPackage","com.skypicker.main");
            caps.setCapability("appActivity","com.kiwi.android.feature.splash.impl.ui.SplashActivity");
            caps.setCapability(MobileCapabilityType.NO_RESET,false); // true uygulama sifirlanmiyor onceki adimlari muhafaza ediyor*/
            //false ise her test baslangicinda sifirliyor


            if (ConfigReader.getProperty("platformName").equals("Android")) {

                assert appiumServerURL != null;
                appiumDriver = new AndroidDriver<>(appiumServerURL, caps);
                appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            } else {
                assert appiumServerURL != null;//Burada throw haric ben yazdim
                appleDriver = new AppiumDriver<>(appiumServerURL, caps);
                appleDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                throw new UnsupportedOperationException("Invalid Platform Name ");

            }

        }
        return appiumDriver;
    }


    public static void quitAppiumDriver(){
        if (appiumDriver != null) {
            appiumDriver.closeApp();
            appiumDriver = null;
        }
    }
}
