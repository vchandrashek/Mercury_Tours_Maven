package pom.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mouse_Over_Yatra {
	ChromeDriver driver;
	
  @Test
  public void Sign_On()  {
	   WebElement element= driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
	  Actions action= new Actions(driver);
	  action.moveToElement(element).build().perform();
	  driver.findElement(By.id("signInBtn")).click();
		
  }
  
  @BeforeTest
  public void Launch_Browser() {
	  String absolutePath = System.getProperty("user.dir");
		//String filePath = absolutePath + "\\chromedriver.exe";
		String filePath = absolutePath + "\\Drivers"+"\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", filePath);
		driver= new ChromeDriver();
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
  }

 @AfterTest
  public void Close_Browser() {
	  driver.quit();
  }

}
