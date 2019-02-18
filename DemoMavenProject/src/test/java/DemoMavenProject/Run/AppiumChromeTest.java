package DemoMavenProject.Run;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class AppiumChromeTest {
	WebDriver driver;
	WebDriverWait wait;
	
	String url = "https://google.com";
	
	
  @Test
  public void f() {
	  driver.get(url);
  }
  
  @BeforeTest
  public void setUp() throws MalformedURLException 
  {
	  DesiredCapabilities capabilities = DesiredCapabilities.android();
	  capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
	  capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
	  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
	  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"my phone");
	  capabilities.setCapability(MobileCapabilityType.VERSION,"8.0.0");
	  
	  URL url = new URL("http://0.0.0.0:5566/wd/hub/");
	  WebDriver driver = new AndroidDriver (url,capabilities);
	  driver = new RemoteWebDriver(new URL("http://0.0.0.0:5566/wd/hub/"), capabilities);
	  

	  
	  
  }
}
