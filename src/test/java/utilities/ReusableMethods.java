package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static io.appium.java_client.touch.offset.PointOption.point;

public class ReusableMethods {
    public static void clickWithCoordinates(int X,int Y,int wait) throws InterruptedException {
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(point(X,Y)).release().perform();
        Thread.sleep(wait);
    }

    public static void screenScrollDown(int waitAction){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(point(530,1710))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(point(530,250))
                .release()
                .perform();
    }

    public static void screenScrollUp(int waitAction){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(point(530,250))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(point(530,1710))
                .release()
                .perform();
    }

    public static void screenScrollLeft(int waitAction){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(point(102,888))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(point(990,888))
                .release()
                .perform();
    }

    public static void screenScrollRight(int waitAction){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(point(990,888))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(point(102,888))
                .release()
                .perform();
    }

    public static void screenScroll(int pressX,int pressY,int wait,int moveX,int moveY){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(point(pressX,pressY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(point(moveX,moveY))
                .release()
                .perform();
    }

    public static void scrollWithUiScrollableAndClick(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();

    }
    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
    }
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAndroidDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }


}
