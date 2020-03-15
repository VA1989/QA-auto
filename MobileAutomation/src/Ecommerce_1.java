import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;



public class Ecommerce_1 extends base{



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
     
     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
             + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
             + "new UiSelector().text(\"Jordan 6 Rings\"));");
		int count=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
		for(int i=0;i<count;i++)
		{
			String text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if(text.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();break;
		}
			
		}
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

		Assert.assertEquals("Jordan 6 Rings", lastpageText);
}
     
}