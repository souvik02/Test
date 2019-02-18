package DemoMavenProject.Run;

import org.testng.annotations.Test;

import DemoMavenProject.Data.Data;
import DemoMavenProject.Properties.properties;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FirstTest {
	WebDriver driver;
	Data data;
	
  @Test
  public void f() throws IOException {
	  
	 // driver.get("https://google.com");
	  File fs = new File("C:\\Users\\Rony\\Desktop\\save.txt");
	  FileOutputStream fss = new FileOutputStream(fs);
	  String s = "true love";
	  byte[] b = s.getBytes();
	  fss.write(b);
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