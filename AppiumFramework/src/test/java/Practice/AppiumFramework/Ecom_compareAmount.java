package Practice.AppiumFramework;
import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;
import pageObjects.CheckoutPage;



public class Ecom_compareAmount extends base{



@Test
public void totalValidation() throws IOException, InterruptedException {

	service.start();
	AndroidDriver<AndroidElement> driver=Capabilities("GenStore");

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     FormPage formPage=new FormPage(driver);
     CheckoutPage chPage=new CheckoutPage(driver);
     Utilities util=new Utilities(driver);
 
     formPage.nameField.sendKeys("Hello");
     formPage.getNameField().sendKeys("Hello");
     //driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
     driver.hideKeyboard();
     formPage.FemaleOption.click();
     formPage.getCountrySelection().click();
     //driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");     
     util.scrollToText("Austria");
     //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));").click();

  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
      
    driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
    driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
    driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
    
    Thread.sleep(4000);
    
    String A1=chPage.productPrice.get(0).getText();
    double A1value = getAmount(A1);
    
    String A2=chPage.productPrice.get(1).getText();
    double A2value = getAmount(A2);
    
    double sumOfProducts = A1value+A2value;
    
    String total=chPage.totalAmount.getText();    
    double totalAmount = getAmount(total);
    
    Assert.assertEquals(sumOfProducts, totalAmount);
    
    System.out.println("Sum of products is " + sumOfProducts);
    System.out.println("Total amount is " + totalAmount);
    
    driver.findElementByClassName("android.widget.CheckBox").click();
    
    TouchAction touch = new TouchAction(driver);
    WebElement TC = driver.findElementById("com.androidsample.generalstore:id/termsButton");
    touch.longPress(longPressOptions().withElement(element(TC)).withDuration(ofSeconds(2))).release().perform();
    driver.findElementByXPath("//*[@text='CLOSE']").click();
    driver.findElementById("com.androidsample.generalstore:id/btnProceed");
    
    service.stop();
}
public static double getAmount(String value) {     
	value = value.substring(1);
	double amount = Double.parseDouble(value);
	return amount;
}


}

