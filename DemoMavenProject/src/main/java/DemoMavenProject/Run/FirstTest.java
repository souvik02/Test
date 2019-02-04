package DemoMavenProject.Run;

import org.testng.annotations.Test;

import DemoMavenProject.Data.Data;
import DemoMavenProject.Properties.properties;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FirstTest {
	WebDriver driver;
	Data data;
	
  @Test
  public void f() {
	  
	  driver.get("https://google.com");
  }
  @BeforeClass
  public void beforeClass() throws Exception {
	  String dt = properties.getDataFromProperty("TestData");
	  data = new Data(dt);
	  driver = DemoMavenProject.Driver.driver.selectBrowser(data.getData(0, 0, 0));
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}