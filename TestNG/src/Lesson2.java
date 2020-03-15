import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lesson2 {

	@Test(groups= {"Smoke"})
	public void Demo2 () {
		System.out.println("Whats up?");
	}
	
	@BeforeTest
	public void prerequisites()
	{
		System.out.println("I will execute first");
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="firstlogin"; // В массивах, первое множество данных начинается с 0, а не с 1.
		data[0][1]="firstpassword";	
//набор данных для 2 страницы
		data[1][0]="secondlogin";
		data[1][1]="secondpassword";
//набор данных для 3 страницы
		data[2][0]="thirdlogin";
		data[2][1]="thirdpassword";
		return data;
	}
	@Test(dataProvider="getData")
	public void MethodForDataprovider(String username, String password)
	{
		System.out.println(username);
		System.out.println(password);

	}
	}
    
