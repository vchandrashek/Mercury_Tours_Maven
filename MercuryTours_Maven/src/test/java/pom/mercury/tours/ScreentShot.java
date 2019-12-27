package pom.mercury.tours;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreentShot {
	WebDriver driver;
	String filepath="C:\\Users\\user1\\Selenium_Training\\eclipse-workspace\\MercuryTours_Maven\\Screenshot";
	
  @Test
  public void Sign_On()  {
	  driver.findElement(By.linkText("SIGN-ON")).click();;
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("logins")).click();
		driver.findElement(By.linkText("SIGN-OFF"));
		
  }
  
  @AfterMethod
  public void teardown(ITestResult result) throws IOException  {
	 if( ITestResult.FAILURE==result.getStatus())
	 {
	 File Browserscreenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// FileUtils.copyFile(Browserscreenshot,  new File("C:\\Users\\user1\\Selenium_Training\\eclipse-workspace\\MercuryTours_Maven\\Screenshot\\Login.png"));
	FileUtils.copyFile(Browserscreenshot,  new File(filepath + "/"+ result.getName()+"_"+System.nanoTime()+".png"));
 }
	 driver.quit();
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
}

 


