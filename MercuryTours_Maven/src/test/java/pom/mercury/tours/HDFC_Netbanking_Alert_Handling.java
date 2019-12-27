package pom.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HDFC_Netbanking_Alert_Handling {
	ChromeDriver driver;
	
  @Test
  public void Sign_On()  {
	  driver.switchTo().frame("login_page");
	  driver.findElement(By.xpath("//img[@alt='continue']")).click();
	  String ActTest= driver.switchTo().alert().getText();
			  String ExpTest= "Customer ID  cannot be left blank.";
	  Assert.assertEquals(ActTest, ExpTest);

		System.out.println(ActTest);
			driver.switchTo().alert().accept();
		
  }
  
  @BeforeTest
  public void Launch_Browser() {
	  String absolutePath = System.getProperty("user.dir");
		//String filePath = absolutePath + "\\chromedriver.exe";
		String filePath = absolutePath + "\\Drivers"+"\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", filePath);
		driver= new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();
  }

 
 @AfterTest
  public void Close_Browser() {
	  driver.quit();
  }
  
 

}
