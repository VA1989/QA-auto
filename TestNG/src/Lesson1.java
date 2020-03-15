import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lesson1 {


	@Test(dependsOnMethods= {"SecondTest"})																													
	public void Demo() 
	{
	System.out.println("Hello!");
	}
	@AfterSuite
	public void AfSuite()
	{
		System.out.println("I will run last");
	}
	@Test(dependsOnMethods= {"ThirdTest"})
	public void SecondTest()
	{
		System.out.println("Bye");
	}
	@Test
	public void ThirdTest()
	{
		System.out.println("Good");
	}
	@Test(timeOut=1000)
	public void JustTest()
	{
		System.out.println("Privet");
	}
	@AfterTest
	public void alastexecution() {
		System.out.println("I will execute last");
	}
	@BeforeMethod
	public void BfMethod()
	{
		System.out.println("Before each and every method)))");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("I will run before class");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("I will run after class");
	}
	@BeforeTest
	public void firstexecution() {
		System.out.println("I will execute first");
	}
}
