	import java.net.MalformedURLException;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebElement;

	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
	import static io.appium.java_client.touch.offset.ElementOption.element;
	import static java.time.Duration.ofSeconds;

		public class swipe extends base{

			public static void main(String[] args) throws MalformedURLException {
				// TODO Auto-generated method stub
				AndroidDriver<AndroidElement> driver=Capabilities("emulator");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
				driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
				driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
				driver.findElementByXPath("//*[@content-desc='9']").click();
				TouchAction touch = new TouchAction(driver);
				WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
				WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
				touch.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(1))).moveTo(element(second)).release().perform();
	}

}
