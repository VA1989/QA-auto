package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	//driver.findElementByXPath("//*[@text='Female']").click();
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement FemaleOption;
	
	@AndroidFindBy(xpath="//*[@text='Male']")
	public WebElement MaleOption;
	
	//driver.findElement(By.id("android:id/text1")).click();
	@AndroidFindBy(id="android:id/text1")
	public WebElement CountrySelection;
	
	public WebElement getNameField()
	{
		System.out.println("Trying to find the name field...");
		return nameField;
	}
	
	public WebElement getCountrySelection()
	{
		System.out.println("Selecting country from drop menu...");
		return CountrySelection;
	}
}
