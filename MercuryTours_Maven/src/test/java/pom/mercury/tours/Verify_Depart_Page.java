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

public class Verify_Depart_Page {
	ChromeDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
		driver.findElement(By.linkText("SIGN-ON")).click();;
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Select SelectPass= new Select(driver.findElement(By.name("passCount")));
		
	SelectPass.selectByValue("4");
	
	Select oSelect= new Select(driver.findElement(By.name("fromPort")));
	oSelect.selectByValue("London");
	
	
	driver.findElement(By.xpath("//input[@value='Business']")).click();

	
	driver.findElement(By.name("findFlights")).click();
   WebElement str= driver.findElement(By.xpath("//td[@class='title']//font[contains(text(),'DEPART')]"));
  System.out.println(str);
  String ExpTitle= "DEPART";
  String ActTitle= str.getText();
  Assert.assertEquals(ExpTitle, ActTitle);
	
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

 /*@AfterTest
  public void Close_Browser() {
	  driver.quit();
  }
  */
}


