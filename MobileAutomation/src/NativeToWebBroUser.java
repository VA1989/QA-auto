import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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



public class NativeToWebBroUser extends baseBroUser{



public static void main(String[] args) throws MalformedURLException, InterruptedException {

AndroidDriver<AndroidElement> driver=Capabilities("emulator");


 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.get("https://bing.com");
 driver.findElementByXPath("//*[@id=\"sb_form_q\"]").click();
 driver.findElement(By.name("q")).sendKeys("https://wikipedia.org");
 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
 driver.findElementByXPath("//*[@id=\"b_results\"]/li[1]/div[1]/h2/a").click();

 String URL = driver.getCurrentUrl();
 System.out.println (driver.getCurrentUrl());
 Assert.assertEquals(URL, "https://wikipedia.org/" );
 
}
}
