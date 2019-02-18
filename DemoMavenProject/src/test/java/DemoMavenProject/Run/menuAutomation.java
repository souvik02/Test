package DemoMavenProject.Run;

import org.testng.annotations.Test;

import DemoMavenProject.Data.Data;
import DemoMavenProject.Properties.properties;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class menuAutomation {
	Data data;
	WebDriver driver;
	
	
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("https://order.kfc.co.za");
	  driver.manage().window().maximize();
	  WebDriverWait wait = new WebDriverWait(driver, 60); 
	  WebElement e =  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\'stickyCartHeader\']/div/div/div/div[2]/span/a"))));
	  e.click();
	  WebElement e1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\'btnForPickup\']/div/span"))));
	  e1.click();
	  WebElement e2 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\'location\']/div[1]/div[2]/span[2]/a"))));
	  e2.click();
	 
	  driver.findElement(By.xpath("//*[@id=\'RestaurantSearchKeyword\']")).sendKeys("7600");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\'RestaurantSearchKeyword\']")).sendKeys(Keys.DOWN);
	  driver.findElement(By.xpath("//*[@id=\'RestaurantSearchKeyword\']")).sendKeys(Keys.ENTER);
	  Thread.sleep(5000);
	  WebElement e3 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\'dvCarryoutAddres1\']/div/div/div[4]/button"))));
	  e3.click();
	  Thread.sleep(3000);
	  List<WebElement> li = driver.findElements(By.xpath("//*[@class='subcatitemimg ng-binding']"));
	  for(int i =0;i <li.size();i++)
	  {
		  for(int j =1;j<li.size();j++)
		  {
			  List<WebElement> li2 = driver.findElements(By.xpath("//*[@class='subcatitemimg ng-binding']"));
			  li2.get(j).click();
			  Thread.sleep(3000);
			  List<WebElement> lili = driver.findElements(By.xpath("//*[@class='text-div']"));
			   for(int k =0;k<lili.size();k++)
			   {
				   List <WebElement> menuName = driver.findElements(By.xpath("//*[@class='uiname-item ng-binding']"));
				   List <WebElement> menuDescription = driver.findElements(By.xpath("//*[@class='item-list py-2']"));
				   List <WebElement> menuPrice = driver.findElements(By.xpath("//*[@class='d-none d-md-block col-md-12 col-xs-12 prod-price ng-binding']"));
				   
				   System.out.println(menuName.get(k).getText()+"  "+menuDescription.get(k).getText()+"  "+menuPrice.get(k).getText());
				   menuName.get(k).click();
				   List <WebElement> subMenu = driver.findElements(By.xpath("//*[@id='RenderBodyDiv']/div/div/div/div[1]/div/div[1]/div/div[2]/div/div/div"));
				   if(subMenu.size()>0)
				   {
					   for(int a=0;a<subMenu.size();a++)
					   {
						   System.out.println(subMenu.get(a).getText());
					   }
					   driver.findElement(By.xpath("//*[@class='btn white block col-12 margin-top-10']")).click();
				   }
				   else
				   {
					   driver.findElement(By.xpath("//*[@class='btn white block col-12 margin-top-10']")).click();
				   }
				   
			   }
			   driver.findElement(By.xpath("//*[@id=\'stickyCartHeader\']/div/div/div/div[1]/ul/li[1]/a")).click();
		  }
	  }
	  
	  
	  
  }
  @BeforeClass
  public void beforeClass() throws Exception {
	  String dt = properties.getDataFromProperty("TestData");
	  data = new Data(dt);
	  driver = DemoMavenProject.Driver.driver.selectBrowser(data.getData(0, 0, 0));
  }

  @AfterClass
  public void afterClass() {
  }

}
