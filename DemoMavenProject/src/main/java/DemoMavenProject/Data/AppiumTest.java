package DemoMavenProject.Data;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTest {

	WebDriver driver;
	WebDriverWait wait;
	
	String url = "https://google.com";
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
			DesiredCapabilities capabilities = DesiredCapabilities.android();
		  capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		  capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"my phone");
		  capabilities.setCapability(MobileCapabilityType.VERSION,"8.0.0");
		  
		  URL url = new URL("http://localhost:4723/wd/hub/");
		  @SuppressWarnings("rawtypes")
		WebDriver driver = new AndroidDriver (url,capabilities);
		  driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub/"), capabilities);
		  driver.get("https://google.com");

	}

}
