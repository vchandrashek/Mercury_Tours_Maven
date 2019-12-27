package pom.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_priority {
	ChromeDriver driver;
	
	
	 @Test(priority=1)
	  public void Search_Flight() {
		 driver.findElement(By.cssSelector("input[value='oneway']")).click();
			
			Select oSelect= new Select(driver.findElement(By.name("fromPort")));
			oSelect.selectByValue("London");
			driver.findElement(By.name("findFlights")).click();
			
			String depart= driver.findElement( By.xpath("//td[@class='title']//font[contains(text(),'DEPART')]")).getText();
  System.out.println(depart);
  Assert.assertEquals("DEPART", depart);
  		driver.findElement(By.name("reserveFlights")).click();
  		}
	 
	 
  @Test(priority=0)
  public void Sign_On() {
		driver.findElement(By.linkText("SIGN-ON")).click();;
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
	
	 
  
  }
  
  @BeforeTest
  public void Launch_Browser() {
	  String absolutePath = System.getProperty("user.dir");
		//String filePath = absolutePath + "\\chromedriver.exe";
		String filePath = absolutePath + "\\Drivers"+"\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", filePath);
		driver= new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
  }

 @AfterTest
  public void Close_Browser() {
	  driver.quit();
  }
}


