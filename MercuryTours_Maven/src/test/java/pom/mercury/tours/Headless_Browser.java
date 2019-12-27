package pom.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Headless_Browser {
	ChromeDriver driver;
	ChromeOptions options = new ChromeOptions();
	
	  @Test
  public void PhantomJs() {
		
		
		driver.findElement(By.linkText("SIGN-ON")).click();;
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();;	
  }
  
  @BeforeTest
  public void Launch_Browser() {
	  
	  String absolutePath = System.getProperty("user.dir");
		//String filePath = absolutePath + "\\chromedriver.exe";
		String filePath = absolutePath + "\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);
		options.setHeadless(true);
		driver= new ChromeDriver(options);
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void Close_Browser() {
	  driver.quit();
  }

}
