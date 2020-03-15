import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lesson3 {

	@Test(groups= {"Smoke"})
	public void WebLogin() 
	{
		System.out.println("WebLogin");
	}
	@Test
	@Parameters({"URL"})
	public void MobileLogin(String url) 
	{
		System.out.println("MobileLogin");
		System.out.println(url);
	}
	@Test
	public void Mobile123() 
	{
		System.out.println("APILogin");
	}
	@BeforeSuite
	public void BfSuite()
	{
		System.out.println("I will run first");
	}
	@Test
	public void Mobile555() 
	{
		System.out.println("APILogin");
	}
	@Test
	public void Mobile777() 
	{
		System.out.println("APILogin");
	}
}
