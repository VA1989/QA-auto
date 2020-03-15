package Practice.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class ApiDemoTest extends base{

	@Test(dataProvider="InputData", dataProviderClass=TestData.class)
	public void ApiDemo(String input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		service=startServer();
		
        //service=startServer();
        AndroidDriver<AndroidElement> driver=Capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage hp=new HomePage(driver);
		Preferences Prefdep=new Preferences(driver);
		
		hp.Preferences.click();
		Prefdep.PreferenceDependencies.click(); 
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
		Prefdep.buttons.get(1).click();
		
		service.stop();
		
	}
	
}