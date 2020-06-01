import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class gestures extends base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver=Capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		TouchAction touch = new TouchAction(driver);
		WebElement expandlist = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		touch.tap(tapOptions().withElement(element(expandlist))).perform();
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		WebElement PNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		touch.longPress(longPressOptions().withElement(element(PNames)).withDuration(ofSeconds(2))).release().perform();
		System.out.println (driver.findElementById("android:id/title").isDisplayed());
	}

}
