package pom.mercury.tours;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Google_Links {
	ChromeDriver driver;
	
  @Test
  public void Sign_On()  {
	 List<WebElement> linksize= driver.findElements(By.tagName("a"));
	 int linksCount= linksize.size();
	 System.out.println("Total no of links Available:" + linksCount);
	 String[] links= new String[linksCount];
	 System.out.println("List of links Available");
	 
	 //print all the links from webpage
	 for(int i=0; i< linksCount; i++) {
		 
	 links[i] = linksize.get(i).getAttribute("href");
	 System.out.println(linksize.get(i).getAttribute("href"));
	
		
  }
	 //navigate to each link on the webpage
	 for (int i=0; i<linksCount; i++) {
		 
		 driver.navigate().to(links[i]);
		 System.out.println(driver.getTitle());
		 driver.navigate().back();
	 }
		 
	 }
  
  @BeforeTest
  public void Launch_Browser() {
	  String absolutePath = System.getProperty("user.dir");
		//String filePath = absolutePath + "\\chromedriver.exe";
		String filePath = absolutePath + "\\Drivers"+"\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", filePath);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.co.in/");
		
  }

  
 @AfterTest
  public void Close_Browser() {
	  driver.quit();
  }

}
