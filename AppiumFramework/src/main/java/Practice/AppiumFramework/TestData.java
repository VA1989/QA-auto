package Practice.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataForEditTextField()
	{
		Object[][] object=new Object[][]
				{
			{"hello"},{"@#$%"}
				};
				return object;
	}
}
