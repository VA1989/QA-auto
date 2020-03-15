package Practice.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public static AppiumDriverLocalService startServer()
	{
		boolean serverON = checkIfServerIsRunning(4723);
		if(!serverON)
		{

		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e)
		{		
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		 return isServerRunning;
		
}
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException {
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Practice\\AppiumFramework\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		File appdir=new File("src");
		File app=new File(appdir, (String) prop.get(appName));
		//File app=new File(appdir,"ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//String device=(String) prop.get("device");
		String device= System.getProperty("devicename");
		if(device.contains("Emulator"))
		{
			startEmulator();
		}
		//String emulator=(String) prop.get("Emulator1");
		//if(device.equals("emulator"))	
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,device);
		//else if(device.equals("real"))	
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME,emulator);				
		//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		//cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;

	}

	public static void getScreenshot(String failed) throws IOException
	{
		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+failed+".png"));
	}
}
