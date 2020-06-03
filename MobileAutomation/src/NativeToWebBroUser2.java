import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class NativeToWebBroUser2 extends baseChrome{



public static void main(String[] args) throws MalformedURLException, InterruptedException {

AndroidDriver<AndroidElement> driver=Capabilities("emulator");

 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.get("https://bing.com");
 driver.findElementByXPath("//*[@id=\"sb_form_q\"]").click();
 driver.findElement(By.name("q")).sendKeys("https://wikipedia.org");
 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
 
 WebDriverWait wait = new WebDriverWait(driver, 10);

//Find frame or iframe and switch
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("android.widget.FrameLayout")));

//Now find the element 
WebElement Category_Body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Wikipedia https://www.wikipedia.org")));
Category_Body.click();

 String URL = driver.getCurrentUrl();
 System.out.println (driver.getCurrentUrl());
 Assert.assertEquals(URL, "https://wikipedia.org/" );
 
}
}

