package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserDriver {


    private static AndroidDriver browserdriver;

    static final String deviceName="Pixel";
    static final String platformName="Android";
    static final String platformVersion="10.0";
    static final String automationName="UiAutomator2";

    public static AndroidDriver getBrowserDriver() {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (browserdriver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
            // caps.setCapability("appPackage","com.android.chrome"); // Hangi uygulama uzerinde calismak istiyorsak apk infodan o uygulamanin degerini aliyoruz
            // caps.setCapability("appActivity","com.google.android.apps.chrome.Main"); // Uygulamayi actiktan sonra hangi sayfadan baslayacagimizi orn; Anasayfa, Profil, vb
            caps.setCapability(MobileCapabilityType.NO_RESET, false);
            // true uygulama sifirlanmiyor onceki adimlari muhafaza ediyor
            //false ise her test baslangicinda uygulamayi sifirliyor ve uygulama en bastan basliyor
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
            //caps.setCapability("chromedriverExecutable", "C:\\Users\\ahmet\\IdeaProjects\\APPIUM_T116-CUCUMBER\\driver\\chromedriver.exe");

            if (ConfigReader.getProperty("platformName").equals("Android")) {

                assert appiumServerURL != null;
                browserdriver = new AndroidDriver<>(appiumServerURL, caps);
                browserdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            } else {

                throw new UnsupportedOperationException("Invalid Platform Name ");

            }

        }

        return browserdriver;
    }


    public static void quitAppiumDriver() {
        if (browserdriver != null) {
            browserdriver.closeApp();
            browserdriver = null;
        }
    }
}