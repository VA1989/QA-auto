import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class browse extends baseChrome{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver=Capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//System.out.println (driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
		/*driver.get("https://vk.com");
		driver.findElementByXPath("//*[@id='mcont']/div[2]/div/div/form/dl[1]/dd/input").sendKeys("qwerty");
		driver.findElementByName("pass").sendKeys("12345");
		driver.findElementByXPath("//*[@id='mcont']/div[2]/div/div/form/div[1]/input").click();*/
		
		driver.get("http://cricbuzz.com");
		driver.findElementByXPath("//*[@id='top']/div/div[3]/div[2]/a/span[1]").click();
		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		System.out.println (driver.getCurrentUrl());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,480)","");
		Assert.assertTrue(((RemoteWebElement) driver.findElements(By.xpath("//h4[text()='Top Stories']"))).getAttribute("class").contains("header"));

}
}