package pom.mercury.tours;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Sign_ON_ExtentReport {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	ChromeDriver driver ;
	  File file =new File("C:\\Selenium_Training\\Workspace\\Mercury\\mercury_tours.properties");
	  Properties prop =new Properties();
	  String filepath = "C:\\Selenium_Training\\Workspace\\Mercury\\screenshot";
	
	 @Test(priority=2)
	  public void Sign_On_Success() throws IOException {
		 test=extent.createTest("Test case 2","Login to mercury Application");
		  FileInputStream fileInput =new FileInputStream(file);
			 prop.load(fileInput);
			 driver.findElement(By.linkText("SIGN-ON")).click();
				driver.findElementByName("userName").sendKeys("testing");
				// driver.findElement(By.name("userName")).sendKeys("testing");
				driver.findElement(By.name("password")).sendKeys("testing");
				driver.findElement(By.name("logins")).click();
				
		WebElement element = driver.findElement(By.linkText("SIGN-OFF"));
		String ActValue = element.getText();
		String ExpValue = "SIGN-OFF";
	 }
			 @Test(priority=1)			  
	private void LaunchBrowser() throws IOException {
		// TODO Auto-generated method stub
		test=extent.createTest("Test case 1","Login to chrome ");
		  String absolutepath = System.getProperty("user.dir");
		 FileInputStream fileInput1 =new FileInputStream(file);
		 prop.load(fileInput1);
			String relativepath = absolutepath+"\\chromedriver.exe";
			//String relativepath = absolutepath+"\\IEDriverServer.exe";
			System.setProperty("WebDriver.ie.driver",relativepath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("URL"));
			}
			 
			 @BeforeTest()
			 public void startReport()
			 {
				 htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
				 extent=new ExtentReports();
				 extent.attachReporter(htmlReporter);
				 
				 //To add system environment
				 extent.setSystemInfo("OS","Window 10");
				 extent.setSystemInfo("Browser","chrome 77+");
				 
				 
				 //configuretion items to change look and feel
				 
				 htmlReporter.config().setDocumentTitle("Extent Report Demo");
				 htmlReporter.config().setReportName("Test Report");
				 htmlReporter.config().setTheme(Theme.STANDARD);
				 htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a'('zzz')'");
				 
			 }
			 
			 @AfterMethod
			  public void getResult(ITestResult result) throws IOException{
				  if(result.getStatus()== ITestResult.FAILURE)
				  {
					  test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED",ExtentColor.RED));
					  test.fail(result.getThrowable());
				  
					  File Browserscreenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					//  FileUtils.copyFile(Browserscreenshot, new File("C:\\Selenium_Training\\Workspace\\Mercury\\screenshot\\login.png"));
					  FileUtils.copyFile(Browserscreenshot, new File(filepath+"/"+result.getName()+"_"+System.nanoTime()+ ".png"));
				  }
				  else if(result.getStatus()== ITestResult.SUCCESS)
				  {
					  test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED",ExtentColor.GREEN));
				  }
				  else
				  {
					  test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED",ExtentColor.YELLOW));
					  test.skip(result.getThrowable());
				  }
			  }
			  

			  @AfterTest
			  public void closeBrowser() {
				     //driver.quit();
				  extent.flush();
					}


}
