package pom.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sign_On_InternetExplorer_Example {
	WebDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
	  
		driver.findElement(By.linkText("SIGN-ON")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(7000);
		driver.findElement(By.linkText("SIGN-OFF")).click();;
		
		 
		
  }
  
  @BeforeTest
  public void Launch_Browser() throws InterruptedException {

		System.setProperty("webdriver.ie.driver", "C:\\Users\\user1\\Selenium_Training\\Selenium_Softwares\\IEDriverServer.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\user1\\Selenium_Training\\Selenium_Softwares\\geckodriver.exe");
		driver= new InternetExplorerDriver();
		//driver= new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void Close_Browser() {
	  driver.quit();
  }

}
