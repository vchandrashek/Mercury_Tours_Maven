package pom.mercury.tours;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile_Roboclass {
	WebDriver driver;
	
  @Test
  public void testUpload() throws InterruptedException {
		driver.get("https://gofile.io/?t=uploadFiles");
		String absolutePath=System.getProperty("user.dir");
		String filepath= absolutePath+ "\\Images\\Login.png";
		System.out.println(filepath);
		Thread.sleep(6000);
		driver.navigate().refresh();
		driver.findElement(By.id("btnChooseFiles")).click();
		uploadFile(filepath);
		Thread.sleep(10);
		
		 }
  
  public static void uploadFile(String fileLocation) {
	  
	  try {
		  //upload file through Robot API
		  StringSelection ss= new StringSelection(fileLocation);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		  
		  //native key strokes for CTRL, V and ENTER keys
		  Robot robot = new Robot();
		  robot.delay(1000);
		  //press CTRL + V
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  //Release CTRL+V
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  //Press Enter
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.delay(1000);
	  } catch(Exception exp) {
		  exp.printStackTrace();
	  }
			  
	  }
  
  
  
  @BeforeTest
  public void Launch_Browser() {
	  String absolutePath = System.getProperty("user.dir");
		//String filePath = absolutePath + "\\chromedriver.exe";
		String filePath = absolutePath + "\\Drivers"+"\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", filePath);
		driver= new ChromeDriver();
  }

  @AfterTest
  public void Close_Browser() {
	  driver.quit();
  }

}
