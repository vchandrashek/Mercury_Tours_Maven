package pom.mercury.tours;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Read_SignOn_PropertiesFile {
	WebDriver driver;
	
  @Test
  public  void Flight_Sign_On() throws IOException, InterruptedException  {
	  
	  File file= new File("C:\\Users\\user1\\Selenium_Training\\eclipse-workspace\\MercuryTours_Maven\\Mercury_Tours.properties");
	  Properties prop= new Properties();
	  FileInputStream fileInput= new FileInputStream(file);
	  prop.load(fileInput);
	  
	  driver.get(prop.getProperty("url"));
	  	driver.manage().window().maximize();
		driver.findElement(By.linkText(prop.getProperty("lsignon"))).click();
		Thread.sleep(5000);
		driver.findElement(By.name(prop.getProperty("lnsername"))).sendKeys("testing");
		driver.findElement(By.name(prop.getProperty("lnuserpass"))).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(4000);
	driver.findElement(By.linkText("SIGN-OFF"));
		
		
		
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
  }*/

}
