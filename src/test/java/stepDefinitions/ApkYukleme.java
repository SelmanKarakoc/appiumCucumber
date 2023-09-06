package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYukleme {
    AndroidDriver<AndroidElement> driver;
    static final String deviceName="Pixel";
    static final String platformName="Android";
    static final String platformVersion="10.0";
    static final String automationName="UiAutomator2";
    @Given("Kullanici gerekli bilgileri girerek {string} apk yuklemesi yapar")
    public void kullanici_gerekli_bilgileri_girerek_apk_yuklemesi_yapar(String apk) throws MalformedURLException {

        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        caps.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty(apk)); // "ailebutcem"
        caps.setCapability(MobileCapabilityType.NO_RESET,false);
        // true uygulama sifirlanmiyor onceki adimlari muhafaza ediyor
        //false ise her test baslangicinda uygulamayi sifirliyor ve uygulama en bastan basliyor
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
}
