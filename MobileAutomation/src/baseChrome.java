
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class baseChrome {
	
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		
		//File appdir=new File("src");
		//File app=new File(appdir,"ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"192.168.0.100:5555");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
		cap.setCapability("chromedriverExecutable", "C:/Users/abram/OneDrive/Рабочий стол/QA/chromedriver_win32/chromedriver");
		//cap.setCapability("chromedriverExecutable", "C:/Users/RBW/AppData/Roaming/npm/node_modules/appium/node_modules/appium-chromedriver/build/lib/chromedriver.js");
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		
	}
	
}