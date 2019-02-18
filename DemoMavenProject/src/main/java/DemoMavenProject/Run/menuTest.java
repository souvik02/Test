package DemoMavenProject.Run;

import org.openqa.selenium.WebDriver;

import DemoMavenProject.Data.Data;
import DemoMavenProject.Properties.properties;

public class menuTest {
	
	
	
	public static void main (String[] args) throws Exception
	{
		WebDriver driver;
		Data data;
		String dt = properties.getDataFromProperty("TestData");
		 data = new Data(dt);
		 driver = DemoMavenProject.Driver.driver.selectBrowser(data.getData(0, 0, 0));
		
		
		
		
		
		
		
	}
	
	 

}
