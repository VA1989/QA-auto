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



public class NativeToWeb extends base{



public static void main(String[] args) throws MalformedURLException, InterruptedException {

AndroidDriver<AndroidElement> driver=Capabilities("emulator");

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");

     driver.hideKeyboard();

     driver.findElementByXPath("//*[@text='Female']").click();

     driver.findElement(By.id("android:id/text1")).click();

     //driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");     

     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));").click();

  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
      
    driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
    driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
    driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
    
    /*Thread.sleep(4000);
    
    String A1=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
   
    double A1value = getAmount(A1);
    String A2=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
    
    double A2value = getAmount(A2);
    
    double sumOfProducts = A1value+A2value;
    
    String total=driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
    
    double totalAmount = getAmount(total);
    Assert.assertEquals(sumOfProducts, totalAmount);
    
    System.out.println("Sum of products is " + sumOfProducts);
    System.out.println("Total amount is " + totalAmount);*/
    
    driver.findElementByClassName("android.widget.CheckBox").click();
    
    TouchAction touch = new TouchAction(driver);
    WebElement TC = driver.findElementById("com.androidsample.generalstore:id/termsButton");
    touch.longPress(longPressOptions().withElement(element(TC)).withDuration(ofSeconds(2))).release().perform();
    driver.findElementByXPath("//*[@text='CLOSE']").click();
    driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
    
    Thread.sleep(7000);
    Set<String> context = driver.getContextHandles();
    
    for(String contextname :context) {
    	System.out.println(contextname);
    }
    
    driver.context("WEBVIEW_com.androidsample.generalstore");
    driver.findElement(By.name("q")).sendKeys("hello");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    
    driver.context("NATIVE_APP");
}
/*public static double getAmount(String value) {     
	value = value.substring(1);
	double amount = Double.parseDouble(value);
	return amount;
}*/
}

