package pom.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CSS_Selector_Example {
	ChromeDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
			driver.findElement(By.linkText("SIGN-ON")).click();;
			driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			driver.findElement(By.name("login")).click();
			WebElement radio1= driver.findElement(By.cssSelector("input[value='oneway']"));
			
			radio1.click();
			WebElement radio = driver.findElement(By.cssSelector("input[value='Business']"));
		radio.click();
		Thread.sleep(8000);
		boolean res= radio.isSelected();
		System.out.println(res);
		
		
		 
		
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
