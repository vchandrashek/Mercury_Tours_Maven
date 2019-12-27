package pom.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserExample extends ApplicationTestData {
	WebDriver driver;
	
  @Test(dataProvider="Login")
 
	  public void Sign_On(String uname, String upass) throws InterruptedException  {
	  
	  driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		//driver.manage().window().maximize();
		  driver.findElement(By.linkText("SIGN-ON")).click();;
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(upass);
			driver.findElement(By.name("login")).click();
			Thread.sleep(8000);
			//driver.findElement(By.linkText("SIGN-OFF")).click();;	
  }
  
  
  @BeforeTest
  @Parameters("browser")
  public void Launch_Browser(String browser) throws Exception {
	  
	  if(browser.equalsIgnoreCase("firefox")) {
		  
		  String absolutePath = System.getProperty("user.dir");
		  String filePath = absolutePath + "\\Drivers"+"\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", filePath);
			driver= new FirefoxDriver();
			  
	  }
	  
	  else if(browser.equalsIgnoreCase("chrome")){
		  
		   String absolutePath = System.getProperty("user.dir");
				String filePath = absolutePath + "\\Drivers"+"\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", filePath);
				driver= new ChromeDriver();
				
	  }
	  else {
		  throw new Exception("Browser incorrect");
	  }
	  
	  
	  		
  }

  @AfterTest
  public void Close_Browser() {
	  
	  driver.quit();
  }

}
