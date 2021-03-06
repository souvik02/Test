package DemoMavenProject.Run;

import org.testng.annotations.Test;

import DemoMavenProject.Data.Data;
import DemoMavenProject.Properties.properties;

import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class menuBucketAndFries {
	WebDriver driver;
	Data data;
	csvFile file = new csvFile("pagol");
	
  @Test
  public void f() throws InterruptedException 
  {
	  driver.get("https://order.kfcdelivery.ca");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id=\'stickyCartHeader\']/div/div/div/div[2]/span/a")).click();
	  driver.findElement(By.xpath("//*[@id=\'anchStartOrder\']")).click();
	  driver.findElement(By.xpath("//*[@id=\'RenderBodyDiv\']/div[2]/div[1]/div[2]/p[2]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\'RestaurantSearchKeyword\']")).sendKeys("m6j 1x8");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\'RestaurantSearchKeyword\']")).sendKeys(Keys.DOWN);
	  driver.findElement(By.xpath("//*[@id=\'RestaurantSearchKeyword\']")).sendKeys(Keys.ENTER);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\'delivery-submit\']")).click();
	  driver.findElement(By.xpath("//*[@id=\'btnForDelivery\']/div/span")).click();
	  driver.findElement(By.xpath("//*[@id=\'locationSelectStore\']")).click();
	  Thread.sleep(3000);
	  List <WebElement> menuCategories = driver.findElements(By.xpath("//*[@class='col-12 col-md-4 two-columns margin-bottom-20 ng-scope']"));
	  for(int j =1;j<menuCategories.size();j++)
	  {
		  List <WebElement> menuCategories2 = driver.findElements(By.xpath("//*[@class='col-12 col-md-4 two-columns margin-bottom-20 ng-scope']"));
		  menuCategories2.get(j).click();
		  Thread.sleep(3000);
		  List <WebElement> subCategory = driver.findElements(By.xpath("//*[@class='single-box']"));
	  	  for(int k =0;k<subCategory.size();k++)
		  {
			  List <WebElement> subCategory1 = driver.findElements(By.xpath("//*[@class='single-box']"));
			  List <WebElement> menuItemName = driver.findElements(By.xpath("//*[@class='uiname-item ng-binding']"));
			  String name = menuItemName.get(k).getText();
			  System.out.println(name);
			  List <WebElement> menuItemPrice = driver.findElements(By.xpath("//*[@class='price-item-small boldfont ng-binding ng-scope']"));
			  String price = menuItemPrice.get(k).getText();
			  System.out.println(price);
			  subCategory1.get(k).click();
			  Thread.sleep(3000);
			  
				  //List <WebElement> modifiers = driver.findElements(By.xpath("//*[@class='name-price margin-bottom-10']"));
				  List<WebElement> totalMod = driver.findElements(By.xpath("//*[@id='RenderBodyDiv']/div/div/div/div/div/div/div/div/ul/li"));
				  System.out.println(totalMod.size());
				  for(int h=0;h<=totalMod.size()-2;h++)
				  {
					  List <WebElement> modifiers2 = driver.findElements(By.xpath("//*[@class='name-price margin-bottom-10']"));
					  for(int g=0;g<modifiers2.size();g++)
					  {
						  String mod = modifiers2.get(g).getText();
						  String lines [] = mod.split("\\r?\\n");
						  for(String line : lines)
						  {
							  System.out.println(line);
						  }
						  file.insertintoCSVFile(name, price, lines);
					  }
					  
					  driver.findElement(By.xpath("//*[@class='next-prev-group=text ng-binding']")).click();;
						  
				  }
				  
				 // driver.findElement(By.xpath("//*[@class='next-prev-group=text ng-binding']")).click();
				  driver.findElement(By.xpath("//*[@id=\'stickyCartHeader\']/div/div/div/div[1]/ul/li[1]/a")).click();
				  List <WebElement> menuCategories3 = driver.findElements(By.xpath("//*[@class='col-12 col-md-4 two-columns margin-bottom-20 ng-scope']"));
				  menuCategories3.get(j).click();
			  
		  }
	  }
	  
	  
	  
  }
  
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  	String dt = properties.getDataFromProperty("TestData");
		data = new Data(dt);
	    driver = DemoMavenProject.Driver.driver.selectBrowser(data.getData(0, 0, 0));
		
  }

  @AfterTest
  public void afterTest() {
  }

}
