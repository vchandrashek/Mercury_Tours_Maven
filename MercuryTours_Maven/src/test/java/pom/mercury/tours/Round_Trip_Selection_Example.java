package pom.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Round_Trip_Selection_Example {
	ChromeDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
		driver.findElement(By.linkText("SIGN-ON")).click();;
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();

		//To verify whether Roundtrip selected or not
		String str= driver.findElement(By.xpath("//input[@value='roundtrip']")).getAttribute("checked");
		if(str.equalsIgnoreCase("true"))
		{
			System.out.println("RoundTrip selected");
		}
		
		//To select Radio Button
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		
		//To verify whether oneway get selected or not post click
		WebElement element= driver.findElement(By.xpath("//input[@value='oneway']"));
		
		Assert.assertEquals(element.isSelected(), true);
		
		driver.findElement(By.cssSelector("input[value='Business']")).click();
		Thread.sleep(6000);
		
		
		
		 
		
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
