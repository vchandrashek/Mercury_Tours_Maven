package pom.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sign_On_GetText_Example {
	ChromeDriver driver;
	
  @Test
  public void Sign_On() {
		driver.findElement(By.linkText("SIGN-ON")).click();;
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		WebElement element=driver.findElement(By.linkText("SIGN-OFF"));
		String ActValue= element.getText();
		String ExpValue= "SIGN-OFF";
		System.out.println(ActValue);
		Assert.assertEquals(ExpValue, ActValue);
		
		String ExpUrl = "http://newtours.demoaut.com/mercuryreservation.php";
		String ActUrl = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(ExpUrl, ActUrl);
		
		String ExpTitle = "Find a Flight:Mercury Tours:";
		String ActTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(ExpTitle,ActTitle);
		element.click();
		
		
		 
		
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
