package Practice.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;



public class Ecommerce_1 extends base{


@Test
public static void Ecommerce1() throws InterruptedException, IOException {
     service=startServer();
     
     AndroidDriver<AndroidElement> driver=Capabilities("GenStore");
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     FormPage formPage=new FormPage(driver);
     CheckoutPage chPage=new CheckoutPage(driver);
     Utilities util=new Utilities(driver);
     
     formPage.nameField.sendKeys("Hello");

     driver.hideKeyboard();

     formPage.FemaleOption.click();

     driver.findElement(By.id("android:id/text1")).click();

     //driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");     

     util.scrollToText("Austria");

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
		
		//String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

		//Assert.assertEquals("Jordan 6 Rings", lastpageText);
		service.stop();
}

@BeforeTest
public void killLocalServer() throws IOException, InterruptedException
{
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	Thread.sleep(3000);
}
}