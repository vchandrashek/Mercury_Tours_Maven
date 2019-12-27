package pom.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Drag_Drop_Example {
	ChromeDriver driver;
	
  @Test
  public void Drag_Drop() throws InterruptedException  {
	 //create object of action class
		 Actions act= new Actions(driver);
		//find element which we need to drag
		WebElement drag= driver.findElementById("draggable");
		//find element which we need to drop
		WebElement drop =  driver.findElementById("droppable");
		//this will drop element to destination
		act.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(5000);
		
  }
  
  @BeforeTest
  public void Launch_Browser() throws InterruptedException {
	  String absolutePath = System.getProperty("user.dir");
		//String filePath = absolutePath + "\\chromedriver.exe";
		String filePath = absolutePath + "\\Drivers"+"\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", filePath);
		driver= new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		Thread.sleep(6000);
  }

 @AfterTest
  public void Close_Browser() {
	  driver.quit();
  }

}
